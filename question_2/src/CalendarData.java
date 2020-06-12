import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class CalendarData {

    private Calendar cal;
    private Map<Calendar,ArrayList<Event>> eventsMap = new HashMap();

    public CalendarData(){
        this.cal = Calendar.getInstance();
    }

    public Map<Integer,DayData> getMYData(int year, int month){
        month--;
        Map<Integer,DayData> monthData = new HashMap<>();
        cal.set(year , month , 1);
        for(int i=1 ; i<=cal.getActualMaximum(Calendar.DAY_OF_MONTH) ; i++){
           cal.set(year, month, i);
           int week = cal.get(Calendar.DAY_OF_WEEK);
           ArrayList<Event> eventsData = eventsMap.get(cal);
           DayData dd = new DayData(eventsData,week);
           monthData.put(i,dd);
        }
        return monthData;
    }

    public void saveEvent (String title , String text , int year , int month , int day){
        Calendar c = Calendar.getInstance();
        c.set(year,month,day);
        Event e = new Event(title , text);
        ArrayList<Event> events = eventsMap.get(c);
        if (events == null) {
            events = new ArrayList<>();
            events.add(e);
        } else {
            events.add(e);
        }
        eventsMap.put(c,events);
    }


}
