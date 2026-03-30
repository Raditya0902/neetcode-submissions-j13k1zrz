class Solution {
    public int characterReplacement(String s, int k) {
        int ans = 0;
        HashSet<Character> set = new HashSet<>();
        for(char c: s.toCharArray()){
            set.add(c);
        }
        for(char c: set){
            int count = 0, l = 0;
            for(int r = 0; r < s.length(); r++){
                if(s.charAt(r) == c){
                    count++;
                }
                while((r-l+1)-count > k){
                    if(s.charAt(l) == c) count--;
                    l++;
                }
                ans = Math.max(ans, r - l + 1);
            }
        }
        return ans;
    }
}
