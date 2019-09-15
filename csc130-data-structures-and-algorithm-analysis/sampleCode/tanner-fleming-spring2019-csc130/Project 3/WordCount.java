import java.io.IOException;

/**
 * An executable that counts the words in a files and prints out the counts in
 * descending order. You will need to modify this file.
 */
public class WordCount
{
    private static void countWords(String dataObject, String output, String file)
    {
        DataCounter<String> counter = fetchObject(dataObject);
        FileWordReader reader;
        DataCount<String>[] counts;
        String word;
        try
        {

            reader = new FileWordReader(file);
            word = reader.nextWord();

            long startTime = System.currentTimeMillis();

            while (word != null)
            {
                counter.incCount(word);
                word = reader.nextWord();
            }

            long endTime = System.currentTimeMillis();                   //Creates variable to store time difference
            System.out.println("Insertion took " + (endTime - startTime) + " milliseconds");

        }
        catch (IOException e)
        {
            System.err.println("Error processing " + file + e);
            System.exit(1);
        }


        counts = counter.getCounts();


        switch(output)
        {
            case("-frequency"):
            {
                long startTime = System.currentTimeMillis();
                sortByDescendingCount(counts);
                for (DataCount<String> count : counts)
                {
                    System.out.println(count.count + "\t" + count.data);
                }
                long endTime = System.currentTimeMillis();                   //Creates variable to store time difference
                System.out.println("Search took " + (endTime - startTime) + " milliseconds");
                break;

            }
            case("-num_unique"):
            {
                System.out.println("Number of unique words: " + counts.length);
                break;
            }
            default:
            {
                System.out.println("Invalid output request");
                System.exit(1);
            }

        }


    }

    /**
     * Sort the count array in descending order of count. If two elements have
     * the same count, they should be in alphabetical order (for Strings, that
     * is. In general, use the compareTo method for the DataCount.data field).
     * 
     * This code uses insertion sort. You should modify it to use a different
     * sorting algorithm. NOTE: the current code assumes the array starts in
     * alphabetical order! You'll need to make your code deal with unsorted
     * arrays.
     * 
     * The generic parameter syntax here is new, but it just defines E as a
     * generic parameter for this method, and constrains E to be Comparable. You
     * shouldn't have to change it.
     * 
     * @param counts array to be sorted.
     */
    private static <E extends Comparable<? super E>> void sortByDescendingCount(
            DataCount<E>[] counts) {
        for (int i = 1; i < counts.length; i++) {
            DataCount<E> x = counts[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (counts[j].count >= x.count) {
                    break;
                }
                counts[j + 1] = counts[j];
            }
            counts[j + 1] = x;
        }
    }

    public static void main(String[] args)
    {
        if (args.length != 3) {
            System.err.println("Usage: java WordCount [-b|-a|-h] [-frequency|-num_unique] <Filename>");
            System.exit(1);
        }
        countWords(args[0], args[1], args[2]);
    }

    private static DataCounter<String> fetchObject(String dataObject)
    {
        switch(dataObject)
        {
            case("-b"): return new BinarySearchTree<String>();
            case("-a"): return new AVLTree<String>();
            case("-h"): return new HashTable();
            default: System.out.println("Invalid data object."); System.exit(1);
        }
        return null;
    }
}
