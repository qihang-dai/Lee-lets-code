class FileSystem {
    Map<String,Integer> map;
    public FileSystem() {
        map = new HashMap<String, Integer>();
        map.put("", -1);
        map.put("/", -1);

        
    }
    
    public boolean createPath(String path, int value) {
        int index = path.lastIndexOf("/");
        String parent = path.substring(0, index);
        if(!map.containsKey(parent)) return false;
        return map.putIfAbsent(path, value) == null;
        
        
    }
    
    public int get(String path) {
        return map.getOrDefault(path, -1);
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */