interface PaymentStrategy {
    void pay(int amount);
}

class Gpay implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("Paying using Gpay amount of " + amount);
    }
}

class Paytm implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("Paying using Paytm amount of " + amount);
    }
}

class PaymentService {

    private PaymentStrategy strategy;

    PaymentService(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void pay(int amount) {
        strategy.pay(amount);
    }
}

public class Main {

    public static void main(String[] args) {

        PaymentService service =
                new PaymentService(new Gpay());

        service.pay(1000);
        service=new PaymentService(new Paytm());
        service.pay(10000);

    }
}