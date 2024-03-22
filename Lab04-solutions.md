
---

## Exercise 2

### 1. Explain the benefits of using generic types
Generics in Java provide stronger type checks at compile time and the generic code is safer and cleaner. They allow for the creation of classes, interfaces, and methods with the capability to operate on any given type. The benefits include:

- **Type Safety:** Generics enforce type checks at compile-time, thus enhancing code safety by reducing runtime errors due to incorrect types.
- **Elimination of Casts:** With generics, explicit type casting is not needed, which makes the code cleaner and more readable.
- **Algorithm Reuse:** A single version of a generic algorithm can be applied to different types, increasing code reuse.

### 2. Explain the syntax of:
- **Generic class declaration:**
  A generic class is declared with type parameters in angle brackets. Example:
  ```java
  class Box<T> {
      private T t;
      // methods
  }
  ```
- **Generic method declaration:**
  A generic method includes type parameters before the return type. Example:
  ```java
  public <T> T getElement(List<T> list, int index) {
      return list.get(index);
  }
  ```

### 3. Explain what a raw type is, why it is unsafe, and why the raw types are allowed in Java
- A **raw type** is the generic class or interface name without its type parameter(s). It's unsafe because it doesn't enforce type safety, and can lead to `ClassCastException`s at runtime. Raw types exist for backward compatibility with code written before Java introduced generics.

### 4. Given `GenBox` as defined in `lst04_01` explain the compilation result of:
#### (a)
```java
GenBox gb1 = new GenBox(1);
gb1.set("abc");
gb1.set(new GenBox(true));
```
If `GenBox` is a raw type, it will accept any Object, and both lines compile. This is unsafe and can cause runtime exceptions.

#### (b)
```java
GenBox<Integer> gb2 = new GenBox<Integer>(1);
gb2.set("abc"); // Compilation error: Cannot convert from String to Integer
gb2.set(new GenBox<Integer>(true)); // Compilation error if GenBox<Boolean> is not subtype of GenBox<Integer>
```

### 5. [c] Complete the method header in the following code so that it compiles:
```java
public class Main {
    public static void main(String[] args) {
        Integer[] ints = {1, 2, 3};
        String[] strs = {"A", "B", "C"};
    
        print(ints);
        print(strs);
    }
    
    public static <T> void print(T[] elems) {
        for (int i = 0; i < elems.length; i++) {
            System.out.print(elems[i] + " ");
        }
        System.out.println();
    }
}
```

### 6. [c] Refactor the source code to `one file=one class` structure
To refactor, place each class definition in its own `.java` file with the file name matching the class name.

### 7. [c] Implement the generic class `Pair<F, S>`:
```java
import java.util.Objects;

public class Pair<F, S> {
    private F first;
    private S second;

    public Pair(F first, S second) {
        this.first = first;
        this.second = second;
    }

    public F getFirst() { return first; }
    public S getSecond() { return second; }

    public void setFirst(F first) { this.first = first; }
    public void setSecond(S second) { this.second = second; }

    @Override
    public String toString() {
        return "Pair{" + "first=" + first + ", second=" + second + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pair)) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(first, pair.first) && Objects.equals(second, pair.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }

    @Override
    public Pair<F, S> clone() {
        return new Pair<>(first, second);
    }
}
```
---



## Exercise 3

### 1. Explain the purpose of bounds for type variables
The purpose of using bounds for type variables in generics is to restrict the types that can be assigned to those variables. This guarantees that the generic classes or methods I create can work safely with the objects of the bounded types. For instance, by specifying a bound, I ensure that the generic type implements a certain interface or extends a certain class, allowing me to call the methods defined in those types without causing runtime errors.

### 2. Check if a type variable may have many interface bounds. Repeat this for class bounds.
In Java, a type variable can have multiple interface bounds, meaning I can specify that a type parameter must implement several interfaces. However, when it comes to class bounds, a type variable can only extend one class. If needed, it can also extend an additional interface or multiple interfaces alongside that one class.

Here’s how I declare a type with multiple interface bounds:

```java
class MyClass<T extends InterfaceA & InterfaceB & InterfaceC> {
    // My methods and fields go here
}
```

And here’s how I declare a type with one class bound and multiple interface bounds:

```java
class MyClass<T extends ClassA & InterfaceA & InterfaceB> {
    // My methods and fields go here
}
```

### 3. [c] Change the following generic function so that it compiles

Firstly, I'll define the `Moveable` interface:

```java
interface Moveable {
    void goTo(double x, double y);
}
```

Next, I'll apply this interface as the bound for the type variable in the `moveAll` function:

```java
private static <T extends Moveable> void moveAll(T[] elems, double x, double y) {
    for (T e : elems) {
        e.goTo(x, y);
    }
}
```

With this change, the `moveAll` method compiles and runs correctly, assuming all elements of the array implement the `Moveable` interface.

---

# Exercice 4

## 1. Notions of Generic Types

- **Invariance**: Une classe générique est dite invariante par rapport à son type de paramètre. Cela signifie que même si `B` est un sous-type de `A`, `GenBox<B>` n'est pas considéré comme un sous-type de `GenBox<A>`.

- **Covariance**: Si `B` est un sous-type de `A`, alors `GenBox<? extends A>` peut être utilisé pour référencer un objet de type `GenBox<B>`. Cela permet de lire des objets de `GenBox<B>` comme des objets de type `A`.

- **Contravariance**: Si `B` est un sous-type de `A`, alors `GenBox<? super B>` peut être utilisé pour référencer un objet de type `GenBox<A>`. Cela permet d'écrire des objets de type `B` dans un objet `GenBox<A>`.

## 2. Notions of Wildcards

- **Subtype wildcard** (`GenBox<? extends B>`): Signifie que le type générique peut être `B` ou un sous-type de `B`. Cela permet une certaine flexibilité en lecture, mais pas en écriture.

- **Supertype wildcard** (`GenBox<? super B>`): Signifie que le type générique peut être `B` ou un supertype de `B`. Cela permet une certaine flexibilité en écriture (en ajoutant des `B` ou sous-types de `B`), mais pas en lecture.

- **Unbounded wildcard** (`GenBox<?>`): Means that the generic type can be any type. It offers the greatest flexibility, but at the cost of limited access to methods that depend on the generic type.

## 3. Code Compilation Issues

### Lines that do not compile:

```java
class A {}
class B extends A {}
class C extends B {}
class GenBox<T> {
private T x;

public T getX() { return x; }
public void setX(T x) { this.x = x; }
//...
}

// Creating instances of GenBox with various type parameters
GenBox<B> gb1 = new GenBox<B>(); // Valid
GenBox<B> gb2 = new GenBox<C>(); // Error: Cannot convert from GenBox<C> to GenBox<B> because of invariance
GenBox<B> gb3 = new GenBox<A>(); // Error: Cannot convert from GenBox<A> to GenBox<B> because of invariance
B b1 = gb1.getX(); // Valid
gb1.setX(new B()); // Valid

GenBox<? extends B> gb4 = new GenBox<B>(); // Valid
GenBox<? extends B> gb5 = new GenBox<C>(); // Valid
GenBox<? extends B> gb6 = new GenBox<A>(); // Error: Cannot convert from GenBox<A> to GenBox<? extends B> because A is not a subtype of B
B b2 = gb5.getX(); // Valid, returns type B or a subtype of B
gb5.setX(new B()); // Error: Cannot assign to a wildcard-extended generic
gb5.setX(new C()); // Error: Cannot assign to a wildcard-extended generic

GenBox<? super B> gb7 = new GenBox<B>(); // Valid
GenBox<? super B> gb8 = new GenBox<C>(); // Error: Cannot convert from GenBox<C> to GenBox<? super B> because C is a subtype of B, not a supertype
GenBox<? super B> gb9 = new GenBox<A>(); // Valid
B b3 = gb9.getX(); // Error: The return type is of type Object, requires casting to B
gb9.setX(new B()); // Valid, can accept B or its subtypes
gb9.setX(new C()); // Valid, can accept C as it is a subtype of B

GenBox<?> gb10 = new GenBox<B>(); // Valid, unknown type, but compatible with any GenBox
GenBox<?> gb11 = new GenBox<C>(); // Valid, unknown type, but compatible with any GenBox
GenBox<?> gb12 = new GenBox<A>(); // Valid, unknown type, but compatible with any GenBox
Object b4 = gb10.getX(); // Valid, returns Object type since the generic type T is unknown
gb10.setX(new B()); // Error: Cannot assign to an unbounded wildcard generic
```

# Mini Project 04_01 (exc04_02)

## 1. Augmented Interfaces with Exception Handling and JavaDoc

### MyQueue Interface

```java
package agh.ii.prinjava.lab04.exc04_02;

import agh.ii.prinjava.lab04.exc04_02.impl.MyQueueDLLBImpl;

/**
 * Defines the contract for a generic queue data structure.
 * A queue is a collection designed for holding elements prior to processing.
 * It follows the FIFO (First-In-First-Out) principle, meaning that elements
 * are added to the end and removed from the beginning of the queue.
 *
 * @param <E> the type of elements held in this queue
 */
public interface MyQueue<E> {

  /**
   * Adds an element to the end of the queue.
   *
   * @param x the element to be added
   */
  void enqueue(E x);

  /**
   * Removes and returns the element at the beginning of the queue.
   * If the queue is empty, the behavior is unspecified and depends on the implementation.
   *
   * @return the element at the beginning of the queue
   */
  E dequeue();

  /**
   * Checks if the queue is empty.
   *
   * @return true if the queue contains no elements, false otherwise
   */
  default boolean isEmpty() {
    return numOfElems() == 0;
  }

  /**
   * Returns the number of elements in the queue.
   *
   * @return the number of elements in the queue
   */
  int numOfElems();

  /**
   * Retrieves, but does not remove, the element at the beginning of the queue.
   * If the queue is empty, the behavior is unspecified and depends on the implementation.
   *
   * @return the element at the beginning of the queue
   */
  E peek();

  /**
   * Factory method to create a new instance of a queue.
   * This method allows for a flexible creation of queue instances without
   * specifying the exact class of the queue at the point of creation.
   *
   * Pros:
   * - Provides a simple way to create a queue instance with default implementation.
   * - Encapsulates the instantiation logic, making the client code cleaner.
   *
   * Cons:
   * - Reduces flexibility by tying the interface to a specific implementation.
   * - Makes it harder to switch to a different implementation without changing the interface.
   *
   * @param <T> the type of elements the queue will hold
   * @return a new instance of MyQueue
   */
  static <T> MyQueue<T> create() {
    return new MyQueueDLLBImpl<>();
  }
}

```

### MyStack Interface

```java
package agh.ii.prinjava.lab04.exc04_02;

import agh.ii.prinjava.lab04.exc04_02.impl.MyStackDLLBImpl;

/**
 * Defines the contract for a generic stack data structure.
 * A stack is a collection that supports push and pop operations,
 * following the Last-In-First-Out (LIFO) principle.
 *
 * @param <E> the type of elements held in this stack
 */
public interface MyStack<E> {

  /**
   * Removes and returns the element at the top of the stack.
   * This method represents the pop operation of a stack.
   *
   * @return the element removed from the top of the stack
   * @throws IllegalStateException if the stack is empty
   */
  E pop();

  /**
   * Adds an element to the top of the stack.
   * This method represents the push operation of a stack.
   *
   * @param x the element to add to the stack
   */
  void push(E x);

  /**
   * Checks if the stack is empty.
   *
   * @return {@code true} if the stack contains no elements
   */
  default boolean isEmpty() {
    return numOfElems() == 0;
  }

  /**
   * Returns the number of elements in the stack.
   *
   * @return the number of elements in the stack
   */
  int numOfElems();

  /**
   * Retrieves, but does not remove, the element at the top of the stack.
   *
   * @return the element at the top of the stack
   * @throws IllegalStateException if the stack is empty
   */
  E peek();

  /**
   * Factory method to create a new instance of a stack.
   * This method facilitates the creation of a stack instance without
   * specifying the exact class that implements the stack interface.
   *
   * @param <T> the type of elements the stack will hold
   * @return a new instance of MyStack
   */
  static <T> MyStack<T> create() {
    return new MyStackDLLBImpl<>();
  }
}

```

## 2. Complete Implementations

### MyQueueDLLBImpl

```java
package agh.ii.prinjava.lab04.exc04_02.impl;

import agh.ii.prinjava.lab04.exc04_02.MyQueue;

/**
 * A doubly-linked list based implementation of the {@link MyQueue} interface.
 * This class provides queue functionalities (FIFO - First In, First Out data structure)
 * where elements are enqueued to the tail and dequeued from the head.
 *
 * @param <E> the type of elements held in this queue
 */
public class MyQueueDLLBImpl<E> implements MyQueue<E> {
  private Node<E> head = null; // Front of the queue
  private Node<E> tail = null; // End of the queue
  private int count = 0; // Number of elements in the queue

  /**
   * Inner static class representing a node in a doubly linked list.
   * Each node stores a reference to an element and links to both the next and the previous nodes in the list.
   *
   * @param <E> the type of element stored in the node
   */
  private static class Node<E> {
    E elem; // The element contained in the node
    Node<E> next; // Link to the next node in the queue
    Node<E> prev; // Link to the previous node in the queue

    /**
     * Constructs a new node with the specified element.
     *
     * @param elem the element to store in this node
     */
    Node(E elem) {
      this.elem = elem;
    }
  }

  /**
   * Adds an element to the end of the queue.
   * This method implements the enqueue operation of the queue,
   * adding a new element to the tail.
   *
   * @param x the element to be added to the queue
   */
  @Override
  public void enqueue(E x) {
    Node<E> newNode = new Node<>(x);
    if (tail == null) {
      head = tail = newNode;
    } else {
      tail.next = newNode;
      newNode.prev = tail;
      tail = newNode;
    }
    count++;
  }

  /**
   * Removes and returns the element from the front of the queue.
   * This method implements the dequeue operation of the queue,
   * removing the head element and returning its value.
   *
   * @return the element that was removed from the front of the queue, or null if the queue was empty
   */
  @Override
  public E dequeue() {
    if (head == null) {
      return null; // Queue is empty
    }
    E value = head.elem;
    head = head.next;
    if (head == null) {
      tail = null;
    } else {
      head.prev = null;
    }
    count--;
    return value;
  }

  /**
   * Returns the number of elements in the queue.
   *
   * @return the count of elements currently in the queue
   */
  @Override
  public int numOfElems() {
    return count;
  }

  /**
   * Retrieves, without removing, the element at the front of the queue.
   * This method implements the peek operation of the queue,
   * allowing observation of the head element without dequeuing it.
   *
   * @return the element at the front of the queue, or null if the queue is empty
   */
  @Override
  public E peek() {
    return (head != null) ? head.elem : null;
  }

}

```

### MyStackDLLBImpl

```java
package agh.ii.prinjava.lab04.exc04_02.impl;

import agh.ii.prinjava.lab04.exc04_02.MyStack;

/**
 * This class implements a stack using a doubly linked list.
 * It provides standard stack operations including push, pop, peek,
 * and checking the number of elements in the stack.
 *
 * @param <E> the type of elements stored in the stack
 */
public class MyStackDLLBImpl<E> implements MyStack<E> {
  private DLinkList<E> elems = new DLinkList<>();

  /**
   * Represents a node in the doubly linked list.
   * Each node holds an element and references to the next and previous nodes.
   *
   * @param <E> the type of the element stored in the node
   */
  private static class Node<E> {
    E elem; // The element contained in this node
    Node<E> next; // Reference to the next node in the list
    Node<E> prev; // Reference to the previous node in the list

    /**
     * Constructs a new Node instance.
     *
     * @param elem the element to be stored in the node
     */
    Node(E elem) {
      this.elem = elem;
    }
  }

  /**
   * Implements a doubly linked list to support stack operations.
   * Provides methods to add, remove, and access the first element,
   * which are used for stack operations.
   */
  private static class DLinkList<E> {
    private Node<E> head = null; // The head of the list, representing the top of the stack
    private int size = 0; // The number of elements in the list

    /**
     * Adds an element to the beginning of the list.
     * This method supports the push operation of the stack.
     *
     * @param elem the element to be added
     */
    void addFirst(E elem) {
      Node<E> newNode = new Node<>(elem);
      newNode.next = head;
      if (head != null) {
        head.prev = newNode;
      }
      head = newNode;
      size++;
    }

    /**
     * Removes and returns the element from the beginning of the list.
     * This method supports the pop operation of the stack.
     *
     * @return the element that was removed
     * @throws IllegalStateException if the list (stack) is empty
     */
    E removeFirst() {
      if (head == null) throw new IllegalStateException("Stack is empty");
      E elem = head.elem;
      head = head.next;
      if (head != null) {
        head.prev = null;
      }
      size--;
      return elem;
    }

    /**
     * Returns the first element of the list without removing it.
     * This method supports the peek operation of the stack.
     *
     * @return the first element of the list
     * @throws IllegalStateException if the list (stack) is empty
     */
    E getFirst() {
      if (head == null) throw new IllegalStateException("Stack is empty");
      return head.elem;
    }

    /**
     * Returns the number of elements in the list (stack).
     *
     * @return the size of the list
     */
    int size() {
      return size;
    }
  }

  /**
   * Removes the element at the top of the stack and returns it.
   * This method implements the pop operation.
   *
   * @return the element that was removed from the top of the stack
   */
  @Override
  public E pop() {
    return elems.removeFirst();
  }

  /**
   * Adds an element to the top of the stack.
   * This method implements the push operation.
   *
   * @param x the element to be added to the stack
   */
  @Override
  public void push(E x) {
    elems.addFirst(x);
  }

  /**
   * Returns the number of elements in the stack.
   *
   * @return the size of the stack
   */
  @Override
  public int numOfElems() {
    return elems.size();
  }

  /**
   * Returns the element at the top of the stack without removing it.
   * This method implements the peek operation.
   *
   * @return the element at the top of the stack
   */
  @Override
  public E peek() {
    return elems.getFirst();
  }
}


```

## 3. JavaDoc Comments

The JavaDoc comments have been included within the interface definitions above.

## 4. Writing Unit Tests

### MyQueueDLLBImplTest

```java
package agh.ii.prinjava.lab04.exc04_02.impl;

import agh.ii.prinjava.lab04.exc04_02.MyQueue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MyQueueDLLBImplTest {

  private MyQueue<Integer> queueOfInts;

  @BeforeEach
  void setUp() {
    queueOfInts = MyQueue.create();
  }

  @AfterEach
  void tearDown() {
    queueOfInts = null; // Clean up after each test
  }

  @Test
  void newQueueIsEmpty() {
    assertTrue(queueOfInts.isEmpty());
  }

  @Test
  void enqueueAndDequeueWorkProperly() {
    queueOfInts.enqueue(10);
    assertFalse(queueOfInts.isEmpty());
    assertEquals(10, queueOfInts.dequeue());
    assertTrue(queueOfInts.isEmpty());
  }

  @Test
  void dequeueOnEmptyQueueReturnsNull() {
    assertNull(queueOfInts.dequeue());
  }

  @Test
  void peekOnEmptyQueueReturnsNull() {
    assertNull(queueOfInts.peek());
  }

  @Test
  void peekReturnsTheFirstElementWithoutRemovingIt() {
    queueOfInts.enqueue(20);
    queueOfInts.enqueue(30);
    assertEquals(20, queueOfInts.peek());
    assertFalse(queueOfInts.isEmpty());
    assertEquals(20, queueOfInts.dequeue());
    assertEquals(30, queueOfInts.peek());
  }
}

```

### MyStackDLLBImplTest

```java
package agh.ii.prinjava.lab04.exc04_02.impl;

import agh.ii.prinjava.lab04.exc04_02.MyStack;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyStackDLLBImplTest {

  private MyStack<Integer> stackOfInts;

  @BeforeEach
  void setUp() {
    stackOfInts = MyStack.create();
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
  void pushIncreasesStackSize() {
    stackOfInts.push(1);
    assertEquals(1, stackOfInts.numOfElems());
  }

  @Test
  void popDecreasesStackSize() {
    stackOfInts.push(1);
    stackOfInts.pop();
    assertTrue(stackOfInts.isEmpty());
  }

  @Test
  void popReturnsLastPushedItem() {
    stackOfInts.push(1);
    stackOfInts.push(2);
    assertEquals(2, stackOfInts.pop());
    assertEquals(1, stackOfInts.pop());
  }

  @Test
  void peekReturnsLastPushedItemWithoutRemoval() {
    stackOfInts.push(1);
    stackOfInts.push(2);
    assertEquals(2, stackOfInts.peek());
    assertEquals(2, stackOfInts.pop());
    assertEquals(1, stackOfInts.numOfElems());
  }

  @Test
  void poppingFromEmptyStackThrowsException() {
    assertThrows(IllegalStateException.class, stackOfInts::pop);
  }

  @Test
  void peekingIntoEmptyStackThrowsException() {
    assertThrows(IllegalStateException.class, stackOfInts::peek);
  }
}

```


