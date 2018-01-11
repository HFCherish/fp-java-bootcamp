package com.tw.training.fp;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author pzzheng
 * parallel is always good???
 * @date 1/9/18
 */
public class StreamParallelTest {
    /**
     * 更改测试，加上预热，保证 JIT 编译已完成，此时基本是在同等条件下测试，测试结果相对更可信一些
     */
    @Test
    public void should_parallel_faster_if_has_warm_up() {
        String[] array = new String[1000000];
        Arrays.fill(array, "AbabagalamagA");
        System.out.println("Warmup...");
        for (int i = 0; i < 100; ++i) {
            sequential(array);
            parallel(array);
        }
        System.out.println("Benchmark...");
        for (int i = 0; i < 5; ++i) {
            System.out.printf("Run %d:  sequential %s  -  parallel %s\n",
                    i,
                    test(() -> sequential(array)),
                    test(() -> parallel(array)));
        }
    }

    /**
     * @author pzzheng
     */
    @Test
    public void should_not_sure_if_without_warm_up() {
        String[] array = new String[1000000];
        Arrays.fill(array, "AbabagalamagA");
        System.out.println("Benchmark...");
        for (int i = 0; i < 5; ++i) {
            System.out.printf("Run %d:  sequential %s  -  parallel %s\n",
                    i,
                    test(() -> sequential(array)),
                    test(() -> parallel(array)));
        }

    }

    private static void sequential(String[] array) {
        Arrays.stream(array).map(String::toLowerCase).collect(Collectors.toList());
    }

    private static void parallel(String[] array) {
        Arrays.stream(array).parallel().map(String::toLowerCase).collect(Collectors.toList());
    }

    private static String test(Runnable runnable) {
        long start = System.currentTimeMillis();
        runnable.run();
        long elapsed = System.currentTimeMillis() - start;
        return String.format("%4.2fs", elapsed / 1000.0);
    }
}
