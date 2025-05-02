class Product 
{
    private int productId;
    private String productName;
    private String category;
    private double price;
    
    private static int totalProducts = 0;

    public Product()
    {
        this.productId = 0;
        this.productName = "Default Product";
        this.category = "General";
        this.price = 0.0;
        totalProducts++;
    }

    public Product(int productId, String productName, String category, double price) 
    {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.price = price;
        totalProducts++;
    }

    public double getPrice() 
    {
        return this.price;
    }

    public void displayProductInfo()
    {
        System.out.println("Product ID: " + this.productId);
        System.out.println("Product Name: " + this.productName);
        System.out.println("Category: " + this.category);
        System.out.println("Price:  " + this.price);
    }

    public static void displayTotalProducts() 
    {
        System.out.println("Total Products: " + totalProducts);
    }

    public double calculateStockValue(int quantity) 
    {
        return this.price * quantity;
    }

    public double calculateStockValue(int quantity, double discountRate) 
    {
        double discountedPrice = this.price - (this.price * discountRate / 100);
        return discountedPrice * quantity;
    }

    public static void main(String[] args)
    {
        Product product1 = new Product();
        Product product2 = new Product(101, "Laptop", "Electronics", 750.50);
        Product product3 = new Product(102, "Smartphone", "Electronics", 500.00);

        Product.displayTotalProducts();

        product1.displayProductInfo();
        System.out.println("Stock Value (10 units): " + product1.calculateStockValue(10));
        
        System.out.println();

        product2.displayProductInfo();
        System.out.println("Stock Value (5 units): " + product2.calculateStockValue(5));
        System.out.println("Stock Value (5 units with 10% discount): " + product2.calculateStockValue(5, 10));

        System.out.println();

        product3.displayProductInfo();
        System.out.println("Stock Value (8 units): " + product3.calculateStockValue(8));
        System.out.println("Stock Value (8 units with 15% discount): " + product3.calculateStockValue(8, 15));
    }
}