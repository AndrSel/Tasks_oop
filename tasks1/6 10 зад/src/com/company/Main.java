package com.company;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}



class f1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        System.out.println(bell(a));
    }
    /*1. Число Белла - это количество способов, которыми массив из n элементов может
    быть разбит на непустые подмножества. Создайте функцию, которая принимает
    число n и возвращает соответствующее число Белла.*/

    public static int bell(int num) {
        int[][] mass = new int[num + 1][num + 1];//создаем массив
        int sum = 0;//переменная для суммы
        mass[0][0] = 1;
        mass[num][num] = 1;
        for (int n = 1; n <= num; n++) {//перебор массива
            for (int i = 1; i < num; i++) {
                mass[n][i] = mass[n - 1][i - 1] + i * mass[n - 1][i];//формула
                //System.out.println(mass[n][i]);
            }
        }
        for (int i = 0; i <= num; i++) sum += mass[num][i];//сумма
        return sum;
    }

}
class f2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        String b = in.nextLine();
        System.out.println(translateWord(a));

        System.out.println(translateSentence(b));
        //flag
//I like to eat honey waffles.
    }
    /* 2. В «поаросячей лтыни» (свинский латинский) есть два очень простых правила:
            – Если слово начинается с согласного, переместите первую букву (буквы) слова до
    гласного до конца слова и добавьте «ay» в конец.*/

    public static String translateWord(String word) {
        if (word.matches("[aeiouy]")) {//если 1 гласная
            word += "yay";
        } else {
            //System.out.println(word);
            //System.out.println(word.split("[aeiouy]")[0]);
            String newWord = word.split("[aeiouy]")[0];//первая согл. буква
            word = word.replaceFirst(newWord, "") + newWord + "ay";//replaceFirst() — заменяет первую подстроку данной строки, которая соответствует заданному регулярному выражению, с данной заменой
        }
        return word;
    }

    public static String translateSentence(String word) {
        String vow = "aeiouyAEIOUY";//все гласные
        String[] newword = word.substring(0, word.length() - 1).split(" ");//разбиваем предложение по словам
        word = "";
        for (String s : newword) {
            for (int j = 0; j < vow.length(); j++) {
                if (vow.indexOf(s.charAt(j)) != -1) {//если гл.
                    word += s + "yay ";
                    break;
                } else {//если согл.
                    String newWord = s.split("[aeiyouAEIYOU]")[0];//первая согл. буква
                    word += s.replaceFirst(newWord, "") + newWord + "ay ";//алгоритм из задания
                    break;
                }
            }
        }
        return word + ".";
    }

}
class f3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        System.out.println(validColor(a));
        //rgba(0,0,0,0.123456789)
        //rgb(0,0,0)
        //rgb(255,256,255)
        //rgb(0, ,0)
        //rgb(0,,0)
    }
    /* 3. Учитывая параметры RGB (A) CSS, определите, является ли формат принимаемых
    значений допустимым или нет. Создайте функцию, которая принимает строку
            (например, " rgb(0, 0, 0)") и возвращает true, если ее формат правильный, в
    противном случае возвращает false.*/

    public static boolean validColor(String rgb) {
        int num = rgb.indexOf('(');//
        if (rgb.contains(" ")||rgb.contains(",,"))//Java String contains()- метод чтобы проверить, содержит ли String указанную последовательность символов
            return false;
        String[] newrgb = rgb.substring(rgb.indexOf('(') + 1, rgb.indexOf(')')).split(",");//запись цифр в скобках
        double[] n = new double[num];
        for (int i = 0; i < num; i++) {
            n[i] = Double.parseDouble(newrgb[i]);//parseDouble возвращает примитивный двойник, содержащий значение строки
        }
        for (int i = 0; i < num; i++) {
            return n[i] >= 0 && n[i] < 255 && num == newrgb.length;
        }
        return false;
    }

}
class f4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        String b = in.nextLine();
        System.out.println(stripUrlParams(a));
        System.out.println(stripUrlParams(a,b));
//https://edabit.com?a=1&b=2&a=2 b
//https://edabit.com?a=1&b=2&a=2 _
    }
    /* 4. Создайте функцию, которая принимает URL (строку), удаляет дублирующиеся
    параметры запроса и параметры, указанные во втором аргументе (который будет
    необязательным массивом).*/

    public static String stripUrlParams(String url, String... paramsToStrip) {
        String str = "";
        if (!url.contains("?"))//Java String contains()- метод чтобы проверить, содержит ли String указанную последовательность символов
            return url;
        else {
            str = url.substring(url.indexOf("?") + 1);//обрезаем ссылку после ?
            url = url.substring(0, url.indexOf("?") + 1);//до ?
        }
        char[] params = str.toCharArray();//разбивает по 1 знаку
// расширяемую строку, которую можно изменять без ущерба для производительности
        StringBuilder print = new StringBuilder();
        for (char param : params) {//перебор массива
            if (Character.isLetter(param))//Character.isLetter() — в Java определяет, является ли указанное значение типа char буквой
                if (!(print.toString().contains(String.valueOf(param)))) {//проверка на совпадение эл.
                    if (paramsToStrip.length > 0) {//если введен paramsToStrip
                        for (String arg : paramsToStrip) {
                            if (!(arg.contains(String.valueOf(param))))//если встречается эл, совпадающий с paramsToStrip
                                //append() — обновляет значение объекта, который вызвал метод
                                print.append(str.substring(str.lastIndexOf(param), str.lastIndexOf(param) + 3)).append("&");//обновление строки
                        }
                    } else
                        print.append(str.substring(str.lastIndexOf(param), str.lastIndexOf(param) + 3)).append("&");//обновление строки без paramsToStrip
                }
        }
        return url + print.substring(0, print.length() - 1);//вывод
    }
}


class f5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        System.out.println(getHashTags(a));
        //How the Avocado Became the Fruit of the Global Trade
        //Why You Will Probably Pay More for Your Christmas Tree This Year
    }
    /* 5. Напишите функцию, которая извлекает три самых длинных слова из заголовка
    газеты и преобразует их в хэштеги. Если несколько слов одинаковой длины,
    найдите слово, которое встречается первым.*/

    public static String getHashTags(String str) {
        String[] hashtags = new String[]{" ", " ", " "};// hashtags
        // расширяемую строку, которую можно изменять без ущерба для производительности
        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {//пребор предложения
            if (str.charAt(i) != ' ')
                buf.append(str.charAt(i));//добавляем слово
            else if (buf.length() > hashtags[0].length()) {
                hashtags[0] = buf.toString();//самое длинное слово
                buf = new StringBuilder();//"обнуляем" переменную
                i = 0;
            }
            else if (buf.length() > hashtags[1].length() & buf.length() != hashtags[0].length()) {
                hashtags[1] = buf.toString();//2 слово
                buf = new StringBuilder();
                i=0;
            } else if (buf.length() > hashtags[2].length()& buf.length() != hashtags[0].length()& buf.length() != hashtags[1].length()) {
                hashtags[2] = buf.toString();//3 слово
                buf = new StringBuilder();
                i=0;
            } else
                buf = new StringBuilder();
        }
        for (int i = 0; i < hashtags.length; i++) {
            hashtags[i] = "#" + hashtags[i].toLowerCase();
        }
        return Arrays.toString(hashtags);
    }

}
class f6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        System.out.println(ulma(a));
        //206
        //4
    }
    /* 6.Создайте функцию, которая принимает число n и возвращает n-е число в
    последовательности Улама.*/

    public static int ulma(int n) {
        int[] mas = new int[n];//массив int длиной n
        mas[0] = 1;//первые два числа
        mas[1] = 2;
        int len = 2, next = 3;
        while (next < Integer.MAX_VALUE && len < n) {//пока next<макс знач в типе int и len<аргумента
            int count = 0;
            for (int i = 0; i < len; i++) {//перебор
                for (int j = len - 1; j > i; j--) {
                    if (mas[i] + mas[j] == next && mas[i] != mas[j])//если числа разные и сумма этих двух знач = след знач
                        count++;
                    else if (count > 1)
                        break;
                }
                if (count > 1)
                    break;
            }
            if (count == 1) {
                mas[len] = next;//новое число
                len++;//увеличение длины
            }
            next++;//некст постепенно увеличивается
        }
        return mas[n - 1];//вывод
    }

}
class f7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        System.out.println(longestNonrepeatingSubstring(a));
        //abcabcbb
        //aaaaaa
        //abcda
    }
    /* 7. Напишите функцию, которая возвращает самую длинную неповторяющуюся
    подстроку для строкового ввода.*/

    public static String longestNonrepeatingSubstring(String str) {
        String podstr = "";
        char[] mass = str.toCharArray();//массив эл.
        // расширяемую строку, которую можно изменять без ущерба для производительности
        StringBuilder strBuilder = new StringBuilder();
        for (char c : mass) {//перебо массива
            if (!strBuilder.toString().contains(String.valueOf(c)))//проверка на совпадение
                strBuilder.append(c);//обновление strBuilder
            else {
                if (strBuilder.length() > podstr.length())
                    podstr = strBuilder.toString();//ниходим самую длинную неповторяющуюся подстроку
                strBuilder = new StringBuilder("" + c);
            }
        }
        str = strBuilder.toString();//вывод самой длинной неповторяющейся подстроки
        if (str.length() > podstr.length())
            podstr = str;
        return podstr;
    }

}
class f8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        System.out.println(convertToRoman(a));
        //2
        //12
    }
    /* 8. Создайте функцию, которая принимает арабское число и преобразует его в римское
    число. */
    //1 = I. 2 = II. 3 = III. 4 = IV. 5 = V. 6 = VI. 7 = VII. 8 = VIII. 9 = IX. 10 = X. 20 = XX. ...
    //100 = C. 200 = CC. 300 = CCC. 400 = CD. 500 = D. 600 = DC. 700 = DCC. 800 = DCCC. 900 = CM. 1 000 = M
    public static String convertToRoman(int num) {
        StringBuilder roman = new StringBuilder();
        if (num < 1 || num > 3999)
            return "Введите число поменьше. ";
        while (num >= 1000) {
            roman.append("M");//обновление roman
            num -= 1000;
        }
        while (num >= 900) {
            roman.append("CM");
            num -= 900;
        }
        while (num >= 500) {
            roman.append("D");
            num -= 500;
        }
        while (num >= 400) {
            roman.append("CD");
            num -= 400;
        }
        while (num >= 100) {
            roman.append("C");
            num -= 100;
        }
        while (num >= 90) {
            roman.append("XC");
            num -= 90;
        }
        while (num >= 50) {
            roman.append("L");
            num -= 50;
        }
        while (num >= 40) {
            roman.append("XL");
            num -= 40;
        }
        while (num >= 10) {
            roman.append("X");
            num -= 10;
        }
        while (num >= 9) {
            roman.append("IX");
            num -= 9;
        }
        while (num >= 5) {
            roman.append("V");
            num -= 5;
        }
        while (num >= 4) {
            roman.append("IV");
            num -= 4;
        }
        while (num >= 1) {
            roman.append("I");
            num -= 1;
        }
        return roman.toString();
    }

}
class f9 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        System.out.println(formula(a));
        //6 * 4 = 24
        //18 / 17 = 2
    }
    /* 9. Создайте функцию, которая принимает строку и возвращает true или false в
    зависимости от того, является ли формула правильной или нет. */

    public static boolean formula(String formula) {
        String[] mass = formula.split(" ");//массив с эл.
        int ans = 0;
        int expectedResult = 0;
        if (!Character.isDigit(mass[0].charAt(0))) return false;//Метод Character.isDigit() — определяет, является ли указанное значение типа char цифрой
        else ans = Integer.parseInt(mass[0]);//Метод parseInt() — в Java используется для получения примитивного типа данных определенной строки, другими словами — преобразует строку в число
        int i = 1;
        while (!mass[i].equals("=")) {//пока не встретит =
            if (mass[i].equals("+")) {//"+"
                ans += Integer.parseInt(mass[i + 1]);
            }
            if (mass[i].equals("-")) {//"-"
                ans -= Integer.parseInt(mass[i + 1]);
            }
            if (mass[i].equals("*")) {//"*"
                ans *= Integer.parseInt(mass[i + 1]);
            }
            if (mass[i].equals("/")) {//"/"
                ans /= Integer.parseInt(mass[i + 1]);
            }
            i=i+2;
        }
        i = formula.indexOf('=');// i присваивается "="
        String check = formula.substring(i + 1, formula.length());//знач. после "="
        if (check.contains("=")) return false;
        else expectedResult = Integer.parseInt(mass[mass.length - 1]);//последнее знач.
        return ans == expectedResult;//проверка
    }

}
class f10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        System.out.println(palindromedescendant(a));
        //11211230
        //13001120
    }
    /* 10. Число может не быть палиндромом, но его потомком может быть. Прямой потомок
    числа создается путем суммирования каждой пары соседних цифр, чтобы создать
    цифры следующего числа.*/

    //Числа-палиндромы — числа, которые в определённой позиционной системе исчисления
    //читаются одинаково как справа налево, так и слева направо

    public static boolean palindromedescendant(int num){
        boolean bul = false;
        // расширяемую строку, которую можно изменять без ущерба для производительности
        StringBuffer nuum =new StringBuffer(num);
        StringBuffer nuuum =new StringBuffer(num);
        if (nuum.length()%2!=0)//проверка
            return false;
        else{
            while (!bul){
                if(nuum != nuum.reverse()){//переворот знач.
                    for(int i=0; i<nuum.length();i=i+2){//перебор
                        int a = Integer.parseInt(String.valueOf(nuum.charAt(i)));//Метод parseInt() — в Java используется для получения
                        // примитивного типа данных определенной строки, другими словами — преобразует строку в число

                        int b = Integer.parseInt(String.valueOf(nuum.charAt(i+1)));

                        nuuum.append(a+b);//конечный вывод
                    }
                }
                else//как только читаются одинаково
                    bul = true;
            }
        }
        return bul;
    }
}
