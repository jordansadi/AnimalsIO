package edu.wctc.jsadi.test;
import edu.wctc.jsadi.FileInput;
import edu.wctc.jsadi.FileOutput;
import org.junit.*;

public class FileOutputTest extends junit.framework.TestCase {
    public FileOutputTest(){}
    FileOutput testFile = new FileOutput("testFile");

    @Before
    public void setUp() throws Exception {}

    @After
    public void tearDown() throws Exception {}

    @Test
    public void testFileWrite() {
        testFile.fileWrite("Will it work?");
        testFile.fileClose();
        FileInput testRead = new FileInput("testFile");
        assertEquals("Will it work?", testRead.fileReadLine());
    }

    @Test
    public void testFileCLose() {
        testFile.fileClose();
        testFile.fileWrite("This should not work");
        FileInput testRead = new FileInput("testFile");
        assertNotSame("This should not work", testRead.fileReadLine());
    }
}
