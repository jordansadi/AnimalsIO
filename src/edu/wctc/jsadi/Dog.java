package edu.wctc.jsadi;

/**
 * This class defines a Dog, which is a type of Pet
 * Created by mgreen14 on 12/27/17.
 * @author Matt Green
 * @version 2018 0822 .3
 */
public class Dog extends Pet implements Talkable {
    private boolean friendly;

    /**
     * The Dog constructor initializes the disposition and name of the animal
     * @param friendly an indicator of whether the dog can be approached
     * @param name the name of the dog
     * @return instance of the Dog class
     */
    public Dog(boolean friendly, String name) {
        super(name);
        this.friendly = friendly;
    }

    /**
     * This method returns the disposition of the Dog i.e. whether it is friendly
     * @return boolean indicates whether the Dog is friendly
     */
    public boolean isFriendly() {
        return friendly;
    }

    /**
     * This method is inherited from the Talkable interface
     * @return string indicating what the dog says
     */
    @Override
    public String talk() {
        return "Bark";
    }

    /**
     * This method is inherited from the Talkable interface
     * @return string indicating the name of the dog and whether it is friendly
     */
    @Override
    public String toString() {
        return "Dog: " + "name=" + name + " friendly=" + friendly;
    }


}