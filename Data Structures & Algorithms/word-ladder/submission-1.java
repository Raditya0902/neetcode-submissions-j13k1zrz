class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> q = new LinkedList<>();
        Set<String> set = new HashSet<>(wordList);

        q.offer(beginWord);
        int step = 1;

        while(!q.isEmpty()){
            int size = q.size();
            for(int s = 0; s < size; s++){
                String currWord = q.poll();
                if(currWord.equals(endWord)) return step;
                char[] chs = currWord.toCharArray();
                for(int i = 0; i < chs.length; i++){
                    char original = chs[i];
                    for(char j = 'a'; j <= 'z'; j++){
                        chs[i] = j;
                        String newWord = new String(chs);
                        if(set.contains(newWord)){
                            q.offer(newWord);
                            set.remove(newWord);
                        }
                    }
                    chs[i] = original;
                }
            }
            step++;
        }

        return 0;
    }
}
