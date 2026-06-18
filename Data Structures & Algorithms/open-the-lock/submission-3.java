class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> visited = new HashSet<>(Arrays.asList(deadends));
        if(visited.contains("0000")) return -1;
        if(target.equals("0000")) return 0;

        Queue<String> q = new LinkedList<>();
        q.offer("0000");
        visited.add("0000");

        int turns = 0;

        while(!q.isEmpty()){
            int size = q.size();
            turns++;
            for(int s = 0; s < size; s++){
                String curr = q.poll();
                for(String next: getNeighbors(curr)){
                    if(visited.contains(next)) continue;
                    if(next.equals(target)) return turns;
                    visited.add(next);
                    q.offer(next);
                }
            }
        }

        return -1;
    }

    List<String> getNeighbors(String state){
        List<String> neighbors = new ArrayList<>();
        char[] chs = state.toCharArray();

        for(int i = 0; i < 4; i++){
            char ori = chs[i];
            chs[i] = (char)((ori - '0' + 1) % 10 + '0');
            neighbors.add(new String(chs));
            
            chs[i] = (char)((ori - '0' + 9) % 10 + '0');
            neighbors.add(new String(chs));

            chs[i] = ori;
        }

        return neighbors;
    }
}