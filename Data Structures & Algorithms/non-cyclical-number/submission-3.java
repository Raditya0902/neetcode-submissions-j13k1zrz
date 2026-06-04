class Solution {
    Set<Integer> set = new HashSet<>();
    public boolean isHappy(int n) {
        int sumSq = 0;
        while(n != 0){
            sumSq += (int) Math.pow(n%10, 2);
            n/=10;
        }
        if(sumSq == 1) return true;
        if(set.contains(sumSq)) return false;
        set.add(sumSq);
        return isHappy(sumSq);
    }
}
