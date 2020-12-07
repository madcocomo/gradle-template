package com.gildedrose;

import java.util.function.Predicate;

class ItemCreator {
    Predicate<String> isType;
    ItemConstructor constructor;

    @FunctionalInterface
    interface ItemConstructor {
        Item apply(String name, int sellIn, int quality);
    }

    public ItemCreator(Predicate<String> isType, ItemConstructor creator) {
        this.isType = isType;
        this.constructor = creator;
    }

    Item createItem(String name, int sellIn, int quality) {
        return constructor.apply(name, sellIn, quality);
    }

    boolean matchName(String name) {
        return isType.test(name);
    }
}
