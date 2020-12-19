package com.company;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

    }
}

class F1 {
//Создайте функцию, которая повторяет каждый символ в строке n раз

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String a = in.next();
        int b = in.nextInt();
        repeat(a,b);
        System.out.println(".....................................");
        repeat("mice",5);
        repeat("hello",3);
        repeat("stop",1);
    }
    public static void repeat(String word, int n) {
        String newWord = " ";
        for (int i = 0; i < word.length(); i++) {
            for (int j = 0; j < n; j++) {
                newWord += word.charAt(i);
            }
        }
        System.out.println(newWord);
    }

}
class F2 {
//Создайте функцию, которая принимает массив и возвращает разницу между
//самыми большими и самыми маленькими числами.
public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int length = in.nextInt();//ввод длины массива
    int [] myArray = new int[length];//создание массива с длинной length
    for(int i=0; i<length; i++ ){
        myArray[i] = in.nextInt();
    }
    differenceMaxMin(myArray);
    System.out.println(".....................................");
    int[] a = {10,4, 1, 4, -10, -50, 32, 21};
    differenceMaxMin(a);
    int[] b = {44, 32, 86, 19};
    differenceMaxMin(b);
}

    public static void differenceMaxMin(int[] mass) {
        int max = Integer.MIN_VALUE;//ввод макс и мин знач, которые может поместить в себя тип integer
        int min = Integer.MAX_VALUE;
        for (int value : mass) {
            min = Math.min(min, value);// min яисло из двух
            max = Math.max(max, value);
        }
        System.out.println(max - min);
    }

}

class F3{
//Создайте функцию, которая принимает массив в качестве аргумента и возвращает
//true или false в зависимости от того, является ли среднее значение всех элементов
//массива целым числом или нет.
public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int length = in.nextInt();//ввод длины массива
    int [] myArray = new int[length];//создание массива с длинной length
    for(int i=0; i<length; i++ ){
        myArray[i] = in.nextInt();
    }
    if (isAvgWhole(myArray)) System.out.println("true");
    else System.out.println("false");
    System.out.println(".....................................");

    int[] a = {1, 3};
    if (isAvgWhole(a)) System.out.println("true");
    else System.out.println("false");

    int[] b = {1,2, 3,4};
    if (isAvgWhole(b)) System.out.println("true");
    else System.out.println("false");

    int[] c = {1,5,6};
    if (isAvgWhole(c)) System.out.println("true");
    else System.out.println("false");

    int[] d = {1,1,1};
    if (isAvgWhole(d)) System.out.println("true");
    else System.out.println("false");

    int[] e = {9,2,5,5};
    if (isAvgWhole(e)) System.out.println("true");
    else System.out.println("false");


}

public static boolean isAvgWhole(int mass[]){
        double sum=0;

        for(int value:mass){
        sum+=value;
        }
        if((sum%mass.length)%100< 1)//если остаток от деления среднего знач. на 100 =0
        return true;
        else
        return false;

        }
}

class F4 {
//Создайте метод, который берет массив целых чисел и возвращает массив, в
//котором каждое целое число является суммой самого себя + всех предыдущих
//чисел в массиве.
public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int length = in.nextInt();//ввод длины массива
    int[] myArray = new int[length];//создание массива с длинной length
    for (int i = 0; i < length; i++) {
        myArray[i] = in.nextInt();
    }

    cumulativeSum(myArray);
}
    public static void cumulativeSum(int[] mass) {

        for (int i = 1; i < mass.length; i++) {
            mass[i] = mass[i] + mass[i - 1];
        }
        //return mass;
        for (int i = 0; i < mass.length; i++) {
            System.out.println(mass[i]);
        }
    }

}

class F5 {
//Создайте функцию, которая возвращает число десятичных знаков, которое имеет
//число (заданное в виде строки). Любые нули после десятичной точки
//отсчитываются в сторону количества десятичных знаков.
public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String a = in.next();

    System.out.println(getDecimalPlaces(a));
    System.out.println(".....................................");
    String b = "43.20";
    System.out.println(getDecimalPlaces(b));

    String c = "400";
    System.out.println(getDecimalPlaces(c));

    String d = "3.1";
    System.out.println(getDecimalPlaces(d));

}

    public static int getDecimalPlaces(String number) {
        if (number.indexOf('.') != 0 & number.indexOf('.') > 0) {//ищет точку в строке
            //System.out.println(number.indexOf('.'));индекс точки
            return number.length() - 1 - number.indexOf('.');//при отсутствии точки принимает значение -1
        } else return 0;
    }
}

class F6 {
//Создайте функцию, которая при заданном числе возвращает соответствующее
//число Фибоначчи.
public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int a = in.nextInt();
    System.out.println(Fibonacci(a));
    System.out.println(".....................................");

    System.out.println(Fibonacci(3));
    System.out.println(Fibonacci(7));
    System.out.println(Fibonacci(12));
}

    public static int Fibonacci(int n) {
        int n0 = 1;
        int n1 = 1;
        int n2 = 0;
        switch (n) {
            case 0:
            case 1:
                return 1;

            default:
                for(int i = 2; i <= n; i++){
                    n2=n0+n1;
                    n0=n1;
                    n1=n2;


            }
                return n2;

        }
}}

class F7 {
//Почтовые индексы состоят из 5 последовательных цифр. Учитывая строку,
//напишите функцию, чтобы определить, является ли вход действительным
//почтовым индексом. Действительный почтовый индекс выглядит следующим
//образом:
//– Должно содержать только цифры (не допускается использование нецифровых цифр).
//– Не должно содержать никаких пробелов.
//– Длина не должна превышать 5 цифр.
public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String a = in.next();
    System.out.println(isValid(a));
    System.out.println("...................................");
    System.out.println(isValid("59001"));
    System.out.println(isValid("853a7"));
    System.out.println(isValid("732 32"));
    System.out.println(isValid("393939"));


}


    public static boolean isValid(String index) {
        int chek = 0;
        for (int i = 0; i < index.length(); i++) {
            if (!Character.isDigit(index.charAt(i)))//определяет, является ли указанное значение типа char цифрой
                chek++;
            else if (index.charAt(i) == ' ')
                chek++;
            else if (index.length() != 5)
                chek++;
        }
        return chek == 0;
    }
}

class F8{
//Пара строк образует странную пару, если оба из следующих условий истинны:
//– Первая буква 1-й строки = последняя буква 2-й строки.
//– Последняя буква 1-й строки = первая буква 2-й строки.
//– Создайте функцию, которая возвращает true, если пара строк представляет собой
//странную пару, и false в противном случае.
public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String a = in.next();
    String b = in.next();
    System.out.println(isStrangePair(a,b));
    System.out.println("...................................");

    System.out.println(isStrangePair("ratio","orator"));
    System.out.println(isStrangePair("sparkling","groups"));
    System.out.println(isStrangePair("bush","hubris"));
    System.out.println(isStrangePair(" "," "));


}
        public static boolean isStrangePair(String word1, String word2) {
            return (word1.charAt(0) == word2.charAt(word2.length() - 1) &
                    word2.charAt(0) == word1.charAt(word1.length() - 1));
        }
}


class F9 {
//Создайте две функции: isPrefix(word, prefix-) и isSuffix (word, -suffix).
//– isPrefix должен возвращать true, если он начинается с префиксного аргумента.
//– isSuffix должен возвращать true, если он заканчивается аргументом суффикса.
//– В противном случае верните false.
public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String a = in.next();
    String b = in.next();
    System.out.println(isPrefix(a,b));
    a = in.next();
    b = in.next();
    System.out.println(isSuffix(a,b));
    System.out.println("...................................");
    System.out.println(isPrefix("automation","auto-"));
    System.out.println(isSuffix("arachnophobia","-phobia"));
    System.out.println(isPrefix("retrospect","sub-"));
    System.out.println(isSuffix("vocation","-logy"));

}
    public static boolean isPrefix(String word, String pref) {
        pref = pref.substring(0, pref.length() - 1);//в int endIndex указывается по какой индекс будет возвращаться строка,
        // в int beginIndex указывается значение индекса, с которого будет возвращаться часть строки
        return word.startsWith(pref);//Java startsWith() возвращает значение true, если последовательность символов,
        // представленного аргумента является префиксом последовательности символов, представляемой данной строкой; в противном случае значение false.
    }

    public static boolean isSuffix(String word, String suf) {
        suf = suf.substring(1);//в int beginIndex указывается значение индекса, с которого будет возвращаться часть строки
        return word.endsWith(suf);//Метод endsWith() — проверяет, заканчивается ли эта строка указанным окончанием
    }

}


class F10{
//Создайте функцию, которая принимает число (шаг) в качестве аргумента и
//возвращает количество полей на этом шаге последовательности.
//Шаг 0: начните с 0
//Шаг 1: Добавьте 3
//Шаг 2: Вычтите 1
//Повторите Шаги 1 И 2 ...
public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int a = in.nextInt();
    System.out.println(boxSeq(a));
    System.out.println("...................................");

    System.out.println(boxSeq(0));
   System.out.println(boxSeq(1));
   System.out.println(boxSeq(2));

}

        public static int boxSeq(int shag) {
            if (shag == 0) return 0;
            int count = 0;
            for (int i = 0; i < shag; i++) {
                if (i % 2 == 0) count += 3;//1 шаг
                else count--;//2 шаг
            }
            return count;
        }
    }

