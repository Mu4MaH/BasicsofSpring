import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    private Client client;
    private EventLogger eventLogger;

    App (Client client, EventLogger eventLogger){
        super();
        this.client = client;
        this.eventLogger = eventLogger;
    }


    public static void main (String[] args) {

        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        App app = (App) ctx.getBean("app");
        app.logEvent(" Some event for 1");
        app.logEvent("Some event for 2");
        ctx.close();

    }

    private void logEvent (String msg) {
        String message = msg.replaceAll(String.valueOf(client.getId()), client.getFullName());
        //eventLogger.logEvent(message);
    }
}
