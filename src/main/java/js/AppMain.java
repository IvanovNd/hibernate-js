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
        Query<VK> from_vk = session.createQuery("from VK vk where vk.id <> 4", VK.class);
        List<VK> vkList = from_vk.getResultList();
        select_x_from_datagroup_dp = session.createQuery(
                "select dp " +
                        "from DATAGROUP dp  " +
                        "where :sizeVK = (" +
                        "select count(dpSize.id) " +
                        "       from DATAGROUP dpSize" +
                        "       join dpSize.vks vk" +
                        "       where dpSize = dp " +
                        "       and vk in :vkss" +
                        ")"
        );
        select_x_from_datagroup_dp.setParameter("vkss", vkList);
        select_x_from_datagroup_dp.setParameter("sizeVK", (long) vkList.size());

        resultList = select_x_from_datagroup_dp.getResultList();
        session.getTransaction().commit();
        session.close();
        HibernateUtil.shutdown();
    }
}
