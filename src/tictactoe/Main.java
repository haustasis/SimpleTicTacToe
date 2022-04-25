package tictactoe;

public class Main {
    public static void main(String[] args) {
        Field.getInstance().fillRandom();
        System.out.println(Field.getInstance().toString());
    }


}
