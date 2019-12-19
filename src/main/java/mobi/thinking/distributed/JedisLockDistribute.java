package mobi.thinking.distributed;

import redis.clients.jedis.params.SetParams;

import java.util.Collections;
import java.util.UUID;

public class JedisLockDistribute {

    public static boolean getDistributeLock(int lockTime, String lockKey, String lockValue) {
        String set = RedisClient.jedis().set(lockKey, lockValue, SetParams.setParams().nx().ex(lockTime));
        return set != null && set.equals("OK");
    }

    /***
     * 避免误删到其他锁
     * @param lockKey
     * @param lockValue
     * @return
     */
    public static boolean releaseDistributeLock(String lockKey, String lockValue) {
        String sp = "if redis.call('get',KEYS[1])==ARGV[1] then return redis.call('del',KEYS[1]) else return 0 end";
        String eval = RedisClient.jedis().eval(sp, Collections.singletonList(lockKey), Collections.singletonList(lockValue)).toString();
        return eval.equals("1");
    }

    public static void main(String[] args) {
        String lockKey = "lishulong";
        String lockValue = UUID.randomUUID().toString();
        try {
            System.out.println(JedisLockDistribute.getDistributeLock(10, lockKey, lockValue));
        } finally {
            System.out.println(JedisLockDistribute.releaseDistributeLock(lockKey, lockValue));
        }
    }

}
