import akka.actor.ActorRef;
import akka.actor.ActorSystem;

/**
 * @author jzx
 * @date 2019/05/31 10:00
 * @Description:
 */
public class Main {
    
    public static void main(String[] args) throws Exception {
        ActorSystem system = ActorSystem.create("demoActor");
        ActorRef SupervisorActorRef = system.actorOf(SupervisorActorRefActor.props("group","device"), "supervisor-actor");
        
        
        SupervisorActorRef.tell("FirstActor", ActorRef.noSender());
        SupervisorActorRef.tell("SecondActor", ActorRef.noSender());
        ActorRef deviceTag = system.actorOf(Device.props("1","1_0001"),"device1");
        SupervisorActorRef.tell("JOIN", deviceTag);
        SupervisorActorRef.tell("SayHi", ActorRef.noSender());
    }
}
