package com.tw.training.fp.fpusingjava.v1;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.function.ToIntBiFunction;
import java.util.stream.Collectors;

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

    public static final BiFunction<Integer, Asset, Asset> addValue = (value, asset) -> new Asset(asset.type, asset.value + value);

    public static final BiFunction<Integer, Asset, Asset> encash = (value, asset) -> addValue.apply(-1 * value, asset);

    public static final TriFunction<Integer, Predicate<Asset>, List<Asset>, List<Asset>> addValueToAll = (value, filter, assets) ->
            assets.stream().filter(filter)
                    .map(asset -> addValue.apply(value, asset))
                    .collect(Collectors.toList());



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

        public AssetType getType() {
            return type;
        }

        public int getValue() {
            return value;
        }
    }
}
