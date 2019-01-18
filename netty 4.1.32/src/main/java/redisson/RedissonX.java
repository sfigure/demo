package redisson;

import org.redisson.Redisson;
import org.redisson.api.RSet;
import org.redisson.api.RedissonClient;
import org.redisson.api.SortOrder;
import org.redisson.client.codec.IntegerCodec;
import org.redisson.config.Config;

/**
 * @author jzx
 * @date 2019/01/18 16:25
 * @Description:
 */
public class RedissonX {
    
    public static void main(String[] argv) {
        Config config = new Config();
        config.useSingleServer()
                .setConnectionMinimumIdleSize(3)
                .setConnectionPoolSize(3)
                .setAddress("redis://127.0.0.1:6379");
        RedissonClient redisson = Redisson.create();
        RSet<Integer> list = redisson.getSet("list", IntegerCodec.INSTANCE);
        list.add(4);
        System.out.println(list.readSort(SortOrder.ASC));
    }
    
}
