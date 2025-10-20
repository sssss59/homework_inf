public class Main{
    public static void main(String[] args){
        Car[] cars = {
            new Car(1, "Toyota", "Camry", 2020, "red", 25000, 145),
            new Car(2, "Toyota", "Corolla", 2019, "green", 20000, 456),
            new Car(3, "Honda", "Civic", 2021, "blue", 22000, 789),
            new Car(4, "Toyota", "RAV4", 2018, "black", 28000, 442)
        };
        Car[] Toyota = getCarByBrend(cars, "Toyota");
        Car[] Honda = getCarByBrend(cars, "Honda");
        Car[] BNW = getCarByBrend(cars, "BNW");
        System.out.println("Кол-во Тойот: " + Toyota.length);
        System.out.println("Кол-во Hond: " + Honda.length);
        System.out.println("Кол-во BNW: " + BNW.length);
    }
    public static Car[] getCarByBrend(Car[] cars, String brend){
        int c = 0;
        for(int i=0; i < cars.length; i++){
            if(cars[i].getBrand() == brend){
                c++;
            }
        }
        if(c == 0){
            return new Car[0];
        }
        Car[] res = new Car[c];
        int ind = 0;
        for(int i = 0; i < cars.length; i++){
            if(cars[i].getBrand() == brend){
                res[ind] = cars[i];
                ind++;
            }
        }
        return res;
    }

}
