import java.util.GregorianCalendar;
import java.util.Random;

public class User implements Comparable<User>{
    private String login;
    private String password;
    private int priority;
    private GregorianCalendar date;
    private final long requests;

    public User(){
        Random rdm = new Random();
        requests = rdm.nextLong();
        login = "login";
        password = "password";
        priority = 0;
        date = new GregorianCalendar();
    }

    public User(String login, String password, int priority) {
        Random rdm = new Random();
        requests = rdm.nextLong();
        this.login = login;
        this.password = password;
        this.priority = priority;
        date = new GregorianCalendar();
    }

    public String getRequests() {
        return "{"+requests+"}";
    }

    public GregorianCalendar getDate() {
        return date;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "login = " + login + ", priority= " + priority + ", date=" + date.getTime();
    }

    @Override
    public int compareTo(User user) {
        if (getPriority() > user.getPriority()) return 1;
        else if (getPriority() < user.getPriority()) return -1;
        else return (getDate().compareTo(user.getDate())) * (-1);
    }
}
