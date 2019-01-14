public class Java1Lesson1{

    public static void main(String[] args) {

        byte b = 6;
        short sh = 222;
        int i = 22;
        long l = 343L;
        char ch = 'C';
        boolean boll = true;
        float fl = 3.3f;
        double d = 3.5;
        System.out.println("Выполнение метода со всеми действиями. Результат равен " + add(2,5,18,9));
        System.out.println("Выполнение метода с проверкой на принадлежность(a+b) промежутку от 10 до 20.  " + ot10do20(5,6));
        System.out.println("Выполнение метода с проверкой на положительность. " + isPositiveOrNegative(5));
        System.out.println("Выполнение метода с проверкой на положительность. " + isNegative(5));
        System.out.println("Выполнение метода с приветствием. " + hello("Kirill"));
        System.out.println("Выполнение метода с годом. " + vis_year(35));
        System.out.println("Выполнение метода с годом. " + vis_year(8));
        System.out.println("Выполнение метода с годом. " + vis_year(100));
        System.out.println("Выполнение метода с годом. " + vis_year(400));
    }

    public static double add(int a, int b, int c, int d){
        return (a * (b + ((double)c / d)));
    }

    public static boolean ot10do20(int a, int b){
        if (a+b>=10 & a+b<=20) return true;
        else return false;
   }

    public static String isPositiveOrNegative(int a){
        String b;
        if (a>=0) {
            b = "Число положительное";
        } else b = "Число отрицательное";
        return b;
    }

    public static boolean isNegative(int a){
        if (a>=0) {
            return false;
        } return true;
    }

    public static String hello(String name){
        String hello = "Hello, " + name + "!";
        return hello;
    }

    public static String vis_year(int a){
        String otvet;
        if (a % 4 != 0 | a % 100 == 0 & a % 400 != 0){
                otvet = a + " год не високостный";
        }else otvet = a + " год високостный";
        return otvet;
    }

}
