import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class CalendarData {

    private Calendar cal;

    public CalendarData(){
        this.cal = Calendar.getInstance();
    }

    public Map<Integer,Integer> getMYData(int year, int month){
        month--;
        Map<Integer,Integer> monthData = new HashMap<>();
        cal.set(year , month , 1);
        for(int i=1 ; i<=cal.getActualMaximum(Calendar.DAY_OF_MONTH) ; i++){
           cal.set(year, month, i);
           int week = cal.get(Calendar.DAY_OF_WEEK);
           monthData.put(i,week);
        }
        return monthData;

    }


}
