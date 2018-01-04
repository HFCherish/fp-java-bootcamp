package com.tw.training.fp.immutableobject;

import org.junit.Test;

import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author pzzheng
 * @date 1/4/18
 */
public class PlanetTest {

    /**
     * @author pzzheng
     */
    @Test
    public void should_date_be_same_value_and_different_objects() {
        Date discoveryDate = new Date();
        Planet jupitor = new Planet(1.0, "jupitor", discoveryDate);

        assertThat(jupitor.getDiscoveryDate().getTime(), is(discoveryDate.getTime()));
        assertThat(jupitor.getDiscoveryDate() != discoveryDate, is(true));
    }
}