package com.tw.training.fp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;

/**
 * @author pzzheng
 * @date 1/5/18
 */
public class ComparatorTest {
    /**
     * @author pzzheng
     */
    @Test
    public void should_compare_when_is_comparable() {
        List<ComparableInt> original = Arrays.asList(
                new ComparableInt(5),
                new ComparableInt(3),
                new ComparableInt(2)
        );

//        sort result is right
        ArrayList<Integer> sorted = original.stream().sorted().mapToInt(x -> x.value)
                .collect(ArrayList<Integer>::new, (l, e) -> l.add(e), (l1, l2) -> l1.addAll(l2));
        assertThat(sorted, contains(2, 3, 5));

//        after sort, original list is not changed
        ArrayList<Integer> originalAfterSort = original.stream().map(x -> x.value).reduce(new ArrayList<Integer>(), (x, y) -> {
            x.add(y);
            return x;
        }, (x, y) -> {
            x.addAll(y);
            return x;
        });

        assertThat(originalAfterSort, contains(5,3,2));
    }

    /**
     * @author pzzheng
     */
    @Test
    public void should_sort_when_is_not_comparable() {
        List<InComparableInt> original = Arrays.asList(
                new InComparableInt(5),
                new InComparableInt(3),
                new InComparableInt(2)
        );

        List<Integer> collect = original.stream().sorted(Comparator.comparingInt(x -> x.value)).map(x -> x.value).collect(Collectors.toList());

        assertThat(collect, contains(2,3,5));
    }

    private class ComparableInt implements Comparable {
        private int value;

        public ComparableInt(int value) {
            this.value = value;
        }

        @Override
        public int compareTo(Object o) {
            if (o == null || !ComparableInt.class.isInstance(o)) return -1;

            return value - ((ComparableInt) o).value;
        }
    }


    private class InComparableInt {
        private int value;

        public InComparableInt(int value) {
            this.value = value;
        }
    }
}
