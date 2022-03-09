class list135:
    
    def __init__(self, first_item = None, rest_of_list = None):
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
