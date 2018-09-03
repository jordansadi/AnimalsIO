package edu.wctc.jsadi;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * This class creates methods for converting a String to an int or a boolean
 * Created by jsadi on 9/1/2018
 * @author Jordan Sadi
 * @version 2018 0822 .3
 */
public class AnimalIO {
    public AnimalIO() {}

    /**
     * This method converts a specified String to an int
     * @param input the String that is to be converted
     * @return int converted from the input String
     */
    public static int convertToInt(String input) {
        int output = 0;
        output = Integer.parseInt(input);
        return output;
    }

    /**
     * This method converts a specified String to a boolean
     * @param input the String that is to be converted
     * @return boolean converted from the input String
     */
    public static boolean convertToBoolean(String input) {
        boolean output = false;
        if (input.toLowerCase().equals("true"))
            output = true;
        return output;
    }

    /**
     * This method returns an instance of the Cat class to add to the Zoo ArrayList
     * @throws Exception if an invalid name or number of mice killed is entered
     * @return instance of the Cat class
     */
    public static Cat addCat() {
        String name = "";
        int mice = 0;
        boolean keepGoing = false;
        BufferedReader inStream = new BufferedReader (new InputStreamReader(System.in));

        System.out.println("What is the name of your cat?");
        try {
            name = inStream.readLine();
        } catch (Exception e) {
            System.out.println("Error: invalid name.");
        }

        while (!keepGoing) {
            System.out.println("How many mice has your cat killed?");
            try {
                mice = convertToInt(inStream.readLine());
                keepGoing = true;
            } catch (Exception e) {
                System.out.println("You must enter an integer.");
            }
        }

        return new Cat(mice, name);
    }

    /**
     * This method returns an instance of the Dog class to add to the Zoo ArrayList
     * @throws Exception if an invalid name or friendliness boolean is entered
     * @return instance of the Dog class
     */
    public static Dog addDog() {
        String name = "", userInput = "";
        boolean friendly = false, keepGoing = false;
        BufferedReader inStream = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("What is the name of your dog?");
        try {
            name = inStream.readLine();
        } catch (Exception e) {
            System.out.println("Error: invalid name.");
        }

        while (!keepGoing) {
            System.out.println("Is your dog friendly? Enter 'true' or 'false'");
            try {
                userInput = inStream.readLine();
                if (userInput.toLowerCase().equals("true") || userInput.toUpperCase().equals("false")) {
                    friendly = convertToBoolean(userInput);
                    keepGoing = true;
                }
            } catch (Exception e) {
                System.out.println("You must enter 'true' or 'false'.");
            }
        }

        return new Dog(friendly, name);
    }

    /**
     * This method returns an instance of the Student class to add to the Zoo ArrayList
     * @throws Exception if an invalid name or age is entered
     * @return instance of the Student class
     */
    public static Student addStudent() {
        String name = "";
        int age = 0;
        boolean keepGoing = false;

        BufferedReader inStream = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("What is the name of your student?");
        try {
            name = inStream.readLine();
        } catch (Exception e) {
            System.out.println("Error: invalid name.");
        }

        while (!keepGoing) {
            System.out.println("How old is your student?");
            try {
                age = convertToInt(inStream.readLine());
                keepGoing = true;
            } catch (Exception e) {
                System.out.println("You must enter an integer.");
            }
        }

        return new Student(age, name);
    }
}