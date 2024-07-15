/*
 * Student name: Jordan Xiong
 * Class: CMSC204 (CRN 40439)
 * Instructor: Gary Thai
 * Platform/compiler: IntellJ
 *
 */
package org.example.priject4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import java.util.ArrayList;
import java.util.Scanner;

public class CourseDBManager implements CourseDBManagerInterface {
    private CourseDBStructure CDS;

    public CourseDBManager() {
        // Initialize CourseDBStructure with an estimated size for testing purposes
        CDS = new CourseDBStructure("Testing", 20);
    }

    @Override
    public void add(String id, int crn, int credits, String roomNum, String instructor) {
        CourseDBElement newElement = new CourseDBElement(id, crn, credits, roomNum, instructor);
        CDS.add(newElement);
    }

    @Override
    public CourseDBElement get(int crn) {
        try {
            return CDS.get(crn);
        } catch (IOException e) {
            e.getMessage();
        }
        return null;
    }

    @Override
    public void readFile(File input) throws FileNotFoundException {
        try {
            Scanner fileData = new Scanner(input);
            while (fileData.hasNextLine()) {


                String line = fileData.nextLine().trim();

                // Ignore comments and blank lines
                if (line.isEmpty() || line.startsWith("#")) {
                    continue;
                }

                // Split the line into parts
                String[] parts = line.split("\\s+");

                // Validate entry
                if (parts.length < 5) {
                    System.out.println("Invalid entry: " + line);
                    continue;
                }

                String id = parts[0];

                String crnString = parts[1];
                String creditsString = parts[2];
                String roomNum = parts[3];

                String instructor = String.join(" ", parts).substring(
                        line.indexOf(parts[4])

                );

                // Validate CRN and credits
                try {
                    int crn = Integer.parseInt(crnString);
                    int credits = Integer.parseInt(creditsString);



                    if (credits <= 0 || credits > 5) {
                        throw new NumberFormatException("Invalid credit hours");
                    }

                    add(id, crn, credits, roomNum, instructor);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid entry: " + line);
                }
            }
            fileData.close();
        } catch (FileNotFoundException e) {


            System.out.println("File not found");
            e.getMessage();
        }
    }

    @Override
    public ArrayList<String> showAll() {


        return CDS.showAll();
    }
}