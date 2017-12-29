package com.tw.training.fp.designpattern.SRP;

/**
 * @author pzzheng
 * @date 12/29/17
 */
@FunctionalInterface
public interface TriFunction<P, P1, P2, R> {
    R apply(P p, P1 p1, P2 p2);
}
