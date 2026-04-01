class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int n = 0;
        for(char ch: s.toCharArray()){
            if(Character.isDigit(ch)){
                n = n * 10 + (ch - '0');
            }else if(ch == '['){
                countStack.push(n);
                stringStack.push(sb);
                n = 0;
                sb = new StringBuilder();
            }else if(ch == ']'){
                int number = countStack.pop();
                StringBuilder prev = stringStack.pop();
                for(int i = 0; i < number; i++){
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