package dao;

import java.util.List;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Student;
import util.HibernateUtil;



public class StudentDao implements IStudentDao {
	
	// save student
	// get All Students 
	// get Student By Id
	// Update Student 
	// Delete Student 
	
	@Override 
	public void saveStudent(Student student) {
		
		Transaction transaction = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start the transaction 
			transaction = session.beginTransaction();
			
			// save student object 
			session.save(student);
			
			// commit the transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}
	
	@Override 
	public void updateStudent(Student student) {
		
		Transaction transaction = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start the transaction  
			transaction = session.beginTransaction();
			
			// save student object
			session.saveOrUpdate(student);
			
			// commit the transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}	
	}
	
	@Override 
	public Student getStudentById(long id) {
		
		Transaction transaction = null;
		
		Student student = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start the transaction
			transaction = session.beginTransaction();
			
			// get student object 
			student = session.get(Student.class, id);
			//student = session.load(student.class, id);
			
			// commit the transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
		return student;
	}
	
	@Override 
	@SuppressWarnings("unchecked")
	public List < Student > getAllStudents() {
		
		Transaction transaction = null;
		List < Student > students = new ArrayList<>();
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start the transaction 
			transaction  = session.beginTransaction();
			
			// get students 
			students = session.createQuery("from Student", Student.class).list();
			// student = session.load(Student.class, id);
			
			// commit the transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
		return students;
	}
	
	@Override 
	public void deleteStudent(long id) {
		
		Transaction transaction = null;
		Student student = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start the session 
			transaction = session.beginTransaction();
			
			student = session.get(Student.class, id);
			// get student object 
			session.delete(student);
			// student = session.load(Student.class, id);
			
			// commit the transaction 
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}
}
