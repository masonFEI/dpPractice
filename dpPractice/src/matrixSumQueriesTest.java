import java.util.*;
import java.util.stream.Collectors;

public class matrixSumQueriesTest {

    public static void main(String[] args) {
        int n=3;
        int[][] queries=       {{0,0,1},{1,2,2},{0,2,3},{1,0,4}};


        long res = matrixSumQueries(n,queries);

        System.out.println(res);
    }

    public static long matrixSumQueries(int n, int[][] queries) {

        long res = 0l;
        int[][] lines = new int[n][n];

        Map<Integer,Integer> rowSum = new HashMap<>();
        int[] lineNum = new int[n];


        for (int i=0;i<queries.length;i++){
            int[] item=queries[i];

            if (item[0] == 0) {
                rowSum.put(item[1],item[2]*n);
            } else {

                lineNum[item[1]] = item[2];

                for (int rowI=0;rowI<n;rowI++){

                    if (rowSum.containsKey(rowI)) {
                        Integer rowItemSum = rowSum.get(rowI);
                        rowItemSum = rowItemSum - rowItemSum/n+item[2];
                        rowSum.put(rowI,rowItemSum);
                    } else {
                        rowSum.put(rowI,item[2]);
                    }

                }

            }

        }

        List<Integer> rowSumList =  rowSum.entrySet().stream().map(x->x.getValue()).collect(Collectors.toList());


        res=rowSumList.stream().reduce(Integer::sum).orElse(0);


        return res;


    }

}
