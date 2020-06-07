import java.util.HashMap;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
        CalendarData data = new CalendarData();
        Map<Integer,Integer> mapData = new HashMap<>();
        mapData = data.getMYData(2020,6);
        System.out.println(mapData);

    }
}
