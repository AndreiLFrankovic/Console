package Hangman;


import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Hangman
    {
    
    

public static void main(String[] args) {
        String[] words = 
        {
            "apple",
            "banana",
            "chair",
            "horse",
            "planet",
        };
        Random random = new Random();
        int wordIndex = random.nextInt(words.length);
        String hangword = words[wordIndex];
        System.out.println(hangword);
    }
}