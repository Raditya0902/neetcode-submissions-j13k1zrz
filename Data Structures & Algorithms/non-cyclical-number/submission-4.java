class Solution {
    Set<Integer> set = new HashSet<>();
    public boolean isHappy(int n) {
        int happyNum = 0;
        while(n != 0){
            int num = n % 10;
            happyNum += num * num;
            n/= 10;
        }
        if(happyNum == 1) return true;
        if(set.contains(happyNum)) return false;
        set.add(happyNum);
        return isHappy(happyNum);
    }
}
