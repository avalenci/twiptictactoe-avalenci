package com.company;

import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String player, Computer, firstPlayer;
        String grid = " 1 | 2 | 3 \n---+---+---\n 4 | 5 | 6 \n---+---+---\n 7 | 8 | 9 ";
        char numb[][] = {{'1', '2', '3'},
                         {'4', '5', '6'},
                         {'7', '8', '9'}};
        int xCoord = 0, yCoord = 0;
        int turns = 0;
        while (true) {
            System.out.println("Would you like to be X or O?");
            while (true) {
                String a = input.next();
                if (a.equalsIgnoreCase("X")) {
                    player = "X";
                    Computer = "O";
                }
                else if (a.equalsIgnoreCase("O")) {
                    player = "O";
                    Computer = "X";
                }
                else {
                    System.out.println("Try Again.");
                    continue;
                }
                System.out.println("Who will go first?\nA. You\nB. Computer\nC. Random");
                while (true) {
                    a = input.next();
                    if (a.equalsIgnoreCase("A"))
                        firstPlayer = player;
                    else if (a.equalsIgnoreCase("B"))
                        firstPlayer = Computer;
                    else if (a.equalsIgnoreCase("C")) {
                        firstPlayer = AI.firstPlayer();
                        System.out.println("The first player is " + firstPlayer + ".");
                    } else {
                        System.out.println("Try Again.");
                        continue;
                    }
                    while (true) {
                        while (firstPlayer.equals(player)) {
                            System.out.println(AI.deleteNumbers(grid));
                            System.out.println("Type the two numbers that correspond with the coordinates of your move.");
                            while (true) {
                                input.nextLine();
                                a = input.nextLine();
                                a = a.replaceAll(" ", "");
                                String a0 = a.substring(0, 1);
                                String a1 = a.substring(1);
                                if ((!(a0.equals("0") && !(a0.equals("1")) && !(a0.equals("2"))))
                                        || (!(a1.equals("0")) && !(a1.equals("1")) && !(a1.equals("2")))) {
                                    System.out.println("Please use valid coordinates only.\nTry Again.");
                                    continue;
                                }
                                xCoord = Integer.parseInt(a0);
                                yCoord = Integer.parseInt(a1);
                                if (numb[xCoord][yCoord] == 'X' || numb[xCoord][yCoord] == 'O') {
                                    System.out.println("That spot is already taken!\nTry Again.");
                                    continue;
                                }
                                else {
                                    char replace = numb[xCoord][yCoord];
                                    numb[xCoord][yCoord] = player.charAt(0);
                                    grid = grid.replace(replace, player.charAt(0));
                                    break;
                                }
                            }
                            turns++;
                            firstPlayer = Computer;
                        }
                        while (firstPlayer.equals(Computer)) {
                            while (turns == 0) {
                            }
                            while (turns == 1) {
                            }
                            while (turns > 1) {
                            }
                        }
                    }
                }
            }
        }
    }
}
