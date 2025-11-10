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
}


public class Main{
    public static void main(String[] args){

    }
}