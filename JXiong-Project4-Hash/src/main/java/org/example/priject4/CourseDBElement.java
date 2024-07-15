/*
 * Student name: Jordan Xiong
 * Class: CMSC204 (CRN 40439)
 * Instructor: Gary Thai
 * Platform/compiler: IntellJ
 *
 */
package org.example.priject4;

public class CourseDBElement implements Comparable<CourseDBElement>{
    private int numCredits;
    private String roomNum;
    private String instructor;
    private String id;
    private int crn;


    public CourseDBElement() {
        id = "";
        crn = 0;
        numCredits = 0;
        roomNum = "";
        instructor = "";
    }

    public CourseDBElement(String id, int crn, int numCredits, String roomNum, String instructor) {
        this.id = id;
        this.crn = crn;

        this.numCredits = numCredits;
        this.roomNum = roomNum;

        this.instructor = instructor;
    }

    @Override
    public int compareTo(CourseDBElement other) {



        return Integer.compare(this.crn, other.crn);
    }
    /**
     * Gets current CRN
     * @return crn
     */
    public int getCRN() {
        return crn;
    }
    /**
     * Sets CRN
     * @param crn
     */
    public void setCRN(int crn) {
        this.crn = crn;
    }
    /**
     * @return str.hashCode()
     */
    @Override
    public int hashCode() {
        String str = crn
                + "";
        return str.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null)
            return false;


        if (getClass() != obj.getClass())
            return false;
        CourseDBElement other =
                (CourseDBElement) obj;
        if (crn != other.crn)
            return false;
        return true;
    }

    @Override
    public String toString() {
        String str = "\nCourse:" +
                id + " CRN:" + crn + " Credits:" + numCredits + " Instructor:" + instructor + " Room:" + roomNum;
        return str;
    }

    public String getID() {
        return id;
    }


    public String getRoomNum() {
        return roomNum;
    }

}