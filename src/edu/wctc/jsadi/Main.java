package edu.wctc.jsadi;

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
        AnimalIO addAnimal = new AnimalIO();

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
                            zoo.add(addAnimal.addCat());
                            keepGoing = false;
                            break;
                        case 'D':
                            zoo.add(addAnimal.addDog());
                            keepGoing = false;
                            break;
                        case 'S':
                            zoo.add(addAnimal.addStudent());
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
}
