import java.lang.reflect.Field;
import sun.misc.Unsafe;

/**
 * @author jzx
 * @date 2019/07/18 12:44
 * @Description:
 */

class Te{
  static Integer add(Integer a){
    return  a+1;
  }
}

@FunctionalInterface
interface Render{
  Integer render(Integer a);
}

public class Test2 {

  public static void main(String[] argv) throws Exception {
      Test2 test2=new Test2();
      test2.test(Te::add);
  }
  void  test(Render r){
    System.out.print(r.render(2));
  }
}
