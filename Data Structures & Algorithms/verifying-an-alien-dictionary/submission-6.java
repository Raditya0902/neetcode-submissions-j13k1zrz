class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();
        int counter = 0;
        for(char ch: order.toCharArray()) map.put(ch, counter++);
        for(int i = 0; i < words.length - 1; i++){
            String w1 = words[i], w2 = words[i+1];
            for(int j = 0; j < w1.length(); j++){
                if(j == w2.length()) return false;
                else if(w1.charAt(j) != w2.charAt(j)){
                    if(map.get(w1.charAt(j)) > map.get(w2.charAt(j))) return false;
                    else break;
                }
            }
        }
        return true;
    }
}