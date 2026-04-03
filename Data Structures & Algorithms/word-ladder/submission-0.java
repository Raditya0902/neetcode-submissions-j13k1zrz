class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int step = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int k = 0; k < size; k++){
                String word = q.poll();
                if(word.equals(endWord)) return step;
                char[] chs = word.toCharArray();
                for(int j = 0; j < chs.length; j++){
                    char original = chs[j];
                    for(char i = 'a'; i <= 'z'; i++){
                        chs[j] = i;
                        String newWord = new String(chs);
                        if(set.contains(newWord)){
                            q.offer(newWord);
                            set.remove(newWord);
                        }
                    }
                    chs[j] = original;
                }
            }
            step++;
        }
        return 0;
    }

}
