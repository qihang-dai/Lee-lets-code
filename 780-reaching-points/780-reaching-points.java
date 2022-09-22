class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        if(tx < sx || ty < sy) return false;
        if(tx == sx && (ty - sy) % sx == 0) return true;
        if(ty == sy && (tx - sx) % sy == 0) return true;
        System.out.println(tx);
        return reachingPoints(sx, sy, tx % ty, ty % tx);
    }
}