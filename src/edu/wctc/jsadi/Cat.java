package edu.wctc.jsadi;

/**
 * This class defines a Cat, which is a type of Pet
 * Created by mgreen14 on 12/27/17.
 * @author Matt Green
 * @version 2018 0822 .3
 */
public class Cat extends Pet implements Talkable {
    private int mousesKilled;

    /**
     * The Cat constructor initializes the number of mice killed by the Cat and the name of the Cat
     * @param mousesKilled number of mice killed by the Cat
     * @param name the name of the Cat
     * @return instance of the Cat class
     */
    public Cat(int mousesKilled, String name) {
        super(name);
        this.mousesKilled = mousesKilled;
    }

    /**
     * This method returns the number of mice killed by the cat
     * @return int number of mice killed
     */
    public int getMousesKilled() {
        return mousesKilled;
    }

    /**
     * This method increments the number of mice killed by the cat
     */
    public void addMouse() {
        mousesKilled++;
    }

    /**
     * This method is inherited from the Talkable interface
     * @return string indicating what the dog says
     */
    @Override
    public String talk() {
        return "Meow";
    }

    /**
     * This method is inherited from the Talkable interface
     * @return string indicating the name of the cat and how many mice it has killed
     */
    @Override
    public String toString() {
        return "Cat: " + "name=" + name + " mousesKilled=" + mousesKilled;
    }
}

