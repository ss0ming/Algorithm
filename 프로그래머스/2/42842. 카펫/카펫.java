class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int w = 0;
        int h = 0;
        
        for (int i=1; i<=Math.sqrt(yellow); i++) {
            if (yellow % i != 0) continue;
            w = i;
            h = yellow/i;
            
            int tmp = (w+h) * 2 + 4;
            
            if (tmp == brown) break;
        }
        
        w += 2;
        h += 2;
        
        if (w > h) {
            answer[0] = w;
            answer[1] = h;
        } else {
            answer[0] = h;
            answer[1] = w;
        }
        
        return answer;
    }
}