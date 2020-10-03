package 类初始化;

public class TestStatic {
    public int anInt = 10;
    public static int j = 0;

    public static void main(String[] args) {
        int a = TestStatic.j;
//        int b = this.anInt;this的使用说必须有不是static的东西
    }
}
