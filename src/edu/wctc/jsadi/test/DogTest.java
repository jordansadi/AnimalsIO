package edu.wctc.jsadi.test;
import edu.wctc.jsadi.Dog;
import org.junit.*;

public class DogTest extends junit.framework.TestCase {
    public DogTest(){}
    public Dog aDog1;
    public Dog aDog2;

    @Before
    public void setUp() throws Exception {
        aDog1 = new Dog(true, "Fido");
        aDog2 = new Dog(false, "Spot");
    }

    @After
    public void tearDown() throws Exception {}

    @Test
    public void testIsFriendly() {
        assertTrue("The dog is friendly", aDog1.isFriendly());
        assertFalse("The dog is friendly", aDog2.isFriendly());
    }

    @Test
    public void testTalk() {
        assertEquals("Bark", aDog1.talk());
    }

    @Test
    public void testToString() {
        assertEquals("Dog: " + "name=" + aDog2.getName() + " friendly=" + aDog2.isFriendly(), aDog2.toString());
    }
}
