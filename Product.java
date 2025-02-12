class Product {
    int productId;
    String productName;
    String category;
    private double price;

    static int totalProducts = 0;

    Product() {
        this.productId = 0;
        this.productName = "Default Product";
        this.category = "General";
        this.price = 0.0;
        totalProducts++;
    }

    Product(int productId, String productName, String category, double price) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.price = price;
        totalProducts++;
    }

    public double getPrice() {
        return price;
    }

    void displayProductInfo() {
        System.out.println("Product ID: " + productId);
        System.out.println("Product Name: " + productName);
        System.out.println("Category: " + category);
        System.out.println("Price: $" + price);
    }

    static void displayTotalProducts() {
        System.out.println("Total Products: " + totalProducts);
    }

    double calculateStockValue(int quantity) {
        return price * quantity;
    }

    double calculateStockValue(int quantity, double discountRate) {
        double totalValue = price * quantity;
        double discountAmount = totalValue * (discountRate / 100);
        return totalValue - discountAmount;
    }

    public static void main(String[] args) {
        Product p1 = new Product(101, "Laptop", "Electronics", 750.0);
        Product p2 = new Product(102, "Smartphone", "Electronics", 500.0);
        Product p3 = new Product();
        Product.displayTotalProducts();
    
        p1.displayProductInfo();
        p2.displayProductInfo();
        p3.displayProductInfo();

        int quantity = 10;
        System.out.println("Stock Value of " + p1.productName + " (10 units): $" + p1.calculateStockValue(quantity));
        System.out.println("Stock Value of " + p2.productName + " (10 units, 10% discount): $" + p2.calculateStockValue(quantity, 10.0));
    }
}
