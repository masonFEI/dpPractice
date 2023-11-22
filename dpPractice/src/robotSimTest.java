import java.util.HashSet;
import java.util.Set;

public class robotSimTest {


    public static void main(String[] args) {
        int[] commands= new int[]{4,-1,4,-2,4};
        int[][] obstacles = new int[][]{{2,4}};

        int res = robotSim(commands,obstacles);

        System.out.println(res);
    }


    public static int robotSim(int[] commands, int[][] obstacles) {

        int[][] changeStep = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int vector = 0;
        int res = 0;
        int[] target = new int[2];
        Set<String> obstaclesSet = new HashSet<>();

        for (int i=0;i<obstacles.length;i++){
            obstaclesSet.add(String.valueOf(obstacles[i][0])+";"+String.valueOf(obstacles[i][1]));
        }

        for (int i=0;i<commands.length;i++){

            int commandItem = commands[i];

            if (commandItem==-1) {
                vector = (vector+1)%4;
            } else if(commandItem==-2){
                vector = (vector+3)%4;
            } else {

                while (commandItem > 0 && !obstaclesSet.contains(String.valueOf(changeStep[vector][0]+target[0])+";"+String.valueOf(changeStep[vector][1]+target[1])) ){
                    target[0]=changeStep[vector][0]+target[0];
                    target[1]=changeStep[vector][1]+target[1];
                    res = Math.max(res, target[0]*target[0]+target[1]*target[1]);
                    commandItem--;
                }
            }
        }

        return res;








    }


}
