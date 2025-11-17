import java.util;

public class Cache<T>{
    private final LinkedList <T> array;
    private int max_size;

    public Cache(int size){
        if(size <= 0){
            throw new IllegalArgumentException("Размер должен быть больше 0");
        }else{
            this.size = size;
            this.array = new LinkedList<T>();
        }
    }

    void add(T item){
        if(item == null){
            throw new IllegalArgumentException("Неправильно введен элемент");
        }
        if(array.size() > max_size){
            array.removeFirst();
        }
        array.add(item);
    }
}