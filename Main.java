import java.util;

public class Cache<T>{
    private final LinkedList <T> array;
    private int size;

    public Cache(int size){
        if(size <= 0){
            throw new IllegalArgumentException("Размер должен быть больше 0");
        }else{
            this.size = size;
            this.array = new LinkedList<T>();
        }
    }

    void add(T item){
        
    }
}