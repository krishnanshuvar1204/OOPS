interface Vehicle {
    void start();
    void stop();
    int getFuelLevel();
}

class Car implements Vehicle {
    private int fuelLevel;

    Car(int fuelLevel) {
        this.fuelLevel = fuelLevel;
    }

    @Override
    public void start() {
        System.out.println("Car started.");
    }

    @Override
    public void stop() {
        System.out.println("Car stopped.");
    }

    @Override
    public int getFuelLevel() {
        return fuelLevel;
    }
}

class Motorcycle implements Vehicle {
    private int fuelLevel;

    Motorcycle(int fuelLevel) {
        this.fuelLevel = fuelLevel;
    }

    @Override
    public void start() {
        System.out.println("Motorcycle started.");
    }

    @Override
    public void stop() {
        System.out.println("Motorcycle stopped.");
    }

    @Override
    public int getFuelLevel() {
        return fuelLevel;
    }
}

public class VehicleManager {
    public static void main(String[] args) {
        Vehicle car = new Car(80);
        Vehicle motorcycle = new Motorcycle(50);

        car.start();
        System.out.println("Car Fuel Level: " + car.getFuelLevel() + "%");
        car.stop();

        motorcycle.start();
        System.out.println("Motorcycle Fuel Level: " + motorcycle.getFuelLevel() + "%");
        motorcycle.stop();
    }
}
