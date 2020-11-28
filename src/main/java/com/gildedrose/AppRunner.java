package com.gildedrose;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

public class AppRunner {
    public static void main(String[] args) throws IOException {
        int days = 3;
        List<String> itemStrings = Arrays.asList(
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

        if (args.length > 1) {
            File itemsFile = new File(args[0]);
            if (itemsFile.exists()) {
                itemStrings = Files.readAllLines(itemsFile.toPath());
            }
            days = Integer.parseInt(args[1]) + 1;
        }


        System.out.println("OMGHAI!");

        Item[] items = itemStrings.stream()
                .map(str -> str.split(" *; *"))
                .map(strs -> new Item(strs[0], Integer.parseInt(strs[1]), Integer.parseInt(strs[2])))
                .toArray(Item[]::new);

        GildedRose app = new GildedRose(items);

        for (int i = 0; i < days; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");
            for (Item item : items) {
                System.out.println(item);
            }
            System.out.println();
            app.update_quality();
        }
    }

}
