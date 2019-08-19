import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * @author jzx
 * @date 2019/07/24 19:10
 * @Description:
 */
public class MainInsert {

  public static void main(String[] argv) throws Exception {

    EntityManagerFactory sessionFactory = Persistence.createEntityManagerFactory( "com.test.demo" );

    EntityManager entityManager = sessionFactory.createEntityManager();

    entityManager.getTransaction().begin();

    int batchSize = 25;
    for ( int i = 0; i < 100; i++ ) {
      if ( i > 0 && i % batchSize == 0 ) {
        //flush a batch of inserts and release memory
        System.out.print("SAVE>>>");
        entityManager.flush();
        entityManager.clear();
      }
      Event event=new Event();
      event.setName(String.valueOf(i));
      entityManager.persist(event);
    }

    entityManager.getTransaction().commit();

  }
}
