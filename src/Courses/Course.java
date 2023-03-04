package Courses;

import java.util.List;

public class Course {
    public int id;
    private String courseName;
    private String courseDescription;
    private int courseDuration;
    private double courseFee;
    private String instructorName;
    private int enrolledBy = 0;
    private List<String> subInstructors;

    public Course(String name, String description, String instructorName, int duration, double fee, List<String> subInstructors) {
        this.courseName = name;
        this.courseDescription = description;
        this.courseDuration = duration;
        this.courseFee = fee;
        this.instructorName = instructorName;
        this.subInstructors = subInstructors; 
    }
    
    public int getId(){
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public int getCourseDuration() {
        return courseDuration;
    }

    public double getCourseFee() {
        return courseFee;
    }

    public void setCourseName(String name) {
        this.courseName = name;
    }

    public void setCourseDescription(String description) {
        this.courseDescription = description;
    }

    public void setCourseDuration(int duration) {
        this.courseDuration = duration;
    }

    public void setCourseFee(double fee) {
        this.courseFee = fee;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public String getSubInstructors() {
        if(subInstructors == null || subInstructors.size() == 0)
            return "   - There are no sub-instructors for this course\n";
        else{
            String si = "";
            for(String ins: subInstructors){
                si += "   - "+ins+"\n";
            }
            return si;
        }
    }

    public void setSubInstructors(List<String> subInstructors) {
        this.subInstructors = subInstructors;
    }
    
    public void addEnrolled(){
        enrolledBy++;
    }
    
    public int getEnrolled(){
        return enrolledBy;
    }

    @Override
    public String toString() {
        return "Course Id: ".toUpperCase() + id + "\n"+
                " - Course Name: " + courseName + "\n"
                + " - Description: " + courseDescription + "\n"
                + " - Duration: " + courseDuration + " hours\n"
                + " - Instructor: " + instructorName+"\n"
                + " - Fee: " + courseFee+"\n"
                + " - Enrolled by: " + enrolledBy+"\n"
                + " - Sub Instructors \n" + getSubInstructors();
    }
}
