import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

public class CacheFileEventLogger extends FileEventLogger {
    private int cacheSize;
    private List<Event> cache;

    CacheFileEventLogger (int cacheSize) {
        super("c:\\log.txt");
        this.cacheSize = cacheSize;
    }

    public void logEvent(Event event) throws IOException {
        cache.add(event);

        if (cache.size() == cacheSize) {
            for (Event e: cache) {
                FileUtils.writeStringToFile(new File(filename), e.toString(), Charset.forName("UTF-8"));
            }
            cache.clear();
        }
    }

    public void destroy () throws IOException{
        if (!cache.isEmpty()) {
            for (Event e: cache) {
                FileUtils.writeStringToFile(new File(filename), e.toString(), Charset.forName("UTF-8"));
            }
        }
    }


}
