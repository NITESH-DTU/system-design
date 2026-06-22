# Strategy Design Pattern

## Why I Learned It

Initially I thought Strategy Pattern was just inheritance with extra steps, but the main idea is different.

The goal is not to avoid creating objects. The goal is to avoid modifying existing business logic whenever a new behavior is added.

---

## Problem

Suppose I have a payment service.

Without Strategy Pattern I would write:

```java
if(method.equals("Paytm")) {
    ...
}
else if(method.equals("Gpay")) {
    ...
}
else if(method.equals("PhonePe")) {
    ...
}
```

This works, but every time a new payment method is added, I need to modify the PaymentService class.

Over time the class becomes filled with if-else conditions.

---

## Solution

Instead of putting every payment logic inside PaymentService, each payment method gets its own class.

Examples:

* Paytm
* Gpay
* PhonePe
* BhimUPI

All of them implement the same interface:

```java
interface PaymentStrategy {
    void pay(int amount);
}
```

PaymentService only knows that it has a strategy and can call:

```java
strategy.pay(amount);
```

It does not care whether the payment is done using Gpay, Paytm, or any future method.

---

## Key Insight

The biggest thing I learned is:

PaymentService HAS-A PaymentStrategy.

It does not inherit from a payment method.

The behavior is injected from outside.

Example:

```java
PaymentService service =
    new PaymentService(new Gpay());
```

Later I can switch to:

```java
PaymentService service =
    new PaymentService(new Paytm());
```

without changing the PaymentService code.

---

## Benefits

* Removes large if-else chains.
* Easier to add new payment methods.
* Existing business logic remains unchanged.
* Follows Open/Closed Principle.

---

## Personal Summary

Whenever I see a class containing many if-else blocks that choose between different algorithms or behaviors, Strategy Pattern is usually a good candidate.

Memory trick:

"If-Else ka jungle dikhe, Strategy Pattern ka bulb jale."
