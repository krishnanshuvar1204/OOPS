abstract class Vehicle
 {
    protected String make;
    protected String model;

    public Vehicle(String make, String model) 
    {
        this.make = make;
        this.model = model;
    }
    abstract void startEngine();
    abstract void stopEngine();
    
    public void serviceInfo() 
    {
        System.out.println("Servicing Instructions:" + make + " " + model);
    }
}
class Car extends Vehicle
 {
    public Car(String make, String model) 
    {
        super(make, model);
    }

    @Override
    void startEngine()
    {
        System.out.println(make + " " + model + " engine has started ");
    }

    @Override
    void stopEngine() {
        System.out.println(make + " " + model + "engine has stopped");
    }
}
public class VehicleTest
 {
    public static void main(String[] args)
    {
        Car myCar = new Car("Toyota", "Corolla");
        myCar.startEngine();
        myCar.serviceInfo();
        myCar.stopEngine();
    }
}