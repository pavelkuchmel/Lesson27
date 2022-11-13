import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class Users {
    private Requests queue;
    private ArrayList<User> users;

    public Users(){
        queue  = new Requests();
        users = new ArrayList<>();
    }

    public void start() throws InterruptedException {
        Scanner in = new Scanner(System.in);
        while (true){
            int num = 0;
            System.out.print("1. Действия с пользователями.\n" +
                    "2. Запуск очереди запросов.\n" +
                    "3. Просмотр статистики запросов\n" +
                    "Любое другое число - выход.\n" +
                    "Введите число: ");
            num = in.nextInt();
            switch (num){
                case 1:
                    showActions();
                    break;
                case 2:
                    queue.startRequests();
                    break;
                case 3:
                    queue.showStats();
                    break;
                default:
                    return;
            }
        }
    }
    public void showActions(){
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("1. Добавить нового пользователя.");
            System.out.println("2. Проверить существует ли пользователь и возможные действия.");
            System.out.println("Любое другое число - выход");
            System.out.print("Введите число: ");
            int num = 0;
            try{
                num = in.nextInt();
            } catch (InputMismatchException e){
                System.out.println("Неверный ввод. Вводить надо число.");
                System.out.println();
                //showActions();
            }
            switch (num){
                case 1:
                    add();
                    break;
                case 2:
                    System.out.print("Введите логин: ");
                    check(in.next());
                    break;
                default: return;
            }
        }
    }

    public void add(){
        Scanner in = new Scanner(System.in);
        System.out.print("Введите логин: ");
        String login =  in.next();
        System.out.print("Введите пароль: ");
        String password = in.next();
        int priority = 0;
        do {
            System.out.print("Введите приоритет(1-3): ");
            priority = in.nextInt();
            if (priority < 0 && priority > 4) System.out.println("Неверное число.");
        }while (priority < 0 && priority > 4);
        addAll(new User(login, password, priority));
    }
    public void addAll(User user){
        users.add(user);
        queue.addInQueue(user);
    }
    public boolean check(String login){
        Scanner in = new Scanner(System.in);
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()){
            User next = iterator.next();
           if (next.getLogin().equals(login)) {
               System.out.print("Такой пользователь есть. Возможные действия:" +
                       "\n1. Удалить." +
                       "\n2. Изменить логин." +
                       "\n3. Изменить пароль." +
                       "\nВведите число: ");
               int choose = 0;
               do {
                   choose = in.nextInt();
                   if (choose < 1 && choose > 3) System.out.println("Неверное число."+
                           "\n1. Удалить." +
                           "\n2. Изменить логин." +
                           "\n3. Изменить пароль." +
                           "\nВведите число:");
               }while (choose < 1 && choose > 3);
               switch (choose){
                   case 1:
                       iterator.remove();
                       break;
                   case 2:
                       System.out.print("Введите новый логин: ");
                       changeLogin(next, in.next());
                       break;
                   case 3:
                       changePassword(next);
                       break;
               }
               return true;
           }
           else {
               System.out.println("Такого пользователя нет");
               return false;
           }
        }
        return false;
    }
    public void changeLogin(User user, String login){
        user.setLogin(login);
    }
    public void changePassword(User user){
        Scanner in = new Scanner(System.in);
        String password = "";
        System.out.print("Введите старый пароль: ");
        do {
            password = in.next();
            if (password.equals("0")) return;
            if (!(password.equals(user.getPassword()))) {
                System.out.println("Неверный пароль.");
                System.out.print("Введите пароль или введите 0, что бы выйти: ");
            }
        }while (!(password.equals(user.getPassword())));
        System.out.print("Введите новый пароль: ");
        user.setPassword(in.next());
        System.out.println("Пароль изменен");
    }
}
