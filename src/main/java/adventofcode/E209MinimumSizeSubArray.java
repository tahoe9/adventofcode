package adventofcode;

public class E209MinimumSizeSubArray {
    public int minSubArrayLen(int target, int[] nums) {
        int min = Integer.MAX_VALUE;

        int sum = 0;
        int start = 0;
        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
            while(sum >= target) {
                min = Math.min(min, (i-start) + 1);
                sum = sum - nums[start];
                start++;
            }

        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] strings) {
        int[] nums = {2,3,1,2,4,3};
        System.out.println(new E209MinimumSizeSubArray().minSubArrayLen(7, nums) == 2);
    }
}
