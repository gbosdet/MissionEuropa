package com.company;

import java.util.Scanner;

public class Main {

    static Scanner input;
    static Map map;
    static Submarine sub;
    public static void main(String[] args) {
	// write your code here
        input = new Scanner(System.in);
        map = new Map();
        sub = new Submarine();
        sub.displayStatus(map);
        while(true){
            map.displayMap();
            System.out.println("Enter your direction (W, A, S, D):");
            char c = getAllowedCharacter("WASD");
            map.move(c);
        }
    }



    public static int getNum(int min, int max){
        System.out.print("Enter a number: ");
        int num = Integer.MAX_VALUE;
        while(num < min || num > max) {
            while (!input.hasNextInt()) {
                System.out.println("That is not a number");
                input.nextLine();
            }
            num = input.nextInt();
            if(num < min || num > max) {
                System.out.println("That is not an allowed value");
            }
        }
        return num;

    }

    public static char getAllowedCharacter(String allowedChars){
        char result = input.next().toUpperCase().charAt(0);
        while (!allowedChars.contains(result + "")){
            System.out.println("That is not an option. Try again");
            result = input.next().charAt(0);
        }
        return result;
    }

}


