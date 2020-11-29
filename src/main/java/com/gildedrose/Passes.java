package com.gildedrose;

public class Passes extends Item {
    public Passes(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    void update() {
        if (quality < 50) {
            quality = quality + 1;
            if (sellIn < 11) {
                if (quality < 50) {
                    quality = quality + 1;
                }
            }
            if (sellIn < 6) {
                if (quality < 50) {
                    quality = quality + 1;
                }
            }
        }
        sellIn = sellIn - 1;
        if (sellIn < 0) {
            quality = 0;
        }
    }

}
