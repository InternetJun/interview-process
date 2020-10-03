package dfs;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**@很重要的提醒*/
public class MaxSumInTree {
    /**
     * 不要求有从root或者结束开始的节点的要求，可以一个节点的内容、
     * @要的是贪心的意思。l=max().r=max();
     * @param root
     * @return
     */
 /*   int sum=Integer.MIN_VALUE;
    public int maxPathSum (TreeNode root) {
        // write code here
        if(root==null)
            return 0;
        PathSum(root);
        return sum;
    }

    public int PathSum (TreeNode root) {
        // write code here
        if(root==null)
            return 0;
        int l=Math.max(PathSum(root.left), 0);//l
        int r=Math.max(PathSum(root.right), 0);//r
        sum=Math.max(sum, root.val+l+r);//root+left+right
        return root.val+Math.max(r, l);//他是一个回溯点的，考虑到了的地方是可能就是一个root的节点的意思了。
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(1);
        System.out.println(maxPathSum(root));
    }
*/
    /**记录路径。有什么情况下是该记录的呢?*/
    int max;
    List<Integer> rs;
    public List<Integer> maxPath(TreeNode root) {
        max = Integer.MIN_VALUE;
        rs = new ArrayList<>();
        postorder(root);
        return rs;
    }

    private Result postorder(TreeNode root) {
        if (root == null) {
            return new Result();
        }
        Result left = postorder(root.left);
        Result right = postorder(root.right);
        int rootVal = root.val;
        int returnSum = Math.max(rootVal, Math.max(rootVal + left.getSum(), rootVal + right.getSum()));
        List<Integer> path = new ArrayList<>();
        if (returnSum == rootVal) {
            path.add(rootVal);
        } else if (returnSum == rootVal + left.getSum()) {
            path.addAll(left.getList());
            path.add(rootVal);
        } else if (returnSum == rootVal + right.getSum()) {
            path.add(rootVal);
            path.addAll(right.getList());
        }
        max = Math.max(max, returnSum);
        /*
            更新 max 时同时更新路径
         */
        if (max == rootVal) {
            rs = new ArrayList<>();
            rs.add(rootVal);
        } else if (max == rootVal + left.getSum()) {
            rs = new ArrayList<>();
            rs.addAll(left.getList());
            rs.add(rootVal);
        } else if (max == rootVal + right.getSum()) {
            rs = new ArrayList<>();
            rs.add(rootVal);
            rs.addAll(right.getList());
        }

        int notReturnSum =  left.getSum() + rootVal + right.getSum();
        max = Math.max(notReturnSum, max);
        if (max == notReturnSum) {
            rs = new ArrayList<>();
            rs.addAll(left.getList());
            rs.add(rootVal);
            rs.addAll(right.getList());
        }
        return new Result(path, returnSum);
    }

    class Result {
        List<Integer> list;
        int sum;

        public Result(List<Integer> list, int sum) {
            this.list = list;
            this.sum = sum;
        }

        public Result() {
            this(new ArrayList<>(), 0);
        }

        public List<Integer> getList() {
            return list;
        }

        public void setList(List<Integer> list) {
            this.list = list;
        }

        public int getSum() {
            return sum;
        }

        public void setSum(int sum) {
            this.sum = sum;
        }
    }



}
