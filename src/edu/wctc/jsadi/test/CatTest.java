package edu.wctc.jsadi.test;
import edu.wctc.jsadi.Cat;
import org.junit.*;

public class CatTest extends junit.framework.TestCase {
    public CatTest(){}

    Cat cat1, cat2;

    @Before
    public void setUp() throws Exception {
        cat1 = new Cat(1, "Meow");
        cat2 = new Cat(0, "Kitty");
    }

    @After
    public void tearDown() throws Exception {}

    @Test
    public void testGetName() {
        assertEquals(cat1.getName(), "Meow");
        assertNotSame(cat2.getName(), "Meow");
    }

    @Test
    public void testGetMousesKilled() {
        assertEquals(1, cat1.getMousesKilled());
        assertEquals(0, cat2.getMousesKilled());
    }

    @Test
    public void testAddMouse() {
        cat1.addMouse();
        cat2.addMouse();
        assertEquals(2, cat1.getMousesKilled());
        assertEquals(1, cat2.getMousesKilled());
    }

    @Test
    public void testTalk() {
        assertEquals("Meow", cat1.talk());
    }

    @Test
    public void testToString() {
        assertEquals("Cat: " + "name=" + cat2.getName() + " mousesKilled=" + cat2.getMousesKilled(), cat2.toString());
    }
}
