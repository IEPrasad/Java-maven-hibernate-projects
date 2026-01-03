//package dao;
//
//import org.hibernate.Session;
//import org.hibernate.Transaction;
//
//import model.*;
//import util.HibernateUtil;
//
//public class DepartmentDao {
//	
//	@Override 
//	public void saveDepartment () {
//        Transaction transaction = null;
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            transaction = session.beginTransaction();
//            session.persist(course);
//            transaction.commit();
//        } catch (Exception e) {
//            if (transaction != null) transaction.rollback();
//            e.printStackTrace();
//        }
//    }
//	
//}
