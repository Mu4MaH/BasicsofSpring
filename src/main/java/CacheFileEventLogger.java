import org.apache.commons.io.FileUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

public class CacheFileEventLogger extends FileEventLogger {
    private int cacheSize;
    private List<Event> cache;

    CacheFileEventLogger (int cacheSize) {
        super("c:\\log.txt");
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
//        FileEventLogger fel = (FileEventLogger) ctx.getBean("fileEventLogger");
        this.cacheSize = cacheSize;
    }

    public void logEvent(Event event) throws IOException {
        cache.add(event);

        if (cache.size() == cacheSize) {
            for (Event e: cache) {
                logEvent(e);
            }
            cache.clear();
        }
    }

    public void destroy () throws IOException{
        if (!cache.isEmpty()) {
            for (Event e: cache) {
                logEvent(e);
            }
        }
    }


}
