# Implicit Constructors

Java has many _implicit_ behaviors; actions that happen automatically and invisibly. 

This can make it difficult to understand what is really happening under the hood. Some of these behaviors relate to constructors.

One such instance is when the Java compiler provides a default no-arg constructor if you do not provide one and another is with invoking a super class's constructor from within a constructor. 

Take a look at the following code:

```java
class Animal {}
```

We simply define a class `Animal`. We didn't define any constructors, so the compiler will add a no-arg one for us and the class will resemble the following after compilation:

```java
class Animal {
    //The below constructor is implicitly added by the compiler**
    public Animal() { }

}
```

One of the rules of a constructor is that it must have a call to invoke its super class's constructor.

> The exception to this rule is the constructor of the Object class which actually creates an object in memory or if you invoke this() to call another constructor from within the class. 

This will happen implicitly, whether you write the code or not. Again, the compiler will assist you here. 
So our Animal class will actually look like the following:

```java
class Animal {
    //the below constructor is implicitly added by the compiler
    public Animal() {
        super(); //added by the compiler
    }
}
```

## Handling a larger inheritance hierarchy

The compiler will continue to add calls to `super()` and create no-arg constructors for as many classes that you define that need them. 
Let's update our example from earlier and define a Dog class that will extend Animal. 

```java
class Animal {}

public class Dog extends Animal {  
    private String name;  
    private String breed;

    public Dog(String name, String breed) {  
        this.name = name;  
        this.breed = breed;  
    }  
}
```

We defined a constructor in the Dog class that sets its two instance variables `name` and `breed`. 

We created a constructor for the Dog class, so the compiler won't add a no-arg version for us, but it will add a call to `super()`. If we add in the other implicit calls the compiler adds the code would look like this: 

```java
class Animal {
    //the below constructor is implicitly added by the compiler
    public Animal() {
        super(); //added by the compiler
    }
}

public class Dog extends Animal {  
    private String name;  
    private String breed;

    public Dog(String name, String breed) {  
        super(); // implicit call to the superclass constructor; this is added by the compiler  
        this.name = name;  
        this.breed = breed;  
    }  
}
```

With this the inheritance hierarchy is complete with Dog invoking Animal which will invoke Object. 

No matter how you chain constructors, _eventually_ the superclass constructor _must_ be called. This guarantees that at the end of the chain, the Object class constructor is getting called, so the object can actually be created in memory.

## Implicit Constructor Pitfalls

When creating constructors, you must ensure that you don't break the superclass chain. 
Take a look at the following code: 

```java
class Animal {
    public Animal(String name) {}
}

public class Dog extends Animal {  
    private String name;  
    private String breed;

    public Dog(String name, String breed) {  
        this.name = name;  
        this.breed = breed;  
    }
}
```

This code will _not_ compile. Can you guess why?

The reason is because of the automatic addition of the call to `super()` from constructors added by the compiler. 

When the compiler handles your code it'll add a call to `super()` as the first line in both Dog's and Animal's constructors. So your code would resemble the following:

```java
class Animal {
    public Animal(String name) {
        super(); //added by the compiler
    }
}

public class Dog extends Animal {  
    private String name;  
    private String breed;

    public Dog(String name, String breed) {
        super(); //added by the compiler
        this.name = name;  
        this.breed = breed;  
    }
}
```

The problem exists in Dog's class. The call to `super()` will attempt to invoke a no-arg constructor in Animal class. Unfortunately, Animal doesn't have a no-arg constructor! The compiler will also not create one for the Animal class because we defined a constructor ourselves. 

This breaks the superclass constructor chain and the compiler reports an error. 

The fix would be to add an explicit call to `super("")`, passing in a String argument to match Animal's only constructor. This will complete the superclass constructor chain.