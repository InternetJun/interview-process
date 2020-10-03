package dfs.base;

import org.junit.Test;
import 类初始化.SBTest;

import java.util.ArrayList;
import java.util.List;

public class Watch {

    @Test
    public void t(){
        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append(0);
        stringBuilder.append(1);
        stringBuilder.append(1);
        System.out.println(stringBuilder.toString());
        int tmp = Integer.parseInt(stringBuilder.toString(), 2);
        System.out.println(tmp);
    }
    public List<String> readBinaryWatch(int num) {
        List<String> ans = new ArrayList<>();
        if(num >= 9) return ans;
        for(int i = 0; i <= 3; i++) {
            if(num - i > 5) continue;
            List<String> h = new ArrayList<>();
            helperHour(i, 0, 0, new int[4], h);
            List<String> m = new ArrayList<>();
            helperHour(num - i, 0, 0, new int[6], m);
            for(String hh : h) {
                for(String mm : m) {
                    if(mm.length() == 1) {
                        mm = "0" + mm;
                    }
                    ans.add(hh + ":" + mm);
                }
            }
        }
        return ans;
    }

    public void helperHour(int num, int idx, int cnt, int[] arr, List<String> res) {
        if(cnt == num) {
            StringBuilder sb = new StringBuilder();
            for(int val : arr) {
                sb.append(val);//这里的是要？
            }
            int tmp = Integer.parseInt(sb.toString(), 2);
            if((tmp > 11 && arr.length == 4) || (tmp > 59 && arr.length == 6))
                return;
            res.add(Integer.toString(tmp));
            return;
        }

        for(int i = idx; i < arr.length; i++) {
            if(arr[i] != 0)
                continue;
            arr[i] = 1;
            helperHour(num, i + 1, cnt + 1, arr, res);
            arr[i] = 0;
        }
    }

}
