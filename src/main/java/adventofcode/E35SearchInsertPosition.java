package adventofcode;

public class E35SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {

        int start = 0;
        int end = nums.length;

        while(start < end) {
            int mid = (start + end)/2;

            if (nums[mid] < target) start = mid+1;
            else end = mid;
        }

        return start;
    }

    public static void main(String[] strings) {
        int[] nums = {1,3,5,6};

        System.out.println(new E35SearchInsertPosition().searchInsert(nums, 5));
    }
}
