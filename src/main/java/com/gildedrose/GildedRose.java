package com.gildedrose;

/**
 * The Gilded Rose class models a store which contains various types of items
 * @author Adam Zemmoura, E Kathuria, Kristin Rievley, Sean Ward
 */
class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    private final String BRIE = "Aged Brie";
    private final String TICKETS = "Backstage passes to a TAFKAL80ETC concert";
    private final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private final String CONJURED = "conjured ";

    enum ItemType { brie, tickets, sulfuras, otherItem, }

    /**
     * This method simulates the passage of one day and contains the logic applicable
     * to update the item quality and sellIn values per the requirements. This method
     * is called on every Item in the items array.
     */
    public void updateQuality() {
        for (Item item: items) {

            ItemType type = ItemType.otherItem;
            if(item.name.equals(BRIE) || item.name.equals(CONJURED + BRIE)) { type = ItemType.brie;
            } else if (item.name.equals(TICKETS) ||
                    item.name.equals(CONJURED + TICKETS)) { type = ItemType.tickets;
            } else if (item.name.equals(SULFURAS) ||
                    item.name.equals(CONJURED + SULFURAS)) { type = ItemType.sulfuras;  }

            int modifier = 1;

            switch (type) {
                case brie:
                    //Passed selling doubles quality
                    if (item.sellIn < 0 ) { modifier = 2; }
                    break;
                case tickets:
                    //Check the sellIn date.
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

    /**
     * This method takes an item and changes its quality value based on a modifier.
     * Quality is doubled if the Item is conjured.
     * @param item The item for which quality is being updated
     * @param modifier The value by which the quality is modified
     */
    private void resolveQuality(Item item, int modifier) {
        //Resolve the modifier.
        if (item.name.contains("conjured")) { modifier *= 2; }
        item.quality += modifier;
        //Check to see if the quality passed is a negative value.
        if(item.quality < 0) {
            //Default to zero.
            item.quality = 0;
        }
        else if(item.quality > 50 && !item.name.equals(SULFURAS)
                && !item.name.equals(CONJURED + SULFURAS)) {
            //Default to fifty.
            item.quality = 50;
        }
    }
}