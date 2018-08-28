package edu.wctc.jsadi.test;
import edu.wctc.jsadi.Cat;
import edu.wctc.jsadi.FileInput;
import edu.wctc.jsadi.FileOutput;
import org.junit.*;
import edu.wctc.jsadi.Main;

public class MainTest extends junit.framework.TestCase {
    public MainTest(){}

    @Before
    public void setUp() throws Exception {}

    @After
    public void tearDown() throws Exception {}

    FileOutput outFile = new FileOutput("testFile");
    FileInput inFile = new FileInput("testFile");
    Cat meow = new Cat(1, "kitty");

    @Test
    public void testPrintOut() {
        outFile.fileWrite(meow.getName() + "|" + meow.talk());
        outFile.fileClose();
        assertEquals("kitty|Meow", inFile.fileReadLine());
        assertEquals("kitty says=Meow", meow.getName() + " says=" + meow.talk());
    }
}
