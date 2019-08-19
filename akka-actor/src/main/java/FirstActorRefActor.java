import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.event.Logging;
import akka.event.LoggingAdapter;

/**
 * @author jzx
 * @date 2019/05/31 10:09
 * @Description:
 */
public class FirstActorRefActor extends AbstractActor {
    private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);
    
    static Props props() {
        return Props.create(FirstActorRefActor.class, FirstActorRefActor::new);
    }
    
    @Override
    public void preStart() {
        log.info("first started");
    }
    
    
    @Override
    public void postStop() {
        log.info("first stopped");
    }
    
    
    @Override
    public Receive createReceive() {
        return receiveBuilder()
                       .matchAny(f->{
                           log.info("我是1号 我收到了未捕捉的消息");
                       })
                       .build();
    }
}
