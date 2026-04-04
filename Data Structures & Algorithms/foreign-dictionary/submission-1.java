class Solution {
    public String foreignDictionary(String[] words) {
        Map<Character, Set<Character>> adj = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        for(String word: words){
            for(char ch: word.toCharArray()){
                adj.putIfAbsent(ch, new HashSet<>());
                indegree.putIfAbsent(ch, 0);
            }
        }

        for(int i = 0; i < words.length - 1; i++){
            String w1 = words[i], w2 = words[i+1];
            int l1 = w1.length(), l2 = w2.length();
            int minLen = Math.min(l1,l2);
            if(l1 > l2 && w1.substring(0,minLen).equals(w2.substring(0,minLen))){
                return "";
            }
            for(int j = 0; j < minLen; j++){
                if(w1.charAt(j) != w2.charAt(j)){
                    if(!adj.get(w1.charAt(j)).contains(w2.charAt(j))){
                        adj.get(w1.charAt(j)).add(w2.charAt(j));
                        indegree.put(w2.charAt(j), indegree.get(w2.charAt(j)) + 1);
                    }
                    break;
                }
            }
        }

        Queue<Character> q = new LinkedList<>();
        for(Character key: indegree.keySet()){
            if(indegree.get(key) == 0) q.offer(key);
        }

        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            char ch = q.poll();
            sb.append(ch);
            for(char nei: adj.get(ch)){
                indegree.put(nei, indegree.get(nei) - 1);
                if(indegree.get(nei) == 0) q.offer(nei);
            }
        }

        if(sb.length() != indegree.size()) return "";
        return sb.toString();
    }
}
