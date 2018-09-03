package edu.wctc.jsadi.test;
import edu.wctc.jsadi.*;
import org.junit.*;

import java.util.ArrayList;

public class MainTest extends junit.framework.TestCase {
    public MainTest(){}

    FileOutput outFile;
    FileInput inFile;
    Cat meow;

    @Before
    public void setUp() throws Exception {
        outFile = new FileOutput("testFile.txt");
        inFile = new FileInput("testFile.txt");
        meow = new Cat(1, "kitty");
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
}
