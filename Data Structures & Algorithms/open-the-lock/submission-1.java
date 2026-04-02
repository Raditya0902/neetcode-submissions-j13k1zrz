class Solution {
    public int openLock(String[] deadends, String target) {
        HashSet<String> set = new HashSet<>(Arrays.asList(deadends));
        Queue<Pair> q = new LinkedList<>();

        if(set.contains("0000")) return -1;

        q.offer(new Pair("0000", 0));
        set.add("0000");

        while(!q.isEmpty()){
            Pair lockPair = q.poll();
            String lock = lockPair.curr;
            int turn = lockPair.turn;

            if(lock.equals(target)) return turn;

            List<String> children = backtrack(lock);
            for(String child: children){
                if(!set.contains(child)){
                    set.add(child);
                    q.offer(new Pair(child, turn + 1));
                }
            }
        }
        return -1;
    }

    List<String> backtrack(String lock){
        List<String> res = new ArrayList<>();
        char[] chs = lock.toCharArray();

        for(int i = 0; i < 4; i++){
            char original = chs[i];

            chs[i] = (char)((original - '0' + 1)%10 + '0');
            res.add(new String(chs));

            chs[i] = (char)((original - '0' - 1 + 10)%10 + '0');
            res.add(new String(chs));
            
            chs[i] = original;
        }
        return res;
    }

    class Pair{
        String curr;
        int turn;
        Pair(String curr, int turn){
            this.curr = curr;
            this.turn = turn;
        }
    }
}