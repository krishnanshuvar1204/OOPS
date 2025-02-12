class SuperClass {
    private int priv = 10;
    public int getPriv() {
        return privateVar;
    }
}

class SubClass extends SuperClass {
    public void showPrivateVar() {
        // System.out.println("Private Variable: " + privateVar); // ERROR: Cannot access private member directly
        System.out.println("Private Variable (via getter): " + getPriv());
    }
}

public class PrivateAccess {
    public static void main(String[] args) {
        SubClass obj1 = new SubClass();
        obj1.showPrivateVar();
    }
}
