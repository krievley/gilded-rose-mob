package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GildedRoseTest {

    GildedRose app;
    String agedBrie;
    String sulfuras;
    String backStagePasses;

    @Before
    public void setUp() throws Exception {
        Item[] items = new Item[] { new Item("item", 10, 10)};
        app = new GildedRose(items);
        agedBrie = "Aged Brie";
        sulfuras = "Sulfuras, Hand of Ragnaros";
        backStagePasses = "Backstage passes to a TAFKAL80ETC concert";
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
        app.items = new Item[] { new Item(agedBrie, 10, 0)};

        app.updateQuality();

        assertEquals(1, app.items[0].quality);
    }

    @Test
    public void agedBrieIncreasesQualityBy2AfterSellIn() {
        app.items = new Item[] { new Item(agedBrie, -1, 0)};

        app.updateQuality();

        assertEquals(2, app.items[0].quality);
    }

    @Test
    public void itemShouldNeverBeAboveQuality50() {
        app.items = new Item[] { new Item(agedBrie, 10, 50)};

        app.updateQuality();

        assertEquals(50, app.items[0].quality);
    }

    @Test
    public void sulfurasQaulityNeverChanges() {
        app.items = new Item[] { new Item(sulfuras, 10, 80)};

        app.updateQuality();

        assertEquals(80, app.items[0].quality);
    }

    @Test
    public void sulfurasSellInNeverChanges() {
        app.items = new Item[] { new Item(sulfuras, 10, 80)};

        app.updateQuality();

        assertEquals(10, app.items[0].sellIn);
    }

    @Test
    public void backstagePassesIncreaseInQualityBy1Outside10Days() {
        app.items = new Item[] { new Item(backStagePasses, 20, 10)};

        app.updateQuality();

        assertEquals(11, app.items[0].quality);
    }

    @Test
    public void backstagePassesIncreaseInQualityBy2Bettwen10And5Days() {
        app.items = new Item[] { new Item(backStagePasses, 10, 10)};

        app.updateQuality();

        assertEquals(12, app.items[0].quality);
    }

    @Test
    public void backstagePassesIncreaseInQualityBy3Bettwen5And0Days() {
        app.items = new Item[] { new Item(backStagePasses, 5, 10)};

        app.updateQuality();

        assertEquals(13, app.items[0].quality);
    }

    @Test
    public void backstagePassesAreWorthlessAfterSellIn() {
        app.items = new Item[] { new Item(backStagePasses, 0, 10)};

        app.updateQuality();

        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void toStringOutputsCorrectString() {
        app.items = new Item[] { new Item("item", 10, 10)};

        String expectedOutput = "item, 10, 10";

        assertEquals(expectedOutput, app.items[0].toString());
    }

    @Test
    public void conjuredItemsDegradeTwiceAsFast() {
        app.items = new Item[] { new Item("conjured item", 10, 10)};

        app.updateQuality();

        assertEquals(8, app.items[0].quality);
    }

    @Test
    public void conjuredBrieDegradeTwiceAsFast() {
        app.items = new Item[] { new Item("conjured" + agedBrie, 10, 10)};

        app.updateQuality();

        assertEquals(12, app.items[0].quality);
    }

}
