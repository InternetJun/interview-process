package 类初始化;

public class SBTest
{
    public static void main(String[] args) {
        StringBuilder x = new StringBuilder();
        StringBuilder y = new StringBuilder();
        func(x, y);
        System.out.println(x.toString());//传不过来的。
        System.out.println(y.toString());
    }

    public static void func(StringBuilder x, StringBuilder y) {
        x.append('a');
        y = x;
    }
}
