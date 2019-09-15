/**
 * Stub code for an implementation of a DataCounter that uses a hash table as
 * its backing data structure. We included this stub so that it's very clear
 * that HashTable works only with Strings, whereas the DataCounter interface is
 * generic.  You need the String contents to write your hashcode code.
 */
public class HashTable implements DataCounter<String> {

    private int numValues;
    private int maxSizeArray;
    private HashData[] table;

    HashTable()
    {
        this.table = new HashData[31];
        this.maxSizeArray = 31;
        this.numValues = 0;
    }

    HashTable(int tableSize)
    {
        this.table = new HashData[tableSize];
        this.maxSizeArray = tableSize;
        this.numValues = 0;
    }

    /** {@inheritDoc} */
    //Fill an array with the counts of all of the elements.
    public DataCount<String>[] getCounts()
    {
        DataCount <String>[] counts = new DataCount[this.numValues];
        int j = 0;

        for (int i = 0; i < maxSizeArray; i++){
            if (this.table[i] != null){
                counts[j] = new DataCount<String>(this.table[i].data, this.table[i].count);
                j++;
            }
        }
        return counts;
    }

    /** {@inheritDoc} */
    //Return size of the array.
    public int getSize() {
        return 0;
    }

    /** {@inheritDoc} */
    //Add a word to the table
    public void incCount(String data)
    {
        boolean collision;
        int stringHash;
        stringHash = hash(data);
        if(numValues > maxSizeArray/2) { this.resizeTable(); }
        do{
            collision = false;
            if(this.table[stringHash] == null){
                this.table[stringHash] = new HashData(data);
                ++this.numValues;
            }else{
                if(this.table[stringHash].data.compareTo(data)  == 0){
                    ++this.table[stringHash].count;
                }else{
                    ++stringHash;
                    collision = true;
                }
            }
        }while(collision);
    }

    public int hash(String data)
    {
        int hash = 0;
        for(int i = 0; i < data.length(); ++i){
            hash = (31 * hash + data.charAt(i)) % this.maxSizeArray;
        }
        return hash;
    }

    public void resizeTable()
    {
        int oldSize = this.maxSizeArray;
        int newSize = oldSize * 2;
        HashTable newTable = new HashTable(newSize);
        for(int i = 0; i < oldSize; ++i){
            if(this.table[i] != null) newTable.incCount(this.table[i].data);
        }
        this.table = newTable.table;
        this.maxSizeArray = newTable.maxSizeArray;
        this.numValues = newTable.numValues;
    }
}

class HashData
{
    String data;
    int count;

    HashData(String data)
    {
        this.data = data;
        this.count = 1;
    }

    String getData()
    {
        return this.data;
    }
}
