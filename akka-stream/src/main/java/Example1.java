import akka.NotUsed;
import akka.actor.ActorSystem;
import akka.stream.ActorMaterializer;
import akka.stream.Materializer;
import akka.stream.javadsl.Keep;
import akka.stream.javadsl.RunnableGraph;
import akka.stream.javadsl.Sink;
import akka.stream.javadsl.Source;
import scala.Int;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author jzx
 * @date 2019/05/31 14:54
 * @Description:
 */
public class Example1 {
    static ActorSystem system;
    static Materializer mat;
    public static void  main(String[] argv) throws Exception{
        
        system = ActorSystem.create("FlowDocTest");
        mat = ActorMaterializer.create(system);
        
        final Source<Integer, NotUsed> source =
                Source.from(IntStream.range(1, 100000).boxed().collect(Collectors.toList()));
    
        final Sink<Integer, CompletionStage<Integer>> sink =
                Sink.fold(0, (aggr, next) -> {
//                    System.out.println(next);
                    return  aggr + next;
                });
    
        final RunnableGraph<CompletionStage<Integer>> runnable = source.toMat(sink, Keep.right());
    
        final CompletionStage<Integer> sum = runnable.run(mat);
        System.out.println("计算结果");
        System.out.println(sum.toCompletableFuture().get(1, TimeUnit.SECONDS));
    }

}
