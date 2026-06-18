class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> vis = new HashSet<>(Arrays.asList(deadends));
        if(vis.contains("0000")) return -1;
        if(target.equals("0000")) return 0;

        Queue<String> q = new LinkedList<>();
        q.offer("0000");
        vis.add("0000");
        int turns = 0;

        while(!q.isEmpty()){
            int s = q.size();
            turns++;
            for(int i = 0; i < s; i++){
                String curr = q.poll();
                for(String next: getNei(curr)){
                    if(vis.contains(next)) continue;
                    if(next.equals(target)) return turns;
                    vis.add(next);
                    q.offer(next);
                }
            }
        }

        return -1;
    }

    List<String> getNei(String str){
        char[] chs = str.toCharArray();
        List<String> ls = new ArrayList<>();

        for(int i = 0; i < 4; i++){
            char ori = chs[i];
            chs[i] = (char)((ori - '0' + 1) % 10 + '0');
            ls.add(new String(chs));
            chs[i] = (char)((ori - '0' + 9) % 10 + '0');
            ls.add(new String(chs));
            chs[i] = ori;
        }
        return ls;
    }
}