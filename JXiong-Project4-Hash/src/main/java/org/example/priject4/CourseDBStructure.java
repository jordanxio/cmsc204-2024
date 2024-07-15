/*
 * Student name: Jordan Xiong
 * Class: CMSC204 (CRN 40439)
 * Instructor: Gary Thai
 * Platform/compiler: IntellJ
 *
 */
package org.example.priject4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class CourseDBStructure implements CourseDBStructureInterface {

    protected int size;

    protected LinkedList<CourseDBElement> hashTable[];

    //
    @SuppressWarnings("unchecked")
    public CourseDBStructure(int size) {
        this.size = getNextPrime(size);
        hashTable = new LinkedList[this.size];
    }


    @SuppressWarnings("unchecked")
    public CourseDBStructure(String testing, int size) {
        this.size = size;

        hashTable = new LinkedList[this.size];
    }

    private int getNextPrime(int n) {
        double loadFactor = 1.5;
        int target = (int) Math.ceil(n / loadFactor);
        while (!isPrime(target)) {
            target++;
        }
        return target;
    }


    private boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        if (num <= 3) {
            return true;
        }
        if (num % 2 == 0 || num % 3 == 0) {
            return false;
        }
        int i = 5;
        while (i * i <= num) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
            i += 6;
        }
        return true;
    }

    /**
     * takes a given CourseDBElement object and adds it into the hashtable
     * @param element The CourseDBElement to add
     */
    @Override
    public void add(CourseDBElement element) {
        int index = Math.abs(element.hashCode()) % size;
        if (hashTable[index] == null) {
            hashTable[index] = new LinkedList<>();
        }
        // Check for duplicates before adding
        for (CourseDBElement e : hashTable[index]) {
            if (e.getCRN() == element.getCRN()) {
                return; // Ignore duplicate entry
            }
        }
        hashTable[index].add(element);
    }


    @Override
    public CourseDBElement get(int crn) throws IOException {
        int index = Math.abs(Integer.toString(crn).hashCode()) % size;
        if (hashTable[index] == null) {
            throw new IOException("Course not found");
        } else {
            for (CourseDBElement element : hashTable[index]) {
                if (element.getCRN() == crn) {
                    return element;
                }
            }
            throw new IOException("Course not found");
        }
    }

    /**
     * @return ArrayList of String representations of all courses
     */
    @Override
    public ArrayList<String> showAll() {

        ArrayList<String> allCourses = new ArrayList<>();
        for (LinkedList<CourseDBElement> list : hashTable) {


            if (list != null) {


                for (CourseDBElement element : list) {
                    allCourses.add(element.toString());
                }
            }
        }
        return allCourses;
    }


    @Override
    public int getTableSize() {


        return size;

    }
}
