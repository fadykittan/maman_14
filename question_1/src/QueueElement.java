public class QueueElement <T> {

    private T _element;
    private int _priority;

    public QueueElement (T element, int priority){
        this._element = element;
        this._priority = priority;
    }

    public T get_element(){
        return this._element;
    }

    public int get_priority(){
        return this._priority;
    }
}
