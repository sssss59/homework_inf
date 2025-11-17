import java.util.*;


public class Main{
    public static void main(String[] args){
        Cache<String> stringCache = new Cache<String>(3);
        stringCache.add("Первый");
        stringCache.add("Второй");
        stringCache.add("Третий");
        System.out.println("После добавления 3 элементов: " + stringCache);
        
        stringCache.add("Четвертый");
        System.out.println("После добавления 4-го элемента: " + stringCache);
        
        System.out.println("Первый элемент: " + stringCache.getFirst());
        System.out.println("Последний элемент: " + stringCache.getLast());
        System.out.println("Элемент по индексу 1: " + stringCache.getItemByIndex(1));
        System.out.println("Элемент по индексу 5: " + stringCache.getItemByIndex(5));
        
        System.out.println("Существует 'Второй': " + stringCache.exists("Второй"));
        System.out.println("Существует 'Первый': " + stringCache.exists("Первый"));
        
        System.out.println("Удаление 'Второй': " + stringCache.remove("Второй"));
        System.out.println("После удаления: " + stringCache);
        System.out.println("Удаление несуществующего: " + stringCache.remove("Несуществующий"));
        
        Cache<Integer> intCache = new Cache<Integer>(2);
        intCache.add(10);
        intCache.add(20);
        intCache.add(30);
        System.out.println("cache из целочисленных: " + intCache);
        System.out.println("Первый элемент: " + intCache.getFirst());
        System.out.println("Существует 20: " + intCache.exists(20));
    }
}