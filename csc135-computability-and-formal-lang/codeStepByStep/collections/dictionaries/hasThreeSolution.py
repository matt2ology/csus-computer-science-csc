# https://www.codestepbystep.com/problem/view/python/collections/dict/has_three
def has_three(list):
    my_dictionary = {}
    for word in list:
        if word not in my_dictionary:
            my_dictionary[word] = 1
        else:
            my_dictionary[word] += 1
    for key in my_dictionary:
        if(my_dictionary[key] >= 3):
            return True
    return False
