package edu.wctc.jsadi;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This is the driver class for the Animals package
 * Created by mgreen14 on 12/27/17.
 * @author Matt Green
 * @version 2018 0822 .3
 */
public class Main {

    private final static FileOutput outFile = new FileOutput("animals.txt");
    private final static FileInput inFile = new FileInput("animals.txt");
    public static void main(String[] args) {
        ArrayList<Talkable> zoo = new ArrayList<>();
        boolean keepGoing = true;
        String userInput;
        Scanner k = new Scanner(System.in);
        while(true) {
            System.out.println("Do you want to add something to the zoo (Y/N)?");
            userInput = k.nextLine();
            if (userInput.toUpperCase().charAt(0) == 'N') {
                break;
            }
            else {
                keepGoing = true;
                while(keepGoing) {
                    System.out.println("Enter C to add a Cat, D to add a Dog, or S to add a Student:");
                    userInput = k.nextLine();
                    switch (userInput.toUpperCase().charAt(0)) {
                        case 'C':
                            zoo.add(addCat());
                            keepGoing = false;
                            break;
                        case 'D':
                            zoo.add(addDog());
                            keepGoing = false;
                            break;
                        case 'S':
                            zoo.add(addStudent());
                            keepGoing = false;
                            break;
                        default:
                            System.out.println("Please enter a valid character.");
                    }
                }
            }
        }

        for (Talkable thing: zoo) {
            printOut(thing);
        }
        outFile.fileClose();
        inFile.fileRead();
        inFile.fileClose();
        FileInput indata = new FileInput("animals.txt");
        String line;
        while ((line = indata.fileReadLine()) != null) {
            System.out.println(line);
        }
    }

    /**
     * This method prints the name of a Talkable object and what that object says
     * @param p the Talkable whose information will be printed
     */
    public static void printOut(Talkable p)  {
        System.out.println(p.getName() + " says=" + p.talk());
        outFile.fileWrite(p.getName() + "|" + p.talk());
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
        AnimalIO converter = new AnimalIO();
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
                mice = converter.convertToInt(inStream.readLine());
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
        AnimalIO converter = new AnimalIO();
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
                    friendly = converter.convertToBoolean(userInput);
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

        AnimalIO converter = new AnimalIO();
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
                age = converter.convertToInt(inStream.readLine());
                keepGoing = true;
            } catch (Exception e) {
                System.out.println("You must enter an integer.");
            }
        }

        return new Student(age, name);
    }
}
