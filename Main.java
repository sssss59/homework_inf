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

    public void add(T item){
        if(item == null){
            throw new IllegalArgumentException("Неправильно введен элемент");
        }
        if(array.size() > max_size){
            array.removeFirst();
        }
        array.add(item);
    }
    public boolean remove(T item){
        if(item == null){
            throw new IllegalArgumentException("Неправильно введен элемент");
        }
        return array.remove(item);
    }
    public boolean exists(T item){
        if(item == null){
            throw new IllegalArgumentException("Неправильно введен элемент");
        }
        return array.contains(item);
    }
    public T getFirst(){
        if(array.getFirst() == null){
            throw new IllegalArgumentException("Список еще пуст");
        }else{
            return array.getFirst();
        }
    }
}