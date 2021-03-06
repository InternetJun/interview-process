package dfs;

import java.util.*;
import java.util.Map;
import java.util.HashMap;

public class Target {
//    Map<Integer, Integer> map = new HashMap<>();
    HashMap map = new HashMap(){{
        put(2, "abc");
        put(3, "def");
        put(4, "ghi");
        put(5, "jkl");
        put(6, "mno");
        put(7, "pqrs");
        put(8, "tuv");
        put(9, "wxyz");
}};
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        map.put();
        List<List<Integer>> res =new ArrayList();
        List<Integer> path = new ArrayList();
        dfs(target, candidates, 0, path, res);
        return res;
    }

    public void dfs(int target, int[] can, int index, List<Integer> path, List<List<Integer>> ls) {
        //什么的情况是可以加入到ls的呢‘？’
        if(can[index] == target) {
            path.add(can[index]);
            /*要新建的。*/
            ls.add(new ArrayList<>(path));
            //新建的list没有出现该有的问题。new ArrayList<>(path)
        }

        //什么的case是不可以的是
        if(index > can.length){
            return;
        }
        //主题的内容和回溯的东西
        dfs(target - can[index], can, index+1, path, ls);
        path.remove(path.size()-1);
    }

    class Main{

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            int len = candidates.length;
            List<List<Integer>> res = new ArrayList<>();
            if (len == 0) {
                return res;
            }

            // 排序是剪枝的前提
            Arrays.sort(candidates);
            Deque<Integer> path = new ArrayDeque<>();
            dfs(candidates, 0, len, target, path, res);
            return res;
        }

        private void dfs(int[] candidates, int begin, int len, int target, Deque<Integer> path, List<List<Integer>> res) {
            // 由于进入更深层的时候，小于 0 的部分被剪枝，因此递归终止条件值只判断等于 0 的情况
            if (target == 0) {
                res.add(new ArrayList<>(path));
                return;
            }

            for (int i = begin; i < len; i++) {
                // 重点理解这里剪枝，前提是候选数组已经有序，
                if (target - candidates[i] < 0) {
                    break;
                }
                path.addLast(candidates[i]);
                dfs(candidates, i, len, target - candidates[i], path, res);
                path.removeLast();
            }
        }
    }

}
