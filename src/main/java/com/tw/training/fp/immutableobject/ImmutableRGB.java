package com.tw.training.fp.immutableobject;

/**
 * @author pzzheng
 * @date 1/4/18
 */
public class ImmutableRGB {
    private final int red;
    private final int green;
    private final int blue;
    private final String name;

    public ImmutableRGB(int red, int green, int blue, String name) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.name = name;
    }

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }

    public String getName() {
        return name;
    }
}
