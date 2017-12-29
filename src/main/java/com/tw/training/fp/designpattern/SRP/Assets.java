package com.tw.training.fp.designpattern.SRP;

import java.util.List; /**
 * @author pzzheng
 * @date 12/29/17
 */
public class Assets {
    public static Asset create(final AssetType type, final int value) {
        return new Asset(type, value);
    }

    public static Integer sumValue(final List<Asset> assets) {
        return assets.stream().mapToInt(a -> a.value).sum();
    }

    public static Integer sumBondValue(final List<Asset> assets) {
        return assets.stream().filter(asset -> asset.type.equals(AssetType.BOND)).mapToInt(a -> a.value).sum();
    }


    /**
     * @author pzzheng
     * @date 12/29/17
     */
    public static class Asset {
        private final AssetType type;
        private final int value;

        private Asset(final AssetType type, final int value) {
            this.type = type;
            this.value = value;
        }
    }
}
