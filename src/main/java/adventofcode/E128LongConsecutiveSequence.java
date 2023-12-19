package adventofcode;

import java.util.HashSet;
import java.util.Set;

public class E128LongConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        int[] arr = new int[(int)Math.pow(10, 5)+1];

        Set<Integer> res = new HashSet();
        for(int num : nums) res.add(num);

        int max = 0;
        for(int num : nums) {
            if (res.contains(num-1)) continue;

            int seq = num;
            while(res.contains(seq)) seq++;

            max = Math.max(max, seq-num);
        }

        return max;
    }

    public static void main(String[] strings) {
        int[] nums = {100,4,200,1,3,2};
        System.out.println(new E128LongConsecutiveSequence().longestConsecutive(nums) == 4);
    }
}
