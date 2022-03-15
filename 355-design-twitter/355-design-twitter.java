class Twitter {
    private static int timestamp = 0;

    Map<Integer, User> userMap;

    private class Tweet{
        public int id;
        public int time;
        public Tweet next;
        
        public Tweet(int id){
            this.id = id;
            this.next = null;
            this.time = timestamp++;
        }
    }


    
    public class User{
        public int userId;
        public Set<Integer> follower;
        public Tweet head;
        
        public User(int userId){
            this.userId = userId;
            follower = new HashSet();
            follow(userId);
            head = null;
        }
        
        public void post(int id){
            Tweet tweet = new Tweet(id);
            tweet.next = head;
            head = tweet;
        }
        
        public void follow(int followerId) {
            follower.add(followerId);
        }
        
        public void unfollow(int followerId) {
            follower.remove(followerId);
        }
    }
    
    
    public Twitter() {
        this.userMap = new HashMap();
    }
    
    public void postTweet(int userId, int tweetId) {
        userMap.putIfAbsent(userId, new User(userId));
        userMap.get(userId).post(tweetId);
        
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList();
        User user = userMap.get(userId);
        if(user == null) return res;
        
        Set<Integer> following = user.follower;
        PriorityQueue<Tweet> pq = new PriorityQueue<Tweet>((a,b) -> b.time - a.time);
        for(int id : following){
            User followingUser = userMap.get(id);
            if(followingUser == null) continue;
            Tweet t = followingUser.head;
            
            if(t != null) pq.add(t);
        }
        
        while(!pq.isEmpty() && res.size() < 10){
            Tweet mostRecentTweet = pq.poll();
            res.add(mostRecentTweet.id);
            
            Tweet nextTweet = mostRecentTweet.next;
            if(nextTweet !=null) pq.add(nextTweet);
        }
        return res;
        
        
    }
    
    public void follow(int followerId, int followeeId) {
        userMap.putIfAbsent(followerId, new User(followerId));
        User follower = userMap.get(followerId);
        follower.follow(followeeId);
        
        
    }
    
    public void unfollow(int followerId, int followeeId) {
        User follower = userMap.get(followerId);
        follower.unfollow(followeeId);
        
    }
}



/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */