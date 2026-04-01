class Solution {
    public String decodeString(String s) {
        Stack<Integer> cSt = new Stack<>();
        Stack<StringBuilder> sSt = new Stack<>();
        int n = 0;
        StringBuilder sb = new StringBuilder();
        for(char ch: s.toCharArray()){
            if(Character.isDigit(ch)){
                n = n * 10 + (ch - '0');
            }
            else if(ch == '['){
                cSt.push(n);
                sSt.push(sb);
                n = 0;
                sb = new StringBuilder();
            }
            else if(ch == ']'){
                int repeat = cSt.pop();
                StringBuilder prev = sSt.pop();
                for(int i = 0; i < repeat; i++){
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