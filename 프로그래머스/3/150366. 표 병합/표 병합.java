import java.util.*;

class Solution {

    static String[][] table = new String[50][50];
    static List<String> answers = new ArrayList<>();
    static int[] parent = new int[2500];
    
    public String[] solution(String[] commands) {
        
        for (int i=0; i<2500; i++) {
            parent[i] = i;
        } 
        
        for (int i=0; i<50; i++) {
            Arrays.fill(table[i], "EMPTY");
        }
        
        for (int t=0; t<commands.length; t++) {
            String[] command = commands[t].split(" ");
            String cmd = command[0];
            
            if (cmd.equals("UPDATE")) {
                if (command.length == 3) {
                    for (int i=0; i<50; i++) {
                        for (int j=0; j<50; j++) {
                            if (table[i][j].equals(command[1])) {
                                table[i][j] = command[2];
                            }
                        }
                    } 
                } else {
                    int r = Integer.parseInt(command[1]) - 1;
                    int c = Integer.parseInt(command[2]) - 1;
                    String v = command[3];
                    int root = find(r * 50 + c);
                    for (int i=0; i<2500; i++) {
                        if (parent[i] == root) {
                            int x = i / 50;
                            int y = i % 50;
                            table[x][y] = v;
                        }
                    }
                }
            } else if (cmd.equals("MERGE")) {
                int r1 = Integer.parseInt(command[1]) - 1;
                int c1 = Integer.parseInt(command[2]) - 1;
                int r2 = Integer.parseInt(command[3]) - 1;
                int c2 = Integer.parseInt(command[4]) - 1;
                
                int root1 = find(r1 * 50 + c1);
                int root2 = find(r2 * 50 + c2);
                union(root1, root2);
                int root = find(root1);
                
                String v = "EMPTY";
                if (table[r1][c1].equals("EMPTY") && !table[r2][c2].equals("EMPTY")) {
                    v = table[r2][c2];
                } else {
                    v = table[r1][c1];
                }
                
                for (int i=0; i<2500; i++) {
                    if (parent[i] == root1 || parent[i] == root2 || parent[i] == root) {
                        parent[i] = root;
                        int x = i / 50;
                        int y = i % 50;
                        table[x][y] = v;
                    }
                }
            } else if (cmd.equals("UNMERGE")) {
                int r = Integer.parseInt(command[1]) - 1;
                int c = Integer.parseInt(command[2]) - 1;
                String v = table[r][c];
                int root = find(r * 50 + c);
                
                for (int i=0; i<2500; i++) {
                    if (parent[i] == root) {
                        parent[i] = i;
                        int x = i / 50;
                        int y = i % 50;
                        table[x][y] = "EMPTY";
                    }
                }
                table[r][c] = v;
                
            } else if (cmd.equals("PRINT")) {
                int r = Integer.parseInt(command[1]) - 1;
                int c = Integer.parseInt(command[2]) - 1;
                answers.add(table[r][c]);
            }
            
        }
        
        return answers.stream().toArray(String[]::new);
    }
    
    private static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }
    
    private static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            if (x > y) parent[x] = y;
            else parent[y] = x;
        }
    }
}