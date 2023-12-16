package adventofcode;

import java.util.ArrayDeque;
import java.util.Queue;

public class E909SnakesAndLadders {
    public int snakesAndLadders(int[][] board) {

        int[] array = new int[board.length * board.length + 1];
        boolean[] visited = new boolean[board.length * board.length + 1];

        int index = 1;
        boolean forward = true;

        for (int i = board.length-1; i >= 0; i--) {
            if (forward)
                for (int j = 0; j < board.length; ++j)
                    array[index++] = board[i][j];
            else
                for (int j=board.length-1; j>=0; j--)
                    array[index++] = board[i][j];

            forward = !forward;
        }


        Queue<Integer> q = new ArrayDeque<Integer>();
        q.offer(1);

        int minMoves = 0;

        while(!q.isEmpty()) {
            minMoves++;

            int size = q.size();

            for(int i=0; i<size; i++) {
                int loc = q.poll();

                for(int j=loc+1; j<=Math.min(loc+6, board.length * board.length); j++) {

                    int nextMove = array[j] == -1 ? j : array[j];

                    if (nextMove == board.length * board.length) return minMoves;
                    if (visited[nextMove]) continue;

                    q.offer(nextMove);
                    visited[nextMove] = true;
                }
            }
        }

        return -1;
    }

    public static void main(String[] strings) {
        int[][] board = {{-1,-1,-1,-1,-1,-1},
                         {-1,-1,-1,-1,-1,-1},
                         {-1,-1,-1,-1,-1,-1},
                         {-1,35,-1,-1,13,-1},
                         {-1,-1,-1,-1,-1,-1},
                         {-1,15,-1,-1,-1,-1}};

        System.out.println(new E909SnakesAndLadders().snakesAndLadders(board) == 4);
    }
}
