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
    public static PaymentStrategy getm(String method){
        if(method=="gpay"){
            return new Gpay();
        }else if(method=="paytm"){
            return new Paytm();
        }
        return null;
    }
}

public class Main {

    public static void main(String[] args) {
        

        PaymentStrategy method=PaymentService.getm("paytm");
        method.pay(100000);

    }
}