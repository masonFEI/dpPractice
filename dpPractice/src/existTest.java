import java.util.LinkedList;

public class existTest {


    public static void main(String[] args) {
//        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
//
//        String word = "ABCCED";


//        char[][] board = {{'a','b'},{'c','d'}};
//
//        String word = "abcd";

//        char[][] board = {{'C','A','A'},{'A','A','A'},{'B','C','D'}};
//
//        String word = "AAB";


        char[][] board = {{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};

        String word = "ABCEFSADEESE";




        boolean res = exist(board,word);

        System.out.println(res);
    }


    public static boolean exist(char[][] board, String word) {

        int stringIndex = 0;
        boolean res = false;

//        res = checkLoop(board,  word, 1, 1, stringIndex, masks);
        Loop:for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                if (board[i][j] == word.charAt(stringIndex)) {
                    int[][] masks = new int[board.length][board[0].length];
                    res = checkLoop(board,  word, i, j, stringIndex, masks);
                    if(res){
                        break Loop;
                    }
                }
            }
        }

        return res;




    }


    public static boolean checkLoop(char[][] board, String word,int i,int j,int stringIndex,int[][] masks){

        if (masks[i][j] == 0 && board[i][j] == word.charAt(stringIndex)) {
            masks[i][j] = 1;

            if (stringIndex == word.length()-1) {
                return true;
            } else {
                stringIndex++;
                boolean tmpres = false;
                if (j+1 < board[0].length && masks[i][j+1]==0) {// 右
                    tmpres = checkLoop(board,  word, i, j+1, stringIndex, masks);

                    if(!tmpres){
                        masks[i][j+1] = 0;
                    }

                }

                if (!tmpres && i+1 < board.length && masks[i+1][j]==0) {// 下

                    tmpres = checkLoop(board,  word, i+1, j, stringIndex, masks);

                    if(!tmpres){
                        masks[i+1][j] = 0;
                    }
                }


                if(!tmpres && j-1 >= 0 && masks[i][j-1]==0) {// 左
                    tmpres = checkLoop(board,  word, i, j-1, stringIndex, masks);

                    if(!tmpres){
                        masks[i][j-1] = 0;
                    }
                }

                if (!tmpres && i-1 >= 0 && masks[i-1][j]==0){// 上
                    tmpres = checkLoop(board,  word, i-1, j, stringIndex, masks);

                    if(!tmpres){
                        masks[i-1][j] = 0;
                    }
                }

                if (!tmpres){
                    return false;
                } else {
                    return true;
                }
            }

        } else {
            return false;
        }

    }




}
