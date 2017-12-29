package com.tw.training.fp.designpattern.SRP;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author pzzheng
 * @date 12/29/17
 */
public class AssetTest {

    /**
     * @author pzzheng
     */
    @Test
    public void should_sum_all_asset() {
        List<Assets.Asset> assets = Arrays.asList(
                Assets.create(AssetType.BOND, 2000),
                Assets.create(AssetType.BOND, 3000),
                Assets.create(AssetType.STOCK, 3000),
                Assets.create(AssetType.STOCK, 4000)
        );

        assertThat(Assets.sumValue(assets), is(12000));
    }
}