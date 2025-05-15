import java.util.*;

class Solution {
    
    static char[][] arr;
    static int answer = 0;
    
    public int solution(int m, int n, String[] board) {
        arr = new char[board.length][board[0].length()];
        
        init(board);
        
        while (true) {
            if (!bomb()) {
                break;
            }
            down();
        }
        
        return answer;
    }
    
    private void down() {
        for (int i=0; i<arr[0].length; i++) {
            List<Character> list = new LinkedList<>();
            for (int j=arr.length-1; j>=0; j--) {
                if (arr[j][i] != 'x' && arr[j][i] != '0') {
                    list.add(arr[j][i]);
                }
            }
            
            for (int j=arr.length-1; j>=0; j--) {
                if (!list.isEmpty()) {
                    arr[j][i] = list.get(0);
                    list.remove(0);
                } else {
                    arr[j][i] = '0';
                }
            }
        }
    }
    
    private boolean bomb() {
        char[][] tmp = new char[arr.length][arr[0].length];
        boolean isBomb = false;
        for (int i=0; i<tmp.length-1; i++) {
            for (int j=1; j<tmp[0].length; j++) {
                char c = arr[i][j];
                if (c == '0') continue;
                if (c == arr[i][j-1] && c == arr[i+1][j] && c == arr[i+1][j-1]) {
                    isBomb = true;
                    tmp[i][j] = 'x';
                    tmp[i][j-1] = 'x';
                    tmp[i+1][j] = 'x';
                    tmp[i+1][j-1] = 'x';
                    
                }
            }
        }
        copy(tmp);
        return isBomb;
    }
    
    private void copy(char[][] tmp) {
        for (int i=0; i<tmp.length; i++) {
            for (int j=0; j<tmp[0].length; j++) {
                if (tmp[i][j] == 'x') {
                    arr[i][j] = tmp[i][j];
                    answer++;
                }
            }
        }
    }
    
    private void init(String[] board) {
        for (int i=0; i<board.length; i++) {
            arr[i] = board[i].toCharArray();
        }
    }
}