package dfs.最短路径;

/*https://leetcode-cn.com/problems/shortest-path-visiting-all-nodes/*/

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**  bfs来计算出最短的路径码?还是什么?
     * if(右存在 && 右下面也存在的时候.)==>
     *
     * if(i, j+1 && i+1, j+1) =前提是不为0;=> choose the i+1, j+1;
     * */
class Point{
    public int x;
    public int y;
    /*有计数的就是加入一个field：oneCount*/
    public Point(int x,int y){
        this.x=x;
        this.y=y;
    }
}

class ShortestPath {
//    利用了很多的知识和一些的内容啊.对吧.加油,你一定是可以的!
    private int col, row;
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1},{-1,1},{-1,-1},{1,1},{1,-1}};//8个dirs
    public int shortestPathBinaryMatrix(int[][] grid) {
        col = grid[0].length;
        row = grid.length;
        if (grid[0][0] == 1 || grid[row-1][col-1] == 1){
            return -1;
        }
        /*需要的是一个queue来存储那个元素的*/
        Queue<int[]> pos = new LinkedList<>();
        grid[0][0] = 1;//用pos来只直接表示出路径的长度啊
        pos.add(new int[]{0,0});
        while(!pos.isEmpty() && grid[row-1][col-1] == 0){
            int[] xy = pos.remove();
            int preLength = grid[xy[0]][xy[1]];
            for (int i = 0; i < 8; i++) {
                int newX = xy[0] + dirs[i][0];
                int newY = xy[1] + dirs[i][1];
                if (isGrid(newX, newY) && grid[newX][newY] == 0) {
                    pos.add(new int[]{newX, newY});
                    grid[newX][newY] = preLength + 1;//路径加1
                }
            }
        }
        return grid[row-1][col-1] == 0 ? -1: grid[row-1][col-1];
    }

    private boolean isGrid(int x,int y){//是否在区域内
        return (x>=0 || x<= row-1 || y>=0 || y<=col-1);
    }

    public int smallestDifference(int[] a, int[] b) {
        Arrays.sort(a);
        int min = Integer.MAX_VALUE;
        for(int i =0; i < b.length; i++) {
            int l = 0, r = a.length-1;
            while(l < r) {
                int mid = (l+r)/2;
                if(a[mid] <= b[i]){
                    l = mid;
                } else{
                    r = mid - 1;
                }
            }
            min = Math.min(min, Math.abs(a[l] - b[i]));
            if(l != a.length-1) {
                min = Math.min(min, Math.abs(a[l+1] - b[i]));
            }
        }
        return min;
    }
}
