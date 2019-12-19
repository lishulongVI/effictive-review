package mobi.thinking.distributed;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.params.SetParams;

public class RedisClient {

    private static Jedis jedis;
    private static RedissonClient redisson;
    private static final String XX = "xx";
    private static final String NX = "nx";
    private static final String PX = "px";
    private static final String EX = "ex";
    private static final String OK = "OK";

    static {
        jedis = new Jedis("0.0.0.0", 6379);
        jedis.auth("123456");

        Config config = new Config();
        config.useSingleServer().setAddress("redis://0.0.0.0:6379").setPassword("123456").setDatabase(0);
//        config.useClusterServers().addNodeAddress("redis://0.0.0.0:6379");
        redisson = Redisson.create(config);
    }

    static Jedis jedis() {
        return jedis;
    }

    static RedissonClient redisson() {
        return redisson;
    }


    public static void main(String[] args) {
        int expireTime = 10;
        String set = RedisClient.jedis().set("key1", "value1", SetParams.setParams().nx().ex(expireTime));
        System.out.println(set);

        System.out.println(RedisClient.jedis().get("key1"));
    }

}
