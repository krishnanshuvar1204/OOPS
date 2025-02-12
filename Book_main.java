import java.util.Scanner;
class Book
 {
    String title;
    String author;
    int year;

    public Book() 
    {
        this.title = "ZerToOne";
        this.author = "Peter Theil";
        this.year = 2014;
    }

    public Book(String title, String author)
    {
        this.title = title;
        this.author = author;
        this.year = 0;
    }

    public Book(String title, String author, int year) 
    {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public void displayDetails()
    {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Publication Year: " + year);
    }
}

public class Book_main {
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        Book book1 = new Book();
        book1.displayDetails();

        System.out.print("\nEnter title for Book 2: ");
        String title2 = sc.nextLine();
        System.out.print("Enter author for Book 2: ");
        String author2 = sc.nextLine();
        Book book2 = new Book(title2, author2);
        book2.displayDetails();

        System.out.print("\nEnter title for Book 3: ");
        String title3 = sc.nextLine();
        System.out.print("Enter author for Book 3: ");
        String author3 = sc.nextLine();
        System.out.print("Enter publication year for Book 3: ");
        int year3 = sc.nextInt();
        Book book3 = new Book(title3, author3, year3);
        book3.displayDetails();
    }
}