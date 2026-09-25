class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";
        int n1 = num1.length(), n2 = num2.length();
        int[] ans = new int[n1 + n2];

        for(int i = n1 - 1; i >= 0; i--){
            int digit1 = num1.charAt(i) - '0';
            for(int j = n2 - 1; j >= 0; j--){
                int digit2 = num2.charAt(j) - '0';
                int prod = digit1 * digit2;
                int pos1 = i + j, pos2 = i + j + 1;
                int sum = prod + ans[pos2];
                ans[pos2] = sum % 10;
                ans[pos1] += sum / 10; 
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int digit: ans){
            if(sb.length() == 0 && digit == 0) continue;
            sb.append(digit);
        }
        return sb.toString();
    }
}
