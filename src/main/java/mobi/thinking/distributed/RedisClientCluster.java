package mobi.thinking.distributed;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashSet;

public class RedisClientCluster {

    private static JedisCluster jedisCluster;

    static {
        HashSet<HostAndPort> hostAndPorts = new HashSet<HostAndPort>();
        hostAndPorts.add(new HostAndPort("0.0.0.0", 6379));
        hostAndPorts.add(new HostAndPort("0.0.0.0", 6379));
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(100);
        jedisPoolConfig.setMaxTotal(1000);
//public JedisCluster(HostAndPort node, int connectionTimeout, int soTimeout, int maxAttempts, String password, GenericObjectPoolConfig poolConfig) {
//        this(Collections.singleton(node), connectionTimeout, soTimeout, maxAttempts, password, poolConfig);
//    }
        jedisCluster = new JedisCluster(hostAndPorts, 10, 10, 5, "", jedisPoolConfig);
    }

    static JedisCluster jedisCluster() {
        return jedisCluster;
    }


    public static void main(String[] args) {
        Long setnx = RedisClientCluster.jedisCluster().setnx("key", "value");
        System.out.println(setnx);
    }

}
