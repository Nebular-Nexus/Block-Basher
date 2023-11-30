class MyClass {
    int value;

    public MyClass(int value) {
        this.value = value;
    }
}

public class ValueChangeExample {
    public static void main(String[] args) {
        MyClass obj = new MyClass(5);
        System.out.println("Before: " + obj.value);

        // Call the method that changes the value inside the object
        changeValue(obj);

        System.out.println("After: " + obj.value);
    }

    // Method that changes the value inside the object
    public static void changeValue(MyClass obj) {
        obj.value = 10; // Modifying the value inside the object
    }
}

