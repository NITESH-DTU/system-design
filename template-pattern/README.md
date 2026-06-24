# Template Method Design Pattern - Machine Learning Pipeline

## Overview

This project demonstrates the **Template Method Design Pattern** using a Machine Learning workflow.

The Template Method Pattern defines the overall algorithm structure in a parent class while allowing child classes to provide their own implementations for specific steps.

In this example, different ML models such as **SVM** and **XGBoost** follow the same pipeline:

1. Load Data
2. Clean Data
3. Add Features / Process Data
4. Collect Results
5. Find Accuracy

The sequence of execution remains fixed, while the implementation of each step varies between models.

---

## Design Pattern Used

### Template Method Pattern

Category:

```text
Behavioral Design Pattern
```

Purpose:

```text
Define the skeleton of an algorithm in a base class and
allow subclasses to redefine specific steps without
changing the algorithm structure.
```

---

## Class Structure

### Abstract Class

```java
abstract class ml_pipeline
```

Contains:

#### Abstract Methods

```java
getdata()
cleandata()
add_data()
collect_result()
find_accuracy()
```

These methods must be implemented by every ML model.

#### Template Method

```java
public final void template()
```

Defines the fixed execution sequence:

```text
Load Data
↓
Clean Data
↓
Add Data
↓
Collect Results
↓
Find Accuracy
```

The method is marked as:

```java
final
```

to prevent subclasses from modifying the workflow.

---

### Concrete Class: SVM

```java
class svm extends ml_pipeline
```

Provides SVM-specific implementations for all pipeline stages.

Example output:

```text
loaded data for svm
cleaned data for svm
added data for svm
collect result for svm
found accuracy for svm
```

---

### Concrete Class: XGBoost

```java
class xgboost extends ml_pipeline
```

Provides XGBoost-specific implementations while following the same workflow.

Example output:

```text
loaded data for xgboost
cleaned data for xgboost
added data for xgboost
collect result for xgboost
found accuracy for xgboost
```

---

## Example Usage

```java
ml_pipeline a = new svm();
ml_pipeline b = new xgboost();

a.template();
b.template();
```

---

## Expected Output

```text
loaded data for svm
cleaned data for svm
added data for svm
collect result for svm
found accuracy for svm

loaded data for xgboost
cleaned data for xgboost
added data for xgboost
collect result for xgboost
found accuracy for xgboost
```

---

## Benefits

### Code Reusability

The workflow is written only once in the parent class.

### Consistency

All ML models follow the same execution sequence.

### Extensibility

Adding a new model requires only a new subclass.

Example:

```java
class RandomForest extends ml_pipeline
```

No changes are required in existing code.

### Open/Closed Principle

The system is open for extension but closed for modification.

---

## Real-World Applications

* Machine Learning Pipelines
* Data Processing Workflows
* ETL Systems
* Payment Processing Systems
* Report Generation Frameworks
* Build and Deployment Pipelines

---

## Key Concepts Demonstrated

* Abstraction
* Inheritance
* Polymorphism
* Method Overriding
* Final Methods
* Behavioral Design Patterns
* Template Method Pattern

---

## Note

Inside the `template()` method, the first step should be:

```java
getdata();
```

instead of:

```java
getClass();
```

Current code:

```java
public final void template(){
    getClass();
    cleandata();
    add_data();
    collect_result();
    find_accuracy();
}
```

Recommended:

```java
public final void template(){
    getdata();
    cleandata();
    add_data();
    collect_result();
    find_accuracy();
}
```

This ensures the complete ML pipeline executes correctly.
