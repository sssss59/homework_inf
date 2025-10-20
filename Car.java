public class Car {
    private int id;
    private String brand;
    private String model;
    private int year;
    private String color;
    private int price;
    private int reg_num;
    public Car(int id, String brand, String model, int year, String color, int price, int reg_num){
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.price = price;
        this.reg_num = reg_num;
    }
    public int getID(){
        return this.id;
    }
    public String getBrand(){
        return this.brand;
    }
    public String getModel(){
        return this.model;
    }
    public int getYear(){
        return this.year;
    }
    public String getColor(){
        return this.color;
    }
    public int getPrice(){
        return this.price;
    }
    public int getReg_num(){
        return this.reg_num;
    }
    public void setID(int id){
        this.id = id;
    }
    public void setBrand(String brand){
        this.brand = brand;
    }
    public void setModel(String model){
        this.model = model;
    }
    public void setYear(int year){
        this.year = year;
    }
    public void setColor(String color){
        this.color = color;
    }
    public void setPrice(int price){
        this.price = price;
    }
    public void setReg_num(int reg_num){
        this.reg_num = reg_num;
    }
}