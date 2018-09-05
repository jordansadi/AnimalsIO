package edu.wctc.jsadi.test;
import edu.wctc.jsadi.Student;
import org.junit.*;

public class StudentTest extends junit.framework.TestCase {
    public StudentTest(){}

    Student student1;

    @Before
    public void setUp() throws Exception {
        student1 = new Student(28, "Jordan");
    }

    @After
    public void tearDown() throws Exception {}

    @Test
    public void testGetName() {
        assertEquals(student1.getName(), "Jordan");
        assertNotSame(student1.getName(), "Nadroj");
    }

    @Test
    public void testSetName() {
        student1.setName("Nadroj");
        assertEquals(student1.getName(), "Nadroj");
        assertNotSame(student1.getName(), "Jordan");
    }

    @Test
    public void testGetAge() {
        assertEquals(28, student1.getAge());
    }

    @Test
    public void testSetAge() {
        student1.setAge(29);
        assertEquals(29, student1.getAge());
    }

    @Test
    public void testTalk() {
        assertEquals("Can we talk about my grade.", student1.talk());
    }
}
