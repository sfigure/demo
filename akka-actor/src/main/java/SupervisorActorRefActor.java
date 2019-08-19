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
public class SupervisorActorRefActor extends AbstractActor {
    
    private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);
    
    
    static Props props(String group,String deviceId) {
        return Props.create(SupervisorActorRefActor.class, SupervisorActorRefActor::new);
    }
    
    @Override
    public void preStart() {
        log.info("start");
    }
    
    
    @Override
    public void postStop() {
        log.info("stop");
    }
    
    ActorRef firstRef = getContext().actorOf(FirstActorRefActor.props(), "first-actor");
    ActorRef secondRef = getContext().actorOf(SecondActorRefActor.props(), "second-actor");
    
    @Override
    public Receive createReceive() {
        return receiveBuilder()
                       .matchEquals(
                        "FirstActor",
                        f -> {
                            firstRef.tell("hi", ActorRef.noSender());
                        })
                       .matchEquals(
                               "SecondActor",
                               f -> {
                                 
                                   secondRef.tell("hi", ActorRef.noSender());
                               })
                       .matchEquals(
                               "Stop",
                               f -> {
                                   firstRef.tell("Stop", this.sender());
                                   secondRef.tell("stop", this.sender());
                               })
                       .matchEquals(
                               "StopAll",
                               f -> {
                                   System.out.println("我是管理员收到 stopAll消息");
                                   getContext().stop(getSelf());
                               })
                       .matchEquals(
                               "JOIN",
                               f -> {
                                   System.out.println("发送欢迎请求 >>>");
                                   getSender().tell("WELCOME",this.sender());
    
                                   getContext().getSystem().actorFor("/user/device1").tell("HI",ActorRef.noSender());
                               })
                       .matchAny(f -> {
                           System.out.println("match Any");
                       })
                       .build();
    }
}
