package com.gildedrose;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * 不得修改此文件
 */
public class AppRunner {
    private static final List<String> DEFAULT_ITEMS = Arrays.asList(
            "+5 Dexterity Vest; 10; 20",
            "Aged Brie; 2; 0",
            "Elixir of the Mongoose; 5; 7",
            "Sulfuras, Hand of Ragnaros; 0; 80",
            "Sulfuras, Hand of Ragnaros; -1; 80",
            "Backstage passes to a TAFKAL80ETC concert; 15; 20",
            "Backstage passes to a TAFKAL80ETC concert; 10; 49",
            "Backstage passes to a TAFKAL80ETC concert; 5; 49",
            "Backstage passes to a TAFKAL80ETC concert; 1; 20",
            "Conjured Mana Cake; 3; 6"
    );
    private static final int DEFAULT_DAYS = 3;

    public static void main(String[] args) throws IOException {
        int days = DEFAULT_DAYS;
        List<String> items = DEFAULT_ITEMS;

        if (args.length > 1) {
            items = readContentFrom(args[0]).orElse(items);
            days = Integer.parseInt(args[1]) + 1;
        }
        updateAndPrintItems(days, createItemsFromString(items));
    }

    private static void updateAndPrintItems(int days, Item[] items) {
        GildedRose app = new GildedRose(items);
        System.out.println("OMGHAI!");
        for (int i = 0; i < days; i++) {
            printItemsInDay(items, i);
            app.updateQuality();
        }
    }

    private static void printItemsInDay(Item[] items, int i) {
        printDayHeader(i);
        printColumeTitle();
        printItems(items);
        printLineBreak();
    }

    private static void printItems(Item[] items) {
        for (Item item : items) {
            System.out.println(item);
        }
    }

    private static void printLineBreak() {
        System.out.println();
    }

    private static void printColumeTitle() {
        System.out.println("name, sellIn, quality");
    }

    private static void printDayHeader(int i) {
        System.out.println("-------- day " + i + " --------");
    }

    private static Item[] createItemsFromString(List<String> itemStrings) {
        return itemStrings.stream()
                .map(str -> str.split(" *; *"))
                .map(strs -> GildedRose.createItem(strs[0], Integer.parseInt(strs[1]), Integer.parseInt(strs[2])))
                .toArray(Item[]::new);
    }

    private static Optional<List<String>> readContentFrom(String arg) throws IOException {
        File itemsFile = new File(arg);
        if (itemsFile.exists()) {
            return Optional.of(Files.readAllLines(itemsFile.toPath()));
        }
        return Optional.empty();
    }

}
