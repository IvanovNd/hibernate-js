package js;

import js.hibernate.HibernateUtil;
import js.model.VK;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class AppMain {
    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query select_x_from_datagroup_dp = session.createQuery("select dp from DATAGROUP dp");
        List resultList = select_x_from_datagroup_dp.getResultList();
        session.getTransaction().commit();
//
        Query<VK> from_vk = session.createQuery("from VK vk where vk.id <> 1", VK.class);
        List<VK> vkList = from_vk.getResultList();
        select_x_from_datagroup_dp = session.createQuery("select dp from DATAGROUP dp join dp.vks vk where vk in :vkss and dp.vks.size = :sizeVK ");
        select_x_from_datagroup_dp.setParameter("vkss", vkList);
        select_x_from_datagroup_dp.setParameter("sizeVK", vkList.size());

        resultList = select_x_from_datagroup_dp.getResultList();
        session.getTransaction().commit();
        session.close();
        HibernateUtil.shutdown();
    }
}
