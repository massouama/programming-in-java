## Exercise 1

1. **Explain the concept of encapsulation and the way it is implemented in Java**


   Encapsulation is a fundamental object-oriented programming concept where the implementation details of a class are hidden from the users of the class. In Java, this is achieved by using access modifiers such as `private`, `protected`, and `public`. Fields and methods that should not be accessible directly from outside the class are made `private`, and access to them is provided through public methods, commonly known as getters and setters.

   For example, in the `RichDad` class, you might have private fields representing wealth and contacts, and you would provide public methods to modify or access these fields' values.

2. **Explain the following concepts:**

   - **Mutator method (setter)**

     A mutator method is used to set or modify the value of a private field. It is also known as a setter. It typically has a `void` return type and takes one parameter which is the new value to be set. This parameter is then used to update the private field.

   - **Accessor method (getter)**

     An accessor method is used to get or retrieve the value of a private field. It is also known as a getter. It typically returns the value of the private field and does not take any parameters.

3. **Explain two different meanings/roles of:**

   - **this**

     The `this` keyword in Java has two main uses. Firstly, it is used within an instance method or a constructor to refer to the current object—the object whose method or constructor is being called. You use `this` to differentiate between instance variables and parameters when they have the same name. Secondly, `this` can be used to call another constructor from a constructor within the same class.

   - **super**

     The `super` keyword refers to the superclass (parent class) of an object and is used to call the superclass's methods and constructors. This is especially useful when you want to call a parent class's constructor, or when overriding a method and you want to call the parent class's version of that method, as seen in the `RichDadsKid` class.

4. **Explain the concept of inheritance and the way it is implemented in Java**

   Inheritance is another core concept of object-oriented programming where one class (child or subclass) can inherit fields and methods from another class (parent or superclass). In Java, inheritance is implemented using the `extends` keyword. A class that inherits from another class can use all the public and protected members of the parent class as if they were its own.

   Looking at the `RichDadsKid` class, it extends the `RichDad` class, which means it inherits the fields and methods from `RichDad`.

5. **Explain the concept of polymorphism, name its three main kinds/forms, and explain the way they are implemented in Java**

   Polymorphism in Java is the ability for a variable, function, or object to take on multiple forms. The three main kinds of polymorphism are:
   - **Ad hoc polymorphism**: This is achieved by method overloading and operator overloading.
   - **Parametric polymorphism**: This is achieved through generics where the type is a parameter.
   - **Subtype polymorphism**: This is when a function works with objects of several different classes that are all subclasses of the same superclass.

   In Java, subtype polymorphism is commonly implemented, where an object of a subclass can be treated as an object of its superclass.

6. **Explain the relationship between inheritance and sub-type/inclusion polymorphism**

   Inheritance is a mechanism where one class can derive from another class for a hierarchical relationship. Subtype polymorphism, or inclusion polymorphism, is a form of polymorphism where a subclass instance is treated as an instance of its parent class. It allows for methods to use objects of different subclasses that share the same superclass as if they were all objects of the superclass.

7. **Read Composition vs. Inheritance: How to Choose?**

   This requires reading an article or a section in a book to understand when to use composition over inheritance. In general, composition is favored over inheritance in many design scenarios because it offers better encapsulation and avoids the issues with deep inheritance hierarchies.

8. **In the analysed code identify testable methods and write a couple of unit tests for them (the IDE can help with it)**

   Here is an example of unit tests for a `Rectangle` class:

   ```java
   package agh.ii.prinjava.lab01.lst01_03;

   import org.junit.jupiter.api.Test;

   import static org.junit.jupiter.api.Assertions.*;

   class RectangleTest {

       @Test
       void area() {
           Rectangle rectangle = new Rectangle(5, 10);
           double expectedArea = 50; // Area = width * height
           assertEquals(expectedArea, rectangle.area());
       }

       @Test
       void perimeter() {
           Rectangle rectangle = new Rectangle(5, 10);
           double expectedPerimeter = 30; // Perimeter = 2 * (width + height)
           assertEquals(expectedPerimeter, rectangle.perimeter());
       }
   }

## Exercise 2

1. **Static Concepts:**

   - **Static Variable (field/class member)**:

     A static variable is associated with the class rather than an instance of the class. All instances share the same static variable. Static variables are initialized when the class is loaded.

   - **Static Constant**:

     A static constant is a static variable that is marked as `final`. This means that once it has been assigned, its value cannot be changed.

   - **Static Method**:

     A static method is a method that belongs to the class and not to an instance of the class. It can be called without needing to create an instance of the class.

2. **Why Static Constants are Often Public:**

   Static constants are often public because they are used as values that need to be globally accessible both inside and outside of the class, but whose value should not be changed. They are often used to define configurations or properties that are constant and do not change throughout the execution of the program.

3. **Why Static Methods Do Not Have Access to Instance Members:**

   Static methods do not have access to instance members (fields and methods) because they are not associated with any specific instance of the class. Instance members are tied to specific objects, and without a reference to a specific object, a static method cannot utilize them.

4. **Example of Applying a Static Method:**

   An example of applying a static method is a utility method for calculating the area of a circle. This method can be part of a utility class and does not require an instance of the class to be utilized.

   ```java
   public class MathUtils {
       public static double calculateCircleArea(double radius) {
           return Math.PI * radius * radius;
       }
   }

   // Usage
   public class Main {
       public static void main(String[] args) {
           double area = MathUtils.calculateCircleArea(5.0);
           System.out.println("Area of the circle: " + area);
       }
   }

## Exercise 3


1. **Describe the object initialization process for a class derived from the `Object` class**:


   - **Default initialization**: Fields of a class are initialized to default values if not explicitly initialized (e.g., `0` for numbers, `false` for boolean, `null` for objects).
   - **Static variables and static blocks**: Static variables and static initializers are executed in the order they are defined when the class is loaded.
   - **Instance variables and instance initializers**: Fields and instance initializers are processed in the order they appear when an object is instantiated.
   - **Constructors**: After instance variables are initialized, the constructor is called to perform any final initialization.

2. **For the class `D9` from `ClassFamily.java`**:

   ## Class Inheritance Diagram

   ```plaintext
   B1
   └─> D1
       └─> D2
           └─> D3
               └─> D4
                   └─> D5
                       └─> D6
                           └─> D7
                               └─> D8
                                   └─> D9


  In this diagram, the └─> symbol is used to denote the inheritance direction from parent to child class, showing a clear and organized path of inheritance down to D9.

3. **Compare capabilities of constructors and factory methods**:
   - **Constructors** are special methods used to create a new object instance of a class. They initialize the object and cannot return a subtype of the class they construct.
   - **Factory methods** are regular static methods that return an object of a class. They provide greater flexibility as they can return any subtype of the declared return type, which can be a different class altogether. Factory methods can also perform additional logic such as caching instances or other pre-instantiation operations.

4. **Applications of the singleton pattern**:
   - The singleton pattern is used to ensure that only one instance of a class is created, accessible globally. For example, it can be used to create a single configuration manager that is available across an application, or to manage a database connection where a single shared connection is needed.

5. **Writing unit tests for singletons from `lst01_08`**:

   Here's how you could write a unit test for an `EagerSingleton` class to ensure that it properly enforces the singleton pattern:

   ```java
   import static org.junit.Assert.assertSame;
   import org.junit.Test;

   public class EagerSingletonTest {

       @Test
       public void testSingleton() {
           EagerSingleton instance1 = EagerSingleton.getInstance();
           EagerSingleton instance2 = EagerSingleton.getInstance();
           assertSame(instance1, instance2);
       }
   }


## exercise 4

1. **Explain a strategy for defining immutable objects:**
   To define an immutable object in Java, you should:
   - Declare the class as `final` so it can’t be extended.
   - Make all fields `private` and `final` so that their values are set once upon construction and never changed.
   - Provide no setters or any methods that modify fields or objects referred to by fields.
   - If the class has mutable object fields, then they must be defensively copied when passed between the class and its caller.

2. **Compare the concepts of the immutable object and immutable class:**
   - An immutable object is an instance of a class whose state cannot be changed after it is created.
   - An immutable class is a class that is designed in such a way that objects created from it are always immutable. Once an instance of an immutable class is created, the object’s state cannot be altered.

3. **Explain the advantages of immutable objects:**
   - **Simplicity:** Immutable objects are much easier to understand and use because their state does not change.
   - **Thread Safety:** Immutable objects are naturally thread-safe, as state cannot change after construction, eliminating synchronization concerns.
   - **Safety from Bugs:** Since their state does not change, they are less prone to bugs.
   - **Good for Caching:** Immutable objects are good candidates for caching because you don't need to worry about the value changes.
   - **Hashing advantage:** Since their state does not change, their hashcode doesn’t change, which makes them great for keys in maps.

4. **Give at least two uses of the Java Records:**
   - **Data Carrier Classes:** Java Records are excellent for creating data carrier classes where the sole purpose is to communicate data in a type-safe way.
   - **DTOs (Data Transfer Objects):** They are used as DTOs which are often used to transfer data across different layers of an application.
   - **Pattern Matching:** They can be used in pattern matching, which is expected to be a Java feature in the future, to deconstruct an object.

5. **Write a couple of unit tests for 'helloImmutable' and 'helloJavaRecord'**

   ```java
   import static org.junit.jupiter.api.Assertions.*;
   import org.junit.jupiter.api.Test;
   
   class HelloImmutableTest {
   
       @Test
       void testImmutability() {
           String expectedName = "Java";
           int expectedNumber = 42;
           HelloImmutable obj = new HelloImmutable(expectedName, expectedNumber);
   
           assertEquals(expectedName, obj.getName());
           assertEquals(expectedNumber, obj.getNumber());

           HelloImmutable newObj = new HelloImmutable(expectedName, expectedNumber + 1);
           assertNotEquals(obj, newObj);
       }
   
       @Test
       void testConsistentHashCode() {
           HelloImmutable obj1 = new HelloImmutable("Java", 42);
           HelloImmutable obj2 = new HelloImmutable("Java", 42);
   
           assertEquals(obj1.hashCode(), obj2.hashCode());
       }
   
       @Test
       void testEquality() {
           HelloImmutable obj1 = new HelloImmutable("Java", 42);
           HelloImmutable obj2 = new HelloImmutable("Java", 42);
   
           assertEquals(obj1, obj2);
       }
   }
   
   import static org.junit.Assert.*;
   import org.junit.Test;
   
   public class HelloJavaRecordTest {
       
       @Test
       public void testRecordEquality() {
           HelloJavaRecord record1 = new HelloJavaRecord("Hello", "World");
           HelloJavaRecord record2 = new HelloJavaRecord("Hello", "World");
           assertEquals(record1, record2);
       }
   
       @Test
       public void testRecordHashCode() {
           HelloJavaRecord record1 = new HelloJavaRecord("Hello", "World");
           HelloJavaRecord record2 = new HelloJavaRecord("Hello", "World");
           assertEquals(record1.hashCode(), record2.hashCode());
       }

## Exercise 5

1. **Difference between `==` operator and `equals` method in Java (consider primitive and reference types)**:
   - The `==` operator is used to check if two primitive values are exactly the same or if two reference variables point to the same object in memory.
   - The `equals` method is intended to check logical equality of two objects. By default, it behaves like `==` for reference types, but it can be overridden to compare the contents of objects.

2. **Explaining the formula `o1.equals(o2) implies hashCode(o1) == hashCode(o2)`**:
   - This principle asserts that if two objects are considered equal by the `equals` method, they must have the same hash code. This consistency is crucial for the correct operation of hash-based collections such as `HashSet` and `HashMap`.

3. **Familiarize yourself with the Java Object class**:
   - The `Object` class is the superclass of all classes in Java. Every class that does not explicitly extend another class implicitly extends `Object`. This class provides foundational methods like `equals`, `hashCode`, and `toString` that can be overridden to suit the needs of subclasses.

4. **General contract of `hashCode` and `equals`**:
   - The contract stipulates that two objects considered equal via `equals(Object)` must have the same hash code. Conversely, unequal objects do not need to have distinct hash codes, although it is preferable for hash table performance.

5. **Generate JavaDoc documentation for the project**:
   - JavaDoc is a tool used to generate API documentation in HTML format from Java source code. It is used to describe the functionality and usage of classes, methods, and variables in a project.
