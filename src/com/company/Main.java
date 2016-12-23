package com.company;

import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String grid = " 1 | 2 | 3 \n---+---+---\n 4 | 5 | 6 \n---+---+---\n 7 | 8 | 9 ";
        char numb[][] = {{'1', '2', '3'},
                         {'4', '5', '6'},
                         {'7', '8', '9'}};
        int turns = 0;
        int xCoord = 0, yCoord = 0;
        while (true) {
            System.out.println("Type \"Next\" to keep the game going.");
            String player = AI.firstPlayer();
            while (true) {
                if (player.equalsIgnoreCase("X"))
                    player = "O";
                else
                    player = "X";
                if (turns == 0) {
                    String c = AI.firstMove();
                    String x = (c.substring(0, 1));
                    String y = (c.substring(1));
                    xCoord = Integer.parseInt(x);
                    yCoord = Integer.parseInt(y);
                }
                else if (turns == 1) {
                    String c = AI.secondMove(xCoord, yCoord);
                    String x = (c.substring(0, 1));
                    String y = (c.substring(1));
                    xCoord = Integer.parseInt(x);
                    yCoord = Integer.parseInt(y);
                }
                else if (turns == 2) {
                    String c = AI.thirdMove(numb);
                    String x = (c.substring(0, 1));
                    String y = (c.substring(1));
                    xCoord = Integer.parseInt(x);
                    yCoord = Integer.parseInt(y);
                }
                if (!((input.nextLine()).equalsIgnoreCase("Next")))
                    continue;
                while (player.equalsIgnoreCase("X")) {
                    if (turns == 0) {
                        grid = grid.replace(numb[xCoord][yCoord], 'X');
                        numb[xCoord][yCoord] = 'X';
                    }
                    else if (turns == 1) {
                        grid = grid.replace(numb[xCoord][yCoord], 'X');
                        numb[xCoord][yCoord] = 'X';
                    }
                    else if (turns == 2) {
                        grid = grid.replace(numb[xCoord][yCoord], 'X');
                        numb[xCoord][yCoord] = 'X';
                    }
                    break;
                }
                while (player.equalsIgnoreCase("O")) {
                    if (turns == 0) {
                        grid = grid.replace(numb[xCoord][yCoord], 'O');
                        numb[xCoord][yCoord] = 'O';
                    }
                    else if (turns == 1) {
                        grid = grid.replace(numb[xCoord][yCoord], 'O');
                        numb[xCoord][yCoord] = 'O';
                    }
                    else if (turns == 2) {
                        grid = grid.replace(numb[xCoord][yCoord], 'O');
                        numb[xCoord][yCoord] = 'O';
                    }
                    break;
                }
                System.out.println(Clear.deleteNumbers(grid));
                turns++;
            }
        }
    }
}
