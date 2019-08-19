import akka.actor.AbstractActor;
import akka.actor.Props;
import akka.event.Logging;
import akka.event.LoggingAdapter;

import java.util.Optional;

/**
 * @author jzx
 * @date 2019/05/31 10:09
 * @Description:
 */
public class Device extends AbstractActor {
    
    private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);
    
    
    final String groupId;
    
    final String deviceId;
    
    
    public Device(String groupId, String deviceId) {
        this.groupId = groupId;
        this.deviceId = deviceId;
    }
    
    static Props props(String groupId, String deviceId) {
        return Props.create(Device.class, ()->new Device(groupId,deviceId));
    }
    
    
    public static final class ReadTemperature {
        final long requestId;
        
        public ReadTemperature(long requestId) {
            this.requestId = requestId;
        }
    }
    
    public static final class RespondTemperature {
        final long requestId;
        final Optional<Double> value;
        
        public RespondTemperature(long requestId, Optional<Double> value) {
            this.requestId = requestId;
            this.value = value;
        }
    }
    
    @Override
    public void preStart() {
        log.info("Device actor {}-{} started", groupId, deviceId);
    }
    
    
    @Override
    public void postStop() {
        log.info("Device actor {}-{} stopped", groupId, deviceId);
    }
    
    
    Optional<Double> lastTemperatureReading = Optional.empty();
    
    @Override
    public Receive createReceive() {
        return receiveBuilder()
                       .matchEquals(
                               "WELCOME",
                               f -> {
                                   System.out.println(">>> 发送欢迎请求");
                               })
                       .matchEquals(
                               "HI",
                               f -> {
                                   System.out.println(">>> 收到打招呼");
                               })
                       .match(
                               ReadTemperature.class,
                               r -> {
                                   getSender()
                                           .tell(new RespondTemperature(r.requestId, lastTemperatureReading), getSelf());
                               })
                       .build();
    }
}

