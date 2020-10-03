package 类初始化;

public class AConstant {
    public int anInt = 1;
    public void t(){
        System.out.println("I am not important");
    }
}

class BConstant extends AConstant{
    public void t(){
        System.out.println("I am important");
    }
}

class TestC{
    public static void main(String[] args) {
        BConstant bConstant = new BConstant();
        System.out.println(bConstant.anInt);//没有的话直接是用了。
    }
}
