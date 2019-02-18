package geekbrains.Java2Lesson2;

public class SumMassive {

    String [][] massiv;

    public SumMassive (String [][] massiv) {
        this.massiv = massiv;
    }

    public int sum (String [][] a) throws MyArraySizeException{

        int sumAllElem = 0;
        boolean exception = checkMyArraySizeException(massiv);

        if (exception) {
                throw new MyArraySizeException();
        } else {
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a.length; j++) {
                    try {
                        sumAllElem += Integer.parseInt(a[i][j]);
                    } catch (NumberFormatException e) {
                        try {
                            throw new MyArrayDataException();
                        }catch (MyArrayDataException myException) {
                            myException.printStackTrace();
                            System.out.println("Элемент массива " + (i + 1) + " " + (j + 1) +
                                    " не является числом. Сумма будет посчитана без этого элемента");
                        }
                    }
                }
            }
        }
        return sumAllElem;
    }

    //проверка на правильный размер массива
    private boolean checkMyArraySizeException(String [][] a) {
        if (a.length != 4) {
            return true;
        }
        else {
            return false;
        }
    }


}
