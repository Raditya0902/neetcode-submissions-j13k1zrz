class Solution {
    public boolean checkValidString(String s) {
        int min = 0, max = 0;
        for(char ch: s.toCharArray()){
            if(ch == '('){
                min++;
                max++;
            }else if(ch == ')'){
                max--;
                min--;
            }else{
                max++;
                min--;
            }
            if(max < 0) return false;
            if(min < 0) min = 0;
        }
        return min == 0;
    }
}
