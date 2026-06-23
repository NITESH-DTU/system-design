# Adapter Design Pattern in Java

## Introduction

This project demonstrates the Adapter Design Pattern, a structural design pattern used to allow classes with incompatible interfaces to work together. The adapter acts as a bridge between the client and an existing class by converting one interface into another that the client expects.

## Problem Statement

Suppose an application expects data in JSON format, but an existing service provides data in XML format. Modifying the existing service may not always be possible, especially when dealing with third-party or legacy code. An adapter can be used to convert the XML data into JSON format without changing the original XML service.

## Components

### Target Interface

The interface expected by the client.

```java
interface adapter {
    void data_in_json();
}
```

### Adaptee

The existing class that provides data in XML format.

```java
class xml {
    public void xml_data() {
        System.out.println("data collected in xml");
    }
}
```

### Adapter

The class that adapts the XML service to the interface expected by the client.

```java
class json implements adapter {
    xml im;

    public json() {
        this.im = new xml();
    }

    public void data_in_json() {
        im.xml_data();
        System.out.println("data converted in json from xml collected json");
    }
}
```

### Client

Uses the target interface without knowing the details of the XML implementation.

```java
public class Main {
    public static void main(String[] args) {
        adapter middleware = new json();
        middleware.data_in_json();
    }
}
```

## Program Flow

1. The client creates an object of the adapter (`json`).
2. The client calls `data_in_json()`.
3. The adapter internally invokes `xml_data()` from the XML service.
4. The adapter converts the XML data into JSON format.
5. The client receives the data through a unified interface.

## Output

```text
data collected in xml
data converted in json from xml collected json
```

## Benefits

* Allows incompatible interfaces to work together.
* Promotes code reusability.
* Reduces modifications to existing code.
* Follows the Open/Closed Principle.
* Useful for integrating legacy systems and third-party libraries.

## Real-World Examples

* XML to JSON converters.
* USB-C to HDMI adapters.
* Payment gateway integrations.
* Database driver adapters.
* Legacy API integration with modern applications.

## Design Pattern Category

Structural Design Pattern

## Conclusion

The Adapter Design Pattern provides a simple and effective way to connect classes with incompatible interfaces. In this project, the adapter converts XML-based data into a JSON-compatible interface, allowing the client to work with a consistent API without modifying the existing XML implementation.
