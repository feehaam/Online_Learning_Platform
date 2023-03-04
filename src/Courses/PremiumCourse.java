package Courses;

import java.util.List;

public class PremiumCourse extends Course {
    public PremiumCourse(String name, String description, int duration, String instructor, double fee, List<String> subInstructors) {
        super(name, description, instructor, duration, fee, subInstructors);
    }
}