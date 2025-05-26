package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (!isAgedBrie(item) && !isBackstagePass(item)) {
                if (item.quality > 0) {
                    if (!isSulfuras(item)) {
                        item.quality--;
                    }
                }
            } else {
                increaseQualityIfPossible(item);

                if (isBackstagePass(item)) {
                    if (item.sellIn < 11) {
                        increaseQualityIfPossible(item);
                    }

                    if (item.sellIn < 6) {
                        increaseQualityIfPossible(item);
                    }
                }
            }

            if (!isSulfuras(item)) {
                item.sellIn--;
            }

            if (item.sellIn < 0) {
                if (!isAgedBrie(item)) {
                    if (!isBackstagePass(item)) {
                        if (item.quality > 0) {
                            if (!isSulfuras(item)) {
                                item.quality--;
                            }
                        }
                    } else {
                        item.quality = 0;
                    }
                } else {
                    increaseQualityIfPossible(item);
                }
            }
        }

    }

    private void increaseQualityIfPossible(Item item) {
        if (item.quality < 50)
            item.quality++;
    }

    private boolean isSulfuras(Item item) {return item.name.equals("Sulfuras, Hand of Ragnaros");}

    private boolean isBackstagePass(Item item) {return item.name.equals("Backstage passes to a TAFKAL80ETC concert");}

    private boolean isAgedBrie(Item item) {return item.name.equals("Aged Brie");}
}
