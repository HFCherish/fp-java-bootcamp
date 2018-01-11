package com.tw.training.fp;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static java.lang.Math.sqrt;
import static java.lang.Thread.sleep;
import static java.util.stream.IntStream.range;
import static java.util.stream.LongStream.rangeClosed;

/**
 * @author pzzheng
 * when to use parallel
 * @date 1/9/18
 */
public class StreamParallelTest2 {

    /**
     * @author pzzheng
     */
    @Test
    public void should_be_influenced_by_long_tasks() throws InterruptedException {
        /** Simulating multiple threads in the system
         * if one of them is executing a long-running task.
         * Some of the other threads/tasks are waiting
         */
        int MAX = 12;
        ExecutorService es = Executors.newCachedThreadPool();

        // 这个线程执行很慢，但是因为共享线程池，因此会影响其他线程的执行。极端情况，这里是一个 broken tread，其他 healthy thread 都会受影响
        es.execute(() -> countPrimes(MAX, 1000));

        // 执行结果不确定，因为有上边的长线程。如果注释掉上边线程，下边这个可以很快执行
        es.execute(() -> countPrimes(MAX, 0));
        es.execute(() -> countPrimes(MAX, 0));
        es.execute(() -> countPrimes(MAX, 0));
        es.execute(() -> countPrimes(MAX, 0));
        es.execute(() -> countPrimes(MAX, 0));
        es.shutdown();
        es.awaitTermination(60, TimeUnit.SECONDS);
    }

    private void countPrimes(int max, int delay) {
        System.out.println(Thread.currentThread().getId() + ": " + range(1, max).parallel().filter(this::isPrime).peek(i -> {
            try {
                sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).count());
    }


    private boolean isPrime(long n) {
        return n > 1 && rangeClosed(2, (long) sqrt(n)).noneMatch(divisor -> n % divisor == 0);
    }
}
