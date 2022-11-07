package com.gildedrose;

import java.util.HashMap;
import java.util.Map;

class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    static Map<String, ItemStrategy> itemStrategyMap = new HashMap<>();

    static {
        itemStrategyMap.put("Aged Brie", new AgedBrieStrategy());
        itemStrategyMap.put("Sulfuras, Hand of Ragnaros", new SulfurasStrategy());
        itemStrategyMap.put("Backstage passes to a TAFKAL80ETC concert", new BackStageStrategy());
        itemStrategyMap.put("Conjured Mana Cake", new ConjuredStartegy());

    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            ItemStrategy itemStrategy = itemStrategyMap.getOrDefault(items[i].name, new DefaultStrategy());
            items[i] = itemStrategy.updateItem(items[i]);
        }
    }
}
