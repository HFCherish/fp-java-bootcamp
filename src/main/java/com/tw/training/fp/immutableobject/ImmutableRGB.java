package com.tw.training.fp.immutableobject;

/**
 * @author pzzheng
 * @date 1/4/18
 */
public final class ImmutableRGB {
    private final int red;
    private final int green;
    private final int blue;
    private final String name;

    public ImmutableRGB(int red, int green, int blue, String name) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.name = name;
        checkInput();
    }

    private void checkInput() {
        if (primaryColorOutOfRange(red) ||
                primaryColorOutOfRange(green) ||
                primaryColorOutOfRange(blue)) {
            throw new IllegalArgumentException("red, green, blue should all be in [0,255]");
        }
    }

    private boolean primaryColorOutOfRange(int primaryColor) {
        return primaryColor < 0 || primaryColor > 255;
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

    public ImmutableRGB invert() {
        return new ImmutableRGB(
                255 - red,
                255 - green,
                255 - blue,
                "invert-" + name
        );
    }
}
