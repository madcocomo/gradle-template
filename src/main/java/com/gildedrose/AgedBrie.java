package com.gildedrose;

public class AgedBrie extends Item {
    public AgedBrie(String name, int sellIn, int quality) {
        super(name, 0, quality);
    }

    @Override
    protected int getQualityRate() {
        return 1;
    }
}
