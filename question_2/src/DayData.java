import java.util.ArrayList;
import java.util.Calendar;

public class DayData {

    private ArrayList<Event> eventsData;
    private int dayOfWeek;
    private int year, month, day;

    public DayData(ArrayList<Event> eventsData, int dayOfWeek) {
        this.eventsData = eventsData == null ? new ArrayList<>() : eventsData;
        this.dayOfWeek = dayOfWeek;
    }

    public DayData(ArrayList<Event> eventsData, int dayOfWeek, int year, int month, int day) {
        this.eventsData = eventsData == null ? new ArrayList<>() : eventsData;
        this.dayOfWeek = dayOfWeek;
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public ArrayList<Event> getEventsData(){
        return eventsData;
    }

    public int getDayOfWeek(){
        return dayOfWeek;
    }


    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }
}
