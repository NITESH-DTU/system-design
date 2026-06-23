# Observer Design Pattern in Java

## Overview

This project demonstrates the Observer Design Pattern using a simple YouTube-like notification system.

In this implementation:

- A Channel acts as the Subject (Observable).
- Users act as Observers.
- When the channel uploads a new video, all subscribed users receive a notification automatically.

The Observer Pattern establishes a one-to-many relationship between objects so that when one object changes state, all its dependents are notified and updated automatically.

--------------------------------------------------

## Components

### Observable (Subject)

The Observable interface defines the operations that every subject must provide:

- subscribe(observer ob)
- unsubscribe(observer ob)
- notifySubscribers()
- getvideo()

Responsibilities:
- Maintain a list of observers.
- Add or remove observers.
- Notify all observers whenever data changes.

--------------------------------------------------

### Channel (Concrete Subject)

The channel class implements the observable interface.

Responsibilities:
- Store subscribers.
- Store the latest uploaded video.
- Notify all subscribed users when a new video is uploaded.

Methods:

subscribe(observer ob)
    Adds a user to the subscriber list.

unsubscribe(observer ob)
    Removes a user from the subscriber list.

notifySubscribers()
    Calls update() on every subscribed user.

updatevideo(String title)
    Updates the latest video and notifies subscribers.

getvideo()
    Displays the latest uploaded video.

--------------------------------------------------

### Observer

The observer interface defines:

update()

Responsibilities:
- Receive notifications from the subject.
- React whenever the subject changes.

--------------------------------------------------

### User (Concrete Observer)

The user class implements the observer interface.

Responsibilities:
- Subscribe to a channel.
- Receive notifications when a new video is uploaded.

Methods:

update()
    Displays the notification and latest uploaded video.

--------------------------------------------------

## Workflow

1. A Channel is created.
2. Users subscribe to the Channel.
3. The Channel uploads a new video.
4. notifySubscribers() is triggered.
5. update() is called for every subscribed user.
6. All users receive the notification.

--------------------------------------------------

## Example Execution

Channel Created:
    nitesh

Users Subscribed:
    nitesh
    rahul

Video Uploaded:
    Observer Design Pattern Video

Notifications Sent:
    rahul received notification -> Latest Video : Observer Design Pattern Video
    nitesh received notification -> Latest Video : Observer Design Pattern Video

--------------------------------------------------

## Design Pattern Used

Observer Design Pattern

Category:
    Behavioral Design Pattern

Purpose:
    Defines a one-to-many dependency between objects so that when one object changes state, all dependent objects are notified automatically.

Real-World Examples:
- YouTube channel subscriptions
- Instagram followers
- Newsletter subscriptions
- Event listeners in Java
- Stock market notification systems

--------------------------------------------------

## Advantages

- Loose coupling between subject and observers.
- Easy to add new observers.
- Supports dynamic subscription and unsubscription.
- Follows Open/Closed Principle.

--------------------------------------------------

## Conclusion

This project demonstrates how the Observer Design Pattern can be used to implement a notification system where multiple users are automatically informed whenever a channel uploads a new video.