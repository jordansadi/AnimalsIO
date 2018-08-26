package edu.wctc.jsadi;

/**
 * Created by mgreen14 on 12/27/17.
 * @author Matt Green
 * @version 2018 0822 .3
 */
public abstract class Pet {
    protected String name;
    public Pet(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}