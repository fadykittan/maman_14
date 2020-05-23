import java.util.Comparator;

public class ElementComparator <T> implements Comparator<QueueElement<T>> {
    @Override
    public int compare(QueueElement queueElement, QueueElement t1) {
        if (queueElement.get_priority() > t1.get_priority()){
            return 1;
        }
        else if (queueElement.get_priority() < t1.get_priority()) {
            return -1;
        }
        else {
            return 0;
        }
    }

}
