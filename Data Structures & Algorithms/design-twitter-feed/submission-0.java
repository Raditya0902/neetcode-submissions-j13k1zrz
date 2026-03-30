class Twitter {
    int count;
    HashMap<Integer, List<int[]>> tweetMap;
    HashMap<Integer, Set<Integer>> followMap;
    public Twitter() {
        this.tweetMap = new HashMap<>();
        this.followMap = new HashMap<>();
        this.count = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.computeIfAbsent(userId, k-> new ArrayList<>()).add(new int[]{count++, tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> ls = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> b[0]-a[0]);
        followMap.computeIfAbsent(userId, k->new HashSet<>()).add(userId);
        for(int followeeId: followMap.get(userId)){
            if(tweetMap.containsKey(followeeId)){
                List<int[]> tweets = tweetMap.get(followeeId);
                int idx = tweets.size() - 1;
                int[] tweet = tweets.get(idx);
                pq.offer(new int[]{
                    tweet[0], tweet[1], followeeId, idx
                });
            }
        }

        while(!pq.isEmpty() && ls.size() < 10){
            int[] curr = pq.poll();
            ls.add(curr[1]);
            int idx = curr[3];
            if(idx > 0){
                int[] tweet = tweetMap.get(curr[2]).get(idx - 1);
                pq.offer(new int[]{tweet[0], tweet[1], curr[2], idx - 1});
            }
        }
         return ls;
    }
    
    public void follow(int followerId, int followeeId) {
        followMap.computeIfAbsent(followerId, k-> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followMap.containsKey(followerId)){
            followMap.get(followerId).remove(followeeId);
        }
    }
}
