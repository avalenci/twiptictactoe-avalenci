package com.company;

public class Main {

    public static void main(String[] args) {
        String grid = " 1 | 2 | 3 \n---+---+---\n 4 | 5 | 6 \n---+---+---\n 7 | 8 | 9 ";
        String numb[][] = {{"1", "2", "3"},
                           {"4", "5", "6"},
                           {"7", "8", "9"}};
        System.out.println(Clear.deleteNumbers(grid));
    }
}
