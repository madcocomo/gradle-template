package com.gildedrose;

class GildedRose {
    private static final ItemFactory itemFactory = new ItemFactory();
    private final Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public static Item createItem(String name, int sellIn, int quality) {
        return itemFactory.createItem(name, sellIn, quality);
    }

    public void updateQuality() {
        for (Item item : items) {
            item.update();
        }
    }

}
