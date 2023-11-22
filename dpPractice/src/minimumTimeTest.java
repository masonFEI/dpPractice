import java.util.*;

public class minimumTimeTest {


    public static void main(String[] args) {
        int n = 5;
        int[][] relations = {{1,5},{2,5},{3,5},{3,4},{4,5}};
        int[] time = {1,2,3,4,5};

        int res = minimumTime(n,relations,time);

        System.out.println(res);
    }


    public static int minimumTime(int n, int[][] relations, int[] time) {
        List<Integer>[] g = new ArrayList[n+1];
        Arrays.setAll(g, e -> new ArrayList<>());
        int[] deg = new int[n+1];
        for (int[] r : relations) {
            int x = r[0], y = r[1];
            g[x].add(y);
            deg[y]++;
        }

        ArrayDeque<Integer> q = new ArrayDeque<Integer>();
        for (int i = 1; i <= n; i++)
            if (deg[i] == 0) // 没有先修课
                q.add(i);
        int[] f = new int[n+1];
        int ans = 0;
        while (!q.isEmpty()) {
            int x = q.poll(); // x 出队，意味着 x 的所有先修课都上完了
            f[x] += time[x-1]; // 加上当前课程的时间，就得到了最终的 f[x]
            ans = Math.max(ans, f[x]);
            for (int y : g[x]) { // 遍历 x 的邻居 y
                f[y] = Math.max(f[y], f[x]); // 更新 f[y] 的所有先修课程耗时的最大值
                if (--deg[y] == 0) // y 的先修课已上完
                    q.add(y);
            }
        }
        return ans;

    }


}
