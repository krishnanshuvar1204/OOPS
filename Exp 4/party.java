class Club
 {
    static String clubName = "Elite Club";
    String memberName;

    static void displayClubName() 
    {
        System.out.println("Club Name: " + clubName);
    }
}

public class party
 {
    public static void main(String[] args)
    {
        Club member1 = new Club();
        member1.memberName = "Alice";
        
        Club member2 = new Club();
        member2.memberName = "Bob";
        
        Club member3 = new Club();
        member3.memberName = "Charlie";

        Club.displayClubName();
        System.out.println("Member: " + member1.memberName);
        
        member2.displayClubName();
        System.out.println("Member: " + member2.memberName);
        
        member3.displayClubName();
        System.out.println("Member: " + member3.memberName);
    }
}