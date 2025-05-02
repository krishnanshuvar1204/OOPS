import java.util.Scanner;

public class ElectricityBill {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the total units consumed: ");
        int units = scanner.nextInt();
        
        double bill = 0;
        
        if (units >= 1 && units <= 100) {
            bill = units * 5;
        } else if (units >= 101 && units <= 200) {
            bill = (100 * 5) + ((units - 100) * 7);
        } else if (units >= 201 && units <= 300) {
            bill = (100 * 5) + (100 * 7) + ((units - 200) * 10);
        } else if (units > 300) {
            bill = (100 * 5) + (100 * 7) + (100 * 10) + ((units - 300) * 15);
        } else {
            System.out.println("Invalid input");
            return;
        }
        
        System.out.println("The total electricity bill is Rs " + bill);
    }
}
