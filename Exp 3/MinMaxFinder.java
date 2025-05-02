import java.util.Scanner;

public class MinMaxFinder 
{
    public static int[] findMinMax(int[] nums) 
    {
        int min = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) 
        {
            if (nums[i] < min) 
            {
                min = nums[i];
            }
            if (nums[i] > max) 
            {
                max = nums[i];
            }
        }

        return new int[]{max, min}; 
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++)
        {
            nums[i] = sc.nextInt();
        }

        int[] result = findMinMax(nums);
        System.out.println("[" + result[0] + ", " + result[1] + "]");
    }
}