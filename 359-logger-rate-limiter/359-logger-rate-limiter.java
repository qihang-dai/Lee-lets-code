class Logger {
    HashMap<String, Integer> map;
    public Logger() {
        map = new HashMap();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        boolean flag = true;
        if(map.containsKey(message)){
            int last = map.get(message);
            if(timestamp - last < 10){
                flag =  false;
            }else{
                map.put(message,timestamp);
            }
        }else{
            map.put(message, timestamp);
        }
        return flag;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */