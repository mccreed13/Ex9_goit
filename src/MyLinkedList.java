public class MyLinkedList {
    private int size = 0;
    Node head;
    Node last;

    public class Node {
        Object date;
        Node next;
        Node prev;
    }

    public void add(Object value){
        Node node=new Node();
        node.date=value;
        node.next=null;
        node.prev=null;
        if(head==null) {
            head=node;
        }
        else
        {
            Node n=head;
            while(n.next!=null)
            {
                n=n.next;
            }
            node.prev = n;
            n.next=node;
            head.prev = node;
        }
        size++;
    }
    public void remove(int index){
        if(index > size-1 || index<0){
            throw new ArrayIndexOutOfBoundsException();
        }
        int i = 0;
        Node n = head;
        while (i != index) {
            n=n.next;
            i++;
        }
        n.prev.next = n.next;
        n.next.prev = n.prev;
        size--;
    }
    public void clear(){
        for (Node x = head; x != null; ) {
            Node next = x.next;
            x.date = null;
            x.next = null;
            x.prev = null;
            x = next;
        }
        head = last = null;
        size = 0;
    }
    public int size(){
        return size;
    }

    public Object get(int index){
        if(index > size-1 || index<0){
            throw new ArrayIndexOutOfBoundsException();
        }
        int i = 0;
        Node n = head;
        while (i != index) {
            n=n.next;
            i++;
        }
        return n.date;
    }
}
