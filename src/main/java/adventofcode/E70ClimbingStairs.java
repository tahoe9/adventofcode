package adventofcode;

public class E70ClimbingStairs {

    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[n]=1;
        dp[n-1]=1;
        for(int i=n-2; i>=0; i--) {
            dp[i] = dp[i+1] + dp[i+2];
        }

        return dp[0];
    }

    public static void main(String[] strings) {
        System.out.println(new E70ClimbingStairs().climbStairs(3) == 3) ;
    }

}
