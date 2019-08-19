
import java.lang.reflect.Field;
import sun.misc.Unsafe;

class T {
}

public class Test1 {

  public static void main(String[] argv) throws Exception {
    Field f = Unsafe.class.getDeclaredField("theUnsafe");
    f.setAccessible(true);
    Unsafe unsafe = (Unsafe) f.get(null);
    System.out.print(unsafe);

  }
}
