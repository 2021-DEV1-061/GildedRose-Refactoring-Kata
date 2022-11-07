package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[]{new Item("foo", 0, 0)};
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals("foo", gildedRose.items[0].name);
    }

    /**
     * Aged Brie item quality is never more than 50
     */
    @Test
    void agedBrieQualityShouldNotBeMoreThan50() {
        Item item = new Item("Aged Brie", 8, 50);
        GildedRose gildedRose = new GildedRose(new Item[]{item});
        gildedRose.updateQuality();
        assertEquals(item.name, "Aged Brie");
        assertEquals(item.quality, 50);
        assertEquals(item.sellIn, 7);
    }

    /**
     * Sulfuras is a legendary item increases when Sell in is off
     */
    @Test
    void sulfurasPassesQualityIncreases0WhenSellInOff() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", -1, 80);
        GildedRose gildedRose = new GildedRose(new Item[]{item});
        gildedRose.updateQuality();
        assertEquals(item.name, "Sulfuras, Hand of Ragnaros");
        assertEquals(item.sellIn, -1);
    }

    /**
     * Sulfuras is a legendary item quality is 80 and it never alter
     */
    @Test
    void sulfurasItemsNeverDecreaseInQuality() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", -1, 80);
        GildedRose gildedRose = new GildedRose(new Item[]{item});
        gildedRose.updateQuality();
        assertEquals(item.quality, 80);
    }

    /**
     * Backstage quality increases by 2 when there are 10 days or less
     */
    @Test
    void backstageQualityIncreases2TimesIn10Days() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 8, 30);
        GildedRose gildedRose = new GildedRose(new Item[]{item});
        gildedRose.updateQuality();
        assertEquals(item.name, "Backstage passes to a TAFKAL80ETC concert");
        assertEquals(item.quality, 32);
        assertEquals(item.sellIn, 7);
    }

    /**
     * Backstage quality increases by 3 when there are 5 days
     */
    @Test
    void backStagePassesQualityIncreases3TimesIn5Days() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 2);
        GildedRose gildedRose = new GildedRose(new Item[]{item});
        gildedRose.updateQuality();
        assertEquals(item.name, "Backstage passes to a TAFKAL80ETC concert");
        assertEquals(item.sellIn, 4);
        assertEquals(item.quality, 5);
    }

    /**
     * Backstage item quality is 0 after concert
     */
    @Test
    void backstagePassesQualityIs0AfterConcert() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20);
        GildedRose gildedRose = new GildedRose(new Item[]{item});
        gildedRose.updateQuality();
        assertEquals(item.quality, 0);
    }

    /**
     * Backstage quality sellIn Is more TenDays
     */
    @Test
    void backStagePassesQualityIncreases3TimesIn10DaysMore() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 2);
        GildedRose gildedRose = new GildedRose(new Item[]{item});
        gildedRose.updateQuality();
        assertEquals(item.name, "Backstage passes to a TAFKAL80ETC concert");
        assertEquals(item.sellIn, 10);
        assertEquals(item.quality, 3);
    }

    /**
     * Conjured item decrement quality twice faster than normal
     */
    @Test
    void conjuredItemDecreaseQualityTwiceFaster() {
        Item item = new Item("Conjured Mana Cake", 10, 30);
        GildedRose gildedRose = new GildedRose(new Item[]{item});
        gildedRose.updateQuality();
        assertEquals(item.quality, 28);
        assertEquals(item.sellIn, 9);
    }

    /**
     * Conjured item decrease quality twice when expired
     */
    @Test
    void conjuredItemDecreasesQualityWhenExpired() {
        Item item = new Item("Conjured Mana Cake", 0, 30);
        GildedRose gildedRose = new GildedRose(new Item[]{item});
        gildedRose.updateQuality();
        assertEquals(item.sellIn, -1);
        assertEquals(item.quality, 28);
    }

}
