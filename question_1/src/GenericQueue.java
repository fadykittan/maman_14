import java.util.ArrayList;
import java.util.PriorityQueue;

public class GenericQueue <T> {

    private PriorityQueue <QueueElement<T>> queue;
    private static final int MIN = 1;
    private static final int MAX = 10;
    private int priorityNum;

    public GenericQueue (int priorityNum){
        if(priorityNum <= MAX && priorityNum >= MIN) {
            this.priorityNum = priorityNum;
        }
        else { priorityNum = MAX;}
        queue = new PriorityQueue<>(new ElementComparator());
    }

    public void add (T data , int p ){
        if (p>=priorityNum && p<=MIN){
            p=priorityNum;
        }
        QueueElement<T> element = new QueueElement<T>(data , p);
        queue.add(element);
    }










}
