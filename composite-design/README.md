# Composite Design Pattern - File System Example

## Overview

This project demonstrates the **Composite Design Pattern** using a simple file system.

The Composite Pattern allows clients to treat individual objects (**Files**) and groups of objects (**Folders**) uniformly through a common interface.

---

## Structure

### Component

```java
interface filesystem
```

Defines common operations:

* `ls()` → List contents
* `getsize()` → Return size
* `getname()` → Return name
* `addfile()` → Add child component

---

### Leaf

```java
class file implements filesystem
```

Represents an individual file.

Responsibilities:

* Store file name
* Store file size
* Return its own size
* Return its own name
* Cannot contain children

Example:

```java
new file("nikhil", 200);
```

---

### Composite

```java
class folder implements filesystem
```

Represents a directory/folder.

Responsibilities:

* Store folder name
* Store folder size
* Maintain a collection of files/folders
* Calculate total size recursively

Example:

```java
folder photos = new folder("photos", 100);
```

---

## Example Usage

```java
filesystem f = new folder("photos", 100);

f.addfile(new file("nikhil", 200));

f.ls();

System.out.println(f.getname());

System.out.println(f.getsize());
```

### Output

```text
nikhil
photos
300
```

Explanation:

* Folder size = 100
* File size = 200
* Total size = 300

---

## Design Pattern Benefits

### Uniform Treatment

Client interacts only with:

```java
filesystem
```

and doesn't need to know whether the object is:

```java
file
```

or

```java
folder
```

### Easy Extensibility

New components can be added without changing client code.

Example:

```java
class ZipFile implements filesystem
```

---

## Pattern Classification

Category:

```text
Structural Design Pattern
```

Purpose:

```text
Compose objects into tree structures and treat individual
objects and compositions uniformly.
```

---

## Real World Examples

* Operating System File Explorer
* Windows Directories
* Linux File System
* Organization Hierarchies
* UI Component Trees
* Menu/Submenu Structures

---

## Concepts Used

* Interfaces
* Polymorphism
* Recursion (extendable version)
* Composition
* Structural Design Patterns
