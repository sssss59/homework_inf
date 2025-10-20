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
        Car[] Ytoyota = getCarByBrendAndYearOperational(cars, "Toyota", 4);
        Car[] Yhonda = getCarByBrendAndYearOperational(cars, "Honda", 5);
        Car[] YBNW = getCarByBrendAndYearOperational(cars, "BNW", 5);
        System.out.println("Кол-во Тойот: " + Toyota.length);
        System.out.println("Кол-во Hond: " + Honda.length);
        System.out.println("Кол-во BNW: " + BNW.length);
        System.out.println("Кол-во Тойот: " + Ytoyota.length);
        System.out.println("Кол-во Hond: " + Yhonda.length);
        System.out.println("Кол-во BNW: " + YBNW.length);
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
            if(cars[i].getBrand().equals(brend)){
                res[ind] = cars[i];
                ind++;
            }
        }
        return res;
    }
    public static Car[] getCarByBrendAndYearOperational(Car[] cars, String brend, int years){
        int c = 0;
        for(int i=0; i < cars.length; i++){
            int expl_year = 2025 - cars[i].getYear();
            if(cars[i].getBrand() == brend && expl_year > years){
                c++;
            }
        }
        if(c == 0){
            return new Car[0];
        }
        Car[] result = new Car[c];
        int ind = 0;
        for(int i = 0; i < cars.length; i++){
            int explYear = 2025 - cars[i].getYear();
            if(cars[i].getBrand().equals(brend) && explYear < years){
                result[ind] = cars[i];
                ind++;
            }
        }
        return result; 
    }
}
