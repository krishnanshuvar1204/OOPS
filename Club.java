class Club {
    static String clubName = "Tech Club";
    String memberName;

    Club(String memberName) {
        this.memberName = memberName;
    }

    static void displayClubName() {
        System.out.println("Club Name: " + clubName);
    }

    void displayMemberDetails() {
        System.out.println("Member Name: " + memberName + " | Club: " + clubName);
    }

    public static void main(String[] args) {
        Club.displayClubName();

        Club member1 = new Club("Rahul");
        Club member2 = new Club("Rohan");
        Club member3 = new Club("Shruti");

        member1.displayMemberDetails();
        member2.displayMemberDetails();
        member3.displayMemberDetails();

        Club.clubName = "Coding Club";

        System.out.println("\nAfter changing club name:\n");

        member1.displayMemberDetails();
        member2.displayMemberDetails();
        member3.displayMemberDetails();
    }
}
