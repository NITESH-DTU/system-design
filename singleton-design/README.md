# Singleton Design Pattern in Java

This project demonstrates three different approaches to implementing the Singleton Design Pattern in Java.

The Singleton pattern ensures that only one instance of a class exists throughout the application and provides a global access point to that instance.

--------------------------------------------------
1. Eager Initialization (singleton)
--------------------------------------------------

class singleton {
    public static singleton single = new singleton();

    private singleton() {}

    public static singleton instance() {
        return single;
    }
}

Description:
- The instance is created as soon as the class is loaded.
- No synchronization is required.
- The same object is returned every time instance() is called.

Advantages:
- Simple implementation.
- Thread-safe because class loading is handled by the JVM.

Disadvantages:
- Object is created even if it is never used.
- May waste memory if object creation is expensive.

--------------------------------------------------
2. Lazy Initialization with Synchronization (singleton2)
--------------------------------------------------

class singleton2 {
    public static singleton2 single;

    private singleton2() {}

    public static synchronized singleton2 instance() {
        if(single == null) {
            return new singleton2();
        }
        return single;
    }
}

Description:
- Object creation is delayed until the first call to instance().
- synchronized ensures that only one thread can execute the method at a time.

Advantages:
- Intended to be thread-safe.
- Object is created only when required.

Disadvantages:
- Synchronization adds performance overhead.
- In the current implementation, the created object is not assigned to 'single', so a new object is returned whenever single is null.

Thread Safety:
- Method execution is thread-safe because of synchronized.
- However, Singleton behavior is not achieved correctly due to the missing assignment.

--------------------------------------------------
3. Lazy Initialization without Synchronization (singleton3)
--------------------------------------------------

class singleton3 {
    public static singleton3 single;

    private singleton3() {}

    public static singleton3 instance() {
        if(single == null) {
            return new singleton3();
        }
        return single;
    }
}

Description:
- Object is created only when first requested.
- No synchronization or locking is used.

Advantages:
- Faster than synchronized implementations.
- Object is created only when needed.

Disadvantages:
- Not thread-safe.
- Multiple threads can create multiple instances simultaneously.
- The created object is never assigned to 'single', causing a new object to be returned whenever single is null.

Thread Safety:
- Unsafe in multithreaded environments.
- Does not guarantee a single instance.

--------------------------------------------------
Output Verification
--------------------------------------------------

System.out.println(s == s4);
System.out.println(s5 == s2);
System.out.println(s6 == s3);

Results:

singleton  -> true
singleton2 -> false
singleton3 -> false

Explanation:
- singleton returns the same object every time.
- singleton2 creates a new object whenever single is null.
- singleton3 also creates a new object whenever single is null.

--------------------------------------------------
Summary
--------------------------------------------------

singleton
- Initialization: Eager
- Thread Safe: Yes
- Lazy Loading: No

singleton2
- Initialization: Lazy
- Thread Safe: Yes (method level)
- Lazy Loading: Yes

singleton3
- Initialization: Lazy
- Thread Safe: No
- Lazy Loading: Yes

This project demonstrates the difference between eager initialization, synchronized lazy initialization, and unsynchronized lazy initialization while highlighting the importance of thread safety in Singleton implementations.