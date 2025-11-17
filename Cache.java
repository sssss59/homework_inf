import java.util.LinkedList;

public class Cache<T>{
    private final LinkedList <T> array;
    private int max_size;

    public Cache(int max_size){
        if(max_size <= 0){
            throw new IllegalArgumentException("Размер должен быть больше 0");
        }else{
            this.max_size = max_size;
            this.array = new LinkedList<T>();
        }
    }

    public void add(T item){
        if(item == null){
            throw new IllegalArgumentException("Неправильно введен элемент");
        }
        array.add(item);
        if(array.size() > max_size){
            array.removeFirst();
        }
        
    }
    public boolean remove(T item){
        if(item == null){
            throw new IllegalArgumentException("Неправильно введен элемент");
        }
        this.max_size--;
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
    public T getLast(){
        if(array.getLast() == null){
            throw new IllegalArgumentException("Список еще пуст");
        }
        else{
            return array.getLast();
        }
    }
    public T getItemByIndex(int i){
        if(i < 0 || i >= array.size()){
            return null;
        }
        return array.get(i);
    }
    @Override
    public String toString(){
        return "Cache = " + array + ", size = " + max_size; 
    }
}