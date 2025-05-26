package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!isAgedBrie(i) && !isBackstagePass(i)) {
                if (items[i].quality > 0) {
                    if (!isSulfuras(i)) {
                        items[i].quality = items[i].quality - 1;
                    }
                }
            } else {
                increaseQualityIfPossible(items[i]);

                if (isBackstagePass(i)) {
                    if (items[i].sellIn < 11) {
                        increaseQualityIfPossible(items[i]);
                    }

                    if (items[i].sellIn < 6) {
                        increaseQualityIfPossible(items[i]);
                    }
                }
            }

            if (!isSulfuras(i)) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (!isAgedBrie(i)) {
                    if (!isBackstagePass(i)) {
                        if (items[i].quality > 0) {
                            if (!isSulfuras(i)) {
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else {
                    increaseQualityIfPossible(items[i]);
                }
            }
        }
    }

    private void increaseQualityIfPossible(Item item) {
        if (item.quality < 50)
            item.quality++;
    }

    private boolean isSulfuras(int i) {return items[i].name.equals("Sulfuras, Hand of Ragnaros");}

    private boolean isBackstagePass(int i) {return items[i].name.equals("Backstage passes to a TAFKAL80ETC concert");}

    private boolean isAgedBrie(int i) {return items[i].name.equals("Aged Brie");}
}
