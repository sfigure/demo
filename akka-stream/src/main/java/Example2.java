import akka.NotUsed;
import akka.actor.ActorSystem;
import akka.stream.ActorMaterializer;
import akka.stream.Materializer;
import akka.stream.javadsl.Keep;
import akka.stream.javadsl.RunnableGraph;
import akka.stream.javadsl.Sink;
import akka.stream.javadsl.Source;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author jzx
 * @date 2019/05/31 14:54
 * @Description:
 */
public class Example2 {
    static ActorSystem system;
    static Materializer mat;
    
    public static void main(String[] argv) throws Exception {
//        system = ActorSystem.create("FlowDocTest");
//        mat = ActorMaterializer.create(system);
    
        final Source<Integer, NotUsed> source =
                Source.from(Arrays.asList(1, 2, 3, 4)).map(elem -> elem * 2);
        source.to(Sink.foreach(System.out::println));
        System.out.println(source);
    }
    
}
