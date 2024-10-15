import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Comparator;

// Class representing an order
class Order {
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
    public void displayOrder() {
        System.out.println("Order for: " + studentName + " | Item: " + foodItem + " | Priority: " + priority);
    }
}

// Comparator to sort the Priority Queue based on order priority
class OrderPriorityComparator implements Comparator<Order> {
    public int compare(Order o1, Order o2) {
        return o1.priority - o2.priority;  // Lower priority value comes first
    }
}

// Canteen Management Class
class CanteenManagement {
    // Priority queue to handle orders
    PriorityQueue<Order> orderQueue = new PriorityQueue<>(new OrderPriorityComparator());
    
    // HashMap to store inventory
    HashMap<String, Integer> inventory = new HashMap<>();

    // Method to add food items to the inventory
    public void addFoodItem(String foodItem, int quantity) {
        inventory.put(foodItem, quantity);
    }

    // Method to place an order
    public void placeOrder(String studentName, String foodItem, int priority) {
        if (inventory.getOrDefault(foodItem, 0) > 0) {
            Order order = new Order(studentName, foodItem, priority);
            orderQueue.add(order);
            System.out.println(studentName + " placed an order for " + foodItem);
        } else {
            System.out.println("Sorry, " + foodItem + " is out of stock.");
        }
    }

    // Method to serve the next order in queue
    public void serveNextOrder() {
        if (!orderQueue.isEmpty()) {
            Order nextOrder = orderQueue.poll();  // Get the highest-priority order
            nextOrder.displayOrder();

            // Decrease the food item count in inventory
            int currentStock = inventory.get(nextOrder.foodItem);
            inventory.put(nextOrder.foodItem, currentStock - 1);

            System.out.println(nextOrder.foodItem + " served. Remaining stock: " + (currentStock - 1));
        } else {
            System.out.println("No orders to serve!");
        }
    }

    // Method to display current inventory
    public void displayInventory() {
        System.out.println("\nCurrent Inventory:");
        for (String item : inventory.keySet()) {
            System.out.println(item + ": " + inventory.get(item) + " left.");
        }
    }
}

// Main class
public class CanteenApp {
    public static void main(String[] args) {
        // Create a canteen management instance
        CanteenManagement canteen = new CanteenManagement();

        // Add some food items to inventory
        canteen.addFoodItem("Sandwich", 10);
        canteen.addFoodItem("Burger", 5);
        canteen.addFoodItem("Pizza", 3);

        // Place some orders
        canteen.placeOrder("Shantanu", "Sandwich", 1);
        canteen.placeOrder("Anushka", "Pizza", 3);
        canteen.placeOrder("Rahul", "Burger", 2);

        // Display inventory
        canteen.displayInventory();

        // Serve orders based on priority
        System.out.println("\nServing Orders:");
        canteen.serveNextOrder();
        canteen.serveNextOrder();
        canteen.serveNextOrder();

        // Display inventory after serving
        canteen.displayInventory();
    }
}
