package Courses;

public class BasicCourse extends Course {
    public BasicCourse(String name, String description, int duration, String instructor) {
        super(name, description, instructor, duration, 0, null);
    }
}