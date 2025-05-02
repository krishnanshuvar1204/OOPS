import java.util.*;
class MajorityElementFinder 
{
    static int majorityElement(int[] arr)
    {
        int n = arr.length;

        for (int i = 0; i < n; i++) 
        {
            int count = 0;

            for (int j = 0; j < n; j++) 
            {
                if (arr[i] == arr[j])
                {
                    count++;
                }
            }

            if (count > n / 2)
            {
                return arr[i];
            }
        }
        return -1;
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

        System.out.println("Majority Element: " + majorityElement(arr));
    }
}