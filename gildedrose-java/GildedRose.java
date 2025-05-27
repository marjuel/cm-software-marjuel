package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (isSulfuras(item))
                continue;

            if (isAgedBrie(item))
                updateAgedBrie(item);
            else if (isBackstagePass(item))
                updateBackstagePass(item);
            else
                updateRegularItem(item);
        }
    }


    private void updateAgedBrie(Item item) {
        increaseQuality(item);

        item.sellIn--;

        if (item.sellIn < 0)
            increaseQuality(item);
    }

    private void updateBackstagePass(Item item) {
        increaseQuality(item);
        if (item.sellIn < 11)
            increaseQuality(item);

        if (item.sellIn < 6)
            increaseQuality(item);

        item.sellIn--;

        if (item.sellIn < 0)
            item.quality = 0;
    }

    private void updateRegularItem(Item item) {
        decreaseQuality(item);

        item.sellIn--;

        if (item.sellIn < 0)
            decreaseQuality(item);
    }

    private void decreaseQuality(Item item) {
        if (item.quality > 0)
            item.quality--;
    }

    private void increaseQuality(Item item) {
        if (item.quality < 50)
            item.quality++;
    }

    private boolean isSulfuras(Item item) {return item.name.equals("Sulfuras, Hand of Ragnaros");}

    private boolean isBackstagePass(Item item) {return item.name.equals("Backstage passes to a TAFKAL80ETC concert");}

    private boolean isAgedBrie(Item item) {return item.name.equals("Aged Brie");}
}
