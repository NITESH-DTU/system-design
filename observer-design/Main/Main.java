import java.util.HashSet;

public class Main {

    public static void main(String[] args) {

        channel ch = new channel("nitesh");

        user u1 = new user("nita", ch);
        user u2 = new user("rahul", ch);

        ch.updatevideo("Observer Design Pattern Video");
    }
}

interface observable {

    void subscribe(observer ob);

    void unsubscribe(observer ob);

    void notifySubscribers();

    void getvideo();
}

class channel implements observable {

    HashSet<observer> set;
    String name;
    String latestvideo;

    public channel(String name) {
        this.name = name;
        this.set = new HashSet<>();
    }

    public void subscribe(observer ob) {
        set.add(ob);
    }

    public void unsubscribe(observer ob) {
        set.remove(ob);
    }

    public void notifySubscribers() {

        for (observer ob : set) {
            ob.update();
        }
    }

    public void updatevideo(String title) {
        latestvideo = title;
        System.out.println(name + " uloaded a vedio named as "+ title);
        notifySubscribers();
    }

    public void getvideo() {
        System.out.println("Latest Video : " + latestvideo);
    }
}

interface observer {

    void update();
}

class user implements observer {

    observable channel;
    String name;

    public user(String name, observable channel) {

        this.name = name;
        this.channel = channel;
        channel.subscribe(this);
    }

    public void update() {

        System.out.print(name + " received notification -> ");
        channel.getvideo();
    }
}