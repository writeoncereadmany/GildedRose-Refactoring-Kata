package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void endOfDayUpdateReducesDaysToSellIn() {
        // Given
        final Item item = new Item("Regular item", 10, 5);

        // When
        applyEndOfDayUpdate(item);

        // Then
        assertEquals(9, item.sellIn);
    }

    @Test
    void endOfDayUpdateReducesQualityForRegularItem() {
        // Given
        final Item item = new Item("Regular item", 10, 5);

        // When
        applyEndOfDayUpdate(item);

        // Then
        assertEquals(4, item.quality);
    }

    private static void applyEndOfDayUpdate(Item... items) {
        GildedRose app = new GildedRose(items);
        app.updateQuality();
    }
}
