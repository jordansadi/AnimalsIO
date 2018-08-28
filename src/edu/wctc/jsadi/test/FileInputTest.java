package edu.wctc.jsadi.test;
import edu.wctc.jsadi.FileInput;
import edu.wctc.jsadi.FileOutput;
import org.junit.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileInputTest extends junit.framework.TestCase {
    public FileInputTest(){}
    FileInput testFile = new FileInput("testFile");

    @Before
    public void setUp() throws Exception {}

    @After
    public void tearDown() throws Exception {}

    @Test
    public void testFileRead() {
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader("testFile"));
        } catch (FileNotFoundException e) {
            System.out.println("File Open Error: " + "testFile" + " " + e);
        }
        FileOutput outFile = new FileOutput("testFile");
        outFile.fileWrite("testing...");
        outFile.fileClose();
        String line;
        int counter = 0;
        try {
            while ((line = in.readLine()) != null) {
                counter++;
            }
        } catch (Exception e) {
            System.out.println("File Write Error: " + "testFile" + " " + e);
        }
        assertEquals(1, counter);
    }

    @Test
    public void testFileReadLine() {
        FileOutput outFile = new FileOutput("testFile");
        outFile.fileWrite("testing...");
        outFile.fileClose();
        assertEquals("testing...", testFile.fileReadLine());
    }

    @Test
    public void testFileClose() {
        FileOutput outFile = new FileOutput("testFile");
        outFile.fileWrite("testing...");
        testFile.fileClose();
        assertNotSame("testing...", testFile.fileReadLine());
    }
}
