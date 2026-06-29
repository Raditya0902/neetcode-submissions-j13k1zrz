class Solution {
    public boolean makesquare(int[] matchsticks) {
        if(matchsticks == null || matchsticks.length < 4) return false;
        
        int sum = 0;
        for(int n: matchsticks) sum += n;
        if(sum % 4 != 0) return false;

        Arrays.sort(matchsticks);
        int l = 0, r = matchsticks.length - 1;
        
        while(l < r){
            int temp = matchsticks[l];
            matchsticks[l] = matchsticks[r];
            matchsticks[r] = temp;
            l++; r--;
        }

        int side = sum / 4;
        if(matchsticks[0] > side) return false;
        
        int[] sides = new int[4];
        return dfs(matchsticks, sides, 0, side);
    }

    boolean dfs(int[] matchsticks, int[] sides, int idx, int side){
        if(idx == matchsticks.length){
            return sides[0] == sides[1] && sides[1] == sides[2] && sides[2] == sides[3];
        }

        int stick = matchsticks[idx];
        for(int i = 0; i < 4; i++){
            if(sides[i] + stick > side) continue;
            if(i > 0 && sides[i] == sides[i-1]) continue;
            sides[i] += stick;
            if(dfs(matchsticks, sides, idx+1, side)) return true;
            sides[i] -= stick;
        }
        return false;
    }

}