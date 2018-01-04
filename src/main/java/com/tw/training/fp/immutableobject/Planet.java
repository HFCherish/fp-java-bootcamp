package com.tw.training.fp.immutableobject;

import java.util.Date;

/**
 * @author pzzheng
 * @date 1/4/18
 */
public final class Planet {
    private final double mass;
    private final String name;
    private final Date discoveryDate;

    public Planet(double mass, String name, Date discoveryDate) {
        this.mass = mass;
        this.name = name;
        this.discoveryDate = new Date(discoveryDate.getTime());
    }

    public double getMass() {
        return mass;
    }

    public String getName() {
        return name;
    }

    public Date getDiscoveryDate() {
        return new Date(discoveryDate.getTime());
    }
}
