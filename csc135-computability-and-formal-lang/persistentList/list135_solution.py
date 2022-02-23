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

    def __str__(self) -> str:
        current = self.rest()
        in_list = "(" + str(self.first())
        while current is not None:
            in_list += ', ' + str(current.first())
            current = current.rest()
        return in_list + ")"


v_01 = list135(5)
v_02 = v_01.cons(7)
v_03 = v_02.cons(6)
v_04 = v_03.cons(3)

print(v_01)
print(v_02)
print(v_03)
print(v_04)

print("{}, {}, {}, {}, {}".format(v_04.first(), v_04.rest().first(), v_04.rest().rest(
).first(), v_04.rest().rest().rest().first(), v_04.rest().rest().rest().rest()))
