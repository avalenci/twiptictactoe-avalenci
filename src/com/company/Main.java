package com.company;

import java.util.Arrays;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean boole = true;
        String player, Computer, firstPlayer;
        String grid = " 1 | 2 | 3 \n---+---+---\n 4 | 5 | 6 \n---+---+---\n 7 | 8 | 9 ";
        char numb[][] = {{'1', '2', '3'},
                         {'4', '5', '6'},
                         {'7', '8', '9'}};
        int xCoord = 0, yCoord = 0;
        int turns = 0;
        while (boole) {
            System.out.println("Would you like to be X or O?");
            while (boole) {
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
                while (boole) {
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
                    while (boole) {
                        while (firstPlayer.equals(player) && boole) {
                            System.out.println(AI.deleteNumbers(grid));
                            if (!(turns > 1)) {
                                System.out.println("Type the two numbers that correspond" +
                                        " with the coordinates of your move.");
                                input.nextLine();
                            }
                            while (boole) {
                                a = input.nextLine();
                                a = a.replaceAll(" ", "");
                                String a0 = a.substring(0, 1);
                                String a1 = a.substring(1);
                                if ((!(a0.equals("0")) && !(a0.equals("1")) && !(a0.equals("2")))
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
                            System.out.println(AI.deleteNumbers(grid + "\n"));
                            turns++;
                            firstPlayer = Computer;
                        }
                        while (firstPlayer.equals(Computer) && boole) {
                            while (turns == 0) {
                                int rand = (int) (Math.random() * 5);
                                if (rand == 0) {
                                    xCoord = 0;
                                    yCoord = 0;
                                }
                                else if (rand == 1) {
                                    xCoord = 0;
                                    yCoord = 2;
                                }
                                else if (rand == 2) {
                                    xCoord = 1;
                                    yCoord = 1;
                                }
                                else if (rand == 3) {
                                    xCoord = 2;
                                    yCoord = 0;
                                }
                                else {
                                    xCoord = 2;
                                    yCoord = 2;
                                }
                                break;
                            }
                            while (turns == 1) {
                                if (xCoord == 1 && yCoord == 1) {
                                    int rand = (int)(Math.random() * 4);
                                    if (rand == 0) {
                                        xCoord = 0;
                                        yCoord = 0;
                                    }
                                    else if (rand == 1) {
                                        xCoord = 0;
                                        yCoord = 2;
                                    }
                                    else if (rand == 2) {
                                        xCoord = 2;
                                        yCoord = 0;
                                    }
                                    else {
                                        xCoord = 2;
                                        yCoord = 2;
                                    }
                                }
                                else if (xCoord != 1 && yCoord != 1) {
                                    xCoord = 1;
                                    yCoord = 1;
                                }
                                else if (xCoord + 1 > 2 || xCoord - 1 < 0)
                                    yCoord = yCoord + 1;
                                else
                                    xCoord = xCoord + 1;
                                break;
                            }
                            if (turns > 1) {
                                int countx = 0;
                                int county = 0;
                                int counte = 0;
                                int countp = 0;
                                while (countx < 3) {
                                    while (county < 3) {
                                        if (numb[countx][county] == player.charAt(0)) {
                                            countp++;
                                        }
                                        else if (numb[countx][county] == Computer.charAt(0)) {
                                            counte++;
                                        }
                                        if (countp == 3) {
                                            System.out.println(AI.deleteNumbers(grid));
                                            System.out.println("You win!");
                                            boole = false;
                                        }
                                        county++;
                                        if (county == 3 && counte == 2 && countp == 0) {
                                            Arrays.fill(numb[countx], Computer.charAt(0));
                                        }
                                    }
                                    counte = 0;
                                    countp = 0;
                                    county = 0;
                                    countx++;
                                }
                                countx = 0;
                                while (county < 3) {
                                    while (countx < 3) {
                                        if (numb[countx][county] == player.charAt(0)) {
                                            countp++;
                                        }
                                        else if (numb[countx][county] == Computer.charAt(0)) {
                                            counte++;
                                        }
                                        if (countp == 3) {
                                            System.out.println(AI.deleteNumbers(grid));
                                            System.out.println("You win!");
                                            boole = false;
                                        }
                                        countx++;
                                        if (countx == 3 && counte == 2 && countp == 0) {
                                            Arrays.fill(numb[county], Computer.charAt(0));
                                        }
                                    }
                                    counte = 0;
                                    countp = 0;
                                    countx = 0;
                                    county++;
                                }
                                while (numb[xCoord][yCoord] == 'X' || numb[xCoord][yCoord] == 'O') {
                                    xCoord = (int)(Math.random() * 3);
                                    yCoord = (int)(Math.random() * 3);
                                }
                            }
                            char replace = numb[xCoord][yCoord];
                            numb[xCoord][yCoord] = Computer.charAt(0);
                            grid = grid.replace(replace, Computer.charAt(0));
                            if (turns > 1) {
                                int countx = 0;
                                int county = 0;
                                int counte = 0;
                                int countp = 0;
                                while (countx < 3) {
                                    while (county < 3) {
                                        if (numb[countx][county] == Computer.charAt(0)) {
                                            counte++;
                                        }
                                        if (counte == 3) {
                                            System.out.println(AI.deleteNumbers(grid));
                                            System.out.println("You loose!");
                                            boole = false;
                                        }
                                        county++;
                                    }
                                    county = 0;
                                    counte = 0;
                                    countx++;
                                }
                                countx = 0;
                                while (county < 3) {
                                    while (countx < 3) {
                                        if (numb[countx][county] == Computer.charAt(0)) {
                                            counte++;
                                        }
                                        if (counte == 3) {
                                            System.out.println(AI.deleteNumbers(grid));
                                            System.out.println("You loose!");
                                            boole = false;
                                        }
                                        countx++;
                                    }
                                    countx = 0;
                                    counte = 0;
                                    county++;
                                }
                            }
                            turns++;
                            firstPlayer = player;
                        }
                    }
                }
            }
        }
    }
}
