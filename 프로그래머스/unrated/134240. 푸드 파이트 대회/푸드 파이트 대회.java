class Solution {
    public String solution(int[] food) {
        String answer = "";
        
        for (int i=1; i<food.length; i++) {
            if(food[i]/2 > 0) {
                for (int j=0; j<food[i]/2; j++) {
                    answer += Integer.toString(i);
                }
            }
        }
        
        StringBuilder sb = new StringBuilder(answer).reverse();
        answer += "0";
        answer += sb.toString();
        
        return answer;
    }
}