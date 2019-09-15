import java.io.IOException;

public class Correlator {
    void countWords(String dataObject, String file1, String file2)
    {
        DataCounter<String> counter;
        DataCount<String>[] counts1, counts2;
        PercFreq[] frequencies1, frequencies2;
        int end;
        double hold;
        double sum = 0;
        counter = fetchObject(dataObject);
        counts1 = generateCounts(counter, file1).getCounts();
        counter = fetchObject(dataObject);
        counts2 = generateCounts(counter, file1).getCounts();
        sortByDescendingCount(counts1);
        sortByDescendingCount(counts2);
        frequencies1 = calcPercent(counts1);
        frequencies2 = calcPercent(counts2);
        end = frequencies1.length;
        for(int i = 0; frequencies1[i] != null && i < end; ++i)
        {
            hold = getPerc(frequencies1[i].data, frequencies2);
            if(hold > 0) sum += Math.pow(hold - frequencies1[i].percentage, 2);
        }
        System.out.println("Difference score: " + sum);
    }

    DataCounter<String> fetchObject(String dataObject)
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

    DataCounter<String> generateCounts(DataCounter<String> obj, String filename)
    {
        FileWordReader reader;
        String word;
        try
        {
            reader = new FileWordReader(filename);
            word = reader.nextWord();
            while (word != null)
            {
                obj.incCount(word);
                word = reader.nextWord();
            }
        }
        catch (IOException e)
        {
            System.err.println("Error processing " + filename + e);
            System.exit(1);
        }
        return obj;
    }

    //Gets the total of all counts
    int getTotal(DataCount<String>[] counts)
    {
        int total = 0;
        for(DataCount<String> count : counts)
        {
            total += count.count;
        }
        return total;
    }

    //Creates an array with each element having a percentage of all counts.
    PercFreq[] calcPercent(DataCount<String>[] counts)
    {
        PercFreq[] initialPerc = new PercFreq[counts.length];
        PercFreq[] finalPerc = new PercFreq[counts.length];
        double total = getTotal(counts);
        int i = 0;
        for(DataCount<String> count : counts)
        {
            initialPerc[i++] = new PercFreq(count.count / total, count.data);
        }
        i = 0;
        for(PercFreq current : initialPerc)
            if(current.percentage < 0.1 && current.percentage >  0.01)
                finalPerc[i++] = current;
        return finalPerc;
    }

    double getPerc(String key, PercFreq[] pool)
    {
        int end = pool.length;
        for(int i = 0; i < end; ++i) if(pool[i].data.equals(key))return pool[i].percentage;
        return 0;
    }
    /**
     * TODO Replace this comment with your own.
     *
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
    static <E extends Comparable<? super E>> void sortByDescendingCount(
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
        Correlator CO = new Correlator();
        if (args.length != 3) {
            System.err.println("Usage: java Correlator [-b|-a|-h] <Filename1> <Filename2>");
            System.exit(1);
        }
        CO.countWords(args[0], args[1], args[2]);
    }
}

class PercFreq
{
    double percentage;
    String data;

    PercFreq(double percentage, String data)
    {
        this.percentage = percentage;
        this.data = data;
    }
}
