# Proxy Design Pattern - Third Party Data Service Example

## Overview

This project demonstrates the **Proxy Design Pattern**.

A Proxy acts as an intermediary between the client and the real object. Instead of directly accessing the real service, the client communicates with the proxy, which controls access to the underlying service.

---

## Design Pattern Used

### Proxy Pattern

Category:

```text
Structural Design Pattern
```

Purpose:

```text
Provide a placeholder or surrogate for another object
to control access to it.
```

---

## Class Structure

### Subject Interface

```java
interface dataservice
```

Defines the common contract:

```java
void fetchdata();
```

Both the Proxy and the Real Service implement this interface.

---

### Real Service

```java
class dataproxy implements dataservice
```

Represents the actual third-party service responsible for fetching data.

Implementation:

```java
public void fetchdata(){
    System.out.println("3rd party service:::::fetching data for user");
}
```

---

### Proxy

```java
class proxy implements dataservice
```

Acts as an intermediary.

Responsibilities:

* Control access to the real service
* Add logging
* Add authentication
* Add caching
* Add rate limiting
* Perform lazy initialization

Implementation:

```java
public void fetchdata(){
    ds = new dataproxy();
    ds.fetchdata();
    System.out.println("proxy service::::::fetching data from the 3rd party service");
}
```

---

## Client Usage

```java
dataservice ds = new proxy();
ds.fetchdata();
```

The client only knows about the interface and interacts with the proxy.

---

## Output

```text
3rd party service:::::fetching data for user
proxy service::::::fetching data from the 3rd party service
```

---

## How It Works

Step 1:

```text
Client calls Proxy
```

Step 2:

```text
Proxy receives request
```

Step 3:

```text
Proxy forwards request to Real Service
```

Step 4:

```text
Real Service processes request
```

Step 5:

```text
Proxy may perform additional operations
```

---

## Real-World Examples

### API Gateway

```text
Client
  ↓
API Gateway (Proxy)
  ↓
Microservices
```

### Redis Cache

```text
Application
  ↓
Cache Layer (Proxy)
  ↓
Database
```

### Spring Security

```text
User Request
  ↓
Security Proxy
  ↓
Business Logic
```

### Nginx Reverse Proxy

```text
Browser
  ↓
Nginx
  ↓
Backend Server
```

---

## Advantages

* Controlled access to objects
* Lazy initialization
* Security checks
* Logging and monitoring
* Caching support
* Reduced load on expensive services

---

## Concepts Demonstrated

* Interfaces
* Polymorphism
* Composition
* Structural Design Patterns
* Object Delegation

---

## Possible Enhancement

Implement Lazy Loading:

```java
private dataservice ds;

public void fetchdata(){
    if(ds == null){
        ds = new dataproxy();
    }

    ds.fetchdata();
}
```

This ensures the real service is created only when needed and only once.
