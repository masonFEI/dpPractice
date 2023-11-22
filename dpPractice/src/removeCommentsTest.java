import java.util.ArrayList;
import java.util.List;

public class removeCommentsTest {


    public static void main(String[] args) {
        String[] source ={"a/*comment", "line", "more_comment*/b"};


        List<String> res = removeComments(source);

        System.out.println(res);

    }

    public static List<String> removeComments(String[] source) {

        List<String> res = new ArrayList<>();
        boolean block = false;
        StringBuilder sb = new StringBuilder();

        for (int i =0;i<source.length;++i){
            String eleString = source[i];

            int m = eleString.length();
            for (int j=0;j<m;j++){

                if (block) {
                    if(j < m-1 && eleString.charAt(j)=='*'&& eleString.charAt(j+1)=='/'){
                        block=false;
                        j++;
                    }
                } else {
                    if (j < m-1 && eleString.charAt(j)=='/'&& eleString.charAt(j+1)=='*') {
                        block=true;
                        j++;
                    } else if(j < m-1 && eleString.charAt(j)=='/'&& eleString.charAt(j+1)=='/'){
                        break;
                    } else {
                        sb.append(eleString.charAt(j));
                    }
                }
            }

            if (!block && sb.length()>0) {
                res.add(sb.toString());
                sb.setLength(0);
            }
        }

        return res;



    }




}
