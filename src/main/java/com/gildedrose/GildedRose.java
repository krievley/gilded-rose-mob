package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    private final String BRIE = "Aged Brie";
    private final String TICKETS = "Backstage passes to a TAFKAL80ETC concert";
    private final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    enum ItemType { brie, tickets, sulfuras }


    public void updateQuality() {
        for (Item item: items) {

            ItemType type = ItemType.valueOf(item.name);

            switch (type) {
                case brie:

                    return;
                case tickets:

                    return;
                case sulfuras:

                    return;
            }

         //for (int i = 0; i < items.length; i++) {
            // check it's NOT brie || NOT backstage passes
            if (!item.name.equals(BRIE) && !item.name.equals(TICKETS)) {
                // check quality is more than 0 && check item is NOT sulfuras
                if (item.quality > 0 && !item.name.equals(SULFURAS)) {
                        // decrement item by 1
                        item.quality = item.quality - 1;
                    }
                }
            }
            // if item IS brie || backstage passes
            else {
                // if item quality is is less than 50
                if (item.quality < 50) {
                    // increment quality by 1
                    item.quality = item.quality + 1;

                    // if the item IS backstage passes
                    if (item.name.equals(TICKETS)) {
                        // if item sellIn is less than 11
                        if (item.sellIn < 11) {
                            // if item quality is less than 50
                            if (item.quality < 50) {
                                // increment quality by 1
                                item.quality = item.quality + 1;
                            }
                        }

                        // if item IS backstage pass && sellin les than 6
                        if (item.sellIn < 6) {
                            // if item quality is less than 50
                            if (item.quality < 50) {
                                // increment quality by 1
                                item.quality = item.quality + 1;
                            }
                        }
                    }
                }
            }

            // if item NOT sulfuras
            if (!item.name.equals(SULFURAS)) {
                // decrement sellIn by 1
                item.sellIn = item.sellIn - 1;
            }

            // if any item is sellIn less than 0
            if (item.sellIn < 0) {
                // if item NOT brie
                if (!item.name.equals(BRIE)) {
                    // if item NOT backstage passes
                    if (!item.name.equals(TICKETS)) {
                        // if item quality is more than 0
                        if (item.quality > 0) {
                            // if item is NOT sulfuras
                            if (!item.name.equals(SULFURAS)) {
                                // decrement item quality by 1
                                item.quality = item.quality - 1;
                            }
                        }
                    }
                    // if item IS backstage passes
                    else {
                        // quality set to zero
                        item.quality = item.quality - item.quality;
                    }
                }
                // if item IS brie
                else {
                    // if item quality is less than 50
                    if (item.quality < 50) {
                        // increment item quality by 1
                        item.quality = item.quality + 1;
                    }
                }
            }
        }
    }
}