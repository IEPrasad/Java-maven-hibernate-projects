package dao;

import model.Course;
import util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

// implementation 
public class CourseDao implements ICourseDao {
    
    @Override
    public void saveCourse(Course course) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(course);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCourse(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Course course = session.get(Course.class, id);
            if (course != null) {
                session.remove(course);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public List<Course> getCoursesBelowPrice(double maxPrice) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Course where fee <= :price", Course.class)
                          .setParameter("price", maxPrice)
                          .list();
        }
    }

    @Override
    public Long getCourseCount() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("select count(id) from Course", Long.class).uniqueResult();
        }
    }
}