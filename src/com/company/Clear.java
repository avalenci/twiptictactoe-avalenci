package com.company;

public class Clear {
    public static String deleteNumbers(String a) {
        for (int x = 1; x < 10; x++) {
            String y = Integer.toString(x);
            char z = y.charAt(0);
            a = a.replace(z, ' ');
        }
        return a;
    }
}
