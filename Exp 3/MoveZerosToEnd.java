import java.util.Scanner;
class MoveZerosToEnd
 {    
    static void push(int[] arr)
    {
        int n = arr.length;
        int[] temp = new int[n];
        int j = 0;
        for (int i = 0; i < n; i++)
        {
            if (arr[i] != 0)
                temp[j++] = arr[i];
        }
        while (j < n)
            temp[j++] = 0;
        for (int i = 0; i < n; i++)
            arr[i] = temp[i];
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) 
        {
            arr[i] = sc.nextInt();
        }
        push(arr);
        System.out.println("Array after moving zeros to the end:");
        for (int i=0; i < arr.length; i++)
        {
            System.out.print(arr[i] + " ");
        }
    }
}