package Users;

import ContextSingleton.Context;
import UsersFactory.UserType;
import Courses.Course;
import java.util.ArrayList;
import java.util.List;
import Helpers.Output;

public class Student extends User {

    Context context;

    private List<Course> enrolledCourses;
    private List<Course> wishlistedCourses;

    public Student(String name, String email, String password) {
        super(name, email, password, UserType.Student);
        Output.show("New student added", super.toString());
        enrolledCourses = new ArrayList<>();
        wishlistedCourses = new ArrayList<>();
        context = Context.getCourseContext();
    }

    @Override
    public boolean addCourse(Course course) {
        try {
            if (course.getCourseFee() == 0) {
                enrolledCourses.add(course);
                Course courseMain = (Course) context.get(course.getId());
                courseMain.addEnrolled();
                Output.show("Enorlled a new course", course);
            } else {
                wishlistedCourses.add(course);
                Output.show("Course wishlisted\nComplete payment to enroll", course);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean payment(double balance) {
        try {
            double total = 0;
            for (Object o : wishlistedCourses) {
                Course c = (Course) o;
                total += c.getCourseFee();
            }
            if (balance >= total) {
                for (Object o : wishlistedCourses) {
                    Course c = (Course) o;
                    enrolledCourses.add(c);
                }
                wishlistedCourses.clear();
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean dropCourse(int id) {
        boolean dropped = false;
        Course course = (Course) context.get(id);
        if (course == null) {
            return false;
        }
        if (enrolledCourses.contains(course)) {
            enrolledCourses.remove(course);
            dropped = true;
        }
        if (wishlistedCourses.contains(course)) {
            wishlistedCourses.remove(course);
            dropped = true;
        }
        return dropped;
    }

    @Override
    public String seePayments() {
        String payments = "";
        for (Course course : wishlistedCourses) {
            payments += course.getCourseName() + " -> " + course.getCourseFee() + "\n";
        }
        return payments;
    }

    @Override
    public String getCourses() {
        String takenCourses = "";
        takenCourses += ">> Enrolled courses: \n" + enrolledCourses.toString() + "\n\n";
        takenCourses += ">> Wishlisted courses: \n" + wishlistedCourses.toString();
        return takenCourses;
    }
}
