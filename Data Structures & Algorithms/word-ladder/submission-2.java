class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if(!set.contains(endWord)) return 0;

        Set<String> vis = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        vis.add(beginWord);
        int steps = 1;

        while(!q.isEmpty()){
            int size = q.size();
            for(int s = 0; s < size; s++){
                String curr = q.poll();
                if(curr.equals(endWord)) return steps;
                char[] chars = curr.toCharArray();
                for(int i = 0; i < chars.length; i++){
                    char ori = chars[i];
                    for(char ch = 'a'; ch <= 'z'; ch++){
                        if(ch == ori) continue;
                        chars[i] = ch;
                        String next = new String(chars);
                        if(set.contains(next) && !vis.contains(next)){
                            vis.add(next);
                            q.offer(next);
                        }
                    }
                    chars[i] = ori;
                }
            }
            steps++;
        }

        return 0;
    }
}
