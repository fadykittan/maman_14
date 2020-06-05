public class CustomerRequest {


    private String name;
    private int id;
    private String requestMessage;


    public CustomerRequest(String name, int id, String requestMessage) {
        this.name = name;
        this.id = id;
        this.requestMessage = requestMessage;
    }


    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getRequestMessage() {
        return requestMessage;
    }

    @Override
    public boolean equals(Object obj) {
        CustomerRequest cr = (CustomerRequest) obj;
        if (cr.id == this.id && cr.requestMessage.equals(this.requestMessage)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "ID = " + this.id + " | name: " + this.name + " | message: " + this.requestMessage;
    }
}
