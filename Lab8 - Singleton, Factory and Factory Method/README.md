## Task 1:  Implementing Singleton Pattern for File Reading


---

**Objectives:**
- Understand the Singleton design pattern.
- Implement a Singleton class, `FileReaderSingleton`, for reading lines from a file.
- Manage file access, opening, and closing within the Singleton class.

**Instructions:**

1. Create a new Java class called `FileReaderSingleton`. This class will implement the Singleton pattern for file access.

2. Define the following private attributes and methods within the `FileReaderSingleton` class:

   - `private static FileReaderSingleton instance`: A static instance of the class.
   - `private BufferedReader reader`: A `BufferedReader` for reading lines from the file.
   - `private void openFile()`: A method that opens the file, "data.txt," and initializes the `reader`. Handle any `FileNotFoundException` that may occur.

3. In the `FileReaderSingleton` class, implement a private constructor to prevent direct instantiation. In this constructor, call the `openFile()` method to open the file.

4. Implement a public static method, `getInstance()`, that returns the Singleton instance. This method should follow the Singleton pattern, ensuring there is only one instance of the class.

5. Implement a public method, `readLineFromFile()`, which reads a line from the file and returns it as a string. This method should handle exceptions related to file access, such as `IOException`.

6. Implement a public method, `closeFile()`, which closes the file. Handle any `IOException` that may occur during the file closing.

**Testing the Implementation**

```
// Class A for reading from the file
class FileReaderClassA {
    FileReaderSingleton fileReader;
    public FileReaderClassA(FileReaderSingleton fileReader) {
        this.fileReader = fileReader;
    }
    public void readFileLine() {
        String line = fileReader.readLineFromFile();
        if (line != null) {
            System.out.println("FileReaderClassA: " + line);
        }
    }
}

// Class B for reading from the file
class FileReaderClassB {
    FileReaderSingleton fileReader;
    public FileReaderClassB(FileReaderSingleton fileReader) {
        this.fileReader = fileReader;
    }
    public void readFileLine() {
        String line = fileReader.readLineFromFile();
        if (line != null) {
            System.out.println("FileReaderClassB: " + line);
        }
    }
}

public class TestLab {
    public static void main(String[] args) {
        FileReaderSingleton fileReader = FileReaderSingleton.getInstance();
        FileReaderClassA readerA = new FileReaderClassA(fileReader);
        FileReaderClassB readerB = new FileReaderClassB(fileReader);

        // Call the readFileLine() method on both instances
        readerA.readFileLine();
        readerB.readFileLine();
        readerB.readFileLine();
        fileReader.closeFile();
        readerA.readFileLine();
        readerB.readFileLine();
        
    }
}
```

Expected Result

```
FileReaderClassA: testline1
FileReaderClassB: testline2
FileReaderClassB: testline3
FileReaderClassA: testline1
FileReaderClassB: testline2
```


## Task 2: Factory Pattern Implementation for Payment Methods
---


**Objective:**
The objective of this lab is to introduce students to the Factory Pattern with a real-world example and provide hands-on experience in implementing it.

**Instructions:**

1. Create an interface named `PaymentMethod`. This interface should include a method `void processPayment(double amount)` that represents the common operations for processing payments.

2. Implement concrete classes for different payment methods. The code already provides `CreditCardPayment`, `PayPalPayment`, and `CryptoPayment` classes, each of which implements the `PaymentMethod` interface. Each method should print the amount and method of payment on the screen.

3. Implement a Factory class named `PaymentMethodFactory`. This factory class will be responsible for creating payment method objects based on the provided payment type.

4. In the `createPaymentMethod` method of the factory, add logic to create an object of the appropriate payment method class based on the provided payment type ("credit card", "paypal", and "crypto")

**Testing the Implementation**
```
public class PaymentApp {
    public static void main(String[] args) {
        // Implement the Client Code
        PaymentMethodFactory paymentFactory = new PaymentMethodFactory();

        // Create payment objects without knowing the exact class
        PaymentMethod creditCardPayment = paymentFactory.createPaymentMethod("credit card");
        PaymentMethod payPalPayment = paymentFactory.createPaymentMethod("paypal");
        PaymentMethod cryptoPayment = paymentFactory.createPaymentMethod("crypto");

        // Test Your Implementation
        double paymentAmount = 100.0;
        creditCardPayment.processPayment(paymentAmount);
        payPalPayment.processPayment(paymentAmount);
        cryptoPayment.processPayment(paymentAmount);
    }
}
```
Expected Result:
```
Processing credit card payment of $100.0
Processing PayPal payment of $100.0
Processing cryptocurrency payment of $100.0
```


## Task 3: The factory method pattern

---

**Objective:**
The objective of this lab is to change from the Factory Pattern to the Factory Method Pattern using the same concept as the previous task.

**Instructions:**

1. Two interfaces are provided as below:

```
interface PaymentMethod {
    void processPayment(double amount);
}

interface PaymentMethodFactory {
    PaymentMethod createPaymentMethod();
}
```

2. Implement concrete classes for different payment methods. These classes should implement the `PaymentMethod` interface and provide the actual payment processing logic for each payment method. Create classes `CreditCardPayment`, `PayPalPayment`, and `CryptoPayment` that implement the PaymentMethod interface. Each class prints `Processing xxx payment of $yyy` where `xxx` denotes the payment method and the `yyy` denotes the amount of payment

3. Create concrete creator classes that implement the `PaymentMethodFactory` interface. These classes are responsible for creating payment method objects and returning them to the client code. Name these classes `CreditCardPaymentFactory`, `PayPalPaymentFactory`, and `CryptoPaymentFactory`.

  * In each concrete creator class, implement the `createPaymentMethod` method to create and return an object of the appropriate payment method class.

**Testing the Implementation**
```
public class PaymentApp {
    public static void main(String[] args) {
        // Implement the Client Code
        PaymentMethodFactory creditCardFactory = new CreditCardPaymentFactory();
        PaymentMethodFactory payPalFactory = new PayPalPaymentFactory();
        PaymentMethodFactory cryptoFactory = new CryptoPaymentFactory();

        PaymentMethod creditCardPayment = creditCardFactory.createPaymentMethod();
        PaymentMethod payPalPayment = payPalFactory.createPaymentMethod();
        PaymentMethod cryptoPayment = cryptoFactory.createPaymentMethod();

        // Test Your Implementation
        double paymentAmount = 100.0;
        creditCardPayment.processPayment(paymentAmount);
        payPalPayment.processPayment(paymentAmount);
        cryptoPayment.processPayment(paymentAmount);
    }
}
```
Expected Result:
```
Processing credit card payment of $100.0
Processing PayPal payment of $100.0
Processing cryptocurrency payment of $100.0
```
