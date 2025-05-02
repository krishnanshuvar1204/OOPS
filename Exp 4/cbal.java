class Customer 
{
    private double balance;

    public void addBalance(double amount) {
        balance += amount;
    }

    public void addBalance(int amount) {
        balance += amount;
    }

    protected void deductBalance(double amount) {
        balance -= amount;
    }

    void showBalance() {
        System.out.println("Current Balance: " + balance);
    }
}

public class cbal
{
    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.addBalance(100.50);
        customer.addBalance(50);
        customer.showBalance();
        customer.deductBalance(30);
        customer.showBalance();
    }
}