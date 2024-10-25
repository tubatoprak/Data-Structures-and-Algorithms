/**
 * from my book
 * @param <K> Keys
 * @param <V> Values
 */
public class ChainTreeSet<K extends Comparable<K>,V extends Comparable <V>> implements KWHashMap<K,V> {

    private MyTreeSet<Entry <K,V>>[] table;
    private int numKeys;
    private static final int CAPACITY = 101;
    private static final double LOAD_THRESHOLD = 3.0;

    private static class Entry<K extends Comparable <K>, V extends Comparable<V>> implements Comparable<Entry <K,V>> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public V setValue(V val) {
            V oldVal = value;
            value = val;
            return oldVal;
        }

        public String toString() {
            return getKey() + "\t" + getValue();
        }

        @Override
        public int compareTo(Entry<K, V> o) {
            return (this.getKey().compareTo(o.getKey()));

        }
    }

    public ChainTreeSet() {
        table = new MyTreeSet[CAPACITY];
    }
    /**
     * Method get for class TreeSet
     * @param key The key being sought
     * @return The value associated with this key if found; otherwise, null
     */
    @Override
    public V get(Object key) {
        int index = key.hashCode() % table.length;
        if(index < 0)
            index += table.length;
        if(table[index] == null)
            return null;
        V val = null;
        Entry temp = table[index].find(new Entry<K,V>((K) key, val));
        val = (V) temp.getValue();
        return val;
    }
    /**
     * empty or not method
     * @return true if map is empty, otherwise false
     */
    @Override
    public boolean isEmpty() {
        if(numKeys > 0 ) return false;
        return true;
    }
    /**
     * Method put for class TreeSet.
     * @param key The key of item being inserted
     * @param value The value for this key
     * @return The old value associated with this key if found; otherwise, null
     */
    @Override
    public V put(K key, V value) {
        int index = key.hashCode() % table.length;
        if(index < 0) index += table.length;
        if(table[index] == null) {
            table[index] = new MyTreeSet<Entry <K,V>>();
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
        return null;
    }
    /**
     * Remove method
     * @param key removing value of key
     * @return removing value
     */
    @Override
    public V remove(Object key) {
        Entry<K,V> temp ;
        V val = null ;
        for(int i =0;i<table.length;++i) {
            if(table[i] != null) {
                temp = table[i].find(new Entry<K, V>((K) key, val));
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
     * size method
     * @return size of hash table
     */
    @Override
    public int size() {
        return numKeys;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (MyTreeSet<Entry<K, V>> e : table) {
            if (e != null) {
                sb.append(e.toString());
            }
        }
        return sb.toString();
    }
}
