package com.company;

class AI {
    AI(int x, int y) {
        xCoord = x;
        yCoord = y;
    }
    static String firstPlayer() {
        int rand = (int) (Math.random() * 2);
        if (rand == 0)
            return "O";
        else
            return "X";
    }
    static String deleteNumbers(String a) {
        for (int x = 1; x < 10; x++) {
            String y = Integer.toString(x);
            char z = y.charAt(0);
            a = a.replace(z, ' ');
        }
        return a;
    }
    public int xCoord, yCoord;
}
