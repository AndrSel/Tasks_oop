package com.company;
import java.util.Arrays;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}




class F1 {
    public static void main(String[] args) {
        //1
        // Квадратное уравнение ax2 + bx + c = 0 имеет либо 0,
        // либо 1, либо 2 различных
        //решения для действительных значений x.
        // учитывая a, b и c, вы должны вернуть
        //число решений в уравнение.
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        System.out.println(solutions(a,b,c));

    }
        public static int solutions( int a, int b, int c){
            int D = b * b - 4 * a * c;
            if (D > 0)
                return 2;
            else if (D == 0)
                return 1;
            else
                return 0;
        }

}
class F2 {
    public static void main(String[] args) {
        //2
        // Напишите функцию, которая возвращает позицию второго вхождения " zip " в
        //строку, или -1, если оно не происходит по крайней мере дважды. Ваш код должен
        //быть достаточно общим, чтобы передать все возможные случаи, когда "zip" может
        //произойти в строке.
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        //String a;
        //a = "all zip files are zipped";

        System.out.println(findZip(a));

    }
    public static int findZip(String strok) {
        int n=-1 ;
        for (int i = 0; i < strok.length(); i++) {
            if (strok.charAt(i) == 'z' && strok.charAt(i + 1) == 'i' && strok.charAt(i + 2) == 'p' && n == 1)
                n = i;
            if (strok.charAt(i) == 'z' && strok.charAt(i + 1) == 'i' && strok.charAt(i + 2) == 'p' && n == -1)
                n = 1;


        }
        if (n==1) n = -1;
        return n;
    }

}
    //3
    // Создайте функцию, которая проверяет, является ли целое число совершенным
    //числом или нет. Совершенное число - это число, которое можно записать как
    //сумму его множителей, исключая само число.
    class F3 {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int a = in.nextInt();
            System.out.println(checkPerfect(a));
        }
        public static boolean checkPerfect(int a) {
            int sum = 0;
            boolean check = false;
            for (int i = 1; i < a; i++) {
                if (a % i == 0)//отбор множителей
                    sum += i;
            }
            if (a == sum)
                check = true;
            return check;
        }

    }
    //4
    //Создайте функцию, которая принимает строку и возвращает новую строку с
    //заменой ее первого и последнего символов, за исключением трех условий:
    //– Если длина строки меньше двух, верните "несовместимо".".
    //– Если первый и последний символы совпадают, верните "два-это пара.".
    class F4 {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            String a = in.nextLine();
            //String a = "Cat, dog, and mouse.";
            System.out.println(flipEndChars(a));
        }
        public static String flipEndChars(String str) {
            char[] buf;
            if (str.length() < 2)
                str = "несовместимо.";
            else if (str.charAt(0) == str.charAt(str.length() - 1)) {
                str = "два-это пара.";
            }
            else if (!((str == "два-это пара.") || (str == "несовместимо."))) {
                buf = str.toCharArray();//Метод toCharArray() создает из строки массив чаров
                buf[0] = str.charAt(str.length() - 1);
                buf[str.length() - 1] = str.charAt(0);
                str = new String(buf);
            }
            return str;
        }

    }
    //5
    // Создайте функцию, которая определяет, является ли строка допустимым
    // шестнадцатеричным кодом
    class F5 {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            String a = in.nextLine();
            System.out.println(isValidHexCode(a));
        }
        public static boolean isValidHexCode(String code) {

            if (code.length() > 7) return false;
//Метод matches() — в Java сообщает, соответствует ли или нет данная строка заданному регулярному выражению.
            else if (code.matches("#[A-Fa-f0-9]+")) return true;//содержит ли строка шестнадцатеричные цифры (от 0 до 9 и от A до F)
            //квантор +, означающий «один или больше раз»
            else return false;
        }

    }
    //6
    // Напишите функцию, которая возвращает true, если два массива имеют одинаковое
    // количество уникальных элементов, и false в противном случае.
    class F6 {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int length = in.nextInt();//ввод длины массива
            int [] myArray = new int[length];//создание массива с длинной length
            for(int i=0; i<length; i++ ){
                myArray[i] = in.nextInt();
            }
            int length1 = in.nextInt();//ввод длины массива
            int [] myArray1 = new int[length1];//создание массива с длинной length
            for(int i=0; i<length1; i++ ){
                myArray1[i] = in.nextInt();
            }
            System.out.println(same(myArray,myArray1));
        }

        public static boolean same(int[] mass, int[] mass1) {
            int kol = 0;
            int kol1 = 0;
            boolean proverka = false;
            Arrays.sort(mass);//Arrays.sort() позволяет сортировать элементы массива по возрастанию
            Arrays.sort(mass1);
            for (int i = 0; i < mass.length - 1; i++) {//определение кол-ва уникальных элементов
                if (mass[i] != mass[i + 1])
                    kol++;
            }
            for (int i = 0; i < mass1.length - 1; i++) {
                if (mass1[i] != mass1[i + 1])
                    kol1++;
            }
            if (kol == kol1)
                proverka = true;
            return proverka;

        }

    }
    //7
    // Число Капрекара-это положительное целое число, которое после возведения в
    // квадрат и разбиения на две лексикографические части равно сумме двух
    // полученных новых чисел:
    // – Если количество цифр квадратного числа четное, то левая и правая части будут иметь
    // одинаковую длину.
    // – Если количество цифр квадратного числа нечетно, то правая часть будет самой длинной
    // половиной, а левая-самой маленькой или равной нулю, если количество цифр равно 1.
    // – Учитывая положительное целое число n, реализуйте функцию, которая возвращает true,
    // если это число Капрекара, и false, если это не так.
    class F7 {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int a = in.nextInt();
            System.out.println(isKaprekar(a));
        }
        public static boolean isKaprekar(int n) {
            int c = n * n;
            String n_str = String.valueOf(c);//возвращает строковое представление int аргумента
            if (n_str.length() == 1)
                return n == c;
            else
                //Integer.parseInt преобразует строку в число
                //substring - с какого индекса будет возвращаться строка или с какого по какой
                //System.out.println(Integer.parseInt(n_str.substring(0, n_str.length() / 2)));
                //System.out.println(Integer.parseInt(n_str.substring(n_str.length() / 2)));
//первая половина строки + вторая половина строки
                return Integer.parseInt(n_str.substring(0, n_str.length() / 2)) + Integer.parseInt(n_str.substring(n_str.length() / 2)) == n;

        }


    }
    //8
    // Напишите функцию, которая возвращает самую длинную последовательность
    // последовательных нулей в двоичной строке.
    class F8 {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            String a = in.nextLine();
            System.out.println(longestZero(a));
        }
        public static String longestZero(String n) {
            String sum = "";
            String otvet = "";
            for (int i = 0; i < n.length() - 1; i++) {
                if (n.charAt(i) == '0'){//если 0, сохраняем 0
                sum += "0";
                }
                else {
                    if (otvet.length() < sum.length())//если длина ответа меньше длины след последовательности
                        otvet = sum;
                    sum = "";
                }
            }
            if (otvet.length() < sum.length()) otvet = sum;
            return otvet;
        }
    }
    //9
    // Если задано целое число, создайте функцию, которая возвращает следующее
    // простое число. Если число простое, верните само число.
    class F9 {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int a = in.nextInt();
            System.out.println(nextPrime(a));
        }
        public static int nextPrime(int num) {
            while (true) {
                boolean check = true;
                for (int i = 2; i <num ; i++) {
                    if (num % i == 0) {//условный опереатор определяет является ли число простым
                        //если число простое, то chek=true
                        num++;
                        check = false;
                    }
                }
                if (check) break;
            }
            return num;
        }

    }
    //10
    // Учитывая три числа, x, y и z, определите, являются ли они ребрами
    // прямоугольного треугольника.
    class F10 {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            System.out.println(rigthTriangle(a,b,c));
        }
    public static boolean rigthTriangle( int x, int y, int z){
        if ( x == 0 || y == 0 || z == 0 )
            return false;
        return  (x*x+y*y==z*z || x*x==y*y+z*z || x*x+z*z == y*y);//Теорема Пифагора
    }
}
