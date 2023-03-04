package Helpers;

import Courses.BasicCourse;
import Courses.Course;
import Courses.PremiumCourse;
import Users.User;
import UsersFactory.UserFactory;
import UsersFactory.UserType;
import java.util.ArrayList;
import java.util.List;

public class Initials {

    public static void setup() {

        Output.show("\n\n------------------INITIAL SETUP & TESTS----------------------\n", "");

        // Create the sub-instructor names with Bangladeshi names
        List<String> subInstructors1 = new ArrayList<>();
        subInstructors1.add("Mahmuda Rahman");
        subInstructors1.add("Zeneva Shewly");

        List<String> subInstructors2 = new ArrayList<>();
        subInstructors2.add("Tariqul Islam");
        subInstructors2.add("Nazia Ahmed");

        List<String> subInstructors3 = new ArrayList<>();
        subInstructors3.add("Fatima Ahmed");
        subInstructors3.add("Kamal Hossain");

        List<String> subInstructors4 = new ArrayList<>();
        subInstructors4.add("Naima Akhter");
        subInstructors4.add("Arif Hossain");

        List<String> subInstructors5 = new ArrayList<>();
        subInstructors5.add("Raisa Islam");
        subInstructors5.add("Rezaul Karim");

        // Create the teacher users
        User teacher1 = UserFactory.createUser("Matheus Solutionless", "matheus@green.edu", "matheus", UserType.Teacher);
        User teacher2 = UserFactory.createUser("Albert Newton", "albert@green.edu", "albert", UserType.Teacher);
        User teacher3 = UserFactory.createUser("Max Hawkings", "max@green.edu", "max", UserType.Teacher);
        User teacher4 = UserFactory.createUser("Dominic Torrato", "dominic@green.edu", "dominic", UserType.Teacher);
        User teacher5 = UserFactory.createUser("Stacker Overflower", "stacker@green.edu", "stacker", UserType.Teacher);

        // Create the courses
        Course course1 = new PremiumCourse("Math Fundamentals", "Learn the basics of math", 10, "", 5000, subInstructors1);
        Course course2 = new PremiumCourse("Calculus", "Learn calculus", 20, "", 8000, subInstructors1);
        Course course3 = new PremiumCourse("Theoretical Physics", "Explore the world of theoretical physics", 25, "", 10000, subInstructors2);
        Course course4 = new PremiumCourse("Quantum Physics 101", "Introduction to quantum physics", 15, "", 7000, subInstructors3);
        Course course5 = new PremiumCourse("Space & Time 101", "Explore space and time", 12, "", 6000, subInstructors3);
        Course course6 = new PremiumCourse("Philosophy 101: The Family", "An introduction to philosophical concepts related to the family", 8, "", 4000, subInstructors4);
        Course course7 = new PremiumCourse("Philosophy", "An introduction to philosophy", 15, "", 7500, subInstructors4);
        Course course8 = new PremiumCourse("C Programming", "Learn C programming", 30, "", 12000, subInstructors5);
        Course course9 = new PremiumCourse("Java", "Learn Java programming", 25, "", 10000, subInstructors5);
        Course course10 = new PremiumCourse("Operating System", "Introduction to Operating System", 20, "", 8000, subInstructors5);

        // Add the courses to the teacher users
        teacher1.addCourse(course1);
        teacher1.addCourse(course2);
        teacher2.addCourse(course3);
        teacher3.addCourse(course4);
        teacher3.addCourse(course5);
        teacher4.addCourse(course6);
        teacher4.addCourse(course7);
        teacher5.addCourse(course8);
        teacher5.addCourse(course9);
        teacher5.addCourse(course10);

        // Create the free courses and assign the same instructors as the related premium courses
        Course freeCourse1 = new BasicCourse("Math for Beginners", "Learn the basics of math for free", 5, "");
        teacher1.addCourse(freeCourse1);

        Course freeCourse3 = new BasicCourse("Theoretical Physics for Beginners", "Explore the world of theoretical physics for free", 10, "");
        teacher2.addCourse(freeCourse3);

        Course freeCourse4 = new BasicCourse("Introduction to Quantum Mechanics", "Introduction to quantum mechanics for free", 6, "");
        teacher3.addCourse(freeCourse4);

        Course freeCourse5 = new BasicCourse("Introduction to Space Exploration", "Introduction to space exploration for free", 10, "");
        teacher3.addCourse(freeCourse5);

        Course freeCourse6 = new BasicCourse("Introduction to Time Travel", "Introduction to time travel for free", 6, "");
        teacher3.addCourse(freeCourse6);

        Course freeCourse8 = new BasicCourse("Introduction to Ethics", "Introduction to ethics for free", 6, "");
        teacher4.addCourse(freeCourse8);

        Course freeCourse9 = new BasicCourse("C for Newbies", "Introduction to C programming for free", 8, "");
        teacher5.addCourse(freeCourse9);

        Course freeCourse10 = new BasicCourse("Java for Newbies", "Introduction to Java programming for free", 10, "");
        teacher5.addCourse(freeCourse10);

        teacher1.dropCourse(10);
        Output.show("Courses conducted by teacher 1", teacher1.getCourses());
        teacher1.addCourse(freeCourse1);

        // Create student 1
        User student1 = UserFactory.createUser("Muhammad Feeham", "mdfeeham@gmail.com", "feeham", UserType.Student);
        student1.addCourse(course1);
        student1.addCourse(freeCourse3);
        student1.addCourse(freeCourse4);
        student1.payment(22000);
        student1.addCourse(course9);
        // Create student 2
        User student2 = UserFactory.createUser("Susmita Debnath", "debnath@gmail.com", "debnath", UserType.Student);
        student2.addCourse(course1);
        student2.addCourse(course2);
        student2.addCourse(course3);
        student2.addCourse(course5);
        student2.addCourse(freeCourse1);
        student2.addCourse(freeCourse5);
        student2.payment(38000);

        // Create student 3
        User student3 = UserFactory.createUser("Mehrab Tanim", "tanim@yahoo.com", "tanim", UserType.Student);
        student3.addCourse(course1);
        student3.addCourse(course4);
        student3.addCourse(freeCourse4);
        student3.addCourse(freeCourse3);

        // Create student 4
        User student4 = UserFactory.createUser("Tahiya Akter", "akter@gmail.com", "akter", UserType.Student);
        student4.addCourse(course2);
        student4.addCourse(course3);
        student4.addCourse(freeCourse4);
        student4.addCourse(freeCourse5);
        student4.payment(13000);
        student4.payment(16000);
        student4.addCourse(course4);

        // Create student 5
        User student5 = UserFactory.createUser("AR Samrat", "samrat@yahoo.com", "samrat", UserType.Student);
        student5.addCourse(course1);
        student5.addCourse(course3);
        student5.payment(10000);
        student5.payment(12000);
        student5.addCourse(course4);
        student5.addCourse(course5);

        // Create student 6
        User student6 = UserFactory.createUser("MH Shuvo", "shuvo@gmail.com", "shuvo", UserType.Student);
        student6.addCourse(course1);
        student6.addCourse(course5);
        student6.addCourse(freeCourse1);
        student6.addCourse(freeCourse5);
        student6.payment(25000);

        // Create student 7
        User student7 = UserFactory.createUser("HH Shovon", "shovon@yahoo.com", "shovon", UserType.Student);
        student7.addCourse(course2);
        student7.addCourse(course3);
        student7.addCourse(freeCourse1);
        student7.addCourse(freeCourse3);

        // Create student 8
        User student8 = UserFactory.createUser("Anjuman Akter", "anjuman@gmail.com", "anjuman", UserType.Student);
        student8.addCourse(course2);
        student8.addCourse(freeCourse1);
        student8.addCourse(freeCourse3);
        student8.addCourse(freeCourse5);

        // Create student 9
        User student9 = UserFactory.createUser("Iffat Jahan", "jahan@yahoo.com", "jahan", UserType.Student);
        student9.addCourse(course1);
        student9.addCourse(course3);
        student9.addCourse(course5);
        student9.addCourse(freeCourse3);
        student9.addCourse(freeCourse4);

        // Create student 10
        User student10 = UserFactory.createUser("Azim Khan", "khan@gmail.com", "khan", UserType.Student);
        student10.addCourse(course2);
        student10.addCourse(course4);
        student10.addCourse(freeCourse1);
        student10.addCourse(freeCourse4);
        student10.payment(18000);
        
        Output.show("Incomplete payments", student1.seePayments());
        Output.show("All courses", student1.getCourses());

        student1.dropCourse(11);
        Output.show("All courses", student1.getCourses());

        Output.show("Teacher 1 payment", teacher1.seePayments());
        Output.show("Teacher 2 payment", teacher2.seePayments());
        Output.show("Teacher 3 payment", teacher3.seePayments());

        Output.show("\n\n-----------------INITIALS COMPLETE------------------\n", "");

        Output.print = true;
    }
}

/*

TEACHERS
- Email: matheus@green.edu, Password: matheus
- Email: albert@green.edu, Password: albert
- Email: max@green.edu, Password: max
- Email: dominic@green.edu, Password: dominic
- Email: stacker@green.edu, Password: stacker

STUDENTS
- Email: mdfeeham@gmail.com, Password: feeham
- Email: debnath@gmail.com, Password: debnath
- Email: tanim@yahoo.com, Password: tanim
- Email: akter@gmail.com, Password: akter
- Email: samrat@yahoo.com, Password: samrat
- Email: shuvo@gmail.com, Password: shuvo
- Email: shovon@yahoo.com, Password: shovon
- Email: anjuman@gmail.com, Password: anjuman
- Email: jahan@yahoo.com, Password: jahan
- Email: khan@gmail.com, Password: khan

*/
