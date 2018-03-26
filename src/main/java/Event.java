import java.text.DateFormat;
import java.util.Date;
import java.util.Random;

public class Event {
    private int id; //random
    private String msg;
    private Date date;
    private DateFormat df;

    public Event(Date date, DateFormat df) {
        this.date = date;
        this.df = df;
        Random random = new Random();
        id = random.nextInt(100);
    }

    public void setMsg (String s) {
        msg = s;
    }

    public String getMsg () {
        return msg;
    }
@Override
   public String toString () {
        return id + " : " + msg +" : " + df.format(date);
    }
}
