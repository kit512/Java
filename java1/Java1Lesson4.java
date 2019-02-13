/**
 * Java 1. HomeWork 4
 *
 * @author Balabkin Kirill
 * @version dated 24.01.2019
 */
import java.util.Random;
import java.util.Scanner;

public class Java1Lesson4 {

    final int SIZE = 3;
    final char DOT_X = 'X';
    final char DOT_O = 'O';
    final char DOT_EMPTY = '.';
    char [][] map;
    Random random;
    Scanner scanner;

    public static void main(String[] args) {
        new Java1Lesson4().game();
    }

    void game() {
        initMap();
        random = new Random();
        scanner = new Scanner(System.in);
        while (true) {
            printMap();
            humanTurn();
            if (checkWin(DOT_X)) {
                System.out.println("YOU WON!");
                break;
            }
            if (isMapFull()){
                System.out.println("DRAW");
                break;
            }
            printMap();
            aiTurn();
            if (checkWin(DOT_O)) {
                System.out.println("AI WON!");
                break;
            }
            if (isMapFull()){
                System.out.println("DRAW");
                break;
            }
        }
        printMap();
        System.out.println("GAME OVER");
    }

    void printMap(){
        for (int i = 0; i < SIZE;i++) {
            for (int j = 0; j < SIZE; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    void initMap() {
        map = new char [SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++){
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    void humanTurn(){
        int x, y;
        System.out.println("");
        do {
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCellValid(x, y));
        map [y][x] = DOT_X;
    }

    boolean isCellValid( int x, int y){
        if (x < 0 || y < 0 || x >= SIZE || y >= SIZE)
            return false;
        return map[y][x] == DOT_EMPTY;
    }

    void aiTurn(){
        int x, y;
        do {
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
        } while (!isCellValid(x, y));
        System.out.println("");
        map [y][x] = DOT_O;
    }

    boolean checkWin(char symb){
        for (int i = 0; i < SIZE; i++) {
            if (map[i][0] == symb && map[i][1] == symb && map[i][2] == symb) return true;
            if (map[0][i] == symb && map[1][i] == symb && map[2][i] == symb) return true;
        }
        if (map[0][0] == symb && map[1][1] == symb && map[2][2] == symb) return true;
        if (map[0][2] == symb && map[1][1] == symb && map[2][0] == symb) return true;
        return false;
    }

    boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++){
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

}
