package main;

import dao.ICourseDao;
import dao.CourseDao;
import model.Course;

public class App {
    public static void main(String[] args) {
        
        ICourseDao courseDao = new CourseDao();

        courseDao.saveCourse(new Course("Computer Science", "CS001", 90000.0));
        
        System.out.println("Total courses: " + courseDao.getCourseCount());
        
        CourseDao course  = new CourseDao();
//        IDepartmentDao department = new DepartmentDao();
        
        
    }
}