import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author jzx
 * @date 2019/05/31 14:38
 * @Description:
 */
public class Tweet {
    public final Author author;
    public final long timestamp;
    public final String body;
    
    public Tweet(Author author, long timestamp, String body) {
        this.author = author;
        this.timestamp = timestamp;
        this.body = body;
    }
    
    public Set<Hashtag> hashtags() {
        return Arrays.asList(body.split(" "))
                       .stream()
                       .filter(a -> a.startsWith("#"))
                       .map(a -> new Hashtag(a))
                       .collect(Collectors.toSet());
    }
    
    // ...
    // #model
    
    @Override
    public String toString() {
        return "Tweet(" + author + "," + timestamp + "," + body + ")";
    }
    
    // #model
}
