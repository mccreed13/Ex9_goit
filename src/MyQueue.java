public class MyQueue {
    private final int maxSize;
    private Object[] array;
    private int last;
    private int items;
    private int head;

    public MyQueue(int s){
        maxSize = s;
        array = new Object[maxSize];
        last = -1;
        head = 0;
        items = 0;
    }
    public void add(Object value){
        if(last == maxSize -1 ){
            last = -1;
        }
        if(last+1 == head && array[head] != null){
            if(head == maxSize-1){
                head = 0;
            }else head++;
            items--;
        }
        array[++last] = value;
        items++;
    }
    public void clear(){
        array = new Object[maxSize];
        head=0;
        last=-1;
        items=0;
    }
    public int size(){
        return items;
    }
    public Object peek(){
        return array[head];
    }
    public Object poll(){
        Object o = array[head];
        array[head] = null;
        if(head == maxSize-1){
            head = 0;
        } else head++;
        items--;
        return o;
    }
}
