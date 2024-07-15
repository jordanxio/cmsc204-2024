
/*
 * Student name: Jordan Xiong
 * Class: CMSC204 (CRN 40439)
 * Instructor: Gary Thai
 * Platform/compiler: IntellJ
 *
 */
import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.example.priject4.CourseDBManager;
import org.example.priject4.CourseDBManagerInterface;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CourseDBManagerStudentTest {
    private CourseDBManagerInterface dataMgr;

    @Before
    public void setUp() throws Exception {
        dataMgr = new CourseDBManager();
    }

    @After
    public void tearDown() throws Exception {
        dataMgr = null;
    }

    @Test
    public void testAddToDB() {
        try {
            dataMgr.add("CMSC203", 30504, 4, "SC450", "Joey Bag-O-Donuts");
        } catch (Exception e) {
            fail("This should not have caused an Exception");
        }
    }

    @Test
    public void testShowAll() {
        dataMgr.add("CMSC203", 30504, 4, "SC450", "Joey Bag-O-Donuts");
        dataMgr.add("CMSC203", 30503, 4, "SC450", "Jill B. Who-Dunit");
        dataMgr.add("CMSC204", 30559, 4, "SC450", "BillyBob Jones");
        ArrayList<String> list = dataMgr.showAll();
        assertEquals("\nCourse:CMSC203 CRN:30503 Credits:4 Instructor:Jill B. Who-Dunit Room:SC450", list.get(0));
        assertEquals("\nCourse:CMSC203 CRN:30504 Credits:4 Instructor:Joey Bag-O-Donuts Room:SC450", list.get(1));
        assertEquals("\nCourse:CMSC204 CRN:30559 Credits:4 Instructor:BillyBob Jones Room:SC450", list.get(2));
    }

    @Test
    public void testReadFile() {
        try {
            // Create a temporary test file
            File inputFile = new File("Test1.txt");
            PrintWriter inFile = new PrintWriter(inputFile);
            inFile.println("CMSC203 30504 4 SC450 Joey Bag-O-Donuts");
            inFile.println("CMSC204 30503 4 SC450 Jill B. Who-Dunit");
            inFile.println("CMSC204 30503 4 SC450 Jill B. Who-Dunit"); // Duplicate entry
            inFile.println("CMSC100 21556 2 Distance-Learning Janet E. Joy");
            inFile.println("CMSC110 3 SC450 Behzad Maghami"); // Missing CRN, invalid entry
            inFile.println("CMSC110 21561 3 SC451 Rabiha J. Kayed");
            inFile.println("CMSC110 23363 3 SC451 Sascha Simkanich");
            inFile.println("CMSC201 22974 99 Distance-Learning Janet Joy"); // Invalid credit hours
            inFile.close();

            // Read the file
            dataMgr.readFile(inputFile);

            // Check the entries
            assertEquals("CMSC203", dataMgr.get(30504).getID());
            assertEquals("CMSC204", dataMgr.get(30503).getID());
            assertEquals("SC450", dataMgr.get(30503).getRoomNum());

            // Check the size of the course list
            ArrayList<String> list = dataMgr.showAll();
            assertEquals(5, list.size());

            // Clean up the test file
            inputFile.delete();
        } catch (FileNotFoundException e) {
            fail("Should not have thrown an exception");
        } catch (Exception e) {
            fail("Should not have thrown an exception");
        }
    }
}