from queue import Empty


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

def _reverse(self, x, acc):  # x! * acc is the answer to the original fact(x) call
    if self.empty():
        return acc
    else:
        # If x! * acc == y here...
        return self.reverse(x-1, acc * x)
        # ...then it does here too.

def reverse(self, x):
    # Initialize accumulator to something appropriate
    return self._reverse(x, 1)


v_01 = list135(5)
v_02 = v_01.cons(7)
v_03 = v_02.cons(6)
v_04 = v_03.cons(3)

print("The List: {}, {}, {}, {}, {}".format(v_04.first(), v_04.rest().first(), v_04.rest().rest(
).first(), v_04.rest().rest().rest().first(), v_04.rest().rest().rest().rest()))

reverse(v_04)
