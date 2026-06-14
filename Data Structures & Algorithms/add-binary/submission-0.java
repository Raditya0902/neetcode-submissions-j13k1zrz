class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1, j = b.length() - 1;
        while(i >= 0 || j >= 0 || carry > 0){
            int dA = i >= 0 ? a.charAt(i) - '0' : 0;
            int dB = j >= 0 ? b.charAt(j) - '0' : 0;
            int total = dA + dB + carry;
            sb.append(total % 2);
            carry = total / 2;
            i--;
            j--;
        }
        return sb.reverse().toString();
    }
}