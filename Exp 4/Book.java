class Book {
String title;
String author;
Integer publicationYear;
public Book() {
this.title = "Untitled";
this.author = "Unknown Author";
this.publicationYear = null;
}
public Book(String title, String author) {
this.title = title;
this.author = author;
this.publicationYear = null;
}
public Book(String title, String author, int publicationYear) {
this.title = title;
this.author = author;
this.publicationYear = publicationYear;
}
public void displayDetails() {
System.out.println("Title: " + title);
System.out.println("Author: " + author);
System.out.println("Publication Year: " +
(publicationYear != null ? publicationYear : "Not Provided"));
}
public static void main(String[] args) {
Book book1 = new Book();
book1.displayDetails();
System.out.println();
Book book2 = new Book("The Great Gatsby", "F. Scott Fitzgerald");
book2.displayDetails();
System.out.println();
Book book3 = new Book("1984", "George Orwell", 1949);
book3.displayDetails();
}}