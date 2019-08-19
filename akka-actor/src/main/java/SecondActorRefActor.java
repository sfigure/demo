import akka.actor.AbstractActor;
import akka.actor.Props;
import akka.event.Logging;
import akka.event.LoggingAdapter;

/**
 * @author jzx
 * @date 2019/05/31 10:16
 * @Description:
 */
public class SecondActorRefActor extends AbstractActor {
    private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);
    
    static Props props() {
        return Props.create(SecondActorRefActor.class, SecondActorRefActor::new);
    }
    
    @Override
    public void preStart() {
        log.info("second started");
    }
    
    @Override
    public void postStop() {
        log.info("second stopped");
    }
    
    @Override
    public Receive createReceive() {
        return receiveBuilder()
                       .matchAny(f -> {
                           log.info("我是2号 我收到了未捕捉的消息");
                       })
                       .build();
    }
}
