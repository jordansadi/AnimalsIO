package edu.wctc.jsadi;

/**
 * This class defines a Student, which is a type of Person
 * Created by mgreen14 on 12/27/17.
 * @author Matt Green
 * @version 2018 0822 .3
 */
public class Student extends Person implements Talkable {
    private int age;

    /**
     * The Student constructor inherits from the Person class
     * Each student is initialized with their name and age
     * @param age the age of the Student
     * @param name the name of the Student
     * @return instance of the Student class
     */
    public Student(int age, String name) {
        super(name);
        this.age = age;
    }

    /**
     * This method returns the age of the Student
     * @return int indicating the age of the Student
     */
    public int getAge() {
        return age;
    }

    /**
     * This method sets the age of the Student to the specified value
     * @param age the new age of the Student
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * This method inherits from the Talkable interface
     * @return string indicating what the student says
     */
    @Override
    public String talk() {
        return "Can we talk about my grade.";
    }
}
