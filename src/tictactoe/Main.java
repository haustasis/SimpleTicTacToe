package tictactoe;

import java.util.Scanner;

public class Main {
    public static void printField(char[][] field) {
        System.out.println("---------");
        for (int i = 0; i < 3; ++i) {
            System.out.print("| ");
            for (int j = 0; j < 3; ++j) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter cells: ");
        String x = s.next();
        char[][] field = new char[3][3];
        int num_x = 0, num_o = 0;
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                field[i][j] = x.charAt(i * 3 + j);
                if (field[i][j] == 'X') num_x++;
                if (field[i][j] == 'O') num_o++;
            }
        }
        printField(field);
        while (true) {
            System.out.println("Enter the coordinates: ");
            int x1, x2;
            try {
                x1 = s.nextInt();
                x2 = s.nextInt();
                if (x1 < 1 || x1 > 3 || x2 < 1 || x2 > 3) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else {
                    if (field[x1 - 1][x2 - 1] != '_') {
                        System.out.println("This cell is occupied! Choose another one!");
                    } else {
                        field[x1 - 1][x2 - 1] = 'X';
                        break;
                    }
                }
            } catch(Exception e) {
                System.out.println("You should enter numbers!");
            }
        }
        printField(field);
    }
}
