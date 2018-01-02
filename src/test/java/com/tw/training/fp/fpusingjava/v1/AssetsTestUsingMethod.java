package com.tw.training.fp.fpusingjava.v1;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author pzzheng
 * @date 1/2/18
 */
public class AssetsTestUsingMethod {

    private List<Assets.Asset> assets;

    /**
     * @author pzzheng
     */
    @Before
    public void setUp() {
        assets = Arrays.asList(
                new Assets.Asset(AssetType.BOND, 2000),
                new Assets.Asset(AssetType.BOND, 3000),
                new Assets.Asset(AssetType.STOCK, 3000),
                new Assets.Asset(AssetType.STOCK, 4000)
        );
    }

    /**
     * @author pzzheng
     */
    @Test
    public void should_sum_all_asset() {
        assertThat(Assets.sumValue(assets, Assets.AssetsFilter.filterAll), is(12000));
    }

    /**
     * @author pzzheng
     */
    @Test
    public void should_sum_bond_assets() {
        assertThat(Assets.sumValue(assets, Assets.AssetsFilter.filterBondAsset), is(5000));
    }

    /**
     * @author pzzheng
     */
    @Test
    public void should_sum_stock_assets() {
        assertThat(Assets.sumValue(assets, Assets.AssetsFilter.filterStockAsset), is(7000));
    }
}
