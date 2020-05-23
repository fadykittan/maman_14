import java.util.ArrayList;
import java.util.PriorityQueue;

public class GenericQueue<T> {

    private PriorityQueue<QueueElement<T>> queue;
    private static final int MIN = 1;
    private static final int MAX = 10;
    private int priorityNum;

    public GenericQueue(int priorityNum) {
        if (priorityNum <= MAX && priorityNum >= MIN) {
            this.priorityNum = priorityNum;
        } else {
            priorityNum = MAX;
        }
        this.priorityNum = priorityNum;
        queue = new PriorityQueue<>(new ElementComparator());
    }

    public void add(T data, int p) {
        if (p >= priorityNum && p <= MIN) {
            p = priorityNum;
        }
        QueueElement<T> element = new QueueElement<>(data, p);
        queue.add(element);
    }


    public T poll() {
        QueueElement<T> element = queue.poll();
        if (element == null) {
            return null;
        } else {
            return element.get_element();
        }
    }

    public boolean contains(T toFind) {
        QueueElement<T> e = new QueueElement<>(toFind);
        return queue.contains(e);
    }




}
