package pao.lab10.iteratorSpliterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TreasureHunt {
    public static void main(String[] args) {
        // Create a List of Area objects representing each area in the game world
        List<Area> areas = new ArrayList<>();
        areas.add(new Area("Area 1", new TreasureChest(100), new TreasureChest(50), new TreasureChest(200)));
        areas.add(new Area("Area 2", new TreasureChest(150), new TreasureChest(75)));
        areas.add(new Area("Area 3", new TreasureChest(300), new TreasureChest(25), new TreasureChest(50)));

        // Implement a findMostValuableChest() method that uses the Iterator to search for the most valuable treasure chest in the game world
        TreasureChest mostValuableChest = findMostValuableChest(areas.iterator());
        System.out.println("The most valuable treasure chest has a value of " + mostValuableChest.getValue());
    }

    public static TreasureChest findMostValuableChest(Iterator<Area> areaIterator) {
        TreasureChest mostValuableChest = null;
        while (areaIterator.hasNext()) {
            Area area = areaIterator.next();
            Iterator<TreasureChest> chestIterator = area.getTreasureChests().iterator();
            while (chestIterator.hasNext()) {
                TreasureChest chest = chestIterator.next();
                if (mostValuableChest == null || chest.getValue() > mostValuableChest.getValue()) {
                    mostValuableChest = chest;
                }
            }
        }
        return mostValuableChest;
    }

    // Area class
    public static class Area {
        private String name;
        private List<TreasureChest> treasureChests;

        public Area(String name, TreasureChest... treasureChests) {
            this.name = name;
            this.treasureChests = new ArrayList<>();
            for (TreasureChest chest : treasureChests) {
                this.treasureChests.add(chest);
            }
        }

        public List<TreasureChest> getTreasureChests() {
            return treasureChests;
        }
    }

    // TreasureChest class
    public static class TreasureChest {
        private int value;

        public TreasureChest(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}
