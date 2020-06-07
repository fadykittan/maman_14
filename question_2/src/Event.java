public class Event {

    private String text;
    private String title;

    public Event (String text , String title){
        this.text = text;
        this.title = title;
    }

    public void setText (String text ){
        this.text = text;
    }

    public void setTitle (String title){
        this.title = title;
    }

    public String getTitle(){
        return this.title;
    }

    public String getText() {
        return this.text;
    }
}
