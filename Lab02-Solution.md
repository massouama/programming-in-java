# Answers to Questions about Java

## 1 Revision of the Java

- Done

## 2. Advantages of using constants in programming
- Code security**: constants cannot be modified once initialized, which helps prevent accidental changes to values that shouldn't change.
- Code maintenance**: constants make code more readable and easier to understand, as they can be named in meaningful ways.
- **Performance optimization**: using constants can help the compiler optimize code by knowing that certain values will never change.

## 3. Meaning of the `final` keyword
- Local variables**: Once initialized, a variable cannot be modified.
- Instance variables** : The variable must be initialized at declaration time or in the constructor, and cannot be modified thereafter.
- **Static constants**: Used to define a constant at class level, which will be the same and unmodifiable for all instances.
- **Methods**: The method cannot be overridden or modified by inheriting classes.
- Classes**: The class cannot be extended (no class can inherit from this class).

## 4. Questions about immutability
- If a class contains only private data fields and no defining methods, is the class immutable?
- Yes**, because there's no way to modify the data fields after the object has been built.
- If all the data fields in a class are private and of primitive type, and the class contains no defining methods, is the class immutable? **Yes**, for the same reason as above. Private primitive types without setters contribute to immutability.

## 5 Immutability of Class C
The following `C` class is not immutable, as it directly exposes its `values` array via the `getValues()` method. Even if the array is private, returning it directly allows other classes to modify the contents of the array, which violates immutability.

```Java

public class C {
private int[] values;

    public int[] getValues() {
        return values;
    }
}
```
## 6. Refactoring for immutability

```java

public class C {
private int[] values;

    public int[] getValues() {
        // Returns a copy of the array to preserve immutability
        return values.clone();
    }
}
```
## Exercise 2

## Analysis of singleton implementation

### Is this correct?
Yes, using an enumeration to implement the Singleton model is correct in Java.

### Is it thread-safe?
Enumeration instantiation is thread-safe. However, the `setValue` method is not synchronized, which could cause problems if several threads try to modify `value` at the same time.

## Refactoring for a one-file-one-class structure

### Proposed refactoring:
Each class or enumeration would be contained in its own source file to improve readability and maintainability.

### Example file for the singleton:
```java
// EnumBasedSingleton.java
public enum EnumBasedSingleton {
    INSTANCE;

    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
```

Translated with DeepL.com (free version)
## Exercise 3


1. **Look briefly at the chapters of Java Language Specification related to Nested classes (a static and non-static member classes, local classes, and anonymous classes)**

   The Java Language Specification provides details about the different types of nested classes available in Java and their characteristics. For a comprehensive understanding, it's best to refer to the relevant sections of the JLS.

2. **Explain the main differences between the types of nested classes available in Java**

   - **Static Member Classes:** Are associated with the outer class and can access all of its static members but need an explicit instance of the outer class to access non-static members.

   - **Non-Static Member Classes (Inner Classes):** Are associated with an instance of the outer class and have access to all of its members, both static and non-static. They can reference the enclosing instance.

   - **Local Classes:** Are classes that are defined within a block (typically, a method) and are not accessible outside that block. They can access final or effectively final local variables.

   - **Anonymous Classes:** Are a form of local class without a name and are defined and instantiated in a single expression. They are used for instantiating classes that are intended for immediate use.

3. **Answer the following questions:**

   - **Can an inner class be used in a class other than the class in which it nests?**
      - Yes, inner classes can be used outside of their enclosing class if they are made accessible, such as by being declared public or package-private, but they require an instance of the enclosing class.

   - **Can the modifiers public, protected, private, and static be used for inner classes?**
      - The modifiers public, protected, and private can control the visibility of inner classes. However, the static modifier cannot be used because inner classes are inherently associated with an instance of the enclosing class. The static modifier is only applicable to nested static classes.

4. **[c] Refactor the source code to one file=one class structure**

- Here we've moved the nested files into classes so that each class has its own file.

## Exercise 4

## Exercise Analysis and Responses

1. **Explain the main differences between abstract classes and interfaces in Java:**
  - **Abstract Classes:** Abstract classes are classes that cannot be instantiated on their own and can contain a mix of methods declared with or without an implementation. They can have member variables and constructors, and they can define methods with default behavior. Abstract classes are used when there are methods that should be shared only with certain subclasses.
  - **Interfaces:** Interfaces are used to represent a contract or a capability. An interface cannot have any method implementations (prior to Java 8); it can only contain method signatures and static final variables (constants). Since Java 8, interfaces can have default and static methods with a body. Interfaces are implemented rather than extended by a class, and a class can implement multiple interfaces.

2. **List the possible types of members in Java interfaces:**
  - Methods (abstract methods by default, and default or static methods with a body since Java 8)
  - Constant variables (public static final)
  - Since Java 9, private methods (for internal use within default methods)

3. **In the following list, select the correct definition of an abstract class:**
  - The correct definition is `abstract class E { abstract void m1(); }`. This is because abstract classes must be explicitly declared as abstract, and they can have abstract methods, which are methods without an implementation.

4. **In the following list, select the correct definition of an interface:**
  - The correct definition is `interface D { void m1(); }`. Interfaces do not need the `abstract` keyword for their methods, as they are implicitly abstract.

5. **Explain the result of the execution of the Main class:**
  - When executing the `Main` class, an instance `b` of class `B` is created. The `instanceof` operator is used to check whether this instance is an instance of `A` or `C`.
  - `B` is a subclass of `D` and implements the interface `A`. Thus, `b instanceof A` will return true, and the string "b is an instance of A" will be printed.
  - However, `B` does not have a direct relationship with `C` (they are not in the same class hierarchy), so `b instanceof C` will return false, and the corresponding message will not be printed.

The output of the execution of the `Main` class will be:



### 6. Execution result of main Class

```java
interface A {}
class C {}
class D extends C {}
class B extends D implements A {}

public class Main {
  public static void main(String[] args) {
    B b = new B();
    if (b instanceof A) {
      System.out.println("b is an instance of A");
    }
    if (b instanceof C) {
      System.out.println("b is an instance of C");
    }
  }
}
```
b is an instance of A
b is an instance of C.\
Because B implements A and extends D, which in turn extends C. Therefore, b is an instance of both A and C.

### 7. [c] Refactor the source code to one file-one class structure

- seeing this in github


## exercise 5

## 1. Explain the relationship between lambda expressions and functional interfaces
The chapters on abstract classes and functional interfaces in the Java language specification detail how these constructs support abstraction in object-oriented programming.

## 2. Explain the relationship between lambda expressions and functional interfaces
Lambda expressions provide a concise syntax for implementing a method of a functional interface without creating a traditional anonymous class.

## 3 Write functional interfaces that correspond to the following function types:
Functional interfaces according to the functional signatures provided:

1. **Functional Interface for `void -> int`:**

    ```java
    @FunctionalInterface
    interface Supplier {
        int get();
    }

    // Anonymous class implementation
    Supplier supplier = new Supplier() {
        @Override
        public int get() {
            return 42; // returns a constant integer
        }
    };

    // Lambda expression implementation
    Supplier supplierLambda = () -> 42; // returns a constant integer
    ```

2. **Functional Interface for `int -> void`:**

    ```java
    @FunctionalInterface
    interface Consumer {
        void accept(int value);
    }

    // Anonymous class implementation
    Consumer consumer = new Consumer() {
        @Override
        public void accept(int value) {
            System.out.println(value); // prints the integer value
        }
    };

    // Lambda expression implementation
    Consumer consumerLambda = (value) -> System.out.println(value); // prints the integer value
    ```

3. **Functional Interface for `int -> int`:**

    ```java
    @FunctionalInterface
    interface Function {
        int apply(int value);
    }

    // Anonymous class implementation
    Function function = new Function() {
        @Override
        public int apply(int value) {
            return value * 2; // returns the integer value multiplied by 2
        }
    };

    // Lambda expression implementation
    Function functionLambda = (value) -> value * 2; // returns the integer value multiplied by 2
    ```

4. **Functional Interface for `(int, int) -> void`:**

    ```java
    @FunctionalInterface
    interface BiConsumer {
        void accept(int value1, int value2);
    }

    // Anonymous class implementation
    BiConsumer biConsumer = new BiConsumer() {
        @Override
        public void accept(int value1, int value2) {
            System.out.println(value1 + value2); // prints the sum of the two integer values
        }
    };

    // Lambda expression implementation
    BiConsumer biConsumerLambda = (value1, value2) -> System.out.println(value1 + value2); // prints the sum of the two integer values
    ```

## 4. Refactor the source code to one file-one class structure

Here we've moved the nested files into classes so that each class has its own file.

## Mini Projet (exc02_01)

## 1. Add JavaDoc comments to the interface and all its methods

```java
/**
 * Interface for a stack of integers.
 * This interface defines the basic operations for a stack data structure.
 */
public interface StackOfInts {

    /**
     * Removes the top element of the stack and returns it.
     * @return the element at the top of the stack
     * @throws IllegalStateException if the stack is empty
     */
    int pop();

    /**
     * Adds an element to the top of the stack.
     * @param x the element to add to the stack
     */
    void push(int x);

    /**
     * Checks if the stack is empty.
     * @return true if the stack is empty, false otherwise
     */
    default boolean isEmpty() {
        return numOfElems() == 0;
    }

    /**
     * Returns the number of elements in the stack.
     * @return the number of elements in the stack
     */
    int numOfElems();

    /**
     * Returns the top element of the stack without removing it.
     * @return the element at the top of the stack
     * @throws IllegalStateException if the stack is empty
     */
    int peek();
}
```
## 2. Add JavaDoc comments to LinkedListBasedImpl (the class itself and all its methods)

```java
package agh.ii.prinjava.lab02.exc02_01.impl;

import agh.ii.prinjava.lab02.exc02_01.StackOfInts;

/**
 * Implementation of the StackOfInts interface using a singly linked list.
 */
public class LinkedListBasedImpl implements StackOfInts {

    private static class Node {
        int elem; // Element contained in the node
        Node next; // Reference to the next node in the list

        /**
         * Node constructor.
         * @param elem the integer element to be stored in the node
         * @param next reference to the next node in the list
         */
        public Node(int elem, Node next) {
            this.elem = elem;
            this.next = next;
        }
    }

    private Node first = null; // Reference to the first node of the list (top of the stack)
    private int numOfElems = 0; // Number of elements in the stack

    /**
     * Removes and returns the element at the top of the stack.
     * @return the element at the top of the stack
     * @throws IllegalStateException if the stack is empty
     */
    @Override
    public int pop() {
        throw new IllegalStateException("To be implemented");
    }

    /**
     * Adds an element to the top of the stack.
     * @param x the element to push onto the stack
     */
    @Override
    public void push(int x) {
        throw new IllegalStateException("To be implemented");
    }

    /**
     * Returns the number of elements in the stack.
     * @return the number of elements in the stack
     */
    @Override
    public int numOfElems() {
        return numOfElems;
    }

    /**
     * Returns but does not remove the element at the top of the stack.
     * @return the element at the top of the stack
     * @throws IllegalStateException if the stack is empty
     */
    @Override
    public int peek() {
        throw new IllegalStateException("To be implemented");
    }
}
```
## 3. Complete the linked list based implementation - LinkedListBasedImpl


```java
package agh.ii.prinjava.lab02.exc02_01.impl;

import agh.ii.prinjava.lab02.exc02_01.StackOfInts;

public class LinkedListBasedImpl implements StackOfInts {

    private Node first = null;
    private int numOfElems = 0;

    @Override
    public int pop() {
        if (first == null) {
            throw new IllegalStateException("Cannot pop from an empty stack");
        }
        int elem = first.elem;
        first = first.next; // remove the top element by pointing first to the next Node
        numOfElems--; // decrease the count of elements
        return elem;
    }

    @Override
    public void push(int x) {
        first = new Node(x, first); // create a new Node and make it the top of the stack
        numOfElems++; // increase the count of elements
    }

    @Override
    public int numOfElems() {
        return numOfElems;
    }

    @Override
    public int peek() {
        if (first == null) {
            throw new IllegalStateException("Cannot peek at an empty stack");
        }
        return first.elem; // return the element of the first Node without removing it
    }

    private static class Node {
        int elem; // the element value
        Node next; // reference to the next node in the list

        public Node(int elem, Node next) {
            this.elem = elem;
            this.next = next;
        }
    }
}
```

## 4. Write unit tests for different cases

```java
package agh.ii.prinjava.lab02.exc02_01.impl;

import agh.ii.prinjava.lab02.exc02_01.StackOfInts;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListBasedImplTest {

  private StackOfInts stackOfInts;

  @BeforeEach
  void setUp() {
    stackOfInts = new LinkedListBasedImpl();
  }

  @AfterEach
  void tearDown() {
    stackOfInts = null;
  }

  @Test
  void newStackIsEmpty() {
    assertTrue(stackOfInts.isEmpty());
  }

  @Test
  void pop() {
    stackOfInts.push(1);
    assertEquals(1, stackOfInts.pop());
    assertTrue(stackOfInts.isEmpty());
  }

  @Test
  void push() {
    stackOfInts.push(1);
    assertFalse(stackOfInts.isEmpty());
  }

  @Test
  void numOfElems() {
    assertEquals(0, stackOfInts.numOfElems());
    stackOfInts.push(1);
    assertEquals(1, stackOfInts.numOfElems());
  }

  @Test
  void peek() {
    stackOfInts.push(2);
    stackOfInts.push(3);
    assertEquals(3, stackOfInts.peek());
    assertEquals(2, stackOfInts.numOfElems()); // Check that peek does not change the number of elements
  }
}

```
## 5. Add JavaDoc comments to ArrayBasedImpl (to the class itself and all its methods)

```java
package agh.ii.prinjava.lab02.exc02_01.impl;

import agh.ii.prinjava.lab02.exc02_01.StackOfInts;

/**
* An array-based implementation of the StackOfInts interface.
* This implementation uses a dynamic array to store the stack elements.
  */
  public class ArrayBasedImpl implements StackOfInts {

  private int[] elems; // Array used to store the elements of the stack
  private int numOfElems = 0; // The current number of elements in the stack
  private int maxSize; // The maximum size of the stack

  /**
  * Constructor for the array-based stack implementation.
  * Initializes the stack with a default size.
    */
    public ArrayBasedImpl() {
    maxSize = 50; // default size
    elems = new int[maxSize];
    }

  /**
  * Removes the element at the top of the stack and returns it.
  * @return The top element of the stack
  * @throws IllegalStateException if the stack is empty
    */
    @Override
    public int pop() {
    if (numOfElems == 0) {
    throw new IllegalStateException("Cannot pop from an empty stack");
    }
    int retValue = elems[--numOfElems];
    elems[numOfElems] = 0; // Optional: nullify the popped element
    return retValue;
    }

  /**
  * Adds an element to the top of the stack.
  * @param x The element to be added to the stack
    */
    @Override
    public void push(int x) {
    if (numOfElems == maxSize) {
    throw new IllegalStateException("Cannot push on a full stack");
    }
    elems[numOfElems++] = x;
    }

  /**
  * Returns the number of elements currently on the stack.
  * @return The number of elements on the stack
    */
    @Override
    public int numOfElems() {
    return numOfElems;
    }

  /**
  * Returns the element at the top of the stack without removing it.
  * @return The top element of the stack
  * @throws IllegalStateException if the stack is empty
    */
    @Override
    public int peek() {
    if (numOfElems == 0) {
    throw new IllegalStateException("Cannot peek at an empty stack");
    }
    return elems[numOfElems - 1];
    }

  // Additional private methods or fields can be added below
  }
```

## 6. Write unit tests for different cases (i.e. apply a TDD-like approach)

```java

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArrayBasedImplTest {

    private StackOfInts stack;

    @BeforeEach
    public void setUp() {
        stack = new ArrayBasedImpl();
    }

    @Test
    public void testIsEmptyInitially() {
        assertTrue(stack.isEmpty(), "Stack should be empty initially");
    }

    @Test
    public void testPushPopSingleElement() {
        stack.push(1);
        assertFalse(stack.isEmpty(), "Stack should not be empty after push");
        assertEquals(1, stack.pop(), "Pop should return the last pushed element");
        assertTrue(stack.isEmpty(), "Stack should be empty after pop");
    }

    @Test
    public void testPeekSingleElement() {
        stack.push(2);
        assertEquals(2, stack.peek(), "Peek should return the last pushed element without removing it");
        assertFalse(stack.isEmpty(), "Stack should not be empty after peek");
    }

    @Test
    public void testPushPopMultipleElements() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.pop(), "Pop should return the last pushed element");
        assertEquals(2, stack.pop(), "Pop should return the next to last pushed element");
        assertEquals(1, stack.pop(), "Pop should return the first pushed element");
        assertTrue(stack.isEmpty(), "Stack should be empty after popping all elements");
    }

    @Test
    public void testNumOfElems() {
        assertEquals(0, stack.numOfElems(), "numOfElems should be 0 initially");
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.numOfElems(), "numOfElems should reflect the number of elements pushed");
    }

    @Test
    public void testPopEmptyStack() {
        assertThrows(IllegalStateException.class, () -> stack.pop(), "Popping from an empty stack should throw IllegalStateException");
    }

    @Test
    public void testPeekEmptyStack() {
        assertThrows(IllegalStateException.class, () -> stack.peek(), "Peeking into an empty stack should throw IllegalStateException");
    }

    // Additional tests could include testing for stack overflow, if applicable.
}


```

## 7. Complete the array based implementation - ArrayBasedImpl

```java

public class ArrayBasedImpl implements StackOfInts {
    private int[] stack;
    private int numOfElems = 0;
    private int capacity = 10; // Initial capacity

    public ArrayBasedImpl() {
        stack = new int[capacity];
    }

    @Override
    public int pop() {
        if (numOfElems == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack[--numOfElems];
    }

    @Override
    public void push(int x) {
        if (numOfElems == capacity) {
            resize();
        }
        stack[numOfElems++] = x;
    }

    private void resize() {
        capacity *= 2;
        int[] newStack = new int[capacity];
        System.arraycopy(stack, 0, newStack, 0, stack.length);
        stack = newStack;
    }

    @Override
    public int numOfElems() {
        return numOfElems;
    }

    @Override
    public int peek() {
        if (numOfElems == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack[numOfElems - 1];
    }
}


```