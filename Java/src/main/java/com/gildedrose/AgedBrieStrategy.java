package com.gildedrose;

public class AgedBrieStrategy implements ItemStrategy {

    private static final Integer minQuality = 0;
    private static final Integer maxQuality = 50;

    @Override
    public Item updateItem(Item item) {
        Item newItem = itemUpdated(item, 1, minQuality, maxQuality, false);
        return new Item(newItem.name, newItem.sellIn, newItem.quality);
    }

}
