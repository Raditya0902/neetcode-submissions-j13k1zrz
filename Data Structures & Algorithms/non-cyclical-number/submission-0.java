class Solution {
    HashSet<Integer> set = new HashSet<>();
    public boolean isHappy(int n) {
        int sumSquared = 0;
        while(n != 0){
            sumSquared += (int)Math.pow((n%10),2);
            n/=10;
        }
        if(sumSquared == 1) return true;
        if(set.contains(sumSquared)) return false;
        set.add(sumSquared);
        return isHappy(sumSquared);
    }
}
