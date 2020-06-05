import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

public class MainClass {

    private static final int MAX_PRIORITY = 5;


    private static final boolean isRunCheckForInteger = false;
    private static final boolean isRunCheckForCustomerRequest = true;


    private static final ArrayList<String> nameList = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E", "F"));
    private static final ArrayList<String> messageList = new ArrayList<>(Arrays.asList("my order didn't arrived", "item broken", "i want to replace it"
            , "can i get a refund", "thank for fast shipping", "great product!"));


    public static void main(String[] args){


        ///////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////
        // This part check GenericQueue for Integer
        ///////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////
        if (isRunCheckForInteger) {
            GenericQueue<Integer> gq = new GenericQueue<>(MAX_PRIORITY);
            for (int i = 0; i <= 15; i++) {
                int data = getRandomData();
                int priority = getRandomPriority();
                gq.add(data, priority);
                System.out.println("added data=  " + data + "  prio=  " + priority);
            }
            toPrint(gq);
            int p = gq.poll();
            System.out.println("poll= " + p);
            toPrint(gq);


            gq.add(5, 1);
            System.out.println("is contains=  " + gq.contains(5));
            toPrint(gq);

            gq.add(5, 2);
            toPrint(gq);
            System.out.println("is removed=  " + gq.remove(5));
            toPrint(gq);

            iterateAndPrint(gq);
        }




        ///////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////
        // This part check GenericQueue for CustomerRequest
        ///////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////
        if (isRunCheckForCustomerRequest) {
            GenericQueue<CustomerRequest> requestsQueue = new GenericQueue<>(MAX_PRIORITY);
            for (int i = 0; i < nameList.size(); i++) {
                CustomerRequest cr = new CustomerRequest(nameList.get(i), getRandomData(), messageList.get(i));
                int priority = getRandomPriority();
                requestsQueue.add(cr, priority);
                System.out.println(cr + " | Priority: " + priority);
            }
            System.out.println("===========================================");
            System.out.println("==========Finish adding to Queue===========");
            System.out.println("===========================================");

            toPrintCustomerRequest(requestsQueue);

            // test Poll
            CustomerRequest cr = requestsQueue.poll();
            System.out.println("Test Poll");
            System.out.println("Polled Element: " + cr);
            System.out.println("-------------------------");
            toPrintCustomerRequest(requestsQueue);

            // test remove
            cr = new CustomerRequest(nameList.get(0), getRandomData(), messageList.get(0));
            requestsQueue.add(cr, getRandomPriority());
            System.out.println("Test Remove: is removed: " + requestsQueue.remove(cr));
            System.out.println("-------------------------");
            toPrintCustomerRequest(requestsQueue);


            // test contains
            cr = new CustomerRequest(nameList.get(0), getRandomData(), messageList.get(0));
            requestsQueue.add(cr, getRandomPriority());
            System.out.println("Test Contains");
            System.out.println("is Contains: " + requestsQueue.contains(cr));
            System.out.println("-------------------------");
            toPrintCustomerRequest(requestsQueue);

        }






    }

    private static int getRandomData(){
        Random r = new Random();
        int res = r.nextInt(100);
        return res;
    }

    private static int getRandomPriority(){
        Random r = new Random();
        int res = r.nextInt(MAX_PRIORITY);
        return res;
    }

    private static void toPrint(GenericQueue<Integer> print){
        for (Iterator<QueueElement<Integer>> it = print.getAll(); it.hasNext(); ) {
            QueueElement<Integer> p = it.next();
            System.out.println("data= " + p.get_element() + " | priority= " + p.get_priority());
        }
        System.out.println("==================================================================");

        System.out.println("size= " + print.size());

        System.out.println("==================================================================");

    }

    private static void iterateAndPrint(GenericQueue<Integer> print) {
        System.out.println("==================================================================");

        System.out.println("iterate other queue");

        System.out.println("==================================================================");

        for (Iterator<Integer> it = print.iterator(); it.hasNext(); ) {
            Integer p = it.next();
            System.out.println("data= " + p);
        }
        System.out.println("==================================================================");

        System.out.println("size= " + print.size());

        System.out.println("==================================================================");
    }



    private static <T> void toPrintGeneric(GenericQueue<T> print){
        for (Iterator<QueueElement<T>> it = print.getAll(); it.hasNext(); ) {
            QueueElement<T> p = it.next();
            System.out.println(p.get_element() + " | Priority = " + p.get_priority());
        }
        System.out.println("==================================================================");

        System.out.println("size= " + print.size());

        System.out.println("==================================================================");
    }


    private static void toPrintCustomerRequest(GenericQueue<CustomerRequest> print){
        for (Iterator<QueueElement<CustomerRequest>> it = print.getAll(); it.hasNext(); ) {
            QueueElement<CustomerRequest> p = it.next();
            System.out.println(p.get_element() + " | Priority = " + p.get_priority());
        }
        System.out.println("==================================================================");

        System.out.println("size= " + print.size());

        System.out.println("==================================================================");
    }

}
