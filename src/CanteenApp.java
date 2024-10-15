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
        canteen.placeOrder("isha", "Burger", 2);
        canteen.placeOrder("gargi", "Sandwich", 2);

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
