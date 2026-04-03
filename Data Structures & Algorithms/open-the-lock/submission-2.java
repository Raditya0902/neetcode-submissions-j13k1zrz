class Solution {

    class Pair{
        String lock;
        int turn;
        Pair(String lock, int turn){
            this.lock = lock;
            this.turn = turn;
        }
    }

    public int openLock(String[] deadends, String target) {
        HashSet<String> set = new HashSet<>(Arrays.asList(deadends));
        Queue<Pair> q = new LinkedList<>();

        if(set.contains("0000") || set.contains(target)) return -1;
        q.offer(new Pair("0000", 0));

        while(!q.isEmpty()){
            Pair p = q.poll();
            String lock = p.lock;
            int turn = p.turn;
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
            chs[i] = (char)((original - '0' + 1) % 10 + '0');
            res.add(new String(chs));

            chs[i] = (char)((original - '0' - 1 + 10)%10 + '0');
            res.add(new String(chs));

            chs[i] = original;
        }
        return res;
    }
}