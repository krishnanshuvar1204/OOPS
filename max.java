public class max {
    public static int[] findMaxMin(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) 
                max = nums[i];
            if (nums[i] < min) 
                min = nums[i];
        }
        return new int[]{max, min};
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 8, 2, 5, 10, -3, 7};
        int[] result = findMaxMin(nums);
        
        System.out.println("Maximum: " + result[0]);
        System.out.println("Minimum: " + result[1]);
    }
}
