package 类初始化;

import org.junit.Test;

public class A {
    public int a = 0;

    public void fun1() {
        System.out.println("func1A is coming");
    }
    public void fun2() {
        System.out.println("func2A is coming");
    }

    @Test
    public void test() {
        byte a = 127;
        byte b = 127;
//        b = a + b;
// 报编译错误:cannot convert from int to byte
        b += a;
//        System.out.println((b instanceof Byte));
    }

}

class B extends A {
    public int a = 1;

//    public void fun() {
//        System.out.println("B");
//    }

   /* public static void main(String[] args) {
        A classA = new B();//编译的运行原理是什么?有什么的问题吗?
        System.out.println(classA.a);
        classA.fun();
    }*/
   public void fun1() {
       System.out.println("func1B is coming");
   }
   public void fun2() {
        System.out.println("func2B is coming");
    }
}

class C extends B{

}

class TestExtends {
    public static void main(String[] args) {
        A a1 = new B();
        A a2 = new C();
        a1.fun1();
        a1.fun2();
        System.out.println(a1.a);//编译看父类, 运行看自己的意思.
        a2.fun1();//有重写就是对自己的输出。就是运行时！
    }


}

