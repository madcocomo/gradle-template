package com.gildedrose;

import com.google.common.collect.ImmutableMap;
import java.util.Map;

public class Passes extends Item {
    private static final Map<Integer, Integer> RATES = ImmutableMap.of(0,-50, 5,3, 10,2);

    public Passes(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    void update() {
        super.update();
    }

    @Override
    protected int getQualityRate() {
        return RATES.entrySet().stream()
                .filter(entry -> isExpiredIn(entry.getKey()))
                .findFirst().map(Map.Entry::getValue).orElse(1);
    }
}
