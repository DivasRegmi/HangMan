package com.example.test;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Enter a hidden code: ");
        Scanner scanner = new Scanner(System.in);
        String hiddenCOde = scanner.nextLine();
        hiddenCOde = hiddenCOde.toUpperCase();
        int length = hiddenCOde.length();
        char[] charSet = hiddenCOde.toCharArray();

        char[] charGuess = new char[length];

        for(int i=0; i<length; i++){
            charGuess[i] = '*';
        }

        int cout = 0;
        while(true){
            System.out.println(charGuess);
            System.out.println("Make your guess");
            String guess = scanner.nextLine();

            if(findGuess(charSet, guess)){
                int index;
                for(int j = 0; j<length;j++){
                    if(charSet[j] == guess.toUpperCase().charAt(0)){
                        charGuess[j] = guess.toUpperCase().charAt(0);
                    }
                }
            }else{
                cout++;
                System.out.println("Wrong guess");
                System.out.println("you have only " + (3-cout) + " Lives");
            }

            if(! findGuess(charGuess, "*")){
                System.out.println("You won the game");
                break;
            }

            if(cout == 3){
                break;
            }


        }


    }

    private static boolean  findGuess(char[] charsSet,String guess){
        for(int i = 0; i <charsSet.length; i++){
            if(charsSet[i] == guess.toUpperCase().charAt(0)){
                return true;
            }


        }
        return false;
    }


}
