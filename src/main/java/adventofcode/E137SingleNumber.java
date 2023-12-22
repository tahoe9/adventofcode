package adventofcode;

public class E137SingleNumber {

    public int singleNumber(int[] nums) {
        int once=0;
        int twice=0;
        for(int num : nums){
            once=(once^num) & (~twice);
            twice=(twice^num) & (~once);
        }
        return once;
    }

    public static void main(String[] strings) {
        System.out.println(new E137SingleNumber().singleNumber(new int[]{2,2,3,2}) == 3);
    }

}
