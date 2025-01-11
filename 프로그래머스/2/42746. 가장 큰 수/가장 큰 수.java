import java.util.*;

class Solution {
    
    public String solution(int[] numbers) {
        List<String> list = new ArrayList<>();

        for(int n : numbers) {
            list.add (String.valueOf(n));
        }
       
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
    
                String str1 = o1+o2;
                String str2 = o2+o1;
                return str2. compareTo (str1);
            }
        });

        String answer ="";
        for(String s : list){
            answer += s;
        }

        if(answer.startsWith("0")) answer="0";
        
        return answer;
    }
}