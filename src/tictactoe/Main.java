package tictactoe;
import java.util.Scanner;

public class Main {

    public static final Scanner SCANNER = new Scanner(System.in);
    public static final char[] SYMBOL = {' ', 'O', 'X'};
    public static final String[] STATE = {"Game not finished", "Draw", "X wins", "O wins", "Impossible"};

    public static void main(String[] args) {
        int stateId;
        int player = 1;
        int[][] grid = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        System.out.println(getGrid(grid));
        do {
            player = player == 1 ? 2 : 1;
            while (!makeMove(grid, player));
            System.out.println(getGrid(grid));
            stateId = getState(grid);
        } while (1 > stateId);
        System.out.println(STATE[stateId]);
    }

    // Reads a string, checks usability, converts it to coordinates and writes a symbol into the grid
    public static boolean makeMove(int[][] grid, int symbId) {
        System.out.print("Enter the coordinates: ");
        String input = SCANNER.nextLine().trim();
        if(!input.matches("^[0-9]+\\s*[\\s,]\\s*[0-9]+$")) {
            System.out.println("You should enter numbers!");
            return false;
        }
        String[] numbers = input.split("\\s*[\\s,]\\s*");
        int row = Integer.parseInt(numbers[0].trim()) - 1;
        int col = Integer.parseInt(numbers[1].trim()) - 1;
        if(row < 0 || row > 2 || col < 0 || col > 2) {
            System.out.println("Coordinates should be from 1 to 3!");
            return false;
        }
        if(grid[row][col] != 0) {
            System.out.println("This cell is occupied! Choose another one!");
            return false;
        }
        grid[row][col] = symbId;
        return true;
    }

    // Returns a printable grid
    public static String getGrid(int[][] grid) {
        StringBuilder bString = new StringBuilder("---------\n");
        for(int[] cells : grid) {
            bString.append(String.format("| %c %c %c |%n", SYMBOL[cells[0]], SYMBOL[cells[1]], SYMBOL[cells[2]]));
        }
        return bString.append("---------").toString();
    }

    // Returns the current state of the grid
    public static int getState(int[][] grid) {
        int xTotal = 0;
        int oTotal = 0;
        boolean xWins = false;
        boolean oWins = false;
        int xh, xv, xd1, xd2, oh, ov, od1, od2;
        xd1 = xd2 = od1 = od2 = 0;
        for(int a= 0; a < 3; a++) {
            xTotal += xh = grid[a][0] / 2 + grid[a][1] / 2 + grid[a][2] / 2;
            xv = grid[0][a] / 2 + grid[1][a] / 2 + grid[2][a] / 2;
            xd1 += grid[a][a] / 2;
            xd2 += grid[a][2 - a] / 2;
            oTotal += oh = grid[a][0] % 2 + grid[a][1] % 2 + grid[a][2] % 2;
            ov = grid[0][a] % 2 + grid[1][a] % 2 + grid[2][a] % 2;
            od1 += grid[a][a] % 2;
            od2 += grid[a][2 - a] % 2;
            xWins |= xh == 3 || xv == 3 || xd1 == 3 || xd2 == 3;
            oWins |= oh == 3 || ov == 3 || od1 == 3 || od2 == 3;
        }
        return Math.abs(xTotal - oTotal) > 1 || xWins && oWins ? 4 : oWins ? 3 : xWins ? 2 : xTotal + oTotal == 9 ? 1 : 0;
    }
}