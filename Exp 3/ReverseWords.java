import java.util.Scanner;
public class ReverseWords 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String s = sc.nextLine();
        String[] words = s.split(" ");
        System.out.print("Reversed sentence: ");
        for (int i = words.length - 1; i >= 0; i--)
        {
            System.out.print(words[i] + " ");
        }
 }
}