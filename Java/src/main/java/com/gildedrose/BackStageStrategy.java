package com.gildedrose;

public class BackStageStrategy implements ItemStrategy {

    private static final Integer minQuality = 0;
    private static final Integer maxQuality = 50;

    @Override
    public Item updateItem(Item item) {

        Item newItem = item;
        if (item.sellIn <= 0) {
            item.quality = 0;
        } else if (item.sellIn < 6) {
            newItem = itemUpdated(item, 3, minQuality, maxQuality, false);
        } else if (item.sellIn < 11) {
            newItem = itemUpdated(item, 2, minQuality, maxQuality, false);
        } else {
            newItem = itemUpdated(item, 1, minQuality, maxQuality, false);
        }
        return newItem;
    }
}
