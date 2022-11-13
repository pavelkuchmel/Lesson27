import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.GregorianCalendar;
import java.util.Iterator;

public class Requests {
    private BinaryHeap<User> queue;
    private ArrayDeque<String> statsRequests;

    public Requests(){
        queue = new BinaryHeap<>();
        statsRequests = new ArrayDeque<>();
    }
    public void startRequests() throws InterruptedException {
        while (true){
            if (!(queue.isEmpty())){
                User user = queue.extractMax();
                System.out.println(user.getRequests());
                saveRequest(user.getLogin(), new GregorianCalendar());
                Thread.sleep(500);
            }
            else break;
        }
    }
    public void addInQueue(User user){
        queue.add(user);
    }

    public void saveRequest(String login, GregorianCalendar date){
        statsRequests.add(login + " - " + new SimpleDateFormat("HH:mm:ss").format(date.getTime()));
    }

    public void showStats(){
        Iterator<String> iterator = statsRequests.iterator();
        System.out.println("Stats: ");
        while (iterator.hasNext()){
            System.out.println(iterator.next());
            System.out.println();
        }
    }
}
