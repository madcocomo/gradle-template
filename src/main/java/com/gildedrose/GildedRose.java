package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    static Item createItem(String name, int sellIn, int quality) {
        if (isAged_brie(name)) {
            return new AgedBrie(name, sellIn, quality);
        }
        if (isSulfuras(name)) {
            return new Sulfuras(name, sellIn, quality);
        }
        if (isPasses(name)) {
            return new Passes(name, sellIn, quality);
        }
        return new Item(name, sellIn, quality);
    }

    static boolean isSulfuras(String name) {
        return name.equals("Sulfuras, Hand of Ragnaros");
    }

    protected static boolean isPasses(String name) {
        return name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    protected static boolean isAged_brie(String name) {
        return name.equals("Aged Brie");
    }

    public void updateQuality() {
        for (Item item : items) {
            item.update();
        }
    }

}
