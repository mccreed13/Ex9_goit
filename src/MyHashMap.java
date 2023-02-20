public class MyHashMap {
    private static final int size = 16;
    private int pointer = 0;
    private Node[] table;

    public MyHashMap() {
        pointer = 0;
        table = new Node[size];
    }
    class Node{
        final Object key;
        Object value;
        Node next;

        Node(Object k, Object v){
            key = k;
            value = v;
        }

        public Object getKey() {
            return key;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }
    }

    public void put(Object key, Object value){
        int hash = key.hashCode() % size;
        Node n = table[hash];
        if(n != null){
            if(n.key.equals(key)){
                n.value = value;
            }else {
                while (n.next != null){
                    n = n.next;
                }
                Node nodeInOldBucket = new Node(key, value);
                n.next = nodeInOldBucket;
            }
        }else {
            Node nodeInNewBucket = new Node(key, value);
            table[hash] = nodeInNewBucket;
        }
        pointer++;
    }

    public void remove(Object key){
        int hash = key.hashCode() % size;
        table[hash] = null;
        pointer--;
    }
    public void clear(){
        table = new Node[size];
    }
    public int size(){
        return pointer;
    }

    public Object get(Object key){
        int hash = key.hashCode() % size;
        Node n = table[hash];

        while(n != null){
            if(n.key.equals(key)){
                return n.value;
            }
            n = n.next;
        }
        return null;
    }
}