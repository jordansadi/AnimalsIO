package edu.wctc.jsadi.test;
import edu.wctc.jsadi.AnimalIO;
import edu.wctc.jsadi.Cat;
import edu.wctc.jsadi.Dog;
import edu.wctc.jsadi.Student;
import org.junit.*;

import java.util.ArrayList;

public class AnimalIOTest extends junit.framework.TestCase {
    AnimalIO converter;
    String testString;
    Cat meow;
    Dog woof;
    Student jordan;

    @Before
    public void setUp() throws Exception {
        converter = new AnimalIO();
        meow = new Cat(1, "kitty");
        woof = new Dog(true, "puppy");
        jordan = new Student(28, "Jordan");
    }

    @After
    public void tearDown() throws Exception {}

    @Test
    public void testConvertToInt() {
        testString = "28";
        assertEquals(converter.convertToInt(testString), 28);
    }

    @Test
    public void testConvertToBoolean() {
        testString = "true";
        assertTrue(converter.convertToBoolean(testString));
        testString = "FALSE";
        assertFalse(converter.convertToBoolean(testString));
    }

    @Test
    public void testAddCat() {
        ArrayList<Cat> cats = new ArrayList<>();
        cats.add(new Cat(1, "kitty"));
        assertEquals(cats.get(0).getName(), meow.getName());
        assertEquals(cats.get(0).getMousesKilled(), meow.getMousesKilled());
    }

    @Test
    public void testAddDog() {
        ArrayList<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog(true, "puppy"));
        assertEquals(dogs.get(0).getName(), woof.getName());
        assertEquals(dogs.get(0).isFriendly(), woof.isFriendly());
    }

    @Test
    public void testAddStudent() {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(28, "Jordan"));
        assertEquals(students.get(0).getAge(), jordan.getAge());
        assertEquals(students.get(0).getName(), jordan.getName());
    }
}
