package algorithm;

import org.junit.Test;

import java.util.Arrays;

public class ToneMe {
    @Test
    public void t(){
        int[] a = {21,11,311};
        radixSort(a);
        System.out.println(Arrays.toString(a));
    }
    public void radixSort(int[] arr){
        int max = arr[0];
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int maxLength = (max+"").length();
        int[][] bucket = new int[10][len];
        int[] OneBucket = new int[10];//里面的是0~9的内容啊！
        /*要的是循环的次数！*/
        for (int j = 0, n = 1; j < maxLength; j++, n *= 10) {
            for (int i = 0; i < len; i++) {
                int d = arr[i]/n%10;
                bucket[d][OneBucket[d]] = arr[i];//按顺序的取元素的。
                OneBucket[d]++;
            }

            int index = 0;
            /*每次的比较数据，不是说什么的！*/
            for (int i = 0; i < OneBucket.length; i++) {
                if (OneBucket[i] != 0){
                    for (int l = 0; l < OneBucket[i]; l++) {
                        // 取出元素
                        arr[index++] = bucket[i][l];
                    }
                    // 把这个桶的对应的记录的数据个数置为0,注意,桶本身数据(前面存的数据还在)
                    OneBucket[i] = 0; //
                }

            }
        }
    }
}
