class TaxCalculator {
    protected static final double GST_RATE = 18.0;
    
    public final void displayGST() {
        System.out.println("The GST rate is: " + GST_RATE + "%");
    }
}

class Invoice extends TaxCalculator {
    public double calculateTotalWithTax(double amount) {
        return amount + (amount * GST_RATE / 100);
    }
}

public class TaxationSystem {
    public static void main(String[] args) {
        Invoice invoice = new Invoice();
        
        invoice.displayGST();
        
        double amount = 1000.0;
        double totalAmount = invoice.calculateTotalWithTax(amount);
        System.out.println("Total amount after applying GST on " + amount + " is: " + totalAmount);
        
        // GST_RATE = 20.0; 
        // public void displayGST() {} 
    }
}
    