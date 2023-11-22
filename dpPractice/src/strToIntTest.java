import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;
import java.util.List;

public class strToIntTest {


    public static void main(String[] args) {
//        String str ="   -42";
//        String str ="   4193 with words";
//        String str ="   words and 987";
//        String str ="-91283472332";
        String str ="+-2";

        int res = strToInt(str);

        System.out.println(res);
    }


    public static int strToInt(String str) {
        long res =0;
        List<String> nums = new ArrayList<>();
        boolean firstNoSpace = false;
        boolean fushu = false;

        for (int i=0;i<str.length();i++){

            if (!firstNoSpace) {
                if (str.substring(i,i+1).equals(" ")) {
                    continue;
                } else {
                    firstNoSpace = true;

                    if(str.substring(i,i+1).equals("+")){
                        continue;
                    } else if(str.substring(i,i+1).equals("-")){
                        fushu = true;
                    } else if(str.charAt(i)>47 && str.charAt(i)<58){
                        nums.add(str.substring(i,i+1));
                    } else {
                        return 0;
                    }
                }
            } else {
                if(str.charAt(i)>47 && str.charAt(i)<58){
                    nums.add(str.substring(i,i+1));
                } else {
                    break;
                }
            }
        }

        if (nums.size()==0){
            return 0;
        }

        for (int i=0;i<nums.size();i++){
            res+=(nums.get(i).charAt(0)-48)*Math.pow(10, nums.size()-1-i);
        }

        if (fushu){
            res = -res;
        }

        if(res> Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        } else if(res < Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        } else {
            return (int)res;
        }



    }



}
