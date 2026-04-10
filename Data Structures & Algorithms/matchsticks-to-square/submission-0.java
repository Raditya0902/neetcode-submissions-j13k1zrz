class Solution {
    public boolean makesquare(int[] matchsticks) {
        if(matchsticks == null || matchsticks.length < 4) return false;

        long sum = 0;
        for(int x: matchsticks) sum += x;
        if(sum % 4 != 0) return false;
        int side = (int)sum / 4;
        Arrays.sort(matchsticks);
        int l = 0, r = matchsticks.length - 1;
        while(l < r){
            int temp = matchsticks[l];
            matchsticks[l] = matchsticks[r];
            matchsticks[r] = temp;
            l++;
            r--;
        }
        int[] sides = new int[4];
        return dfs(matchsticks, 0, sides, side);
    }

    boolean dfs(int[] matchsticks, int i, int[] sides, int target){
        if(i == matchsticks.length){
            return sides[0] == target && sides[1] == target && sides[2] == target && sides[3] == target;
        }

        int curr = matchsticks[i];
        for(int k = 0; k < 4; k++){
            if(sides[k] + curr > target) continue;
            if(k > 0 && sides[k] == sides[k-1]) continue;
            sides[k] += curr;
            if(dfs(matchsticks, i + 1, sides, target)) return true;
            sides[k] -= curr;
        }
        return false;
    }
}