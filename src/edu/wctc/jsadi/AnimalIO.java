package edu.wctc.jsadi;

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
    public int convertToInt(String input) {
        int output = 0;
        output = Integer.parseInt(input);
        return output;
    }

    /**
     * This method converts a specified String to a boolean
     * @param input the String that is to be converted
     * @return boolean converted from the input String
     */
    public boolean convertToBoolean(String input) {
        boolean output = false;
        if (input.toLowerCase().equals("true"))
            output = true;
        return output;
    }
}