import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;

public class GenericQueue<T> implements Iterable<T> {

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
        if (p > priorityNum || p < MIN) {
            p = priorityNum;
        }
        QueueElement<T> element = new QueueElement<>(data, p);
        queue.add(element);
    }


    public T poll() {
        QueueElement<T> el = queue.poll();
        if (el == null) {
            return null;
        } else {
            return el.get_element();
        }
    }

    public boolean contains(T find) {
        QueueElement<T> e = new QueueElement<>(find);
        return queue.contains(e);
    }

    public boolean remove (T find){
        QueueElement<T> e = new QueueElement<>(find);
        return queue.remove(e);
    }

    public int size (){
        return queue.size();

    }


    @Override
    public Iterator<T> iterator() {
        ArrayList<T> array = new ArrayList<>();
        for (Iterator<QueueElement<T>> it = queue.iterator(); it.hasNext(); ) {
            QueueElement<T> i = it.next();
            array.add(i.get_element());
        }
        return array.iterator();
    }

    public Iterator<QueueElement<T>> getAll() {
           return queue.iterator();
    }
}
