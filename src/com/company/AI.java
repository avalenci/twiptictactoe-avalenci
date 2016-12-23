package com.company;

public class AI {
    static String firstPlayer() {
        int rand = (int) (Math.random() * 2);
        if (rand == 0)
            return "O";
        else
            return "X";
    }
    static String firstMove() {
        int rand = (int) (Math.random() * 5);
        if (rand == 0)
            return "00";
        else if (rand == 1)
            return "02";
        else if (rand == 2)
            return "11";
        else if (rand == 3)
            return "20";
        else
            return "22";
    }
    static String secondMove(int x, int y) {
        if (x == 1 && y == 1) {
            int z = (int) (Math.random() * 4);
            if (z == 0)
                return "00";
            else if (z == 1)
                return "02";
            else if (z == 2)
                return "20";
            else
                return "22";
        }
        else
            return "11";
    }
    static String thirdMove(char a[][]) {
        String t;
        while (true) {
            int x = (int) (Math.random() * 3);
            int y = (int) (Math.random() * 3);
            String z = "" + a[x][y];
            if (!(z.equals("X") || z.equals("O"))) {
                t = Integer.toString(x) + Integer.toString(y);
                break;
            }
        }
        return t;
    }
    static String nextMove(char a[][], String player) {
        String enemy;
        if (player.equalsIgnoreCase("X"))
            enemy = "O";
        else
            enemy = "X";

        return "00";
    }
}
