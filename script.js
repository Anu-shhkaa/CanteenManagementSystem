let orders = [];
let inventory = {
    Sandwich: 10,
    Burger: 5,
    Pizza: 3
};

// Function to display current inventory
function displayInventory() {
    const inventoryDisplay = document.getElementById('inventoryDisplay');
    inventoryDisplay.innerText = JSON.stringify(inventory, null, 2);
}

// Function to place an order
function placeOrder() {
    const studentName = document.getElementById('studentName').value;
    const foodItem = document.getElementById('foodItem').value;
    const priority = parseInt(document.getElementById('priority').value);

    if (inventory[foodItem] > 0) {
        orders.push({ studentName, foodItem, priority });
        console.log(`${studentName} placed an order for ${foodItem}`);
        displayInventory();
    } else {
        alert(`Sorry, ${foodItem} is out of stock.`);
    }
}

// Function to serve the next order
function serveNextOrder() {
    if (orders.length > 0) {
        // Sort orders by priority
        orders.sort((a, b) => a.priority - b.priority);
        const nextOrder = orders.shift();
        console.log(`Serving: ${nextOrder.studentName} | ${nextOrder.foodItem} | Priority: ${nextOrder.priority}`);
        
        // Update inventory
        inventory[nextOrder.foodItem]--;
        displayInventory();
    } else {
        alert("No orders to serve!");
    }
}

// Initial inventory display
displayInventory();
