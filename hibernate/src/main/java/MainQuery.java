import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author jzx
 * @date 2019/07/24 19:10
 * @Description:
 */
public class MainQuery {

  public static void main(String[] argv) throws Exception {

    EntityManagerFactory sessionFactory = Persistence.createEntityManagerFactory( "com.test.demo" );

    EntityManager entityManager = sessionFactory.createEntityManager();

    entityManager.getTransaction().begin();

    Event event=entityManager.find(Event.class,1);

    Event event1=entityManager.find(Event.class,1);
    System.out.print(event);

    entityManager.getTransaction().commit();

  }
}
