package edu.wctc.jsadi.test;
import edu.wctc.jsadi.*;
import org.junit.*;

import java.util.ArrayList;

public class MainTest extends junit.framework.TestCase {
    public MainTest(){}

    FileOutput outFile;
    FileInput inFile;
    Cat meow;
    Dog woof;
    Student jordan;

    @Before
    public void setUp() throws Exception {
        outFile = new FileOutput("testFile.txt");
        inFile = new FileInput("testFile.txt");
        meow = new Cat(1, "kitty");
        woof = new Dog(true, "puppy");
        jordan = new Student(28, "Jordan");
    }

    @After
    public void tearDown() throws Exception {
        outFile.fileClose();
        inFile.fileClose();
    }

    @Test
    public void testPrintOut() {
        outFile.fileWrite(meow.getName() + "|" + meow.talk());
        outFile.fileClose();
        assertEquals("kitty|Meow", inFile.fileReadLine());
        assertEquals("kitty says=Meow", meow.getName() + " says=" + meow.talk());
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
