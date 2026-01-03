package dao;

import model.Course;
import java.util.List;

public interface ICourseDao {
    void saveCourse(Course course);
    void deleteCourse(int id);
    List<Course> getCoursesBelowPrice(double maxPrice);
    Long getCourseCount();
}