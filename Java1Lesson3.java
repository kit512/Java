/**
 * Java 1. HomeWork 3
 *
 * @author Balabkin Kirill
 * @version dated 20.01.2019
 */
import java.util.Scanner;

public class Java1Lesson3 {
    public static Scanner scanner = new Scanner(System.in);
    public static String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
            "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
            "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

    public static void main(String[] args) {

        game1();
        game2();
		
    }
	
    public static void game1() {
        do {
            System.out.println("Угадай число от 0 до 9. У тебя 3 попытки.");
            int randomNumber = (int) (Math.random() * 10);

            for (int i = 0; i < 3; i++) {
                int a = scanner.nextInt();
                if (a == randomNumber) {
                    System.out.println("Ты угадал!");
                    break;
                } else if (a > randomNumber) {
                    System.out.println("Загаданное число меньше.");
                } else System.out.println("Загаданное число больше.");
            }

            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет.");
        }while (scanner.nextInt() == 1);
    }

    public static void game2() {
        int numberWord = (int)(Math.random() * words.length);
        System.out.println("Угадай слово.");
        String zag = words[numberWord];
        for (;;){
            String word = scanner.nextLine();
            if (word.equals(zag)) {
                System.out.println("Ты угадал!");
                break;
            } else {
                //решение ошибки сравнения разных по длине слов
                int min = word.length();
                if (word.length()>zag.length()) min = zag.length();
                for (int i = 0; i < min; i++){
                    if(word.charAt(i)==zag.charAt(i)) System.out.print(zag.charAt(i));
                    else System.out.print("#");
                }
                //заполнение оставшегося места "#"
                for (int i = min; i < 15; i++){
                    System.out.print("#");
                }
                System.out.println();
            }
        }

    }

}


