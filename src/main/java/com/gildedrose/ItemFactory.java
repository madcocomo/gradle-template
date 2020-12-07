package com.gildedrose;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class ItemFactory {
    static List<ItemCreator> CREATORS = Arrays.asList(
            new ItemCreator(matchName("Aged Brie"), AgedBrie::new),
            new ItemCreator(matchName("Sulfuras, Hand of Ragnaros"), Sulfuras::new),
            new ItemCreator(matchName("Backstage passes to a TAFKAL80ETC concert"), Passes::new)
    );

    private static Predicate<String> matchName(String expectName) {
        return name -> name.equals(expectName);
    }

    Item createItem(String name, int sellIn, int quality) {
        return CREATORS.stream()
                .filter(creator -> creator.matchName(name))
                .findFirst()
                .map(creator -> creator.createItem(name, sellIn, quality))
                .orElse(new Item(name, sellIn, quality));
    }
}
