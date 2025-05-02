class Car
 {
    private String make;
    private String model;
    private int year;

    public Car(String make, String model, int year) 
    {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public void displayCarDetails() 
    {
        System.out.println("Car Make: " + this.make);
        System.out.println("Car Model: " + this.model);
        System.out.println("Car Year: " + this.year);
    }

    public static void main(String[] args)
    {
        Car myCar = new Car("Tesla", "Model 3", 2025);
        myCar.displayCarDetails();
    }
}