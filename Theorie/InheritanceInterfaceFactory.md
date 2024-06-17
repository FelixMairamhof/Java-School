Certainly! Let's consolidate all the concepts—abstract classes, interfaces, extends, super, factory methods, and abstract methods—into one cohesive explanation with Java-specific examples.

### Abstract Classes

Abstract classes in Java are classes that cannot be instantiated on their own and may contain abstract methods (methods without a body) that subclasses must implement. They serve as blueprints for other classes to extend from.

**Example of an abstract class:**

```java
// Abstract class
abstract class Shape {
    // Abstract method (no implementation)
    public abstract void draw();
    
    // Concrete method
    public void display() {
        System.out.println("Displaying shape.");
    }
}

// Concrete subclass
class Circle extends Shape {
    @Override
    public void draw() {
        System.out.println("Drawing Circle.");
    }
}
```

### Interfaces

Interfaces in Java define a contract for classes to follow. They can contain method signatures (abstract methods), default methods (methods with a default implementation), static methods, and constants. A class implements an interface using the `implements` keyword.

**Example of an interface:**

```java
// Interface declaration
interface Animal {
    void makeSound(); // Abstract method

    default void eat() {
        System.out.println("Animal is eating."); // Default method
    }

    static void sleep() {
        System.out.println("Animal is sleeping."); // Static method
    }
}

// Class implementing the Animal interface
class Dog implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Dog barks.");
    }
}
```

### `extends`

In Java, `extends` is used to create a subclass (derived class) that inherits properties and behaviors from a superclass (base class). Subclasses can override methods, add new methods, and access superclass methods and fields using `super`.

**Example of inheritance using `extends`:**

```java
// Superclass
class Animal {
    void sound() {
        System.out.println("Animal makes a sound.");
    }
}

// Subclass extending Animal
class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Dog barks.");
    }

    void display() {
        super.sound(); // accessing superclass method
        System.out.println("Displaying dog.");
    }
}
```

### `super`

The `super` keyword in Java is used to refer to the superclass methods, constructors, and instance variables from within a subclass. It can be used to invoke superclass constructors, access overridden methods, and access superclass fields.

**Example of using `super`:**

```java
// Superclass
class Vehicle {
    int maxSpeed = 100;

    void display() {
        System.out.println("Vehicle max speed: " + maxSpeed);
    }
}

// Subclass extending Vehicle
class Car extends Vehicle {
    int maxSpeed = 200;

    @Override
    void display() {
        super.display(); // accessing superclass method
        System.out.println("Car max speed: " + maxSpeed);
    }

    void show() {
        System.out.println("Car specific max speed: " + maxSpeed);
    }
}
```

### Factory Method

The Factory Method pattern in Java is a creational design pattern where a superclass provides an interface (method) for creating objects, but allows subclasses to alter the type of objects that will be created.

**Example of Factory Method pattern:**

```java
// Abstract Product
interface Animal {
    void makeSound();
}

// Concrete Products
class Dog implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Dog barks.");
    }
}

class Cat implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Cat meows.");
    }
}

// Creator (Abstract Factory)
abstract class AnimalFactory {
    abstract Animal createAnimal();

    void makeSound() {
        Animal animal = createAnimal();
        animal.makeSound();
    }
}

// Concrete Creators
class DogFactory extends AnimalFactory {
    @Override
    Animal createAnimal() {
        return new Dog();
    }
}

class CatFactory extends AnimalFactory {
    @Override
    Animal createAnimal() {
        return new Cat();
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        AnimalFactory dogFactory = new DogFactory();
        dogFactory.makeSound(); // Output: Dog barks

        AnimalFactory catFactory = new CatFactory();
        catFactory.makeSound(); // Output: Cat meows
    }
}
```

### Abstract Methods

Abstract methods in Java are declared without an implementation in abstract classes or interfaces. They provide a way to define a method signature that subclasses must implement.

**Example of abstract method in abstract class:**

```java
// Abstract class with abstract method
abstract class Shape {
    abstract void draw(); // Abstract method

    void display() {
        System.out.println("Displaying shape.");
    }
}

// Concrete subclass implementing abstract method
class Circle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing Circle.");
    }
}

// Main method to demonstrate usage
public class Main {
    public static void main(String[] args) {
        Shape shape = new Circle();
        shape.draw(); // Output: Drawing Circle.
        shape.display(); // Output: Displaying shape.
    }
}
```

### Summary

- **Abstract classes** and **interfaces** in Java provide mechanisms for abstraction, defining contracts, and promoting code reusability.
- **Extends** is used for inheritance, allowing subclasses to inherit behaviors and properties from superclasses.
- **Super** refers to the superclass methods, constructors, and instance variables from within a subclass.
- **Factory Method** pattern provides an interface (method) for creating objects, allowing subclasses to decide the type of objects created.
- **Abstract methods** are method signatures without an implementation, meant to be implemented by subclasses or classes that implement the interface.

These concepts are fundamental in Java programming, especially in object-oriented design and design patterns, enabling developers to write modular, reusable, and maintainable code.