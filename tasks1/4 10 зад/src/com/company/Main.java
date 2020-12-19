package com.company;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.io.UnsupportedEncodingException;
public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}






    /*1. Бесси работает над сочинением для своего класса писателей. Поскольку ее почерк довольно плох,
     * она решает напечатать эссе с помощью текстового процессора. Эссе содержит N слов (1≤N≤100),
     * разделенных пробелами. Каждое слово имеет длину от 1 до 15 символов включительно и состоит только
     * из прописных или строчных букв. Согласно инструкции к заданию, эссе должно быть отформатировано
     * очень специфическим образом: каждая строка должна содержать не более K (1≤K≤80) символов, не считая пробелов.
     * К счастью, текстовый процессор Бесси может справиться с этим требованием, используя следующую стратегию:
     * – Если Бесси набирает Слово, и это слово может поместиться в текущей строке, поместите его в эту строку.
     *      В противном случае поместите слово на следующую строку и продолжайте добавлять к этой строке.
     *      Конечно, последовательные слова в одной строке все равно должны быть разделены одним пробелом.
     *      В конце любой строки не должно быть места.
     * – К сожалению, текстовый процессор Бесси только что сломался.
     *      Пожалуйста, помогите ей правильно оформить свое эссе! */
    class F1 {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            String c = in.nextLine();
            int a = in.nextInt();
            int b = in.nextInt();

//hello my name is Bessie and this is my essay
            //System.out.println(Bessy(a,b,c));
            //int a=10;
            //int b=7;
            //String c="hello my name is Bessie and this is my essay";
            System.out.println(Bessy(a,b,c));
            //bessy(a,b,c);
        }
    public static String Bessy(int n, int k, String txt) {
        String[] text = txt.split(" ");//создается массив со словами
        //for (String y:text)System.out.print(y);
        txt = "";
        String finaltxt = "";
        for (int i = 0; i < n; i++) {
            if (txt.length() + text[i].length() > k) {
                finaltxt = finaltxt.trim() + "\n" + text[i] + " ";//Метод trim() — возвращает копию строки с пропущенными начальными и конечными пробелами
                txt = text[i];//txt = новой строке
            } else {
                finaltxt += text[i] + " ";
                txt += text[i];
            }
        }
        return finaltxt.trim();
    }
}
    //2. Напишите функцию, которая группирует строку в кластер скобок.
    //Каждый кластер должен быть сбалансирован.
    class F2 {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            String c = in.nextLine();

            //System.out.println(split(c));
            //for (String y :split(c))System.out.print(y);
            System.out.println(Arrays.toString(split(c)));
        }
        public static String[] split(String str) {
            List<String> list = new ArrayList<String>();
            int f = 0;
            int i = 0;//индекс
            while (str.length() > 0) {
                if (str.charAt(i) == '(') f++;
                else f--;
                if (f == 0) {//срабатывает, когда кол-во открытых скоб = кол-ву закрытых
                    list.add(str.substring(0, i + 1));//группировка
                    str = str.substring(i + 1);//обрезание обработанной строки
                    i = 0;//обнулние индекса
                    continue;
                }
                i++;
            }
            return list.toArray(new String[list.size()]);
        }

    }

    //3. Создайте две функции toCamelCase () и toSnakeCase (),
    // каждая из которых берет одну строку и преобразует ее либо
    // в camelCase, либо в snake_case.
    class F3 {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            String c = in.nextLine();
            System.out.println(toCamelCase(c));
            System.out.println(toSnakeCase(c));
        }
        public static String toCamelCase(String str) {
            for (int i = 1; i < str.length(); i++) {
                if (str.charAt(i) == '_')
                    str = str.substring(0, i) + str.substring(i + 1, i + 2).toUpperCase() + str.substring(i + 2, str.length());
            }
            return str;
        }


        public static String toSnakeCase(String s) {
            String res = "";
            for(int i = 0;i<s.length();i++){
                if(Character.isUpperCase(s.charAt(i))) { res+="_"+Character.toLowerCase(s.charAt(i)); }
                else { res += s.charAt(i); }
            }
            return res;
        }
    }
    //4. Напишите функцию, которая вычисляет сверхурочную работу и оплату,
    // связанную с сверхурочной работой.
    //Работа с 9 до 5: обычные часы работы После 5 вечера это сверхурочная работа Ваша функция получает массив с 4 значениями:
    //– Начало рабочего дня, в десятичном формате, (24-часовая дневная нотация)
    //– Конец рабочего дня. (Тот же формат)
    //– Почасовая ставка
    // – Множитель сверхурочных работ
    //Ваша функция должна возвращать: $ + заработанные в тот день
    // (округлены до ближайшей сотой)
    class F4 {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int length = 4;//ввод длины массива
            double [] myArray = new double[4];//создание массива с длинной length
            for(int i=0; i<4; i++ ){
                myArray[i] = in.nextDouble();
            }
            //overTime([9, 17, 30, 1.5]) ➞ "$240.00"
            //overTime([16, 18, 30, 1.8]) ➞ "$84.00"

            System.out.println(overTime(myArray));
        }
        public static String overTime(double[] work) {
            double sum = 0;
            if(work[1]<=17) sum += ((work[1]-work[0])*work[2]);
            else sum += ((17-work[0])*work[2]+(work[1]-17)*work[2]*work[3]);
            return ('$' + String.valueOf(sum));
        }

    }
    // 5. Индекс массы тела (ИМТ) определяется путем измерения вашего веса
    // в килограммах и деления на квадрат вашего роста в метрах.
    // Категории ИМТ таковы:
    // Недостаточный вес: <18,5
    // Нормальный вес: 18.5-24.9
    // Избыточный вес: 25 и более Создайте функцию, которая будет принимать вес
    // и рост (в килограммах, фунтах, метрах или дюймах)
    // и возвращать ИМТ и связанную с ним категорию.
    // Округлите ИМТ до ближайшей десятой.
    class F5 {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            String c = in.nextLine();
            String a = in.nextLine();
            System.out.println(BMI(c,a));
        }
        public static String BMI(String weight, String height){
            double weight_num = 0;
            double height_num = 0;
            if(weight.indexOf("pounds")!=-1){//возвращает индекс, под которым символ или строка первый раз появляется в строке;
                //возвращает (-1) если символ или строка не найдены.                фунты
                weight_num = Double.parseDouble(weight.substring(0, weight.indexOf("pounds")))*0.4536;//берет значение от 0 индекса до ключевого слова
            }else{//kilos
                weight_num = Double.parseDouble(weight.substring(0, weight.indexOf("kilos")));//parseDouble возвращает примитивный двойник, содержащий значение строки
            }
            if(height.indexOf("inches")!=-1){
                //дюймы
                height_num = Double.parseDouble(height.substring(0, height.indexOf("inches")))*0.0254;
            }else{//meters
                height_num = Double.parseDouble(height.substring(0, height.indexOf("meters")));
            }
            double mass_index = (weight_num/(height_num*height_num));//*10000;
            if(mass_index<18.5){
                return (String.format("%1$,.1f", mass_index)+" Underweight");
            }else if(mass_index<=24.9){
                return (String.format("%1$,.1f", mass_index)+" Normal Weight");
            }else{
                return (String.format("%1$,.1f", mass_index)+" Overweight");
            }
        }

    }
    // 6. Создайте функцию, которая принимает число и возвращает его
    // мультипликативное постоянство, которое представляет собой количество раз,
    // которое вы должны умножать цифры в num, пока не достигнете одной цифры.
    class F6 {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int a = in.nextInt();
            System.out.println(bugger(a));
        }
        public static int bugger(int num) {
            int kol = 0;
            while (num > 9) {//пока значение двузначное
                int chnum = 1;//произведение
                while (num > 0) {
                    chnum *= (num % 10);//произвдение всех цифр
                    num /= 10;//целочисленное деление
                }
                num = chnum;//num = произвдение всех цифр
                kol++;
            }
            return kol;
        }

    }
    // 7. Напишите функцию, которая преобразует строку в звездную стенографию.
    // Если символ повторяется n раз, преобразуйте его в символ*n.
    class F7 {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            String a = in.nextLine();
            System.out.println(toStarShorthand(a));
        }
        public static String toStarShorthand(String str) {
            int count = 1;
            char let = str.charAt(0);//1 эл.
            String newStr = "";
            for (int i = 1; i < str.length(); i++) {//начинаем с 2 эл.
                if (str.charAt(i) != let) {//проверка на совпадение
                    if (count != 1)//если эл. больше 1
                        newStr += let + "*" + count;
                    else//если эл. 1
                        newStr += let;
                    let = str.charAt(i);//след. эл
                    count = 1;
                }
                else
                    count++;//кол-во совпадающих эл
            }
            if (count != 1)
                newStr += let + "*" + count;
            else
                newStr += let;
            return newStr;
        }

    }

    //8. Создайте функцию, которая возвращает true,
    // если две строки рифмуются, и false в противном случае.
    // Для целей этого упражнения две строки рифмуются,
    // если последнее слово из каждого предложения содержит одни и те же гласные.
    class F8 {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            String a = in.nextLine();
            String b = in.nextLine();
            System.out.println(doesRhyme(a,b));
        }
        public static boolean doesRhyme(String str1, String str2) {
            str1 = str1.substring(str1.lastIndexOf(" ") + 1);//возвращает последнее слово
            str2 = str2.substring(str2.lastIndexOf(" ") + 1);
            //System.out.println(str1);
            String let = "aeiouyAEIOUY";//все гласные
            String res1 = "", res2 = "";
            for (int i = 0; i < str1.length(); i++) {
                //indexOf возвращает индекс, под которым символ или строка первый раз появляется в строке;
                //возвращает (-1) если символ или строка не найдены.
                if (let.indexOf(str1.charAt(i)) != -1)//если есть гласные
                    res1 += str1.charAt(i);//записывает последнюю гласную
            }
            for (int i = 0; i < str2.length(); i++) {
                if (let.indexOf(str2.charAt(i)) != -1)//если есть гласные
                    res2 += str2.charAt(i);//записывает последнюю гласную
            }
            //преобразовывает все гласные в нижний регистр и сравнивает их
            if (res1.toLowerCase().equals(res2.toLowerCase())) return true;
            else
                return false;
        }

    }
    //9. Создайте функцию, которая принимает два целых числа и возвращает true,
    // если число повторяется три раза подряд в любом месте в num1 и то же самое
    // число повторяется два раза подряд в num2.
    class F9 {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            long a = in.nextLong();
            long b = in.nextLong();
            System.out.println(trouble(a,b));
        }
        public static boolean trouble(long a, long b) {
            String aa = Long.toString(a);//перевод long в String
            String bb = Long.toString(b);
            int num = 0;
            for (int i = 0; i < aa.length()-2; i++) {//до длины -2
                if (aa.charAt(i) == aa.charAt(i + 1) && aa.charAt(i) == aa.charAt(i + 2))//если 3 числа совпадают
                    num = aa.charAt(i);


            }
            for (int i = 0; i < bb.length(); i++) {
                if (bb.charAt(i) == num && bb.charAt(i + 1) == num)//если 2 числа совпадают
                    return true;
            }
            return false;
        }

    }
    //10. Предположим, что пара одинаковых символов служит концами книги
    // для всех символов между ними.Напишите функцию,
    // которая возвращает общее количество уникальных символов
    // (книг, так сказать) между всеми парами концов книги.
    class F10 {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            String a = in.nextLine();
            char b = in.nextLine().charAt(0);
            System.out.println(countUniqueBooks(a,b));
        }
    public static int countUniqueBooks(String str, char c){
        HashMap<Character, Integer> values = new HashMap<>();
        boolean start = true;
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == c && start) {//если start=true
                i++;
                while (str.charAt(i) != c){
                    Integer n = values.get(str.charAt(i));//проверка существования значения по ключу
                    if (n == null)//если значений нет - довавить
                        values.put(str.charAt(i), 1);
                    else//если знач. сущ., то добавляем знач в след. ячейку
                        values.put(str.charAt(i), n);
                    i++;
                }
                start = false;
            }
            if (str.charAt(i) == c)
                start = true;
        }
        return values.size();
    }



}

