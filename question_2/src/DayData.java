import java.util.ArrayList;
import java.util.Calendar;

public class DayData {

    private ArrayList<Event> eventsData;
    private int dayOfWeek;

    public DayData(ArrayList<Event> eventsData, int dayOfWeek) {
        this.eventsData = eventsData;
        this.dayOfWeek = dayOfWeek;
    }

    public ArrayList<Event> getEventsData(){
        return eventsData;
    }

    public int getDayOfWeek(){
        return dayOfWeek;
    }
}
