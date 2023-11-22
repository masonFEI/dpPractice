import java.util.Deque;
import java.util.LinkedList;

public class flipChessTest {


    private static int m;
    private static int n;
    private static String[] chessboard;

    public static void main(String[] args) {
        String[] chessboard = new String[]{"..X.X.X", "..OO.", "XOOO..", "......", "......"};


        int res = flipChess(chessboard);

        System.out.println(res);

    }


    public static int flipChess(String[] chessboard) {

        chessboard = chessboard;
        m = chessboard.length;
        n = chessboard[0].length();


        int result = 0;
        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {
                result = Math.max(result, bfs(i, j));
            }
        }

        return result;

    }


    public static int bfs(int i, int j) {

        if (chessboard[i].charAt(j) != '.') {
            return 0;
        }

        char[][] g = new char[m][0];
        for (int k = 0; k < m; k++) {
            g[k] = chessboard[k].toCharArray();
        }

        g[i][j] = 'X';
        Deque<int[]> queue = new LinkedList<>();
        queue.offerLast(new int[]{i, j});
        int count =0;


        while (!queue.isEmpty()){
            int[] black = queue.pollFirst();
            int x =black[0];
            int y =black[1];

            for (int dx = -1;dx<=1;dx++){

                for (int dy = -1;dy<=1;dy++){
                    if(dx == 0 && dy == 0){
                        continue;
                    }

                    int curX =x+dx;
                    int curY =y+dy;

                    while (curX>=0 && curY>=0 &&curX<m && curY<n && g[curX][curY]=='O'){
                        curX+=dx;
                        curY+=dy;
                    }

                    if (curX >=0 && curY>=0 && curX<m && curY<n && g[curX][curY]=='X'){
                        curX-=dx;
                        curY-=dy;

                        while (curX !=x || curY !=y){
                            count++;
                            queue.offerLast(new int[]{curX,curY});
                            g[curX][curY] ='X';
                            curX-=dx;
                            curY-=dy;
                        }

                    }
                }
            }
        }

        return count;
    }


}
