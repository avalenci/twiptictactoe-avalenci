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
        if (rand == 1)
            return "02";
        if (rand == 2)
            return "11";
        if (rand == 3)
            return "20";
        else
            return "22";
    }
    static String secondMove(char a[][]) {

    }
}
