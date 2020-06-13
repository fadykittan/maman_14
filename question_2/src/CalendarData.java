import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class CalendarData {

    private static Map<String ,ArrayList<Event>> eventsMap = new HashMap();


    public static Map<Integer,DayData> getMYData(int year, int month){
        month--;
        Map<Integer,DayData> monthData = new HashMap<>();
        Calendar cal = Calendar.getInstance();
        cal.set(year , month , 1);
        for(int i=1 ; i<=cal.getActualMaximum(Calendar.DAY_OF_MONTH) ; i++){
           cal.set(year, month, i);
           int week = cal.get(Calendar.DAY_OF_WEEK);
           ArrayList<Event> eventsData = eventsMap.get(getMapKey(cal));
           DayData dd = new DayData(eventsData,week, year, month + 1, i);
           monthData.put(i,dd);
        }
        return monthData;
    }

    public static ArrayList<Event> saveEvent (String title , String text , int year , int month , int day){
        month--;
        Calendar c = Calendar.getInstance();
        c.set(year,month,day);
        Event e = new Event(title , text);
        ArrayList<Event> events = eventsMap.get(getMapKey(c));
        if (events == null) {
            events = new ArrayList<>();
            events.add(e);
        } else {
            events.add(e);
        }
        eventsMap.put(getMapKey(c),events);
        return events;
    }


    private static String getMapKey(Calendar cal){
        String key = "";
        key = key + cal.get(Calendar.YEAR);
        key = key + (cal.get(Calendar.MONTH) + 1);
        key = key + cal.get(Calendar.DATE);
        return key;
    }

}
