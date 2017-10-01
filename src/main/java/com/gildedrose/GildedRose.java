package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    private final String BRIE = "Aged Brie";
    private final String TICKETS = "Backstage passes to a TAFKAL80ETC concert";
    private final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    enum ItemType { brie, tickets, sulfuras, otherItem }


    public void updateQuality() {
        for (Item item: items) {

            ItemType type = ItemType.otherItem;
            if(item.name.equals(BRIE)) {
                type = ItemType.brie;
            } else if (item.name.equals(TICKETS)) {
                type = ItemType.tickets;
            } else if (item.name.equals(SULFURAS)) {
               type = ItemType.sulfuras;
            }


            switch (type) {
                case brie:
                    //Passed selling doubles quality
                    if (item.sellIn < 0 ) {
                        item.quality =resolveQuality(item.quality, 2);
                    }
                    else {
                        item.quality =resolveQuality(item.quality, 1);
                    }
                    // decrement sellIn by 1
                    item.sellIn -= 1;
                    return;
                case tickets:
                    //Check the sellin date.
                    if (item.sellIn <= 0 ) {
                        item.quality = 0;
                    }
                    else if(item.sellIn < 6) {
                        // increment quality by 3
                        item.quality = resolveQuality(item.quality, 3);
                    }
                    else if(item.sellIn < 11) {
                        // increment quality by 1
                        item.quality = resolveQuality(item.quality, 2);
                    }
                    else {
                        // increment quality by 1
                        item.quality = resolveQuality(item.quality, 1);
                    }

                    // decrement sellIn by 1
                    item.sellIn -= 1;
                    return;
                case sulfuras:

                    return;
                default:
                   if (item.sellIn >= 0) {
                       // decrement item by 1
                       item.quality = resolveQuality(item.quality, -1);
                   }
                   // if quality < 0, decrement 2
                   else {
                       item.quality = resolveQuality(item.quality, -2);
                   }
                   // decrement sellIn by 1
                   item.sellIn -= 1;
            }
        }
    }

    public int resolveQuality(int quality, int modifier) {
        //Resolve the modifier.
        quality = quality + modifier;
        //Check to see if the quality passed is a negative value.
        if(quality < 0) {
            //Default to zero.
            quality = 0;
        }
        else if(quality > 50) {
            //Default to fifty.
            quality = 50;
        }
        //Return the correct value.
        return quality;
    }
}