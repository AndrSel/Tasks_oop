package com.company;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//№ 1
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        func_1(a,b);
        System.out.println("..............................................");
        func_1(1,3);
        func_1(3,4);
        func_1(-9,45);
        func_1(5,5);
    }
    public static void func_1(int x, int y){
        System.out.println("x mod y = " + x % y);
        }
}

//№ 2
class S_TR{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        func_2(a,b);
        System.out.println("..............................................");
        func_2(3,2);
        func_2(7,4);
        func_2(10,10);
    }
    public static void func_2(int a,int b){
        System.out.println("S = " + a*b/2);
    }
}

//№ 3
class Legs{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        func_3(a,b,c);
        System.out.println("..............................................");
        func_3(2,3,5);
        func_3(1,2,3);
        func_3(5,2,8);
    }
    public static void func_3(int chickens, int cows,int pigs){
        chickens *= 2;
        cows *= 4;
        pigs *= 4;
        System.out.println("Sum legs: "+ (chickens + cows + pigs));
    }
}

//№ 4
class prob_prize_pay{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        float a = in.nextFloat();
        int b = in.nextInt();
        int c = in.nextInt();
        func_3(a,b,c);
        System.out.println("..............................................");
        func_3(0.2f,50,9);
        func_3(0.9f,1,2);
        func_3(0.9f,3,2);
    }
    public static void func_3(float prob, int prize,int pay){
        boolean a;
        if (prob*prize>pay) {
            a = true;
        } else a = false;
        System.out.println(a);
    }
}

//№ 5
class Number_5{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        func_4(a,b,c);
        System.out.println("..............................................");
        func_4(24,15,9);
        func_4(24,26,2);
        func_4(15,11,11);
    }
    public static void func_4(int N, int a,int b){
        if (a-b==N || b-a==N)
            System.out.println("subtracted");
        else if (a+b==N)
            System.out.println("added");
        else if (a/b==N || b/a==N)
            System.out.println("divided");
        else if (a*b==N)
            System.out.println("multiplied");
        else System.out.println("none");
    }
}

//№ 6
class Number_6{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        char a = in.next().charAt(0);
        func_6(a);
        System.out.println("..............................................");
        func_6('A');
        func_6('m');
        func_6('[');
        func_6('\\');
    }
    public static void func_6(char ch){
        //int asciiCode = ch;
        int asciiValue = (int)ch;

        //System.out.println("ASCII value of "+ch+" is: " + asciiCode);
        System.out.println("ASCII value of "+ch+" is: " + asciiValue);
    }
}

// № 7
class Number_7 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        func_7(a);
        System.out.println("..............................................");
        func_7((7));
        func_7((10));
        func_7((3));
    }
    public static void func_7(int a) {
        int[] arr= new int [a];
        //int s = list.size()-1;
        int s = 0 ;
        for (int i=1;i<a+1;i++){
            s += i;
            //System.out.print(i+"    ");
            //System.out.println(s);
        }
        System.out.println(s);
        //int s;
        //for (int i=0;i<s;i++){
            //s += list.get(i);
        //}
    }
}

//№ 8
class Number_8{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        func_8(a,b);
        System.out.println("..............................................");
        func_8(8,10);
        func_8(5,7);
        func_8(9,2);
    }
    public static void func_8(int a,int b){
        int c = 0;
        for(int i=0;i<a+b;i++){
            c = i;
        }
        System.out.println(c);
    }
}

//№ 9
class Number_9{
    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        int length = in.nextInt();//ввод длины массива
        int [] myArray = new int[length];//создание массива с длинной length
        for(int i=0; i<length; i++ ){
            myArray[i] = in.nextInt();
        }
        func_9(myArray);
        System.out.println("..............................................");
        int [] arr_1 = {3,4,5};
        func_9(arr_1);
    }
    public static void func_9(int[] arr){
        int sum = 0;
        for(int i=0;i<arr.length;i++){
            sum += arr[i]*arr[i]*arr[i];
        }
        System.out.println(sum);
    }
}

//№ 10
class Number_10{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        func_10(a,b,c);
        System.out.println("..............................................");
        func_10(42,5,10);
        func_10(5,2,1);
        func_10(1,2,3);
    }
    public static void func_10(int a,int b,int c){
        for (int i=0;i<b;i++){
            a+= a;
        }
        if (a % c==0)
            System.out.println("true");
        else System.out.println("false");
        //System.out.println(a);
    }
}