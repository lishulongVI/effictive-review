package mobi.thinking.distributed;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class RedissionLockDistribute {

    public static void main(String[] args) {
        System.out.println(new Date());
        test();
        test();
        System.out.println(new Date());
    }


    public static void test() {

        String lockKey = "lishulong";

        RedissonClient redisson = RedisClient.redisson();
        RLock lock = redisson.getLock(lockKey);

        long lockTime = 10;
        long waitTime = 10;
        try {
            boolean b = lock.tryLock(waitTime, lockTime, TimeUnit.SECONDS);
            System.out.println(b);
            if (b) {
                //
                System.out.println("获取到锁");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("获取锁异常");
        } finally {
            lock.unlock();
            System.out.println("释放锁" + lock.getHoldCount());
        }

    }
}
