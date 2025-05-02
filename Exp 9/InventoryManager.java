import java.util.HashMap;
import java.util.Map;

public class InventoryManager {
    public static void main(String[] args) {
    
        HashMap<Integer, Integer> inventory = new HashMap<>();

        inventory.put(101, 50);   
        inventory.put(102, 30);  
        inventory.put(103, 20);   

        System.out.println("Initial Inventory: " + inventory);
        inventory.put(102, 40);
        System.out.println("Updated product 102 quantity to 40.");

        inventory.remove(103);
        System.out.println("Removed product 103 from the inventory.");

        System.out.println("\nFinal Inventory:");
        for (Map.Entry<Integer, Integer> entry : inventory.entrySet()) {
            System.out.println("Product ID: " + entry.getKey() + ", Quantity: " + entry.getValue());
        }
    }
}