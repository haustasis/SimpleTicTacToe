package tictactoe;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        init();
        String userStr = userInput();
        displayBoard(userStr);
    }

    private static void init() {
        System.out.print("Enter cells: ");
    }

    private static String userInput() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }



    private static void displayBoard(String s) {
        System.out.println("---------");
        System.out.printf("| %s %s %s |%n", s.charAt(0), s.charAt(1), s.charAt(2));
        System.out.printf("| %s %s %s |%n", s.charAt(3), s.charAt(4), s.charAt(5));
        System.out.printf("| %s %s %s |%n", s.charAt(6), s.charAt(7), s.charAt(8));
        System.out.println("---------");
    }



}
