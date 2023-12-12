package adventofcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class E120Traingle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int min = Integer.MAX_VALUE;

        for(int row=1; row<triangle.size(); row++) {
            for(int col=0; col<triangle.get(row).size(); col++) {
                int prevRowPrevCol = col-1 >=0 ? triangle.get(row-1).get(col-1) : Integer.MAX_VALUE;
                int prevRowSameCol = col < triangle.get(row-1).size() ? triangle.get(row-1).get(col) : Integer.MAX_VALUE;
                triangle.get(row).set(col, triangle.get(row).get(col) + Math.min(prevRowPrevCol, prevRowSameCol));

                if (row == triangle.size()-1) {
                    min = Math.min(min, triangle.get(row).get(col));
                }
            }
        }

        return triangle.size() == 1 ? triangle.get(0).get(0) : min;
    }

    public static void main(String[] strings) {
        // [[2],[3,4],[6,5,7],[4,1,8,3]]
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3,4));
        triangle.add(Arrays.asList(6,5,7));
        triangle.add(Arrays.asList(4,1,8,3));

        System.out.println(new E120Traingle().minimumTotal(triangle) == 11);
    }
}
