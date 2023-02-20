public class MyArrayList {
    private final int init_size = 16;
    private final int cut_rate = 4;
    private Object[] array = new Object[init_size];
    private int pointer = 0;

    public void add(Object value) {
        if(pointer == array.length-1)
            resize(array.length*2);
        array[pointer++] = value;
    }

    public Object get(int index) {
        if(index > -1 && index < array.length) {
            return array[index];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public void remove(int index) {
        if(index < 0 || index > array.length-1) {
            throw new ArrayIndexOutOfBoundsException();
        }
        for (int i = index; i<pointer; i++) {
            array[i] = array[i + 1];
        }
        array[pointer] = null;
        pointer--;
        if (array.length > init_size && pointer < array.length / cut_rate)
            resize(array.length/2);
    }

    public int size() {
        return pointer;
    }
    public void clear(){
        for(int i = 0; i<pointer; i++){
            array[i] = null;
        }
        pointer = 0;
    }
    private void resize(int newLength) {
        Object[] newArray = new Object[newLength];
        System.arraycopy(array, 0, newArray, 0, pointer);
        array = newArray;
    }
}
