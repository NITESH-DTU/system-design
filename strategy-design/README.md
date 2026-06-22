# Strategy Design Pattern (Hinglish Notes)

## Problem

Maan lo mere paas ek PaymentService hai.

```java
if(method.equals("UPI"))
    // UPI logic

else if(method.equals("CARD"))
    // Card logic

else if(method.equals("PAYPAL"))
    // Paypal logic
```

Abhi sab theek lag raha hai.

Lekin kal:

* Wallet Payment
* Crypto Payment
* Net Banking

add karna pad gaya.

Har baar PaymentService modify karni padegi.

Yahi Strategy Pattern solve karta hai.

---

## Core Idea

Behavior ko class ke andar hardcode mat karo.

Behavior ko alag-alag classes me daal do aur runtime pe jo chahiye usko inject kar do.

Simple words me:

"Main kaam karne wali class ko implementation ka pata nahi hona chahiye."

Usko sirf itna pata hona chahiye:

```java
strategy.pay(amount);
```

Bas.

---

## Structure

### Strategy Interface

```java
interface PaymentStrategy{
    void pay(int amount);
}
```

---

### Concrete Strategies

```java
class UpiPayment implements PaymentStrategy{
    public void pay(int amount){
        System.out.println("UPI Payment");
    }
}
```

```java
class CardPayment implements PaymentStrategy{
    public void pay(int amount){
        System.out.println("Card Payment");
    }
}
```

```java
class PaypalPayment implements PaymentStrategy{
    public void pay(int amount){
        System.out.println("Paypal Payment");
    }
}
```

---

### Context Class

```java
class PaymentService{

    private PaymentStrategy strategy;

    PaymentService(PaymentStrategy strategy){
        this.strategy = strategy;
    }

    void pay(int amount){
        strategy.pay(amount);
    }
}
```

---

### Usage

```java
PaymentService service =
    new PaymentService(
        new UpiPayment()
    );

service.pay(1000);
```

Output:

```
UPI Payment
```

---

## Sabse Important Point

Object to mujhe fir bhi banana padega:

```java
new UpiPayment()
```

Strategy Pattern object creation ko remove nahi karta.

Strategy Pattern ka goal hai:

"New behavior add karne par existing code modify na karna pade."

---

## HAS-A vs IS-A

Inheritance:

```java
class Dog extends Animal
```

Dog IS-A Animal.

---

Strategy:

```java
class PaymentService{
    PaymentStrategy strategy;
}
```

PaymentService HAS-A Strategy.

Yahan PaymentService strategy ko use kar raha hai, inherit nahi kar raha.

---

## Real Benefit

Without Strategy:

```java
if(...)
else if(...)
else if(...)
else if(...)
```

Code continuously badhta rahega.

With Strategy:

```java
new UpiPayment()
new CardPayment()
new WalletPayment()
new CryptoPayment()
```

Har logic apni class me.

Clean code.
Easy maintenance.
Easy extension.

---

## Interview Definition

Strategy Pattern is a behavioral design pattern that defines a family of algorithms, encapsulates each one in separate classes, and allows them to be interchangeable at runtime.

---

## One-Line Memory Trick

"If-Else ka jungle dikhe,
to Strategy Pattern ka bulb jale."
