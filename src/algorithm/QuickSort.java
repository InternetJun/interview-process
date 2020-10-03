package algorithm;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

public class QuickSort {

    @Test
    public void t(){
        int[] nums = new int[]{1,3,2,5};
        System.out.println(Arrays.toString(nums
        ));
        quickSort(nums, 0, 3);
        System.out.println(Arrays.toString(nums
        ));
    }

    public void quickSort(int[] nums, int l, int r) {
        if (l > r){
            return;//没有他的话会1, 3 2 5;会溢出的风险,
        }
        int right = r;
        int left = l;
        int temp = nums[l];
        while(left < right) {
            while(left < right && nums[right] > temp) {
                right--;
            }
            if (left < right)
                nums[left++] = nums[right];
            while(left < right && nums[left] < temp){
                left++;
            }
            if (left < right)
                nums[right--] = nums[left];

        }
        nums[left] = temp;
        quickSort(nums, l, left-1);
        quickSort(nums, left+1, r);
    }


    /*实现的是按基准来的*/
    public static void quickSort(int left, int right, int[] arr) {
        int l = left;
        int r = right;
        int pivot = arr[(left + right) / 2];//中间的元素了.
        int temp = 0;
        // while 循环的目的是让 比pivot小的放到 左边
        // 将比pivot大的放到右边
        while (l < r) {
            // 在pivot的左边直到找到一个大于等于pivot的数，才退出
            while (arr[l] < pivot) {
                l += 1;
            }
            // 在pivot的左边直到找到一个小于等于pivot的数，才退出
            while (arr[r] > pivot) {
                r -= 1;
            }
            // 如果 l>=r 说明pivot 的左右两边的值已经按照 左边全是
            // 小于等于pivot的值，右边全是大于等于pivot的值
            if (l >= r) {
                break;
            }
            // 交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            // 如果交换后，发现这个值和pivot相等，可以r--,前移一步
            if (arr[l] == pivot) {
                r -= 1;
            }
            // 如果交换后，发现这个值和pivot相等，可以l--,后移一步
            if (arr[r] == pivot) {
                l += 1;
            }
        }
        // 如果 l==r 还可以让 l++， r--下.
        if (l == r) {
            l += 1;
            r -= 1;
        }
        // 向左递归
        if (left < r) {
            quickSort(left, r, arr);
        }
        // 向右递归
        if (right > l) {
            quickSort(l, right, arr);
        }
    }

//    @Test
  /*  public void te() {
        int j, n = 10;
        for (int i = 0; i+n; i--) {
            System.out.printf("-\t");
        }
    }*/

}
