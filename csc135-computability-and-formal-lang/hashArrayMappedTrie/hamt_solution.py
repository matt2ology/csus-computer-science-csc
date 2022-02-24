# Hash Array Mapped Trie - Used in CSC 135, Sacramento State
# Written by Ted Krovetz, February 2022
#
# This implementation assumes that the objects pointed at by the key and value
# references stored in the HAMT structure do not change during the lifetime
# of the structure.
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

    def __init__(self, key, value, children=None):
        self._key = key
        self._value = value
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

    def set(self, key, value):
        # Pass key/value and hashbits to recursive helper
        return self._set(key, value, hash(key))

    def __str__(self):
        s = "[({},{})".format(str(self._key), str(self._value))
        for i in range(hamt.DEG):
            if (self._children[i] == None):
                s = s + "X"
            else:
                s = s + str(self._children[i])
        return s + "]"

    def get(self, key):
        """
        Returns the value key is mapped-to or None if key is not a key in the HAMT

        Parameters:
        Key (any): Key to find mapped value

        Returns:
        any: Value set to key
        """
        return self._get(key, hash(key))

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

    def len(self) -> int:
        counter = 1
        for i in range(hamt.DEG):
            if (self._children[i] is not None):
                counter += self._children[i].len()
        return counter


a = hamt("A", "a")  # 01
b = a.set("B", "b") # 02
c = b.set("C", "c") # 03
d = c.set("D", "d") # 04
e = d.set("E", "e") # 05
f = e.set("F", "f") # 06
g = f.set("G", "g") # 07
h = g.set("H", "h") # 08
i = h.set("I", "i") # 09
j = i.set("J", "j") # 10
k = j.set("K", "k") # 11
print("{} - {}".format(a, a.len()))  # 01
print("{} - {}".format(b, b.len()))  # 02
print("{} - {}".format(c, c.len()))  # 03
print("{} - {}".format(c, c.len()))  # 03
print("{} - {}".format(d, d.len()))  # 04
print("{} - {}".format(e, e.len()))  # 05
print("{} - {}".format(f, f.len()))  # 06
print("{} - {}".format(g, g.len()))  # 07
print("{} - {}".format(h, h.len()))  # 08
print("{} - {}".format(i, i.len()))  # 09
print("{} - {}".format(j, j.len()))  # 10
print("{} - {}".format(k, k.len()))  # 11
print("eol")
