package com.company;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение с римскими или арабскими числами, до 10-ти. Примеры:\n1+6\nV/III");
        String str = scanner.nextLine();
        String op = checkOp(str);
        String[] arr = checkArr(str);
        Boolean numRom = compArr(arr);
        String show = start(op, arr, numRom);
        System.out.println(show);
    }

    public static String checkOp(String n) {

        String a = "";

        if (n.contains(".") || n.contains(",")) {
            System.out.println("Пожалуйста, используйте выражение с целыми числами.");
            System.exit(0);
        }
        if(n.contains("*") ){
            a = "*";
        }else if(n.contains("+")){
            a = "+";
        }else if(n.contains("/")){
            a = "/";
        }else if(n.contains("-")){
            a = "-";
        }else{
            System.out.println("Пожалуйста, используйте корректный математический оператор.");
            System.exit(0);
        }

        return a;
    }
    public static String[] checkArr(String n){
        n = n.replaceAll(" ", "");
        String[] arr = n.replaceAll("[\\+\\-\\*\\/]", " ").split(" ");
        if(arr.length != 2 ){
            System.out.println("Пожалуйста, используйте калькулятор как в указанном примере.");
            System.exit(0);
        }
        return arr;
    }
    public static Boolean compArr(String[] n){

        String[] arr = {"I","II","III","IV","V","VI","VII","VIII","IX","X"};

        for (String y : arr) {
            for (String s : n) {
                if (y.equals(s)) {
                    return false;
                }
            }
        }
        return true;
    }


    public static String start(String a, String[] arr, Boolean b) {
        String[] arabianArr = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};

        int x, y, z;
        if(b){
            x = Integer.parseInt(arr[0]);
            y = Integer.parseInt(arr[1]);
        }
        else {
            x = arrabianNum(arr[0]) + 1;
            y = arrabianNum(arr[1]) + 1;
        }
        if (x>10 || y> 10){
            System.out.println("Пожалуйста, придерживайтесь указанного диапазона.");
            System.exit(0);
        }
        switch (a) {
            case "*":
                z = x * y;
                break;
            case "+":
                z = x + y;
                break;
            case "/":
                z = x / y;
                break;
            default:
                z = x - y;
                break;
        }
        if(b){
            return Integer.toString(z);
        }
        else{
            return arabianArr[z-1];
        }
    }

    public static int arrabianNum(String a) {
        String[] arabianArr = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};

        for (int i = 0; i < arabianArr.length; i++) {
            if (Objects.equals(arabianArr[i], a)) {
                return i;
            }
        }
        return 0;
    }
}