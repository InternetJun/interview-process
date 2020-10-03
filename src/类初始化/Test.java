package 类初始化;

public class Test {

    public static Test t1=new Test();//他是一个static的.先要运行的.就是说要出来了blockA;

    {
        System.out.println("blockA");
    }

    static {
        System.out.println("blockB");
    }

    public static void main(String[] args){
        Test t2=new Test();
    }



}

class Main {

    public static Main t1=new Main();


    {
        System.out.println("blockA");
    }
    static {
        System.out.println("blockB");
    }

    Main(){
        System.out.println("BlockC");
    }


    public static void main(String[] args){
        Main t2=new Main();
        System.out.println();
        Main t3=new Main();
    }
}

class Test1{
    {
        System.out.println("test1 cons block");
    }
    static {
        System.out.println("test1 static");
    }
    public Test1() {
        System.out.println("test1 cons");
    }
    public void demo(){
        System.out.println("test1 demo...");
    }
}

class Test2 {
    {
        System.out.println("test cons block");
    }
    static {
        System.out.println("test static");
    }
    public Test2() {
        System.out.println("test cons func");
    }
    public void demo(){
        System.out.println("test demo...");
    }
    public static void main(String []args){
        System.out.println("start");
        new Test2().demo();
        new Test2().demo();
    }
}

