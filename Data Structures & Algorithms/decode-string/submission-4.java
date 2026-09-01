class Solution {
    public String decodeString(String s) {
        Stack<Integer> cSt = new Stack<>();
        Stack<StringBuilder> strSt = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int n = 0;

        for(char ch: s.toCharArray()){
            if(Character.isDigit(ch)){
                n = (n * 10) + (ch - '0');
            }else if(ch == '['){
                cSt.push(n);
                strSt.push(sb);
                sb = new StringBuilder();
                n = 0;
            }else if(ch == ']'){
                StringBuilder prev = strSt.pop();
                int r = cSt.pop();
                for(int i = 0; i < r; i++){
                    prev.append(sb);
                }
                sb = prev;
            }else{
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}