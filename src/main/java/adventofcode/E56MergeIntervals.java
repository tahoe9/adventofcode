package adventofcode;

import java.util.ArrayList;
import java.util.Arrays;

public class E56MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        ArrayList<int[]> list =  new ArrayList();
        for(int[] curr : intervals) {
            if (list.isEmpty()) {
                list.add(curr);
                continue;
            }

            int[] prev = list.get(list.size()-1);
            if (prev[1] < curr[0]) {
                list.add(curr);
                continue;
            }

            prev[1] = Math.max(prev[1], curr[1]);
        }

        int[][] res = new int[list.size()][];
        for(int i=0; i<list.size(); i++)
            res[i] = list.get(i);

        return res;
    }

    public static void main(String[] strings) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] result = new E56MergeIntervals().merge(intervals);
        System.out.println(result[0][0] == 1);
        System.out.println(result[0][1] == 6);
        System.out.println(result[1][0] == 8);
        System.out.println(result[1][1] == 10);
        System.out.println(result[2][0] == 15);
        System.out.println(result[2][1] == 18);
    }
}
