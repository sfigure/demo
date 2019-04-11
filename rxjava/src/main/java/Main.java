import io.reactivex.Flowable;

/**
 * @author jzx
 * @date 2019/01/31 16:05
 * @Description:
 */
public class Main {
    public static void main(String[] main) throws  Exception{
        Flowable.just("rxjava").subscribe(System.out::println);
    }
}
