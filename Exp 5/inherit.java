class Parent
 {
    private int marks = 100;

    public int getmarks() 
    {
        return marks;
    }
}

class Child extends Parent
 {
    public void display()
    {
        System.out.println("marks: " + getmarks());
    }
}

public class inherit
{
    public static void main(String[] args) 
    {
        Child obj = new Child();
        obj.display();
    }
}