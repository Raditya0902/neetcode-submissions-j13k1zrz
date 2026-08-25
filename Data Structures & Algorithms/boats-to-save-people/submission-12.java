class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int l = 0, r = people.length - 1;
        int count = 0;
        while(l <= r){
            int weight = people[l] + people[r];
            if(weight <= limit){
                l++;
                r--;
            }else{
                r--;
            }
            count++;
        }
        return count;
    }
}