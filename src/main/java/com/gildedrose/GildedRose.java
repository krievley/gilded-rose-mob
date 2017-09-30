package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            // check it's NOT brie || NOT backstage passes
            if (!items[i].name.equals("Aged Brie")
                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                // check quality is more than 0
                if (items[i].quality > 0) {
                    // check item is NOT sulfuras
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                        // decrement item by 1
                        items[i].quality = items[i].quality - 1;
                    }
                }
            }
            // if item IS brie || backstage passes
            else {
                // if item quality is is less than 50
                if (items[i].quality < 50) {
                    // increment quality by 1
                    items[i].quality = items[i].quality + 1;

                    // if the item IS backstage passes
                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        // if item sellIn is less than 11
                        if (items[i].sellIn < 11) {
                            // if item quality is less than 50
                            if (items[i].quality < 50) {
                                // increment quality by 1
                                items[i].quality = items[i].quality + 1;
                            }
                        }

                        // if item IS backstage pass && sellin les than 6
                        if (items[i].sellIn < 6) {
                            // if item quality is less than 50
                            if (items[i].quality < 50) {
                                // increment quality by 1
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }
            }

            // if item NOT sulfuras
            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                // decrement sellIn by 1
                items[i].sellIn = items[i].sellIn - 1;
            }

            // if any item is sellIn less than 0
            if (items[i].sellIn < 0) {
                // if item NOT brie
                if (!items[i].name.equals("Aged Brie")) {
                    // if item NOT backstage passes
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        // if item quality is more than 0
                        if (items[i].quality > 0) {
                            // if item is NOT sulfuras
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                                // decrement item quality by 1
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    }
                    // if item IS backstage passes
                    else {
                        // quality set to zero
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                }
                // if item IS brie
                else {
                    // if item quality is less than 50
                    if (items[i].quality < 50) {
                        // increment item quality by 1
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
        }
    }
}