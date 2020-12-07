package com.gildedrose;

public class Item {
    private String name;
    private int sellIn;
    private int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    void update() {
        updateSellIn();
        updateQualityBy(getQualityRate());
    }

    protected int getQualityRate() {
        return isExpiredIn(0) ? -2 : -1;
    }

    public boolean isExpiredIn(int days) {
        return sellIn < days;
    }

    private void updateQualityBy(int rate) {
        quality = quality + rate;
        quality = Math.min(quality, 50);
        quality = Math.max(quality, 0);
    }

    protected void clearQuality() {
        quality = 0;
    }

    protected void updateSellIn() {
        sellIn = sellIn - 1;
    }
}
