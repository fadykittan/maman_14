import java.util.Iterator;
import java.util.Random;

public class MainClass {


    public static void main(String[] args){
        GenericQueue<Integer> gq = new GenericQueue<>(5);
        for(int i=0; i<= 15 ; i++){
            int data = getRandomData();
            int priority = getRandomPriority();
            gq.add( data, priority);
            System.out.println("added data=  " + data + "  prio=  " + priority);
        }
        toPrint(gq);
        int p = gq.poll();
        System.out.println("poll= " + p);
        toPrint(gq);


        gq.add(5,1);
        System.out.println("is contains=  " + gq.contains(5));
        toPrint(gq);

        gq.add(5,2);
        toPrint(gq);
        System.out.println("is removed=  " + gq.remove(5));
        toPrint(gq);

        iterateAndPrint(gq);
    }

    private static int getRandomData(){
        Random r = new Random();
        int res = r.nextInt(100);
        return res;
    }

    private static int getRandomPriority(){
        Random r = new Random();
        int res = r.nextInt(5);
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

}
