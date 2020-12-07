package com.gildedrose;

public class Conjured extends Item {
    public Conjured(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    protected int getQualityRate() {
        return super.getQualityRate() * 2;
    }
}
