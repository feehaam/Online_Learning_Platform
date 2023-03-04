package Users;

import ContextSingleton.Context;
import Courses.Course;
import UsersFactory.UserType;
import Helpers.Output;

public class Teacher extends User {

    Context context;

    public Teacher(String name, String email, String password) {
        super(name, email, password, UserType.Teacher);
        Output.show("New teacher added", super.toString());
        context = Context.getCourseContext();
    }
    
    @Override
    public boolean addCourse(Course course) {
        try {
            course.setInstructorName(getName());
            course.id = context.getAll().size();
            boolean added = context.add(course);
            if(added) {
                Output.show("New Course added", course);
                return true;
            }
            else return false;
        }
        catch(Exception e){
            return false;
        }
    }

    @Override
    public boolean dropCourse(int id) {
        try {
            Course course = (Course) context.get(id);
            return context.remove(course);
        }
        catch(Exception e){
            return false;
        }
    }

    @Override
    public boolean payment(double balance) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String seePayments() {
        double total = 0;
        String payments = "";
        for(Object o: context.getAll()){
            Course course = (Course) o;
            if(course.getInstructorName().equals(getName())){
                payments += course.getCourseName() + " -> " + (course.getCourseFee() * course.getEnrolled() + "\n");
                total += course.getCourseFee() * course.getEnrolled();
            }
        }
        payments += "Total: "+total+"\n";
        return payments;
    }

    @Override
    public String getCourses() {
        String courses = "";
        for(Object o: context.getAll()){
            Course course = (Course) o;
            if(course.getInstructorName().equals(getName())){
                courses += course.toString();
            }
        }
        return courses;
    }
}
