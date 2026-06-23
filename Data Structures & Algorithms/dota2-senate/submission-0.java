class Solution {
    public String predictPartyVictory(String senate) {
        int n = senate.length();
        Queue<Integer> radiants = new LinkedList<>();
        Queue<Integer> dires = new LinkedList<>();
        for(int i = 0; i < senate.length(); i++){
            if(senate.charAt(i) == 'R') radiants.offer(i);
            else dires.offer(i);
        }
        while(!radiants.isEmpty() && !dires.isEmpty()){
            int r = radiants.poll();
            int d = dires.poll();
            if(r < d) radiants.offer(n + r);
            else dires.offer(n + d);
        }
        return radiants.isEmpty() ? "Dire" : "Radiant";
    }
}