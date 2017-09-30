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
    public void itemShould() {
        app.items = new Item[] { new Item("item", 10, 10)};
        app.updateQuality();

        assertEquals(9, app.items[0].sellIn);
    }

}
