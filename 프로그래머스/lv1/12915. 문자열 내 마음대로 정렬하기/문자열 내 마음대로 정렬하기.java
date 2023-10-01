class Solution {
    public String[] solution(String[] strings, int n) {
        
        for (int i=0; i<strings.length-1; i++) {
            for (int j=i+1; j<strings.length; j++) {
                if (Character.compare(strings[i].charAt(n), strings[j].charAt(n)) > 0) {
                    String tmp = strings[i];
                    strings[i] = strings[j];
                    strings[j] = tmp;
                } else if (Character.compare(strings[i].charAt(n), strings[j].charAt(n)) == 0) {
                    if (strings[i].compareTo(strings[j]) > 0) {
                        String tmp = strings[i];
                        strings[i] = strings[j];
                        strings[j] = tmp;
                    }
                }
            }
        }
        
        return strings;
    }
}