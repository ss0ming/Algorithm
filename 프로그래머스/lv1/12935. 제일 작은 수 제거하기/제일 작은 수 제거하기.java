import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int[] answer; 
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        if (arr.length == 1) {
            answer = new int[1];
            answer[0] = -1;
        } else {
            answer = new int[arr.length-1];
            int smallestN = arr[0];
            list.add(arr[0]);

            for (int i=1; i<arr.length; i++) {
                list.add(arr[i]);
                if (arr[i] < smallestN) {
                    smallestN = arr[i];
                }
            }

            int idxN = list.indexOf(smallestN);

            list.remove(idxN);

            int idx = 0;

            for (Integer n : list) {
                answer[idx++] = n;
            }
        }
          
        return answer;
    }
}