import java.util.HashSet;

public class UniqueNames {
    public static void main(String[] args) {
        
        String[] names = {"Aman", "Varchasv", "Sourabh", "Varchasv", "Aman"};

        HashSet<String> uniqueNames = new HashSet<>();
        for (String name : names) {
            uniqueNames.add(name);
        }

        String nameToCheck = "Aman";
        if (uniqueNames.contains(nameToCheck)) {
            System.out.println(nameToCheck + " exists in the set.");
        } else {
            System.out.println(nameToCheck + " does not exist in the set.");
        }

        System.out.println("\nUnique names:");
        for (String uniqueName : uniqueNames) {
            System.out.println(uniqueName);
        }
    }
}