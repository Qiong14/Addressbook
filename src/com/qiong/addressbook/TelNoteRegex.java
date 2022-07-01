package com.qiong.addressbook;

import java.util.Scanner;

//校准类
public class TelNoteRegex {

    public static int menuItemValidate(int min, int max){
        String regex = "[1-9]{1}";
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Please enter a number between " + min + " and " + max);
            String input = scanner.nextLine();
            if (input.matches(regex)){
                int inputNum = Integer.parseInt(input);
                if (inputNum >= min && inputNum <= max){
                    return inputNum;
                }else{
                    System.out.println("Invalid number!");
                }
            }else{
                System.out.println("Invalid input!");
            }
        }
    }

    public static String nameValidate(){
        String regex = "[a-zA-Z]{1,20}";
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Please enter the name: ");
            String input = scanner.nextLine();
            if (input.matches(regex)){
                return input;
            }else{
                System.out.println("Invalid input!");
            }
        }

    }

    public static String ageValidate(){
        String regex = "[0-9]{1,2}";
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Please enter the age: ");
            String input = scanner.nextLine();
            if (input.matches(regex)){
                return input;
            }else{
                System.out.println("Invalid input!");
            }
        }
    }

    public static String sexValidate(){
        String regex = "[mMfF]{1}";
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Please enter the sex (M/F): ");
            String input = scanner.nextLine();
            if (input.matches(regex)){
                return input;
            }else{
                System.out.println("Invalid input!");
            }
        }
    }

    public static String telNumValidate(){
        String regex = "\\d{1,11}|";
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Please enter the phone number: ");
            String input = scanner.nextLine();
            if (input.matches(regex)){
                return input;
            }else{
                System.out.println("Invalid input!");
            }
        }
    }

    public static String addressValidate(){
        String regex = "\\w{1,50}";
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Please enter the address: ");
            String input = scanner.nextLine();
            if (input.matches(regex)){
                return input;
            }else{
                System.out.println("Invalid input!");
            }
        }
    }

//    public static void main(String[] args) {
//        TelNoteRegex regex = new TelNoteRegex();
//        String test = regex.nameValidate();
//        System.out.println(test);
//    }

}
