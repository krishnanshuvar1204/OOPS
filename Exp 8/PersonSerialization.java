import java.io.*;
class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}

public class PersonSerialization {
    public static void main(String[] args) {
        String fileName = "person.txt";
        Person person = new Person("Alice", 25);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(person);
            System.out.println("Person serialized.");
        } catch (IOException e) {
            System.out.println("Serialization error: " + e.getMessage());
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            Person deserializedPerson = (Person) ois.readObject();
            System.out.println("Deserialized: " + deserializedPerson);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Deserialization error: " + e.getMessage());
        }
    }
}