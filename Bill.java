import java.util.*;
public class Bill{
    public static void Total_Bill(int unit){
        int cost = 0;
        if (unit > 1 && unit < 100){
            cost = 5*unit;
        }
        else if(unit >= 100 && unit < 200){
            cost = 7*unit;
        }
        else if(unit >= 200 && unit < 300){
            cost = 10*unit;
        }
        else if (unit >= 300 && unit < 400){
            cost = 15*unit;
        }

        System.out.println(cost);
    }        


    public static void main(String args[]){
        System.out.println("Enter the Total Units Consumed");
        Scanner myScan = new Scanner(System.in);
        int unit = myScan.nextInt();
        Total_Bill(unit); 

    }
}