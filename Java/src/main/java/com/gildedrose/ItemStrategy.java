package com.gildedrose;

public interface ItemStrategy {

    Item updateItem(Item item);

    /**
     * update item to increment and decrement quality based on minQuality and maxQuality
     * and decrease sellIn in legendary item case
     *
     * @param coef
     * @param minQuality
     * @param maxQuality
     * @item
     */
    default Item itemUpdated(Item item, int coef, int minQuality, int maxQuality, boolean isLegendary) {
        updateQuality(item, coef, minQuality, maxQuality);
        if (!isLegendary) {
            --item.sellIn;
        }
        return item;
    }

    static void updateQuality(Item item, int coef, int minQuality, int maxQuality) {
        if (item.quality + coef < minQuality) {//do not exceed the min value
            item.quality = minQuality;
        } else if (item.quality + coef > maxQuality) {//do not exceed the max value
            item.quality = maxQuality;
        } else if (item.quality > minQuality && item.quality < maxQuality) {
            item.quality = item.quality + coef;
        }
    }

}
