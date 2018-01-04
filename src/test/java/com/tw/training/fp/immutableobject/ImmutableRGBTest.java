package com.tw.training.fp.immutableobject;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

/**
 * @author pzzheng
 * @date 1/4/18
 */
public class ImmutableRGBTest {

    private final String colorName = "some color";

    /**
     * @author pzzheng
     */
    @Test
    public void should_create_color_when_given_right_input() {
        ImmutableRGB someColor = new ImmutableRGB(1, 1, 1, colorName);

        assertThat(someColor.getRed(), is(1));
        assertThat(someColor.getGreen(), is(1));
        assertThat(someColor.getBlue(), is(1));
        assertThat(someColor.getName(), is(colorName));
    }

    /**
     * @author pzzheng
     */
    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_if_atom_color_is_out_of_range() {
        new ImmutableRGB(-1, 1, 1, colorName);
    }

    /**
     * @author pzzheng
     */
    @Test
    public void should_revert_color() {
        ImmutableRGB original = new ImmutableRGB(1, 1, 1, colorName);

        ImmutableRGB invert = original.invert();

        assertThat(invert, is(not(original)));
        assertThat(invert.getName(), is(not(colorName)));
        assertThat(invert.getRed(), is(254));
    }
}