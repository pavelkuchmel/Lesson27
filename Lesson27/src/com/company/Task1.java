package com.company;


import java.util.ArrayList;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        ArrayList<String> array = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        int answer = 0;
        while (true){
            printMenu();
            answer = in.nextInt();
            if (choise(answer, array)) break;
            System.out.println();
        }
    }
    static void printMenu(){
        System.out.print("Выберите действие:\n" +
                "1. Добавить элемент в список.\n" +
                "2. Удалить элемент из списка.\n" +
                "3. Показать содержимое списка.\n" +
                "4. Проверить есть ли значение в списке.\n" +
                "5. Заменить значение в списке.\n" +
                "9. Выход.\n"+
                "Введите номер выбранного пункта: ");
    }
    static boolean choise(int answer, ArrayList<String> array) {
        Scanner in = new Scanner(System.in);
        switch (answer) {
            case 1:
                case1(array);
                break;
            case 2:
                case2(array);
                break;
            case 3:
                case3(array);
                break;
            case 4:
                case4(array);
                break;
            case 5:
                case5(array);
                break;
            default:
                return true;
        }
        return false;
    }
    static void case1(ArrayList<String> array){
        Scanner in = new Scanner(System.in);
        System.out.print("Введите текст: ");
        array.add(in.nextLine());
    }
    static void case2(ArrayList<String> array){
        Scanner snr = new Scanner(System.in);
        System.out.print("Введите номер стоки из списка: ");
        int numElement = snr.nextInt();
        System.out.print("Выбранная строка: \"" + array.get(numElement) + "\"\nУдалить стороку? Y - да, все остальное - нет: ");
        String a = snr.nextLine();
        String b = snr.nextLine();
        System.out.println("test");
        if (a.equals("Y")) array.remove(numElement);
    }
    static void case3(ArrayList<String> array){
        System.out.println("Содержимое: ");
        for (String n : array) {
            System.out.println(n);
        }
    }
    static void case4(ArrayList<String> array){
        Scanner in = new Scanner(System.in);
        if (array.contains(in.nextLine())) System.out.println("Такая строка есть");
        else System.out.println("Такой строки нет");
    }
    static void case5(ArrayList<String> array){
        Scanner in = new Scanner(System.in);
        System.out.print("Введите номер стоки из списка: ");
        int numElementSecond = in.nextInt();
        try {
            System.out.print("Выбранная строка: \"" + array.get(numElementSecond) + "\"\nВведите новый текст: ");
            array.add(numElementSecond, in.nextLine());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
