package 类初始化;

public class TestOrder{

    {
        System.out.println("I am a struct!");
    }
    static{
        System.out.println("I am a static struct!");
    }

    private static TestOrder main = new TestOrder();



    public static void main(String[] args) {
        TestOrder testOrder = new TestOrder();
    }


}

class OrderB extends TestOrder{
    public static void main(String[] args) {
        OrderB b = new OrderB();//没有的是类中的什么method，可以用父类！
    }
}