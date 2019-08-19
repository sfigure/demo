import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PersistenceUnit;
import javax.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * @author jzx
 * @date 2019/07/24 19:29
 */

@PersistenceUnit
@Entity
@Table(name = "event")
@Data
//@Cacheable
//@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

}
