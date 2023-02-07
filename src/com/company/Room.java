package com.company;

public class Room {
    private boolean[][] openings;
    private boolean found;
    private int dangerLevel;
    private int ore;

    public Room(int dangerLevel, int ore, boolean[][] openings  ){
        this.dangerLevel = dangerLevel;
        this.ore = ore;
        this.openings = openings;
        found = false;
    }

    public boolean[][] getOpenings() {
        return openings;
    }

    public boolean isFound() {
        return found;
    }

    public int getDangerLevel() {
        return dangerLevel;
    }

    public int getOre() {
        return ore;
    }

    public boolean getFound() {
        return found;
    }

    public void setFound() {
        found = true;
    }
}
