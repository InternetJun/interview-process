package 反射;

public class StringTest{
    public static void main(String[] args) throws Exception {
        String s = "abc";
        java.lang.reflect.Field f = s.getClass().getDeclaredField("value");
        f.setAccessible(true);
        char[] value = (char[]) f.get(s);
        value[0] = 'c';
        value[2] = 'a';
        System.out.print(s+"--------\t");
        System.out.println("abc");
        System.out.println("abc");
//    } char[]value(char[] ) f.get(s) ；value[0]value[2]System.out.print(s+System.out.println("abc") ；
    }
}