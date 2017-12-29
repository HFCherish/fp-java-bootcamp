package com.tw.training.fp.designpattern.SRP;

import com.tw.training.fp.designpattern.SRP.Assets.Asset;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.tw.training.fp.designpattern.SRP.Assets.AssetsFilter.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author pzzheng
 * @date 12/29/17
 */
public class AssetTest {

    private List<Asset> assets;

    /**
     * @author pzzheng
     */
    @Before
    public void setUp() {
        assets = Arrays.asList(
                new Asset(AssetType.BOND, 2000),
                new Asset(AssetType.BOND, 3000),
                new Asset(AssetType.STOCK, 3000),
                new Asset(AssetType.STOCK, 4000)
        );
    }

    /**
     * @author pzzheng
     */
    @Test
    public void should_sum_all_asset() {
        assertThat(Assets.sumValue.applyAsInt(assets, filterAll), is(12000));
    }

    /**
     * @author pzzheng
     */
    @Test
    public void should_sum_bond_assets() {
        assertThat(Assets.sumValue.applyAsInt(assets, filterBondAsset), is(5000));
    }

    /**
     * @author pzzheng
     */
    @Test
    public void should_sum_stock_assets() {
        assertThat(Assets.sumValue.applyAsInt(assets, filterStockAsset), is(7000));
    }
}