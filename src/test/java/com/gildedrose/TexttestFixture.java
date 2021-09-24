package com.gildedrose;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.Files.readString;
import static java.nio.file.Files.writeString;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TexttestFixture {

    public static final Path EXPECTED_OUTPUT = Paths.get("src/test/resources/expected.out");

    public static final Item[] ITEMS = new Item[]{
        new Item("+5 Dexterity Vest", 10, 20), //
        new Item("Aged Brie", 2, 0), //
        new Item("Elixir of the Mongoose", 5, 7), //
        new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
        new Item("Sulfuras, Hand of Ragnaros", -1, 80),
        new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
        new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
        new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
        // this conjured item does not work properly yet
        new Item("Conjured Mana Cake", 3, 6)};

    @Test
    public void outputMatchesReference() throws Exception
    {
        assertEquals(readString(EXPECTED_OUTPUT), generateOutput(2, ITEMS));
    }

    @Disabled("Run this manually to update the expected output based on current behaviour")
    @Test
    public void approveCurrentOutput() throws Exception
    {
        writeString(EXPECTED_OUTPUT, generateOutput(2, ITEMS));
    }

    public static String generateOutput(int days, Item[] items) {
        String output = "OMGHAI!\n";

        GildedRose app = new GildedRose(items);

        for (int i = 0; i < days; i++) {
            output += "-------- day " + i + " --------\n";
            output += "name, sellIn, quality\n";
            for (Item item : items) {
                output += item + "\n";
            }
            output += "\n";
            app.updateQuality();
        }
        return output;
    }
}
