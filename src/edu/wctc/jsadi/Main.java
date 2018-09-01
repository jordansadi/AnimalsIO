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

        //Lines to Replace
        zoo.add(addDog());
        zoo.add(addCat());
        zoo.add(addStudent());
        //End Lines to Replace

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
        Scanner k = new Scanner(System.in);
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
                mice = k.nextInt();
                keepGoing = true;
            } catch (Exception e) {
                System.out.println("You must enter an integer.");
                k.next();
            }
        }

        Cat newCat = new Cat(mice, name);
        return newCat;
    }

    /**
     * This method returns an instance of the Dog class to add to the Zoo ArrayList
     * @throws Exception if an invalid name or friendliness boolean is entered
     * @return instance of the Dog class
     */
    public static Dog addDog() {
        String name = "";
        boolean friendly = false, keepGoing = false;
        Scanner k = new Scanner(System.in);
        BufferedReader inStream = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("What is the name of your dog?");
        try {
            name = inStream.readLine();
        } catch (Exception e) {
            System.out.println("Error: invalid name.");
        }

        while (!keepGoing) {
            System.out.println("Is your dog friendly? (true/false)");
            try {
                friendly = k.nextBoolean();
                keepGoing = true;
            } catch (Exception e) {
                System.out.println("You must enter 'true' or 'false'.");
                k.next();
            }
        }

        Dog newDog = new Dog(friendly, name);
        return newDog;
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

        Scanner k = new Scanner(System.in);
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
                age = k.nextInt();
                keepGoing = true;
            } catch (Exception e) {
                System.out.println("You must enter an integer.");
                k.next();
            }
        }

        Student newStudent = new Student(age, name);
        return newStudent;
    }
}
