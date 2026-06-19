class Solution {
    public String foreignDictionary(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();
        for(String word: words){
            for(char ch: word.toCharArray()){
                graph.putIfAbsent(ch, new HashSet<>());
                indegree.put(ch, 0);
            }
        }

        for(int i = 0; i < words.length - 1; i++){
            String w1 = words[i], w2 = words[i+1];
            int minLen = Math.min(w1.length(), w2.length());
            if(w1.length() > w2.length() && w1.substring(0,minLen).equals(w2.substring(0,minLen))) return "";

            for(int j = 0; j < minLen; j++){
                char c1 = w1.charAt(j), c2 = w2.charAt(j);
                if(c1 != c2){
                    if(!graph.get(c1).contains(c2)){
                        graph.get(c1).add(c2);
                        indegree.put(c2, indegree.get(c2) + 1);
                    }
                    break;
                }
            }
        }

        Queue<Character> q = new LinkedList<>();
        for(char ch: indegree.keySet()){
            int val = indegree.get(ch);
            if(val == 0) q.offer(ch);
        }

        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            char ch = q.poll();
            sb.append(ch);
            for(char nei: graph.get(ch)){
                indegree.put(nei, indegree.get(nei) - 1);
                if(indegree.get(nei) == 0) q.offer(nei);
            }
        }

        return sb.length() == indegree.size() ? sb.toString() : "";
    }
}
