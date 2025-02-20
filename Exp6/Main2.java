import StudentRecords.Student;

public class Main2{
    public static void main(String[] args) {
        Student student1 = new Student("S001", "Alice", "A");
        Student student2 = new Student("S002", "Bob", "B+");

        student1.displayStudentInfo();
        System.out.println();
        student2.displayStudentInfo();
    }
}
