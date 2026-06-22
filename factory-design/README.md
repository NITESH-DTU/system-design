# Factory Design Pattern

## Overview

This project demonstrates the Factory Design Pattern using different payment methods.

The main idea behind the Factory Pattern is to move object creation logic into a dedicated factory method instead of creating objects directly throughout the application.

---

## Problem

Without a factory, object creation would look like:

```java
PaymentStrategy method = new Gpay();
```

or

```java
PaymentStrategy method = new Paytm();
```

As the number of payment methods grows, object creation logic starts getting scattered across the codebase.

---

## Solution

A factory method is responsible for creating and returning the appropriate object.

```java
PaymentStrategy method =
    PaymentService.getm("paytm");
```

The client does not need to know how the object is created.

It only requests the desired payment method and receives an implementation of the `PaymentStrategy` interface.

---

## Components

### PaymentStrategy

Defines a common contract for all payment methods.

```java
interface PaymentStrategy {
    void pay(int amount);
}
```

### Concrete Implementations

* Gpay
* Paytm

Each class provides its own implementation of the payment behavior.

### Factory Class

```java
PaymentService.getm(String method)
```

Responsible for creating and returning the correct payment object.

---

## Execution Flow

1. Client requests a payment method.
2. Factory checks the requested type.
3. Factory creates the appropriate object.
4. Factory returns the object as a `PaymentStrategy`.
5. Client uses the returned object.

Example:

```java
PaymentStrategy method =
    PaymentService.getm("paytm");

method.pay(100000);
```

Output:

```text
Paying using Paytm amount of 100000
```

---

## Benefits

* Centralizes object creation logic.
* Reduces direct dependency on concrete classes.
* Makes code easier to maintain.
* Adding new payment methods becomes simpler.
* Improves readability by separating creation from usage.

---

## What I Learned

The Factory Pattern is not about changing behavior.

Its primary goal is to hide object creation from the client.

Instead of writing:

```java
new Gpay();
new Paytm();
```

the client simply asks the factory for an object:

```java
PaymentService.getm("paytm");
```

and the factory decides which implementation to return.

---

## Personal Memory Trick

Strategy Pattern decides **how something works**.

Factory Pattern decides **which object gets created**.
