package ContextStrategy;

import Courses.Course;
import java.util.ArrayList;
import java.util.List;

public class CourseContext implements Strategy {

    private List<Object> courses = new ArrayList<>();
    
    @Override 
    public Object get(int id){
        for(Object o: courses){
            Course course = (Course) o;
            if(course.getId() == id) return course;
        }
        return null;
    }

    @Override
    public boolean add(Object o) {
        try {
            Course course = (Course) o;
            courses.add(course);
            return true;
        }
        catch(Exception e) {
            return false;
        }
    }

    @Override
    public boolean remove(Object o) {
        try {
            Course course = (Course) o;
            courses.remove(course);
            return true;
        }
        catch(Exception e) {
            return false;
        }
    }

    @Override
    public List<Object> getAll() {
        return courses;
    }

    @Override
    public boolean update(Object o) {
        try {
            Course course = (Course) o;
            courses.remove(course);
            courses.add(course);
            return true;
        }
        catch(Exception e) {
            return false;
        }
    }
}
