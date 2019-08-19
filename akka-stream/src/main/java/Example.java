import akka.NotUsed;
import akka.actor.ActorSystem;
import akka.stream.ActorMaterializer;
import akka.stream.Materializer;
import akka.stream.javadsl.Sink;
import akka.stream.javadsl.Source;

import java.util.Arrays;

/**
 * @author jzx
 * @date 2019/05/31 14:54
 * @Description:
 */
public class Example {
    public static final Hashtag AKKA = new Hashtag("#akka");
    
    public static  void main(String[] argv) {
        Source<Tweet, NotUsed> tweets =
                Source.from(
                        Arrays.asList(
                                new Tweet[]{
                                        new Tweet(new Author("rolandkuhn"), System.currentTimeMillis(), "#akka rocks!"),
                                        new Tweet(new Author("patriknw"), System.currentTimeMillis(), "#akka !"),
                                        new Tweet(new Author("bantonsson"), System.currentTimeMillis(), "#akka !"),
                                        new Tweet(new Author("drewhk"), System.currentTimeMillis(), "#akka !"),
                                        new Tweet(
                                                new Author("ktosopl"), System.currentTimeMillis(), "#akka on the rocks!"),
                                        new Tweet(new Author("mmartynas"), System.currentTimeMillis(), "wow #akka !"),
                                        new Tweet(new Author("akkateam"), System.currentTimeMillis(), "#akka rocks!"),
                                        new Tweet(new Author("bananaman"), System.currentTimeMillis(), "#bananas rock!"),
                                        new Tweet(new Author("appleman"), System.currentTimeMillis(), "#apples rock!"),
                                        new Tweet(
                                                new Author("drama"),
                                                System.currentTimeMillis(),
                                                "we compared #apples to #oranges!")
                                }));
        
        
        final ActorSystem system = ActorSystem.create("reactive-tweets");
        final Materializer mat = ActorMaterializer.create(system);
        final Source<Author, NotUsed> authors = tweets.filter(t -> t.hashtags().contains(AKKA)).map(t -> t.author);
        
        System.out.println("运行到这里了");
        
        authors.runWith(Sink.foreach(a -> System.out.println(a)), mat);
        authors.runForeach(a -> System.out.println(a), mat);
    }
}
