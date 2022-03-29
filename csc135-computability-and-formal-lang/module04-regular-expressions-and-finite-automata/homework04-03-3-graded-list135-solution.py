class list135:

    def __init__(self, first_item=None, rest_of_list=None):
        self._first_item = first_item
        self._rest_of_list = rest_of_list

    def cons(self, first_item):
        return list135(first_item, self)

    def first(self):
        return self._first_item

    def rest(self):
        return self._rest_of_list

    def empty(self):
        return self._rest_of_list == None

    def __str__(self):
        result = "["
        cur = self
        if cur._rest_of_list != None:
            result = result + str(cur._first_item)
            cur = cur._rest_of_list
        while cur._rest_of_list != None:
            result = result + "," + str(cur._first_item)
            cur = cur._rest_of_list
        return result + "]"


# 1. Write a tail recursive function "reverse" that takes a list135 parameter
# and returns a list135 that is the same as the parameter but in reverse order.
# For example \[1,2,3\] would reverse to \[3,2,1\].

#     Your solution should use a design similar to fact and \_fact shown above.
# The accumulator should be initialized as an empty list, and the invariant that
# you maintain should be that the reversal of the list parameter followed by the
# accumulator should equal the reversal of the original list.

#     Do not place this method in your class. Instead it should use the list135
# public interface to manipulate the old and new lists.

def _reverse(lst, acc):
    if lst.rest() is None:
        return acc
    else:
        acc = acc.cons(lst.first())
        return _reverse(lst.rest(), acc)


def reverse(list135_obj):
    # Initialize accumulator to something appropriate
    acc = list135()
    return _reverse(list135_obj, acc)


# 2. Beginning with your tail recursive solution to _reverse, convert it to a
# loop version following the pattern shown above for foo and gcd.
def reverse_via_loop(lst, acc):
    cur = lst
    while cur._rest_of_list != None:
        acc = acc.cons(cur._first_item)
        cur = cur._rest_of_list
    return acc


v_01 = list135()
v_02 = v_01.cons("A")
v_03 = v_02.cons("B")
v_04 = v_03.cons("C")

print("The List: \n{}, \n{}, \n{}, \n{}, \n{}".format(v_04.first(), v_04.rest().first(), v_04.rest().rest(
).first(), v_04.rest().rest().rest().first(), v_04.rest().rest().rest().rest()))

print("recursive: {}".format(reverse(v_04)))
print("loop version: {}".format(reverse_via_loop(v_04)))
