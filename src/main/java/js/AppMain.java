package js;

import js.hibernate.HibernateUtil;
import org.hibernate.Session;

public class AppMain {
    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        System.out.println("Work");
        session.getTransaction().commit();
        session.close();
        HibernateUtil.shutdown();
    }
}
