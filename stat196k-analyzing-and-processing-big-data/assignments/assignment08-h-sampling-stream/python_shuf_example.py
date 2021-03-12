import random
import logging
FORMAT = '[%(asctime)s]-[%(funcName)s]-[%(levelname)s] - %(message)s'
logging.basicConfig(
    level=logging.INFO,
    format=FORMAT
)


def printArray(stream, n):
    for i in range(n):
        print(stream[i], end=" ")
    print()
    pass


def selectKItems(stream, lenthOfStream, numberOfSamples):
    indexCounter = 0

    reservoir = [0]*numberOfSamples

    for i in range(numberOfSamples):
        reservoir[i] = stream[i]

    while(indexCounter < lenthOfStream):

        j = random.randrange(indexCounter+1)

        if(j < numberOfSamples):
            reservoir[j] = stream[indexCounter]
        indexCounter += 1

    logging.info("Following are k randomly selected items")
    printArray(reservoir, numberOfSamples)


def main():
    #selectKItems(stream, n, k);
    test()
    pass


def test():
    stream = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]
    n = len(stream)
    k = 5
    selectKItems(stream, n, k)
    pass

# Driver Code


if __name__ == "__main__":
    main()
    pass

# This code is contributed by mits
