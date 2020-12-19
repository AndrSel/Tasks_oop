package com.company;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import java.util.Arrays;
//import java.lang.Math;
import java.security.MessageDigest;
//import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;
import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}
class F1{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        System.out.println(encrypt(a));

        int length = in.nextInt();//ввод длины массива
        int [] myArray = new int[length];//создание массива с длинной length
        for(int i=0; i<length; i++ ){
            myArray[i] = in.nextInt();
        }
        System.out.println(dycrypt(myArray));
    }

    /* 1. Пришло время отправлять и получать секретные сообщения.
    Создайте две функции, которые принимают строку и массив и возвращают
    закодированное или декодированное сообщение.
    Первая буква строки или первый элемент массива представляет собой символьный код
    этой буквы. Следующие элементы-это различия между символами: например, A +3 --> C
    или z -1 --> y.*/

    public static String encrypt(String str) {
        int[] mass = new int[str.length()];
        //int yt = str.charAt(1) - str.charAt(0);
        //System.out.println(yt);
        //char u = (char) 72+29+7+3;
        //System.out.println(u);
        for (int i = 0; i < str.length(); i++) {
            if (i == 0) {
                //System.out.println(str.charAt(i));
                mass[i] = str.charAt(i);//Первая буква строки или первый элемент массива представляет собой символьный код
                //этой буквы
            }
            else{

                //System.out.println(str.charAt(i));
                //System.out.println((str.charAt(i - 1)));
                //System.out.println(str.charAt(i)-(str.charAt(i - 1)));
                //System.out.println((str.charAt(i - 1)));
                mass[i] = str.charAt(i) - (str.charAt(i - 1));
                //System.out.println(mass[i]);
            }

        }
        return Arrays.toString(mass);
    }

    public static String dycrypt(int[] mass) {
        char[] str = new char[mass.length];
        for (int i = 0; i < mass.length; i++) {
            if (i == 0) {
                str[i] = (char) mass[i];//запись первой буквы
                //System.out.println(str[i]);
            } else {
                str[i] = (char) (mass[i - 1] + mass[i]);//2,3,4..... буквы
                mass[i] = mass[i - 1] + mass[i];//1 эл. масс + 2 эл. масс.....(сложение всех эл массива)
            }
        }
        return new String(str);
    }
}
class F2 {
    public static void main(String[] args) {
        //char q = 'A';
        //char q1 = 'B';
        //int res = q1 - q;//1
        //System.out.println(res);

        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        String b = in.nextLine();
        String c = in.nextLine();
        System.out.println(canMove(a,b,c));
    }
    /* 2. Создайте функцию, которая принимает имя шахматной фигуры, ее положение и
    целевую позицию. Функция должна возвращать true, если фигура может двигаться
    к цели, и false, если она не может этого сделать.*/

    public static boolean canMove(String name, String start, String end) {
        char startl = start.charAt(0);//первое занчение start
        int startn = Integer.parseInt(String.valueOf(start.charAt(1)));//преобразует 2 эл. в тип данных int
        char endl = end.charAt(0);//первое занчение end
        int endn = Integer.parseInt(String.valueOf(end.charAt(1)));//преобразует 2 эл. в тип данных int
        if (startl == endl && startn == endn) return false;//если старт является конецной точкой
        switch (name) {
            case "Pawn": {//Пешка
                if (startl == endl && startn == 2 && endn == 4)//первый ход
                    return true;
                return startl == endl && endn == (startn + 1);
            }
            case "Knight": {//конь
                return (Math.abs(startl - endl) == 2 && Math.abs(startn - endn) == 1) || (Math.abs(startl - endl) == 1 && Math.abs(startn - endn) == 2);
            }
            case "Bishop": {//слол
                return Math.abs(startl - endl) == Math.abs(startn - endn);
            }
            case "Rook": {//ладья
                return (startl == endl && startn != endn) || (startl != endl && startn == endn);
            }
            case "Queen": {
                if ((startl == endl && startn != endn) || (startl != endl && startn == endn))
                    return true;
                if (Math.abs(startl - endl) == Math.abs(startn - endn))
                    return true;
                break;
            }
            case "King": {
                return Math.abs(startl - endl) < 2 && Math.abs(startn - endn) < 2;
            }
            default:
                return false;
        }
        return false;
    }

}
class F3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        String b = in.nextLine();
        System.out.println(canComplite(a,b));
        String y = String.valueOf(0);
    }
    /* 3. Входная строка может быть завершена, если можно добавить дополнительные
    буквы, и никакие буквы не должны быть удалены, чтобы соответствовать слову.
    Кроме того, порядок букв во входной строке должен быть таким же, как и порядок
    букв в последнем слове.*/

    public static boolean canComplite(String str1, String str2) {
        char[] massstr1 = str1.toCharArray();//Метод toCharArray() создает из строки массив чаров
        int num = 0;//индекс, с которого начинается проверка
        for (char c : massstr1) {//перебор массива
            if (str2.indexOf(String.valueOf(c), num) != -1){//если есть одинаковые буквы
                //System.out.println(str2.indexOf(String.valueOf(c), num));
                num = str2.indexOf(String.valueOf(c), num) + 1;//обрезание пройденной части строки
                }

            else
                return false;
        }
        return true;
    }

}
/* 4. Создайте функцию, которая принимает числа в качестве аргументов, складывает их
вместе и возвращает произведение цифр до тех пор, пока ответ не станет длиной
всего в 1 цифру.*/
class F4 {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int length = in.nextInt();//ввод длины массива
        int [] myArray = new int[length];//создание массива с длинной length
        for(int i=0; i<length; i++ ){
            myArray[i] = in.nextInt();
        }
        System.out.println(sumDigProd(myArray));
    }

    public static int sumDigProd(int[] mass) {
        int sum = 0;//сумма
        for (int value : mass) {//перебор массива
            sum += value;//сумма всех значений
        }
        while (sum > 9) {//пока значение не Однозначное
            int mult = 1;//произвдение
            while (sum > 0) {
                mult *= sum % 10;//произведение всех цифр числа
                sum /= 10;
            }
            sum = mult;
        }
        return sum;
    }

}
class F5 {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int length = in.nextInt();//ввод длины массива
        String [] myArray = new String[length];//создание массива с длинной length
        for(int i=0; i<length; i++ ){
            myArray[i] = in.next();
        }
        System.out.println(sameVowelGroup(myArray));
    }
    /* 5. Напишите функцию, которая выбирает все слова, имеющие все те же гласные (в
    любом порядке и / или количестве), что и первое слово, включая первое слово.*/

    public static String sameVowelGroup(String[] str) {
        String glas = "aeiouyAEIOUY";//все гласные
        StringBuilder first = new StringBuilder();
        String second = "";

        ArrayList<String> words = new ArrayList<>();//list для слов
        Collections.addAll(words, str);//запись всех слов в words

        for (int i = 0; i < words.get(0).length(); i++) {//первое слово
            if (glas.indexOf(words.get(0).charAt(i)) != -1)//если существует гласная в слове из list(words)
                first.append(words.get(0).charAt(i));//запись гласной
        }

        for (int i = words.size() - 1; i >= 0; i--) {//перебор list(words)
            for (int j = 0; j < words.get(i).length(); j++) {//перебор слов по очереди
                if (glas.indexOf(words.get(i).charAt(j)) != -1) {//если существует гласная в слове из list(words)
                    second += words.get(i).charAt(j);//запись гласных
                }
            }
            for (int k = 0; k < second.length(); ) {//пребор гласных всех слов по очереди(second)
                if (first.toString().indexOf(second.charAt(k)) != -1)//если гласные первого слова совпадают с гласными след слова
                    k++;
                else {//проверка на совпадение
                    words.remove(i);//в противном случае слово удаляется
                    second = "";//"обнуление" second ,для того чтобы записать в него гласные след. слова
                }
            }
        }
        return String.valueOf(words);
    }

}
/* 6. Создайте функцию, которая принимает число в качестве аргумента и возвращает
 true, если это число является действительным номером кредитной карты, а в
 противном случае-false.*/
class F6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long a = in.nextLong();
        System.out.println(validateCard(a));

    }

    public static boolean validateCard(long cardNum) {
        StringBuilder str = new StringBuilder();
        if (Long.toString(cardNum).length() >= 14 && Long.toString(cardNum).length() <= 19) {
            // шаг 1
            long lastNum = cardNum % 10;//последнее занчение("контрольная цифра")
            StringBuilder cardNumStr = new StringBuilder(Long.toString(cardNum /= 10));//номер без последней цифры
            // шаг 2
            cardNumStr.reverse();//перевернутое число
            // шаг 3
            for (int i = 0; i < cardNumStr.length(); i++) {//перебираем cardNumStr
                if (i % 2 == 0) {//проверка на четность/нечетность
                    //Удвойте значение каждой цифры в нечетных позициях
                    int c = Character.getNumericValue(cardNumStr.charAt(i)) * 2;// возвращает значение INT , что указанный символ Unicode представляет
                    if (c > 9) {//Если удвоенное значение имеет более 1 цифры, сложите цифры вместе
                        String buf = Integer.toString(c);//сохраняем знач. в переменную(String) и складываем 1 и 2 цифру
                        str.append(Character.getNumericValue(buf.charAt(0)) + Character.getNumericValue(buf.charAt(1)));//сложите цифры вместе
                    } else str.append(c);//добавление значения
                } else str.append(cardNumStr.charAt(i));
            }
            System.out.println(str);//изменненный номер
            int sum = 0;
            for (int i = 0; i < str.length(); i++)
                sum += Character.getNumericValue(str.charAt(i));//находим сумму
            System.out.println(sum);//сумма изменненного номера
            System.out.println(lastNum);//вывод последней цифры
            return lastNum == 10 - sum % 10;//10 - последняя цифра суммы
        }
        return false;
    }

}
class F7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        System.out.println(numToEng(a));
        System.out.println(numToRus(a));

    }
   /* 7. Напишите функцию, которая принимает положительное целое число от 0 до 999
    включительно и возвращает строковое представление этого целого числа,
    написанное на английском языке.*/

    public static String numToEng(int num) {
        String strnum = "";
        if (num == 0) return "zero";
        // сотни
        switch (num / 100) {
            case 1: {
                strnum += "one hundred ";
                break;
            }
            case 2: {
                strnum += "two hundred ";
                break;
            }
            case 3: {
                strnum += "three hundred ";
                break;
            }
            case 4: {
                strnum += "four hundred ";
                break;
            }
            case 5: {
                strnum += "five hundred ";
                break;
            }
            case 6: {
                strnum += "six hundred ";
                break;
            }
            case 7: {
                strnum += "seven hundred ";
                break;
            }
            case 8: {
                strnum += "eight hundred ";
                break;
            }
            case 9: {
                strnum += "nine hundred ";
                break;
            }
        }
        // десятки до 20
        switch (num / 10 % 10) {
            case 1: {
                switch (num % 10) {
                    case 0: {
                        strnum += "ten";
                        return strnum;
                    }
                    case 1: {
                        strnum += "eleven";
                        return strnum;
                    }
                    case 2: {
                        strnum += "twelve";
                        return strnum;
                    }
                    case 3: {
                        strnum += "thirteen";
                        return strnum;
                    }
                    case 4: {
                        strnum += "fourteen";
                        return strnum;
                    }
                    case 5: {
                        strnum += "fifteen";
                        return strnum;
                    }
                    case 6: {
                        strnum += "sixteen";
                        return strnum;
                    }
                    case 7: {
                        strnum += "seventeen";
                        return strnum;
                    }
                    case 8: {
                        strnum += "eighteen";
                        return strnum;
                    }
                    case 9: {
                        strnum += "nineteen";
                        return strnum;
                    }
                }
            }
            // десятки после 20
            case 2: {
                strnum += "twenty ";
                break;
            }
            case 3: {
                strnum += "thirty ";
                break;
            }
            case 4: {
                strnum += "forty ";
                break;
            }
            case 5: {
                strnum += "fifty ";
                break;
            }
            case 6: {
                strnum += "sixty ";
                break;
            }
            case 7: {
                strnum += "seventy ";
                break;
            }
            case 8: {
                strnum += "eighty ";
                break;
            }
            case 9: {
                strnum += "ninety ";
                break;
            }
        }
        // единицы
        switch (num % 10) {
            case 1: {
                strnum += "one";
                break;
            }
            case 2: {
                strnum += "two";
                break;
            }
            case 3: {
                strnum += "three";
                break;
            }
            case 4: {
                strnum += "four";
                break;
            }
            case 5: {
                strnum += "five";
                break;
            }
            case 6: {
                strnum += "six";
                break;
            }
            case 7: {
                strnum += "seven";
                break;
            }
            case 8: {
                strnum += "eight";
                break;
            }
            case 9: {
                strnum += "nine";
                break;
            }
        }
        return strnum;
    }

    public static String numToRus(int num) {
        String strnum = "";
        if (num == 0) return "ноль";
        // сотни
        switch (num / 100) {
            case 1: {
                strnum += "сто ";
                break;
            }
            case 2: {
                strnum += "двести ";
                break;
            }
            case 3: {
                strnum += "триста ";
                break;
            }
            case 4: {
                strnum += "четыреста ";
                break;
            }
            case 5: {
                strnum += "пятьсот ";
                break;
            }
            case 6: {
                strnum += "шестьсот ";
                break;
            }
            case 7: {
                strnum += "семьсот ";
                break;
            }
            case 8: {
                strnum += "восемьсот ";
                break;
            }
            case 9: {
                strnum += "девятьсот ";
                break;
            }
        }
        // десятки до 20
        switch (num / 10 % 10) {
            case 1: {
                switch (num % 10) {
                    case 0: {
                        strnum += "десять";
                        return strnum;
                    }
                    case 1: {
                        strnum += "одиннадцать";
                        return strnum;
                    }
                    case 2: {
                        strnum += "двенадцать";
                        return strnum;
                    }
                    case 3: {
                        strnum += "тринадцать";
                        return strnum;
                    }
                    case 4: {
                        strnum += "четырнадцать";
                        return strnum;
                    }
                    case 5: {
                        strnum += "пятнадцать";
                        return strnum;
                    }
                    case 6: {
                        strnum += "шестнадцать";
                        return strnum;
                    }
                    case 7: {
                        strnum += "семнадцать";
                        return strnum;
                    }
                    case 8: {
                        strnum += "восемьнадцать";
                        return strnum;
                    }
                    case 9: {
                        strnum += "двадцать";
                        return strnum;
                    }
                }
            }
            // десятки после 20
            case 2: {
                strnum += "двадцать ";
                break;
            }
            case 3: {
                strnum += "тридцать ";
                break;
            }
            case 4: {
                strnum += "сорок ";
                break;
            }
            case 5: {
                strnum += "пятьдесят ";
                break;
            }
            case 6: {
                strnum += "шестьдесят ";
                break;
            }
            case 7: {
                strnum += "семьдесят ";
                break;
            }
            case 8: {
                strnum += "восемьдесят ";
                break;
            }
            case 9: {
                strnum += "девяносто ";
                break;
            }
        }
        // единицы
        switch (num % 10) {
            case 1: {
                strnum += "один";
                break;
            }
            case 2: {
                strnum += "два";
                break;
            }
            case 3: {
                strnum += "три";
                break;
            }
            case 4: {
                strnum += "четыре";
                break;
            }
            case 5: {
                strnum += "пять";
                break;
            }
            case 6: {
                strnum += "шесть";
                break;
            }
            case 7: {
                strnum += "семь";
                break;
            }
            case 8: {
                strnum += "восемь";
                break;
            }
            case 9: {
                strnum += "девять";
                break;
            }
        }
        return strnum;
    }

}
class F8 {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        System.out.println(getSha256Hash(a));
    }
    /*8. Хеш-алгоритмы легко сделать одним способом, но по существу невозможно
     сделать наоборот. Например, если вы хешируете что-то простое, например,
     password123, это даст вам длинный код, уникальный для этого слова или фразы. В
     идеале, нет способа сделать это в обратном порядке. Вы не можете взять хеш-код и
     вернуться к слову или фразе, с которых вы начали.*/

        public static String getSha256Hash(String s) throws NoSuchAlgorithmException {
            try {
                MessageDigest digest = MessageDigest.getInstance("SHA-256");
                byte[] hash = digest.digest(s.getBytes("UTF-8"));//вычисление дайджеста сообщения из одного блока данных
                StringBuffer hexString = new StringBuffer();//строка с кодом
                for(int i = 0; i<hash.length;i++){
                    //Java.lang.Integer.toHexString () - это встроенная функция в Java,
                    // которая возвращает строковое представление целочисленного аргумента в виде целого числа без знака в базе 16
                    String hex = Integer.toHexString(0xff & hash[i]);//преобразование в 16-ную строку
                    //if(hex.length() == 1) hexString.append(0);
                    hexString.append(hex);//обновление строки с кодом
                }
                return hexString.toString();//вывод
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();//что произошло, и где в коде это произошло
            }
            return "";
        }
}
class F9 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        System.out.println(correctTitle(a));
        //sansa stark, lady of winterfell.
    }
    /* 9. Напишите функцию, которая принимает строку и возвращает строку с правильным
    регистром для заголовков символов в серии "Игра престолов".
    Слова and, the, of и in должны быть строчными. Все остальные слова должны иметь
    первый символ в верхнем регистре, а остальные-в Нижнем.*/

    public static String correctTitle(String title) {
        String[] text = title.toLowerCase().split(" ");//слова с нижным регистром
        //for (int i = 0; i < text.length; i++) System.out.println(text[i]);
        title = "";
        String pos = "";
        for (int i = 0; i < text.length; i++) {
            if (text[i].equals("in") || text[i].equals("of") || text[i].equals("and") || text[i].equals("the"))
                title += text[i].toLowerCase() + " ";//Слова and, the, of и in должны быть строчными
            else
                title += text[i].substring(0, 1).toUpperCase() + text[i].substring(1) + " ";//установка 1 символа с верхним регистром+след. символы
        }
        return title;
    }

}
class F10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        System.out.println(haxLattice(a));
    }
    /* 10. Как указано в онлайн-энциклопедии целочисленных последовательностей:
    Гексагональная решетка - это привычная двумерная решетка, в которой каждая точка
    имеет 6 соседей.
    Центрированное шестиугольное число - это центрированное фигурное число,
    представляющее шестиугольник с точкой в центре и всеми другими точками,
    окружающими центральную точку в шестиугольной решетке. */

    public static String haxLattice(int n){
        int num = 1;
        int i = 1;
        String res="";
        String str2="";
        while (n>num) {
            i++;
            num = 3 * i * (i - 1) + 1;//вычисление 1/7/19/37
        }
        int l = i;
        // верхняя половина
        if (n != num)
            res = "invalid";
        else {
            while (l < i * 2 - 1) {//кол-во итераций = l-1
                for (int a = 0; a < i * 2 - 1 - l; a++)//
                    res += "  ";//пробелы
                for (int b = 0; b < l; b++)//кол-во итераций = l
                    res += " o  ";//отрисовка o
                res += "\n";
                l++;
            }
            // нижняя половина
            while (l >= i) {//алгоритм пройдет на 1 раз больше
                for (int a = 0; a < i * 2 - 1 - l; a++)
                    res += "  ";//пробелы
                for (int b = l; b > 0; b--)//кол-во итераций = l(измененное l)
                    res += " o  ";//отрисовка o
                res += "\n";
                l--;
            }
        }
        return res;
    }
}
