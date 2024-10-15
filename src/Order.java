import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Comparator;

// Order.java
public class Order {
    String studentName;
    String foodItem;
    int priority; // Lower values represent higher priority (e.g., class urgency)

    // Constructor
    public Order(String studentName, String foodItem, int priority) {
        this.studentName = studentName;
        this.foodItem = foodItem;
        this.priority = priority;
    }

    // Display the order details
    public String displayOrder() {
        return "Order for: " + studentName + " | Item: " + foodItem + " | Priority: " + priority;
    }
}
