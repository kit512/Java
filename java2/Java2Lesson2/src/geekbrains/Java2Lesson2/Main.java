package geekbrains.Java2Lesson2;
/**
 * Java 2. HomeWork 1
 *
 * @author Balabkin Kirill
 * @version dated 17.02.2019
 */
public class Main {

    public static void main(String[] args) {

        //создаем 3 массива и объекта(2 из которых будут выдавать ошибки)
        String [][] wrongSizeMassive = new String [][] {
                {"1","2","3","4","5"},
                {"1","2","3","4","5"},
                {"1","2","3","4","5"},
                {"1","2","3","4","5"},
                {"1","2","3","4","5"}
        };

        String [][] wrongCharMassive = new String [][] {
                {"1","2","3","4"},
                {"1","2","3","4"},
                {"1","*","3","4"},
                {"1","2","3","4"},
        };

        String [][] goodMassive = new String [][] {
                {"1","2","3","4"},
                {"1","2","3","4"},
                {"1","2","3","4"},
                {"1","2","3","4"},
        };

        SumMassive sumMassive1 = new SumMassive(wrongSizeMassive);
        SumMassive sumMassive2 = new SumMassive(wrongCharMassive);
        SumMassive sumMassive3 = new SumMassive(goodMassive);

        //exception с пробрасываанием
        try {
            System.out.println("Сумма первого массива: " +
                    sumMassive1.sum(wrongSizeMassive));
        }catch (MyArraySizeException e) {
            e.printStackTrace();
            System.out.println("Wrong size");
        }

        try {
            System.out.println("Сумма второго массива: " +
                    sumMassive2.sum(wrongCharMassive));
        }catch (MyArraySizeException e) {
            e.printStackTrace();
            System.out.println("Wrong size");
        }

        try {
            System.out.println("Сумма третьего массива: " +
                    sumMassive3.sum(goodMassive));
        }catch (MyArraySizeException e) {
            e.printStackTrace();
            System.out.println("Wrong size");
        }
    }
}
