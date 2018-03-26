import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.commons.io.*;
import sun.text.normalizer.UTF16;

public class FileEventLogger implements EventLogger {
    String filename;
    private File file;

//    FileEventLogger() {
//        //default,doesnthng
//    }


    FileEventLogger (String filename){
        this.filename = filename;
    }

    public void logEvent(Event event) throws IOException{
        FileUtils.writeStringToFile(new File(filename), event.toString(), Charset.forName("UTF-8"));
    }

    private void init() throws IOException{
         this.file = new File(filename);
         file.canWrite();
    }
}

