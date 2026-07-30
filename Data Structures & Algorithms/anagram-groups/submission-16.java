class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str: strs){
            int[] f = new int[26];
            for(char ch: str.toCharArray()){
                f[ch-'a']++;
            }
            String key = Arrays.toString(f);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
