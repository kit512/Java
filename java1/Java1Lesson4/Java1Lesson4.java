package geekbrains.Java1Lesson;

import java.util.Random;
import java.util.Scanner;

public class Java1Lesson4 {

    public static Scanner sc = new Scanner(System.in);
    public static char[][] map;
    public static final int SIZE_GAME = 5;
    public static final int DOTS_TO_WIN = 4;
    public static final char DOT_EMPRY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static Random random = new Random();
    public static int [] arr = new int [2];

    public static void main(String[] args) {
        initMap();
        drawGameMap();

        while (true){
            humanTurn();
            drawGameMap();
            if (checkWin(DOT_X)){
                System.out.println("Человек победил.");
            break;}
            if (mapIsFull()){
                System.out.println("Ничья.");
                break;
            }
            aiTurn();
            drawGameMap();
            if (checkWin(DOT_O)){
                System.out.println("Копрьютер победиль.");
            break;}
            if (mapIsFull()){
                System.out.println("Ничья.");
                break;
            }

        }
        System.out.println("Игра закончена.");

    }

    public static void initMap(){
        map = new char[SIZE_GAME][SIZE_GAME];
        for (int i = 0; i < SIZE_GAME; i++){
            for (int j = 0; j < SIZE_GAME; j++){
                map[i][j] = DOT_EMPRY;
            }
        }
    }

    public static void drawGameMap (){
        for (int i = 0; i <= SIZE_GAME; i++){
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE_GAME; i++){
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE_GAME; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void humanTurn(){
        int x, y;
        do {
            System.out.println("Введите коордианаты x и y.");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        }while (!isCellValid(x, y));
        map[x][y] = DOT_X;
    }

    public static boolean isCellValid(int x, int y){
        if (x < 0 || x >= SIZE_GAME || y < 0 || y >= SIZE_GAME) return false;
        if (map[x][y] == DOT_EMPRY) return true;
        return false;
    }

    public static void aiTurn(){
        int x, y;
        do {
            x = random.nextInt(SIZE_GAME);
            y = random.nextInt(SIZE_GAME);
            if (aiCheckHumanWin() == true){
                x = arr[0];
                y = arr[1];
            }
        }while (!isCellValid(x, y));
        System.out.println("Компьютер походил в точку " + x +" " + y);
        map[x][y] = DOT_O;
    }
//    public static boolean checkWin (char symb){
//        if (map[0][0] == symb && map[0][1] == symb && map[0][2] == symb) return true;
//        if (map[1][0] == symb && map[1][1] == symb && map[1][2] == symb) return true;
//        if (map[2][0] == symb && map[2][1] == symb && map[2][2] == symb) return true;
//        if (map[0][0] == symb && map[1][0] == symb && map[2][0] == symb) return true;
//        if (map[0][1] == symb && map[1][1] == symb && map[2][1] == symb) return true;
//        if (map[0][2] == symb && map[1][2] == symb && map[2][2] == symb) return true;
//        if (map[0][0] == symb && map[1][1] == symb && map[2][2] == symb) return true;
//        if (map[0][2] == symb && map[1][1] == symb && map[2][0] == symb) return true;
//        return false;
//    }

    public static boolean checkWin (char symb){
        for (int i = 0; i < SIZE_GAME; i++){
            for (int j = 0; j < SIZE_GAME; j++){
                if (j < SIZE_GAME - DOTS_TO_WIN){                                               // check hor all line
                    if (map[i][j] == symb && map[i][j+1] == symb && map[i][j+2] == symb && map[i][j+3] == symb ) return true;
                }
                if (i < SIZE_GAME - DOTS_TO_WIN){                                              //check ver  all line
                    if (map[i][j] == symb && map[i+1][j] == symb && map[i+2][j] == symb  && map[i+3][j] == symb) return true;
                }
                if (i < SIZE_GAME - DOTS_TO_WIN && j < SIZE_GAME - DOTS_TO_WIN) {                //check all diag \
                    if (map[i][j] == symb && map[i + 1][j + 1] == symb && map[i + 2][j + 2] == symb && map[i + 3][j + 3] == symb) return true;
                }
                if (i > SIZE_GAME - DOTS_TO_WIN && j < SIZE_GAME - DOTS_TO_WIN){                 //check all diag /
                    if (map[i][j] == symb && map[i-1][j+1] == symb && map[i-2][j+2] == symb && map[i-3][j+3] == symb) return true;
              }
            }
        }
        return false;
    }

    public static boolean mapIsFull(){
        for (int i = 0; i < SIZE_GAME; i++){
            for (int j = 0; j < SIZE_GAME; j++){
                if (map[i][j] == DOT_EMPRY) return false;
            }
        }
        return true;
    }

    public static boolean aiCheckHumanWin(){
        for (int i = 0; i < SIZE_GAME; i++){
            for (int j = 0; j < SIZE_GAME; j++){
                if (j < SIZE_GAME - DOTS_TO_WIN + 1){                                               // check hor all line
                    if (map[i][j] == DOT_X && map[i][j+1] == DOT_X && map[i][j+2] == DOT_EMPRY){
                        arr[0] = i;
                        arr[1] = j+2;
                        return true;
                    }
                }
                if (j > SIZE_GAME - DOTS_TO_WIN){                                               // check hor all line
                    if (map[i][j] == DOT_X && map[i][j-1] == DOT_X && map[i][j-2] == DOT_EMPRY){
                        arr[0] = i;
                        arr[1] = j-2;
                        return true;
                    }
                }
                if (i < SIZE_GAME - DOTS_TO_WIN + 1){                                              //check ver  all line
                    if (map[i][j] == DOT_X && map[i+1][j] == DOT_X && map[i+2][j] == DOT_EMPRY ) {
                        arr[0] = i+2;
                        arr[1] = j;
                        return true;
                    }
                }
                if (i > SIZE_GAME - DOTS_TO_WIN ){                                              //check ver  all line
                    if (map[i][j] == DOT_X && map[i-1][j] == DOT_X && map[i-2][j] == DOT_EMPRY ) {
                        arr[0] = i-2;
                        arr[1] = j;
                        return true;
                    }
                }
                if (i < SIZE_GAME - DOTS_TO_WIN +1 && j < SIZE_GAME - DOTS_TO_WIN + 1) {                //check all diag \
                    if (map[i][j] == DOT_X && map[i + 1][j + 1] == DOT_X && map[i + 2][j + 2] == DOT_EMPRY ) {
                        arr[0] = i + 2;
                        arr[1] = j + 2;
                        return true;
                    }
                }
                if (i > SIZE_GAME - DOTS_TO_WIN && j > SIZE_GAME - DOTS_TO_WIN ) {                //check all diag \
                    if (map[i][j] == DOT_X && map[i - 1][j - 1] == DOT_X && map[i - 2][j - 2] == DOT_EMPRY ) {
                        arr[0] = i + 2;
                        arr[1] = j + 2;
                        return true;
                    }
                }
                if (i > SIZE_GAME - DOTS_TO_WIN && j < SIZE_GAME - DOTS_TO_WIN + 1){                 //check all diag /
                    if (map[i][j] == DOT_X && map[i-1][j+1] == DOT_X && map[i-2][j+2] == DOT_EMPRY ) {
                        arr[0] = i - 2;
                        arr[1] = j + 2;
                        return true;
                    }
                }
                if (i < SIZE_GAME - DOTS_TO_WIN + 1 && j > SIZE_GAME - DOTS_TO_WIN ){                 //check all diag /
                    if (map[i][j] == DOT_X && map[i+1][j-1] == DOT_X && map[i+2][j-2] == DOT_EMPRY ) {
                        arr[0] = i + 2;
                        arr[1] = j - 2;
                        return true;
                    }
                }
            }
        }
        return false;

    }
}
