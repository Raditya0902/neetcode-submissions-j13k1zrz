class Solution {
    public String foreignDictionary(String[] words) {
        Map<Character, Set<Character>> adj = new HashMap<>();
        Map<Character, Integer> ind = new HashMap<>();

        for(String word: words){
            for(char ch: word.toCharArray()){
                adj.putIfAbsent(ch, new HashSet<>());
                ind.putIfAbsent(ch, 0);
            }
        }

        for(int i = 0; i < words.length - 1; i++){
            String w1 = words[i];
            String w2 = words[i+1];
            int minLen = Math.min(w1.length(), w2.length());
            if(w1.length() >  w2.length() && w1.substring(0,minLen).equals(w2.substring(0,minLen))){
                return "";
            }
            for(int j = 0; j < minLen; j++){
                if(w1.charAt(j) != w2.charAt(j)){
                    if(!adj.get(w1.charAt(j)).contains(w2.charAt(j))){
                        adj.get(w1.charAt(j)).add(w2.charAt(j));
                        ind.put(w2.charAt(j), ind.get(w2.charAt(j)) + 1);
                    }
                    break;
                }
            }
        }

        Queue<Character> q = new LinkedList<>();
        for(char ch: ind.keySet()){
            if(ind.get(ch) == 0){
                q.offer(ch);
            }
        }

        StringBuilder res = new StringBuilder();

        while(!q.isEmpty()){
            char ch = q.poll();
            res.append(ch);
            for(char nei: adj.get(ch)){
                ind.put(nei, ind.get(nei)-1);
                if(ind.get(nei) == 0){
                    q.offer(nei);
                }
            }
        }

        if(res.length() != ind.size()) return "";
        return res.toString();
    }
}
