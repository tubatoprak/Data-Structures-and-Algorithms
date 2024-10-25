
/**
 * HashTable implementation using chaining with binary search tree.
 * @param <K> Keys
 * @param <V> Values
 */
public class Hybrid<K extends Comparable<K>,V extends Comparable <V>> implements KWHashMap<K,V> {
    /** The table */
    private BinarySearchTree<Entry <K,V>>[] table;
    /** The number of keys */
    private int numKeys;

    /** The capacity */
    private static final int CAPACITY = 10;

    /** The maximum load factor */
    private static final double LOAD_THRESHOLD = 3.0;

    /**
     * Constructor
     */
    public Hybrid() {
        table = new BinarySearchTree[CAPACITY];
    }

    private static class Entry<K extends Comparable <K>, V extends Comparable<V>> implements Comparable<Entry <K,V>> {
        /** The key */
        private K key;

        /** The value */
        private V value;

        /** Creates a new key-value pair.
         @param key The key
         @param value The value
         */
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
        /** Retrieves the key.
         @return The key
         */
        public K getKey() {
            return key;
        }

        /** Retrieves the value.
         @return The value
         */
        /** Sets the value.
         @param val The new value
         @return The old value
         */
        public V setValue(V val) {
            V oldVal = value;
            value = val;
            return oldVal;
        }
        /** Retrieves the value.
         @return The value
         */
        public V getValue() {
            return value;
        }

        /**
         *  To string
         * @ Key and Value
         */
        public String toString() {
            return "Key: "+ getKey() +"   Value: "+ getValue();
        }

        @Override
        public int compareTo(Entry<K, V> o) {
            return (this.getKey().compareTo(o.getKey()));

        }
    }



    /** Method get for class HashtableChain.
     @param key The key being sought
     @return The value associated with this key if found;
     otherwise, null
     */
    @Override
    public V get(Object key) {
        int index = key.hashCode() % table.length;
        if(index < 0) index += table.length;
        if(table[index] == null) return null;

        V value = null;
        Entry temp = table[index].find(new Entry<K,V>((K) key, value));
        //return table[index].find(target)
        value = (V) temp.getValue();
        return value;
    }
    /** Method put for class HashtableChain.
     post: This key-value pair is inserted in the
     table and numKeys is incremented. If the key is already
     in the table, its value is changed to the argument
     value and numKeys is not changed.
     @param key The key of item being inserted
     @param value The value for this key
     @return The old value associated with this key if
     found; otherwise, null
     */
    @Override
    public V put(K key, V value) {
        int index = key.hashCode() % table.length;
        if(index < 0) index += table.length;
        if(table[index] == null) {
            table[index] = new BinarySearchTree<Entry <K,V>>();
        }

        Entry<K,V> temp = table[index].find(new Entry<K,V>(key,value));
        if(temp != null) {
            V oldVal = temp.getValue();
            table[index].remove(temp);
            temp.setValue(value);
            table[index].add(temp);
            return oldVal;
        }


        table[index].add(new Entry<K,V>(key,value));
        numKeys++;
        if(numKeys > ( LOAD_THRESHOLD * table.length)) rehash();
        return null;
    }

    /** Returns true if empty */
    @Override
    public boolean isEmpty() {
        if(numKeys > 0 ) return false;
        return true;
    }
    /** Returns the number of entries in the map */
    @Override
    public int size() {
        return numKeys;
    }
    /** Expands table size when loadFactor exceeds LOAD_THRESHOLD
     post: the size of table is doubled and is an
     odd integer. Each non-deleted entry from the original
     table is reinserted into the expanded table.
     The value of numKeys is reset to the number of items
     actually inserted; numDeletes is reset to 0.
     */
    private void rehash() {
        BinarySearchTree<Entry <K,V>>[] oldTable = table;

        table = new BinarySearchTree[2 * oldTable.length + 1];

        numKeys = 0;
        for(int i =0 ;i< oldTable.length;i++) {
            if((oldTable[i] != null) ) {
                table[i] = oldTable[i];
            }
        }
    }

    /**
     * Method remove for class HashtableChain.
     * @param key  The key of item being deleted
     * @return The  value
     */
    @Override
    public V remove(Object key) {
        Entry<K,V> temp ;
        V val = null ;
        for(int i =0;i<table.length;++i) {
            if(table[i] != null) {
                temp = table[i].find(new Entry<K,V>((K) key,val));
                if(temp != null) {
                    V value = temp.getValue();
                    table[i].remove(temp);
                    numKeys--;
                    return value;
                }
            }
        }
        return null;
    }

    /**
     * method to string
     * @return string items
     */
    public String toString() {
        String sb = "";
        System.out.println("\n----Hash Table----");
        for (int i = 0; i < CAPACITY; i++) {
            if (table[i] != null)
                sb +=  table[i].toString() ;
        }
        return sb;
    }
}

