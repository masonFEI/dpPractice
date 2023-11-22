public class reverseWordsTest {


    public static void main(String[] args) {
        String s ="a";


        String res = reverseWords(s);

        System.out.println(res);
    }


    public static String reverseWords(String s) {
        String res ="";

        if(s.length()==0){
            return res;
        }
        int breakIndex = s.length();
        for(int i=s.length()-1;i>=0;i--){

            if (s.substring(i,i+1).equals(" ")) {

                if (res.equals("")) {

                    if(!s.substring(i+1,breakIndex).equals(" ") && !s.substring(i+1,breakIndex).equals("")){
                        res+=s.substring(i+1,breakIndex).trim()+" ";
                    }
                } else {
                    if(!s.substring(i+1,breakIndex).equals(" ") && !s.substring(i+1,breakIndex).equals("")){
                        res+=s.substring(i+1,breakIndex);
                    }
                }

                breakIndex = i+1;
            }
        }

        res+=s.substring(0,breakIndex);

        return res.trim();
    }


}
