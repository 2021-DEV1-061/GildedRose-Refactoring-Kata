package com.gildedrose;

public class SulfurasStrategy implements ItemStrategy {

    private static final Integer minQuality = 80;
    private static final Integer maxQuality = 80;

    @Override
    public Item updateItem(Item item) {

        Item newItem = itemUpdated(item, 0, minQuality, maxQuality, true);
        return new Item(newItem.name, newItem.sellIn, newItem.quality);

    }
}
