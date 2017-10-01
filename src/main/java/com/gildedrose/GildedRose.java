package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    private final String BRIE = "Aged Brie";
    private final String TICKETS = "Backstage passes to a TAFKAL80ETC concert";
    private final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    enum ItemType { brie, tickets, sulfuras, otherItem, }


    public void updateQuality() {
        for (Item item: items) {

            ItemType type = ItemType.otherItem;
            if(item.name.equals(BRIE)) { type = ItemType.brie;
            } else if (item.name.equals(TICKETS)) { type = ItemType.tickets;
            } else if (item.name.equals(SULFURAS)) { type = ItemType.sulfuras; }

            int modifier = 1;

            switch (type) {
                case brie:
                    //Passed selling doubles quality
                    if (item.sellIn < 0 ) { modifier = 2; }
                    break;
                case tickets:
                    //Check the sellin date.
                    if (item.sellIn <= 0 ) {
                        item.quality = 0;
                        modifier = 0;
                        break;
                    }
                    else if(item.sellIn < 6) { modifier = 3; }
                    else if(item.sellIn < 11) { modifier = 2; }

                    break;
                case sulfuras:
                    // offset the sellIn by 1 to take account of decrement
                    item.sellIn += 1;
                    modifier = 0;
                    break;
                default:
                   if (item.sellIn >= 0) { modifier = -1; }
                   else { modifier = - 2; }
            }

            item.sellIn -= 1;
            resolveQuality(item, modifier);
        }
    }

    private void resolveQuality(Item item, int modifier) {
        //Resolve the modifier.
        item.quality += modifier;
        //Check to see if the quality passed is a negative value.
        if(item.quality < 0) {
            //Default to zero.
            item.quality = 0;
        }
        else if(item.quality > 50 && !item.name.equals(SULFURAS)) {
            //Default to fifty.
            item.quality = 50;
        }
    }
}