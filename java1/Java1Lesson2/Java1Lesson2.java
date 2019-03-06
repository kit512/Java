package geekbrains.Java1Lesson2;
/**
 * Java 1. HomeWork 2
 *
 * @author Balabkin Kirill
 * @version dated 16.01.2019
 */

import java.util.Arrays;

public class Java1Lesson2 {

    public static void main(String[] args) {
        int [] arr6 = {1, 1, 1, 1, 1, 1, 1, 7};
        int [] arr7 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int n = -5;

        refresh();
        add();
        multiply();
        fillTheDiagonal();
        getMinAndMax();

        System.out.println("№6");
        System.out.println(checkBalance(arr6));
        System.out.println("№7");
        System.out.println(Arrays.toString(shift(arr7,n)));
    }

    public static void refresh () {
        int [] arr = {0, 1, 0, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 0};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) arr[i] = 1;
            else arr[i] = 0;
        }
        System.out.println("№1");
        System.out.println(Arrays.toString(arr));
    }

    public static void add (){
        int [] arr = new int [8];
        for (int i = 0; i< arr.length; i++) {
            arr[i] = i * 3;
        }
        System.out.println("№2");
        System.out.println(Arrays.toString(arr));
    }

    public static void multiply () {
        int [] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i<arr.length; i++) {
            if (arr[i] < 6) arr[i] *= 2;
        }
        System.out.println("№3");
        System.out.println(Arrays.toString(arr));
    }

    public static void fillTheDiagonal () {
        int [][] arr = new int [5][5];
        System.out.println("№4");
        for (int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr.length; j++) {
                if (i == j | i + j == arr.length - 1) arr[i][j] = 1;
                System.out.print(arr[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public static  void getMinAndMax () {
        int [] arr = {5, 9, 156, -1516, 4156,994};
        int min = arr[0];
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) min = arr[i];
            if (max < arr[i]) max = arr[i];
        }
        System.out.println("№5");
        System.out.println(min + " " + max);
    }

    public static boolean checkBalance(int [] a) {
        int sum = 0;
        int x = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }   //поиск суммы
        if (sum % 2 == 0){
            for (int i = 0; x < sum/2; i++){
                x += a[i];
                if (x == sum/2) return true;
            }
        }
        return false;
    }

    public static int [] shift (int [] a, int b) {
        int shiftArr [] = new int [a.length];
        for (int i = 0; i < a.length; i++){
            if (b + i < 0) shiftArr[a.length + b + i] = a[i];
            else if(b + i < a.length) shiftArr[i + b] = a[i];
            else shiftArr[i + b - a.length] = a[i];
        }
        return shiftArr;
    }

 }
