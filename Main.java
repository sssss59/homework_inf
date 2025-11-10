public class Cache<T>{
    private int n;
    private Object List[];
    private int size;
    public Cache(int n){
        if(n <= 0){
            throw new IllegalArgumentException("Количество элементов в кэше должно быть больше 0");
        }
        this.n = n;
        this.List = new Object[n];
        this.size = 0;
    }
    public void add(T item){
        if (item == null){
            throw new IllegalArgumentException("Не чувак пустой элемент не будет добавлен");
        }
        if(size<n){
            List[size] = item;
            size++;
        }else{
            for(int i = 0; i < n-1; i++){
                List[i] = List[i+1];
            }
            List[n-1] = item;
        }
    }
    public boolean remove(T item){
        if( item == null){
            throw new IllegalArgumentException("Не чувак пустой элемент не приколько");
        }
        for(int i = 0; i < size; i++){
            if(List[i] != null &&  List[i].equals(item)){
                for(int j = i; j < size -1; j++){
                    List[j] = List[j+1];
                }
                List[size-1] = null;
                size--;
                return true;
            }
        }
        return false;
    }
    public boolean exists(T item){
        if( item == null){
            throw new IllegalArgumentException("Не чувак пустой элемент не приколько");
        }
        for(int i = 0; i < size; i++){
            if( List[i] != null && List[i].equals(item)){
                return true;
            }
        }
        return false;
    }
    public T getFirst(){
        if (size > 0 && List[0] != null){return (T) List[0];}
        else{return null;}
    }
    public T getLast(){
        if(size > 0 && List[size-1] != null){
            return (T) List[size-1];
        }
        else{
            return null;
        }
    }
    public T getItemByIndex(int i){
        if(List[i] != null){
            return (T) List[i];
        }else{
            return null;
        }
    }
}


public class Main{
    public static void main(String[] args){
        Cache<String> cache = new Cache<>(3);
        
        System.out.println("\nТестирование метода add");
        cache.add("Первый");
        cache.add("Второй");
        cache.add("Третий");
        System.out.println("Добавлено 3 элемента. " + cache.getItemByIndex(0) + cache.getItemByIndex(1) + cache.getItemByIndex(2));
        
        cache.add("Четвертый");
        System.out.println("Добавлен четвертый элемент. Размер кэша: " + cache.getItemByIndex(0) + cache.getItemByIndex(1) + cache.getItemByIndex(2));
        

        System.out.println("\nТестирование метода exists");
        System.out.println("Элемент 'Первый' существует: " + cache.exists("Первый"));
        System.out.println("Элемент 'Второй' существует: " + cache.exists("Второй"));
        System.out.println("Элемент 'Третий' существует: " + cache.exists("Третий"));
        System.out.println("Элемент 'Четвертый' существует: " + cache.exists("Четвертый"));
 
        System.out.println("\nТестирование метода getFirst");
        System.out.println("Первый элемент: " + cache.getFirst());
        
        System.out.println("\nТестирование метода getLast");
        System.out.println("Последний элемент: " + cache.getLast());
        

        System.out.println("\nТестирование метода remove");
        System.out.println("Удаление 'Второй': " + cache.remove("Второй"));
        System.out.println("Удаление 'Несуществующий': " + cache.remove("Несуществующий"));
        
  
        System.out.println("\nПосле удаления");
        System.out.println("Первый элемент: " + cache.getFirst());
        System.out.println("Последний элемент: " + cache.getLast());
        
        System.out.println("\nТестирование с Integer");
        Cache<Integer> intCache = new Cache<>(2);
        intCache.add(10);
        intCache.add(20);
        intCache.add(30); 
        
        System.out.println("Первый элемент: " + intCache.getFirst());
        System.out.println("Последний элемент: " + intCache.getLast());
        System.out.println("Существует ли 10: " + intCache.exists(10));
        System.out.println("Существует ли 20: " + intCache.exists(20));
        System.out.println("Существует ли 30: " + intCache.exists(30));
        
    }
}