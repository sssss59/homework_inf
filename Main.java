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
}


public class Main{
    public static void main(String[] args){

    }
}