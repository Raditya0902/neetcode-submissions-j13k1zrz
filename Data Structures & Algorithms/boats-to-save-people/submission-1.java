class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int l = 0, r = people.length - 1;
        int count = 0;
        Arrays.sort(people);
        while(l <= r){
            int sum = people[l] + people[r];
            if(sum <= limit){
                l++;
                r--;
            }else if(sum > limit) r--;
            count++;
        }
        return count;
    }
}