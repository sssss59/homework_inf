import java.io.*;
import java.util.*;

public class ClassicIOCacheWithLimit{
    private int maxSize;
    private Map<String, FileCacheEntry> cache;

    public class FileCacheEntry{
        String content;
        long lastReadTime;
        long lastModifiredTimeAtRead;

        public FileCacheEntry(String content, long lastReadTime, long lastModifiredTimeAtRead){
            this.content = content;
            this.lastReadTime = lastReadTime;
            this.lastModifiredTimeAtRead = lastModifiredTimeAtRead;
        }
    }

    public ClassicIOCacheWithLimit(int maxSize){
        this.maxSize = maxSize;
        this.cache = new LinkedHashMap<>(maxSize);
    }
    public ClassicIOCacheWithLimit(){
        this(100);
    }
    public String readFile(String filePath) throws IOException{
        File file = new File(filePath);
        if(!file.exists()){
            throw new FileNotFoundException("File not found");
        }
        String absolutePath = file.getAbsolutePath();
        long currentModifiredTime = file.lastModified();
        long currentTime = System.currentTimeMillis();
        if(cache.containsKey(absolutePath)){
            FileCacheEntry cacheEntry = cache.get(absolutePath);
            if(isCachedValid(cacheEntry, currentModifiredTime)){
                cacheEntry.lastReadTime = currentTime;
                return cacheEntry.content; 
            }
        }
        return updateCache(file, absolutePath, currentModifiredTime);
    } 
     
    private boolean isCachedValid(FileCacheEntry cacheEntry, long currentModifiredTime){
        if(cacheEntry.lastModifiredTimeAtRead == currentModifiredTime){
            return true;
        }else{
            return false;
        }
    }
    private String updateCache(File file, String absolutePath, long currentModifiredTime) throws IOException{
        String content = readFileContent(file);
        long currentTime = System.currentTimeMillis();

        FileCacheEntry newEntry = new FileCacheEntry(content, currentTime, currentModifiredTime);
        cache.put(absolutePath, newEntry);
        return content;
    }

    private String readFileContent(File file) throws IOException{
        StringBuilder content = new StringBuilder();
        char buffer[] = new char[8192];
        try(FileReader fileReader = new FileReader(file))
        {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            int charRead;
            while((charRead = bufferedReader.read(buffer)) != -1){
                content.append(buffer, 0, charRead);
            }

        }
        return content.toString();
    }

    public void invalidate(String filePath){
        String absolutePath = new File(filePath).getAbsolutePath();
        cache.remove(absolutePath);
    }

    public void invalidateAll(){
        cache.clear();
    }

    public boolean isCached(String fielPath){
        String absolutePath = new File(fielPath).getAbsolutePath();
        if(cache.containsKey(absolutePath)){
            return true;
        }else{
            return false;
        }
    }
    public int getCachedFilesCount(){
        return cache.size();
    }

    public long getCachedSizeIbMemory(){
        long temp_size = 0;
        for(FileCacheEntry entry: cache.values()){
            temp_size += entry.content.length() * 2;
        }
        return temp_size;
    }
    public void printCacheStats(){
        System.out.println("количество файлов " + getCachedFilesCount());
        System.out.println("Size in memory " + getCachedSizeIbMemory());
        System.out.println("Max count of files = " + maxSize);
        System.out.println("Files in cache");
        for(Map.Entry<String, FileCacheEntry> entry: cache.entrySet()){
            String filePath = entry.getKey();
            FileCacheEntry cacheEntry = entry.getValue();
            long fielSize = cacheEntry.content.length() * 2;
            String lastReadTime = new Date(cacheEntry.lastReadTime).toString();
            System.out.println("PATH: " + filePath + " fileSize: " + fielSize + " was read: " + lastReadTime);
        }
    }
    public static void main(String[] args) {
        try {
            File testFile1 = new File("test1.txt");
            File testFile2 = new File("test2.txt");
            
            try (FileWriter writer1 = new FileWriter(testFile1)) {
                writer1.write("Содержимое первого тестового файла");
            }
            
            try (FileWriter writer2 = new FileWriter(testFile2)) {
                writer2.write("Содержимое второго тестового файла");
            }
            
            ClassicIOCacheWithLimit cache = new ClassicIOCacheWithLimit(2);
            
            System.out.println("Первое чтение файлов");
            String content1 = cache.readFile("test1.txt");
            System.out.println("Прочитан test1.txt: " + content1.substring(0, Math.min(20, content1.length())) + "...");
            
            String content2 = cache.readFile("test2.txt");
            System.out.println("Прочитан test2.txt: " + content2.substring(0, Math.min(20, content2.length())) + "...");
            
            System.out.println("\nПовторное чтение (из кэша) ");
            long startTime = System.nanoTime();
            String cachedContent1 = cache.readFile("test1.txt");
            long endTime = System.nanoTime();
            System.out.println("Время чтения из кэша: " + (endTime - startTime) + " наносекунд");
            
            System.out.println("\nПроверка наличия в кэше");
            System.out.println("test1.txt в кэше: " + cache.isCached("test1.txt"));
            System.out.println("test2.txt в кэше: " + cache.isCached("test2.txt"));
            
            System.out.println("\nСтатистика кэша");
            cache.printCacheStats();
            
            System.out.println("\nОчистка конкретного файла");
            cache.invalidate("test1.txt");
            System.out.println("test1.txt в кэше после invalidate: " + cache.isCached("test1.txt"));
            
            System.out.println("\nПолная очистка кэша");
            cache.invalidateAll();
            System.out.println("Количество файлов в кэше после invalidateAll: " + cache.getCachedFilesCount());
            
            testFile1.delete();
            testFile2.delete();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
}
}