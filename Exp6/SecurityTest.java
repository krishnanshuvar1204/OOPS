final class SecuritySystem {
    public void authenticateUser(String username, String password) {
        if (username == "admin" && password == "secure123") {
            System.out.println("Authentication successful! Welcome, " + username + ".");
        } else {
            System.out.println("Authentication failed! Invalid credentials.");
        }
    }
}

class AdvancedSecurity extends SecuritySystem {
    @Override
    public void authenticateUser(String username, String password) {
        System.out.println("Overriding logic");
    }
}

public class SecurityTest {
    public static void main(String[] args) {
        SecuritySystem security = new SecuritySystem();
        
        security.authenticateUser("admin", "secure123");
        security.authenticateUser("user", "password");
        AdvancedSecurity advSecurity = new AdvancedSecurity();
    }
}
