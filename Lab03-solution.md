## Exercise 2

1. **Look briefly at the chapters of Java Language Specification related to:**

    - `throws` clause
    - `throw` statement
    - `try` statement

2. **Explain the differences between checked and unchecked exceptions:**
   Checked exceptions are exceptions that are checked at compile-time. They must be either caught within the code using `try-catch` blocks or declared to be thrown in the method signature using the `throws` keyword. Unchecked exceptions, which include `RuntimeException` and its subclasses, are not checked at compile-time but at runtime, and they do not need to be declared or caught.

3. **Explain the meaning of keywords `throw` and `throws`:**
   The `throw` keyword is used to explicitly throw an exception, indicating that an error or unexpected situation has occurred. The `throws` keyword is used in a method's signature to declare that the method might throw particular types of exceptions, alerting the caller of the method to handle or declare these exceptions.

4. **Refactor the source code to one file=one class structure:**
   Refactoring code to a `one file=one class` structure means that each class should be contained in its own file. This convention enhances readability and maintainability of the code.

5. **Add exception handling to the StackOfInts:**
   Exception handling can be added to `StackOfInts` by using `try-catch` blocks where exceptions might occur (e.g., when accessing elements in an empty stack) and by throwing appropriate exceptions when illegal operations are performed.

## Exercise 3

1. **Look briefly at the chapter of Java Language Specification related to `try-with-resources`:**
   The `try-with-resources` statement allows for the declaration of one or more resources to be used in a try block with the assurance that the resources will be closed automatically after the execution of the try block. A resource is an object that must be closed after the program is finished with it. This statement ensures that each resource is closed at the end of the statement.

2. **Familiarize yourself with the `AutoCloseable` interface:**
   The `AutoCloseable` interface is used to create objects that can be closed automatically using the `try-with-resources` statement. It includes a single method, `close()`, which is called automatically on objects managed by such a try-with-resources statement.

3. **Refactor the source code to `one file-one class` structure:**
   To refactor the code to a `one file-one class` structure, each class should be separated into its own file. This is a standard practice in Java for better organization and to avoid any naming conflicts or readability issues.

## Exercise 4

1. **Look briefly at the content of files: `Console.java`, `System.java`, and `Scanner.java`**
   - `Console.java` is a class providing methods to interact with the user console.
   - `System.java` is a class that contains several useful methods and fields, such as `System.out` for standard output, `System.in` for standard input, and `System.err` for standard error.
   - `Scanner.java` is a class used to parse text for primitive types and strings using regular expressions, often reading input from sources like `System.in`.

2. **Run `agh.ii.prinjava.lab03.lst03_05.Main` from the (external) console window**
   To execute the `Main` class from the command line :
![Capture d’écran 2024-03-14 à 23.54.20.png](..%2F..%2F..%2F..%2F..%2Fvar%2Ffolders%2Fb7%2Fyzwn76gj21q19xp6ch5019zh0000gn%2FT%2FTemporaryItems%2FNSIRD_screencaptureui_Y5I2Te%2FCapture%20d%E2%80%99%C3%A9cran%202024-03-14%20%C3%A0%2023.54.20.png)

# Exercise 5


# 1. Write a function that counts the number of characters in a given text file

```java
public static int countCharacters(String filePath) throws IOException {
    int characterCount = 0;
    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
        int ch;
        while ((ch = reader.read()) != -1) {
            characterCount++;
        }
    }
    return characterCount;
}
```
# 2. Write a function that counts the number of lines in a given text file
```java
public static int countLines(String filePath) throws IOException {
   int lineCount = 0;
   try (BufferedReader reader = new BufferedReader(new FileReader(filePath)))
        while (reader.readLine() != null)
            lineCount++;
        }
   }
   return lineCount;
}
```

## 3. Write a function that concatenates two given files

```java

public static void concatenateFiles(String file1Path, String file2Path, String outputFile) throws IOException {
    try (FileWriter writer = new FileWriter(outputFile, true);
         BufferedReader reader1 = new BufferedReader(new FileReader(file1Path));
         BufferedReader reader2 = new BufferedReader(new FileReader(file2Path))) {
        
        String line;
        while ((line = reader1.readLine()) != null) {
            writer.write(line + System.lineSeparator());
        }
        while ((line = reader2.readLine()) != null) {
            writer.write(line + System.lineSeparator());
        }
    }
}


```

# 4. Write a function that counts the number of words in a given text file

```java
public static int countWords(String filePath) throws IOException {
    int wordCount = 0;
    try (Scanner scanner = new Scanner(new File(filePath))) {
        while (scanner.hasNext()) {
            scanner.next();
            wordCount++;
        }
    }
    return wordCount;
}


```

# 5. Write a function that counts the number of whitespace characters in a given text file

```java
public static int countWhitespaces(String filePath) throws IOException {
    int whitespaceCount = 0;
    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
        int ch;
        while ((ch = reader.read()) != -1) {
            if (Character.isWhitespace(ch)) {
                whitespaceCount++;
            }
        }
    }
    return whitespaceCount;
}


```

# 6. Write a function that changes, in a given text file, all TAB characters to SPACE characters

```java
public static void replaceTabsWithSpaces(String filePath) throws IOException {
    Path path = Path.of(filePath);
    String content = Files.readString(path);
    content = content.replace("\t", " ");
    Files.writeString(path, content);
}

```

# Exercise 6

1. Explain briefly the applications of the following classes:
   - `BufferedReader`: Used to read text from an input stream, buffering characters to provide efficient reading of characters, arrays, and lines.
   - `BufferedWriter`: Used to write text to an output stream, buffering characters to provide efficient writing.
   - `FileReader`: Convenient class for reading character files.
   - `FileWriter`: Convenient class for writing character files.
   - `PrintWriter`: Enables formatted printing of characters to text-output streams.
   - `FileInputStream`: Used to read raw byte data from a file.
   - `FileOutputStream`: Used to write raw byte data to a file.
   - `DataInputStream`: Allows an application to read primitive Java data types from an underlying input stream in a machine-independent way.
   - `DataOutputStream`: Allows an application to write primitive Java data types to an output stream in a portable way.
   - `ObjectInputStream`: Used to read objects and primitive data written using `ObjectOutputStream`.
   - `ObjectOutputStream`: Used to write objects and primitive data types to an OutputStream that can be read back using `ObjectInputStream`.
   - `Files`: Provides methods to read, write, and manipulate files and directories.
   - `Path`: Represents a file system path to a file or directory.
   - `File`: Represents an abstract pathname to a file or directory.

2. Extend the code in `lst03_07` to track how many times `agh.ii.prinjava.lab03.lst03_07.Main` has been executed. Hint: you can store a counter in the file and increment each time the program is executed.
```java
public class ExecutionTracker {
    private static final String countFileName = "execution_count.txt";

    public static void trackExecution() {
        Path countFilePath = Path.of(countFileName);
        int executionCount = 0;

        try {
            // Read the current count
            if (Files.exists(countFilePath)) {
                executionCount = Integer.parseInt(Files.readString(countFilePath).trim());
            }

            // Increment the count
            executionCount++;

            // Write the updated count back to the file
            Files.writeString(countFilePath, Integer.toString(executionCount));
            System.out.println("Program has been executed " + executionCount + " times.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        trackExecution();
        // Existing demo code calls
    }
}
```

# Exercise 7

# Java Concepts Demonstrations in Source Code

1. **Marker Interface Concept (lst03_08)**:
   The concept of a marker interface is demonstrated with an interface named `Reliable` that contains no methods. Classes `Dunedain` and `Orc` are used to show how to use `instanceof` to check if an object is marked as reliable.

2. **Cloneable Interface (lst03_10)**:
   The use of the `Cloneable` interface is demonstrated. It includes two classes, `ShalowCloner` and `DeepCloner`, each illustrating shallow and deep cloning, respectively.

3. **Serializable Interface (lst03_09)**:
   The third file addresses serialization with the `Serializable` interface. Several classes show how serialization is achieved, including the management of non-serializable fields with the `transient` keyword and the serialization of an object with a serializable superclass.

## Exercise 8 : Mini project 03_01 ( ex03_01 )

# 1. 


```java
package agh.ii.prinjava.lab03.exc03_01.impl;

import agh.ii.prinjava.lab03.exc03_01.QueueOfInts;

public class LinkedListBasedImpl implements QueueOfInts {

    private Node first = null;
    private Node last = null;
    private int numOfElems = 0;

    private static class Node {
        int elem;
        Node next;
        Node prev;

        Node(int elem) {
            this.elem = elem;
        }

        Node(int elem, Node next, Node prev) {
            this.elem = elem;
            this.next = next;
            this.prev = prev;
        }
    }

    @Override
    public void enqueue(int x) {
        Node newNode = new Node(x, null, last);
        if (isEmpty()) {
            first = newNode;
        } else {
            last.next = newNode;
        }
        last = newNode;
        numOfElems++;
    }

    @Override
    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("The queue is empty");
        }
        int retValue = first.elem;
        first = first.next;
        if (first == null) {
            last = null;
        } else {
            first.prev = null;
        }
        numOfElems--;
        return retValue;
    }

    @Override
    public int numOfElems() {
        return numOfElems;
    }

    @Override
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("The queue is empty");
        }
        return first.elem;
    }

    public boolean isEmpty() {
        return numOfElems == 0;
    }
}
```

# 2. 

```java

package agh.ii.prinjava.lab03.exc03_01;

/**
 * Interface defining the operations for a queue of integers.
 * This interface enforces a FIFO (First-In-First-Out) behavior.
 */
public interface QueueOfInts {

    /**
     * Adds the specified element to the end of the queue.
     *
     * @param x the integer element to add to the queue
     */
    void enqueue(int x);

    /**
     * Removes and returns the element at the front of the queue.
     *
     * @return the integer at the front of the queue
     * @throws IllegalStateException if the queue is empty
     */
    int dequeue();

    /**
     * Returns the number of elements in the queue.
     *
     * @return the integer number of elements currently in the queue
     */
    int numOfElems();

    /**
     * Retrieves, but does not remove, the head of the queue.
     *
     * @return the head element of the queue
     * @throws IllegalStateException if the queue is empty
     */
    int peek();

    /**
     * Checks if the queue is empty.
     *
     * @return {@code true} if the queue is empty, {@code false} otherwise
     */
    default boolean isEmpty() {
        return numOfElems() == 0;
    }
}


```

# 3. Add JavaDoc comment to LinkedListasedImpl

```java

package agh.ii.prinjava.lab03.exc03_01.impl;

import agh.ii.prinjava.lab03.exc03_01.QueueOfInts;

public class LinkedListBasedImpl implements QueueOfInts {

    private Node first = null;
    private Node last = null;
    private int numOfElems = 0;

    private static class Node {
        int elem;
        Node next;
        Node prev;
        /**
         * Constructor for Node that sets the element value.
         *
         * @param elem the integer element stored in this node
         */
        Node(int elem) {
            this.elem = elem;
        }
        /**
         * Constructor for Node that sets the element value and its next and previous nodes.
         *
         * @param elem the integer element stored in this node
         * @param next the next node in the linked list
         * @param prev the previous node in the linked list
         */
        Node(int elem, Node next, Node prev) {
            this.elem = elem;
            this.next = next;
            this.prev = prev;
        }
    }
    /**
     * Adds an element to the end of the queue.
     * This method appends the specified element to the end of this queue.
     *
     * @param x the element to be inserted
     */
    @Override
    public void enqueue(int x) {
        Node newNode = new Node(x, null, last);
        if (isEmpty()) {
            first = newNode;
        } else {
            last.next = newNode;
        }
        last = newNode;
        numOfElems++;
    }
    /**
     * Retrieves and removes the head of this queue.
     * This method removes and returns the first element of this queue.
     *
     * @return the head of this queue
     * @throws IllegalStateException if this queue is empty
     */
    @Override
    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("The queue is empty");
        }
        int retValue = first.elem;
        first = first.next;
        if (first == null) {
            last = null;
        } else {
            first.prev = null;
        }
        numOfElems--;
        return retValue;
    }
    /**
     * Returns the number of elements currently in the queue.
     *
     * @return the number of elements in the queue
     */
    @Override
    public int numOfElems() {
        return numOfElems;
    }
    /**
     * Retrieves, but does not remove, the head of this queue.
     * This method throws an exception if this queue is empty.
     *
     * @return the head of this queue
     * @throws IllegalStateException if this queue is empty
     */
    @Override
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("The queue is empty");
        }
        return first.elem;
    }
}

```

# 4.

```java

package agh.ii.prinjava.lab03.exc03_01.impl;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LinkedListBasedImplTest {

    @Test
    void enqueueShouldAddElementToQueue() {
        LinkedListBasedImpl queue = new LinkedListBasedImpl();
        queue.enqueue(1);
        assertFalse(queue.isEmpty());
        assertEquals(1, queue.numOfElems());
    }

    @Test
    void dequeueShouldReturnAndRemoveTheFirstElement() {
        LinkedListBasedImpl queue = new LinkedListBasedImpl();
        queue.enqueue(1);
        queue.enqueue(2);
        int dequeuedElement = queue.dequeue();
        assertEquals(1, dequeuedElement);
        assertEquals(1, queue.numOfElems());
    }

    @Test
    void numOfElemsShouldReturnTheCorrectNumber() {
        LinkedListBasedImpl queue = new LinkedListBasedImpl();
        assertEquals(0, queue.numOfElems());
        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals(2, queue.numOfElems());
        queue.dequeue();
        assertEquals(1, queue.numOfElems());
    }

    @Test
    void peekShouldReturnTheFirstElementWithoutRemoving() {
        LinkedListBasedImpl queue = new LinkedListBasedImpl();
        queue.enqueue(1);
        queue.enqueue(2);
        int peekedElement = queue.peek();
        assertEquals(1, peekedElement);
        assertEquals(2, queue.numOfElems());
    }

    @Test
    void dequeueOnEmptyQueueShouldThrowException() {
        LinkedListBasedImpl queue = new LinkedListBasedImpl();
        Exception exception = assertThrows(IllegalStateException.class, queue::dequeue);
        assertEquals("The queue is empty", exception.getMessage());
    }

    @Test
    void peekOnEmptyQueueShouldThrowException() {
        LinkedListBasedImpl queue = new LinkedListBasedImpl();
        Exception exception = assertThrows(IllegalStateException.class, queue::peek);
        assertEquals("The queue is empty", exception.getMessage());
    }
}


```