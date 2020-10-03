package algorithm;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LargestK {
    public int findKth(int[] args, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue();
        for (int item: args
             ) {
            priorityQueue.add(item);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        return priorityQueue.peek();
    }

    /*返回的是一个第kth的索引结构*/
   /*
    核心思路：有大根堆与小根堆两种
    小根堆思路：构建一个k大小的小根堆，把数组的数全部装进去，边装边比较，大的始终会被丢到下面，而最小的会被放到堆顶！！所以装完之后，我们就可以确保，第k大的在小根堆堆顶。
    大根堆思路：构建一个k大小的大根堆，把数组的数全部装进去，边装边比较，小的始终会被丢到下面，而每次放数的时候，都会调整把大数丢到最上面。所以装完之后，我们就可以确保，第k大的在大根堆堆顶了。
 */
    public static int findLeast(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(k);//一个基于优先级堆的极大优先级队列
        for (int i : nums) {
            q.offer(i);//把数丢进堆里自动调整

            if (q.size() > k) {
                q.poll();//检索并移除此队列的头，也就是把堆顶的那个丢出去。
            }
        }

        return q.peek();//单纯检查，不移除
    }
    public static void main(String[] args) {
        int[] array = {
                9, 1, 5, 3, 5, 2, 6, 8, 7, 6
        };//这里就没有用clone来复制一份数组了，因为PriorityQueue有暂存空间。
        int k=findLeast(array,4);
        System.out.print(k);
        System.out.print("\n");
        for(int i=0;i<10;i++){
            System.out.print(array[i]+" ");
        }
        System.out.print("\n");
        for(int i=0;i<10;i++){
            if (k==array [i]){//还是利用的比较的办法啊。
                System.out.print(" 位置"+i+"  ");
            }
        }
    }

    public static int findLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        for (int item: nums
             ) {
            pq.add(item);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == pq.peek()){
                System.out.println("要找的元素在第"+(i+1)+"个位置");
            }
        }
        return pq.peek();

    }

    @Test
    public void main() {
        int res = findLargest(new int[]{1,2,3,4}, 2);
        System.out.println(res);
        int[][] nums = {{1,2},{2,3},{3,4},{4,5}};
        Arrays.sort(nums, (a, b) -> a[0]!=b[0] ? a[0]-b[0] : a[1]-b[1]);
        int[] arr = new int[]{1, 3, 2};
//        Arrays.sort(arr, (Integer a, Integer b) -> a!=b ? b - a:a-b);


    }

    /*找前k个最大数*/

}
