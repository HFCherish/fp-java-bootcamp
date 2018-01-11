package com.tw.training.fp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pzzheng
 * @date 1/9/18
 */
public class GenericTest<T extends NaturalNumber> {

    /**
     * @author pzzheng
     */
    @Test
    public void should_ok() {
        Collections.<Integer>copy(new ArrayList<Integer>(){{add(1);}}, new ArrayList<Integer>(){{add(1);}});

        add1(new ArrayList<NaturalNumber>(){{add(new EvenNumber(1));}});
    }

    public void add(List<? super NaturalNumber> ln) {
        ln.add(new NaturalNumber(1));
    }

    public void add1(List<? super NaturalNumber> naturalNumbers) {
        naturalNumbers.add(new NaturalNumber(1));
    }

    public static class Collections {
        public static  <T> void copy
                ( List<? super T> dest, List<? extends T> src) {  // bounded wildcard parameterized types
            for (int i=0; i<src.size(); i++)
                dest.set(i,src.get(i));
        }

    }
}

class NaturalNumber {
    private int value;

    public NaturalNumber(int value) {
        this.value = value;
    }
}

class EvenNumber extends NaturalNumber{

    public EvenNumber(int value) {
        super(value);
    }
}
