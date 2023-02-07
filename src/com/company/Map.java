package com.company;

public class Map {
    private Room[][] layout;
    private int[] location;


    public Map(){
        constructMap();
        location = new int[]{0, 2};
    }
    private void constructMap(){
        boolean[][][] option = poss();
        //0 - closed
        //1 - open right
        //2 - open left
        //3 - open right and left
        //4 - open down
        //5 - open down and right
        //6 - open down and left
        //7 - open down, left, and right
        //8 - open up
        //9 - open up and right
        //10 - open up and left
        //11 - open up, right and left
        //12 - open up and down
        //13 - open up, down and right
        //14 - open up, down and left
        //16 - open up, down, left, and right
        layout = new Room[6][5];
        Room blocked = new Room(0, 0, option[0]);
        layout[0][0] = blocked;
        layout[0][1] = blocked;
        layout[0][2] = new Room(0, 0, option[4]);
        layout[0][3] = blocked;
        layout[0][4] = blocked;

        layout[1][0] = new Room(2, 2, option[1]);
        layout[1][1] = new Room(1, 1, option[3]);
        layout[1][2] = new Room(1, 1, option[15]);
        layout[1][3] = new Room(1, 1, option[3]);
        layout[1][4] = new Room(2, 3, option[2]);

        layout[2][0] = blocked;
        layout[2][1] = blocked;
        layout[2][2] = new Room(1, 1, option[12]);
        layout[2][3] = blocked;
        layout[2][4] = blocked;

        layout[3][0] = new Room(5, 6, option[4]);
        layout[3][1] = blocked;
        layout[3][2] = new Room(2, 3, option[13]);
        layout[3][3] = new Room(2, 3, option[3]);
        layout[3][4] = new Room(3, 4, option[6]);

        layout[4][0] = new Room(4, 4, option[12]);
        layout[4][1] = blocked;
        layout[4][2] = new Room(2, 3, option[12]);
        layout[4][3] = blocked;
        layout[4][4] = new Room(3, 4, option[12]);

        layout[5][0] = new Room(4, 4, option[9]);
        layout[5][1] = new Room(3, 4, option[3]);
        layout[5][2] = new Room(3, 4, option[10]);
        layout[5][3] = blocked;
        layout[5][4] = new Room(5, 5, option[8]);
        layout[0][2].setFound();
    }

    public Room getCurrentRoom(){
        return layout[location[0]][location[1]];
    }

    private boolean[][][] poss(){
        boolean[][][] result = new boolean[16][][];
        for(int i = 0; i< 16; i++) {
            result[i] = new boolean[][]{{(i >> 3) % 2 == 1, (i >> 2) % 2 == 1}, {(i >> 1) % 2 == 1, i % 2 == 1}};
        }
         return result;

    }

    public void displayMap(){
        for(int i = 0; i <layout[0].length*2+1; i++){
            System.out.print("_");
        }
        System.out.println();
        for(int row = 0; row < layout.length; row++){
            System.out.print("|");
            for(int col = 0; col < layout[row].length; col++){
                Room room = layout[row][col];
                if(room.getFound()){
                    if(location[0] == row && location[1] == col){
                        System.out.print("*");
                    }
                    else if(!room.getOpenings()[0][1]){
                        System.out.print("_");
                    }
                    else{
                        System.out.print(" ");
                    }
                    if(room.getOpenings()[1][1]){
                        System.out.print("=");
                    }
                    else{
                        System.out.print("|");
                    }
                }
                else{

                    if(row+1 < layout.length && layout[row+1][col].getFound()){

                        if(!room.getOpenings()[0][1]) {
                            System.out.print("_");
                        }
                        else{
                            System.out.print(" ");
                        }
                    }
                    else{
                        System.out.print(" ");
                    }
                    if(col+1 < layout[row].length && layout[row][col+1].getFound()){
                        if(!room.getOpenings()[1][1]) {
                            System.out.print("|");
                        }
                        else{
                            System.out.print("=");
                        }
                    }
                    else{
                        System.out.print(" ");

                    }
                }
            }
            System.out.println();

        }
    }

    public void move(char c) {
        Room current = getCurrentRoom();
        switch(c){
            case 'W':
                if(current.getOpenings()[0][0]){
                    location[0]--;
                }
                break;
            case 'S':
                if(current.getOpenings()[0][1]){
                    location[0]++;
                }
                break;
            case 'A':
                if(current.getOpenings()[1][0]){
                    location[1]--;
                }
                break;
            case 'D':
                if(current.getOpenings()[1][1]){
                    location[1]++;
                }
                break;
        }
        getCurrentRoom().setFound();
    }
}
