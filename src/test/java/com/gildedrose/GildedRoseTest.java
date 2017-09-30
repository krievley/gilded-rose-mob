package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GildedRoseTest {

    GildedRose app;

    @Before
    public void setUp() throws Exception {
        Item[] items = new Item[] { new Item("item", 10, 10)};
        app = new GildedRose(items);
    }

    @Test
    public void itemShouldDecrementQuality() {
        app.items = new Item[] { new Item("item", 10, 10)};
        app.updateQuality();

        assertEquals(9, app.items[0].quality);
    }

    @Test
    public void itemShouldDecrementSellInValue() {
        app.items = new Item[] { new Item("item", 10, 10)};
        app.updateQuality();

        assertEquals(9, app.items[0].sellIn);
    }

    @Test
    public void itemQualityShouldDecrementTwiceAfterSell() {
        app.items = new Item[] { new Item("item", -1, 10)};
        app.updateQuality();

        assertEquals(8, app.items[0].quality);
    }

    @Test
    public void itemQualityNeverNegative() {
        app.items = new Item[] { new Item("item", 10, 0)};
        app.updateQuality();

        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void agedBrieIncreasesQuality() {
        app.items = new Item[] { new Item("Aged Brie", 10, 0)};
        app.updateQuality();

        assertEquals(1, app.items[0].quality);
    }

}
