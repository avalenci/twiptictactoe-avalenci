package com.company;

public class AI {
    public static String firstPlayer() {
        int rand = (int) (Math.random() * 2);
        if (rand == 0)
            return "O";
        else
            return "X";
    }
    public static String deleteNumbers(String a) {
        for (int x = 1; x < 10; x++) {
            String y = Integer.toString(x);
            char z = y.charAt(0);
            a = a.replace(z, ' ');
        }
        return a;
    }
}
