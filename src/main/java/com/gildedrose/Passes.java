package com.gildedrose;

public class Passes extends Item {
    public Passes(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    void update() {
        super.update();
        if (isExpiredIn(0)) {
            clearQuality();
        }
    }

    @Override
    protected int getQualityRate() {
        if (isExpiredIn(5)) {
            return 3;
        }
        if (isExpiredIn(10)) {
            return 2;
        }
        return 1;
    }
}
