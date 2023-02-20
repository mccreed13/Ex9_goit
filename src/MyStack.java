import java.util.EmptyStackException;

public class MyStack {
    private final int maxSize;
    private Object[] array;
    private int last;
    private int items;
    private int head;

    public MyStack(int s){
        maxSize = s;
        array = new Object[s];
        last = -1;
        head = 0;
        items = 0;
    }

    public void push(Object value){
        if(last == maxSize-1){
            last = -1;
        }
        if(array[last+1] != null){
            items--;
        }
        array[++last] = value;
        items++;
    }

    public void remove(int index){
        if(last != -1){
            array[last] = null;
            items--;
        } else throw new EmptyStackException();
    }

    public void clear(){
        array = new Object[maxSize];
        last = -1;
        head = 0;
        items = 0;
    }

    public int size(){
        return items;
    }
    public Object peek(){
        if(last != -1){
            return array[last];
        } else throw new EmptyStackException();
    }

    public Object pop(){
        Object o = null;
        if(last != -1){
            o = array[last];
            array[last] = null;
        } else throw new EmptyStackException();
        if(last == 0 && array[array.length-1] != null){
            last = array.length-1;
        }else last--;
        return o;
    }
}

