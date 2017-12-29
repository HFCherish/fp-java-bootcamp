package com.tw.training.fp.designpattern.SRP;

import java.util.List;
import java.util.function.Predicate;
import java.util.function.ToIntBiFunction;

/**
 * @author pzzheng
 * @date 12/29/17
 */
public class Assets {
    public static class AssetsFilter {
        public static final Predicate<Asset> filterStockAsset = asset -> asset.type.equals(AssetType.STOCK);
        public static final Predicate<Asset> filterBondAsset = asset -> asset.type.equals(AssetType.BOND);
        public static final Predicate<Asset> filterAll = asset -> true;
    }

    public static final ToIntBiFunction<List<Asset>, Predicate<Asset>> sumValue = (assets, filter) -> assets.stream().filter(filter).mapToInt(a -> a.value).sum();


    /**
     * @author pzzheng
     * @date 12/29/17
     */
    public static class Asset {
        private final AssetType type;
        private final int value;

        public Asset(final AssetType type, final int value) {
            this.type = type;
            this.value = value;
        }
    }
}
