# Hash Array Mapped Trie - Used in CSC 135, Sacramento State
# Written by Ted Krovetz, February 2022
#
# This implementation assumes that the objects pointed at by the key and value
# references stored in the HAMT structure do not change during the lifetime
# of the structure.
from itertools import count
import logging

FORMAT = '[%(asctime)s]-[%(funcName)s]-[%(levelname)s] - %(message)s'
logging.basicConfig(
    level=logging.DEBUG,
    format=FORMAT
)


class hamt:

    DEG = 4      # Children per node (must be power of 2)
    BITS = 2     # log2(DEG), bits needed to select child
    MASK = 0b11  # Bitmask for extracting low BITS bits (DEG - 1)
    _NUMBER_OF_KEYS_IN_TREE = int(0)

    def __init__(self, key, value, children=None):
        self._key = key
        self._value = value
        self._NUMBER_OF_KEYS_IN_TREE += int(1)
        if children == None:
            self._children = [None] * hamt.DEG
        else:
            self._children = children

    def _set(self, key, value, hashbits):
        # Each node encountered during search will get altered.
        # To maintain persistence, each is duplicated, updated, returned.
        if (self._key == key):
            # This node matches key. Return duplicate with new value
            return hamt(self._key, value, self._children)
        else:
            # Continue search using hashbits to pick direction
            child_num = hashbits & hamt.MASK
            # Copy can reuse key/value. Child list gets updated, so duplicate
            copy = hamt(self._key, self._value, list(self._children))
            if (copy._children[child_num] == None):
                # End of search, key not found, add new node
                copy._children[child_num] = hamt(key, value)
            else:
                # Continue by asking appropriate child to set key/value
                copy._children[child_num] = copy._children[child_num].     \
                    _set(key, value, hashbits >> hamt.BITS)
            return copy

    def _get(self, key, hashbits):
        child_num = hashbits & hamt.MASK
        found_value = None
        if self._key == key:
            logging.debug(
                "[key found] - actual: {} expected: {}".format(self._key, key))
            found_value = self._value
        elif self._children[child_num] is not None:
            logging.debug(
                "[key not found] - actual: {} expected: {}".format(self._key, key))
            logging.debug("searching down the trie's node children...")
            found_value = self._children[child_num]._get(
                key, hashbits >> hamt.BITS)
        else:
            logging.debug(
                "[key not found - end of search] - actual :{} expected: {}".format(self._key, key))

        return found_value

    def set(self, key, value):
        # Pass key/value and hashbits to recursive helper
        return self._set(key, value, hash(key))

    def get(self, key):
        """
        Returns the value key is mapped-to or None if key is not a key in the HAMT

        Parameters:
        Key (any): Key to find mapped value

        Returns:
        any: Value set to key
        """
        return self._get(key, hash(key))

    def __str__(self):
        s = "[({},{})".format(str(self._key), str(self._value))
        for i in range(hamt.DEG):
            if (self._children[i] == None):
                s = s + "X"
            else:
                s = s + str(self._children[i])
        return s + "]"

    def _len(self) -> int:
        hashbits = hash(self._key)
        child_num = hashbits & hamt.MASK
        key_counter = 0
        if self._children[child_num] is not None:
            key_counter += 1
            logging.debug("searching down the trie's node children...")
            self._children[child_num]._len(self._key, hashbits >> hamt.BITS)
            
        return key_counter

a = hamt("A", "a")
b = a.set("B", "b")
c = b.set("C", "c")
d = c.set("D", "d")
e = d.set("E", "e")
f = e.set("F", "f")
print(f._len())