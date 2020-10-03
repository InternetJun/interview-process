package 类初始化;

public class TestNull {
    /**
    * @null是说对象没有分配出内存的意思
     * @""表示的是没有对象。没有内存的地址上调用method会报错的。所以
    * */
    public static void main(String[] args) {
        String s = "a";
        String s1 = null;

        try {
            System.out.println(s1.length());
        } catch (Exception e) {
            e.printStackTrace();
        }
        //==============================
        try {
            if(s1==null && s.length() == 0){
                System.out.println("I am OK");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
