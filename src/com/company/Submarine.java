package com.company;

public class Submarine {
    private Component miningGear;
    private Component weapon;
    private Component powerPlant;
    private Component armour;
    int hp;
    int maxHP;

    public Submarine(){
        weapon = new Component("Defense Taser", 5, new int[7]);
        armour = new Component("Steel Hull", 5, new int[7]);
        miningGear = new Component("Small Drill", 5, new int[7]);
        powerPlant = new Component("Methane, Engine", 5, new int[7]);
        hp = armour.getPower()*10;
        maxHP = hp;
    }

    public void displayStatus(Map map){
        System.out.println("Submersible State\n");
        System.out.println("HP: " + hp + " / " + maxHP);
        System.out.println("Weaponry: " + weapon);
        System.out.println("Armour: " + armour);
        System.out.println("Mining Gear: " + miningGear);
        System.out.println("Power Plant: " + powerPlant);
        System.out.println("");
        map.displayOres();
    }

    public Component getMiningGear() {
        return miningGear;
    }

    public Component getWeapon() {
        return weapon;
    }

    public Component getPowerPlant() {
        return powerPlant;
    }

    public Component getArmour() {
        return armour;
    }
}
