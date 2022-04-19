# Multiplies a and non-negative b using repeated addition
def mult(a, b, accu = 0):
    if b == 0:
        return accu
    else:
        return mult(a, b-1, a + accu)

def mult_loop(a, b, accu = 0):
    while True:
        if b == 0:
            return accu
        else:
            (b, accu) = (b-1, a + accu)


print(mult_loop(4,5))