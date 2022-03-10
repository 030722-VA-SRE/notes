## Abstract Classes

- An abstract class is a class that is declared `abstract` —it may or may not include abstract methods. Abstract classes cannot be instantiated, but they can be subclassed.
- An abstract class can have 0 or more abstract methods, but if a class has at least one abstract method then the whole class has to be abstract.
- An abstract class can have implemented methods as well.
- Use the `extends` keyword to extend an abstract class.

```java
public abstract class GraphicObject {
   // declare fields
   // declare nonabstract methods
   abstract void draw();
}

class Circle extends GraphicObject {
    void draw() {
        ...
    }
    void resize() {
        ...
    }
}

class Rectangle extends GraphicObject {
    void draw() {
        ...
    }
    void resize() {
        ...
    }
}
```

### Difference between interface and Abstract classes
- Conceptually, interfaces define behaviors and abstract classes are for concepts and inheritance.
- You can implement multiple interfaces, but you can extend only one class.