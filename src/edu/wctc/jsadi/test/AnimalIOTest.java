package edu.wctc.jsadi.test;
import edu.wctc.jsadi.AnimalIO;
import org.junit.*;

public class AnimalIOTest extends junit.framework.TestCase {
    AnimalIO converter;
    String testString;

    @Before
    public void setUp() throws Exception {
        converter = new AnimalIO();
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
}
