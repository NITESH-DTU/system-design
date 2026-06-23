# Decorator Design Pattern - Mario Game Example

## Overview

The Decorator Design Pattern is a **structural design pattern** that allows us to add new behavior to an object dynamically without modifying its existing code.

In this example, a `Mario` character can gain multiple abilities such as:

* Energy Boost
* Fire Power
* Running Ability

Instead of creating many subclasses like:

* MarioWithFire
* MarioWithRun
* MarioWithFireAndRun
* MarioWithEnergyAndFireAndRun

we use decorators to add abilities at runtime.

---

## Class Structure

### Component

```java
interface character {
    void getabilities();
}
```

Defines the common behavior for all characters.

---

### Concrete Component

```java
class mario implements character {
    @Override
    public void getabilities() {
        System.out.println("running mario abilities");
    }
}
```

The base object that will be decorated.

---

### Decorator Interface

```java
interface decorator extends character {
    void getabilities();
}
```

Acts as a wrapper around the `character` interface.

---

### Concrete Decorators

#### Energy Decorator

```java
class energy implements decorator
```

Adds energy-related abilities.

#### Fire Decorator

```java
class fire implements decorator
```

Adds fire-related abilities.

#### Run Decorator

```java
class run implements decorator
```

Adds running-related abilities.

Each decorator:

1. Stores a reference to another `character`.
2. Calls the wrapped object's method.
3. Adds its own behavior.

Example:

```java
public void getabilities() {
    ch.getabilities();
    System.out.println("running get abilities of fire!");
}
```

---

## Client Code

```java
character ch =
    new run(
        new fire(
            new energy(
                new mario()
            )
        )
    );

ch.getabilities();
```

---

## Execution Flow

The call stack becomes:

```text
run
 └── fire
      └── energy
            └── mario
```

Execution order:

1. mario abilities
2. energy abilities
3. fire abilities
4. run abilities

---

## Output

```text
running mario abilities
running get abilities of energy!
running get abilities of fire!
running get abilities of run!
```

---

## Benefits

### Open/Closed Principle

New abilities can be added without modifying existing classes.

### Runtime Flexibility

Abilities can be combined dynamically.

### Avoids Class Explosion

Without decorators:

```text
MarioWithFire
MarioWithRun
MarioWithEnergy
MarioWithFireAndRun
MarioWithEnergyAndRun
MarioWithEnergyAndFire
MarioWithEnergyAndFireAndRun
...
```

With decorators:

```java
new run(new fire(new mario()));
new energy(new mario());
new fire(new energy(new mario()));
```

---

## Real-World Examples

* Java I/O Streams

  * BufferedInputStream
  * DataInputStream
  * FileInputStream

* Coffee Ordering Systems

  * Coffee + Milk
  * Coffee + Sugar
  * Coffee + Whipped Cream

* Game Power-Ups

  * Shield
  * Fire Ability
  * Speed Boost
  * Extra Health

---

## Pattern Structure

```text
Component
    ^
    |
ConcreteComponent (Mario)

Decorator
    ^
    |
-------------------------
|          |           |
Energy     Fire       Run
```

Each decorator wraps another component and adds extra functionality while preserving the original behavior.
