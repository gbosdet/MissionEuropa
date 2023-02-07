package com.company;

import java.util.Arrays;

public class Component {
    private String name;
    private int power;
    private int[] cost;

    public Component(String name, int power, int[] cost) {
        this.name = name;
        this.power = power;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public int getPower() {
        return power;
    }

    public int[] getCost() {
        return cost;
    }

    @Override
    public String toString() {
        String result =  name  +
                ", Power:" + power +
                ", Cost: ";
        for(int i = 1; i < cost.length; i++){
            result += cost[i] + " ";
        }
        return result;
    }
}
