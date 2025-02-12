import java.util.Scanner;
class Book
 {
    String title;
    String author;
    int publicationYear;

    public Book() 
    {
        this.title = "Untitled";
        this.author = "Unknown Author";
        this.publicationYear = 0;
    }

    public Book(String title, String author)
    {
        this.title = title;
        this.author = author;
        this.publicationYear = 0;
    }

    public Book(String title, String author, int publicationYear) 
    {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    public void displayDetails()
    {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Publication Year: " + publicationYear);
    }
}

public class Main {
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