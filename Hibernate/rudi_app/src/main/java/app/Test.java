package app;

import model.Customer;
import model.Order;

import java.util.List;

public class Test {

    public static void main(String[] args) {
        CustomerDAO customerDAO = new CustomerDAO();
        OrderDAO orderDAO = new OrderDAO();

        // Create a new customer
        Customer customer = new Customer("John Doe", "john.doe@example.com");
        customerDAO.createCustomer(customer);
        System.out.println("Customer created: " + customer);

        // Read the customer
        Customer readCustomer = customerDAO.getCustomerById(customer.getId());
        System.out.println("Customer read: " + readCustomer);

        // Update the customer
        readCustomer.setName("Jane Doe");
        customerDAO.updateCustomer(readCustomer);
        System.out.println("Customer updated: " + readCustomer);

        // Create a new order for the customer
        Order order1 = new Order("Product A", 100, readCustomer);
        orderDAO.createOrder(order1);
        System.out.println("Order created: " + order1);

        // Create another order for the customer
        Order order2 = new Order("Product B", 200, readCustomer);
        orderDAO.createOrder(order2);
        System.out.println("Order created: " + order2);

        // Read the orders
        Order readOrder1 = orderDAO.getOrderById(order1.getId());
        System.out.println("Order read: " + readOrder1);
        Order readOrder2 = orderDAO.getOrderById(order2.getId());
        System.out.println("Order read: " + readOrder2);

        // Update the orders
        readOrder1.setPrice(150);
        orderDAO.updateOrder(readOrder1);
        System.out.println("Order updated: " + readOrder1);
        readOrder2.setPrice(250);
        orderDAO.updateOrder(readOrder2);
        System.out.println("Order updated: " + readOrder2);

        // Create a new customer to perform CRUD operations
        Customer customer2 = new Customer("Alice Smith", "alice.smith@example.com");
        customerDAO.createCustomer(customer2);
        System.out.println("Customer created: " + customer2);

        // Read the new customer
        Customer readCustomer2 = customerDAO.getCustomerById(customer2.getId());
        System.out.println("Customer read: " + readCustomer2);

        // Update the new customer
        readCustomer2.setName("Alice Johnson");
        customerDAO.updateCustomer(readCustomer2);
        System.out.println("Customer updated: " + readCustomer2);

        // Delete the new customer
        customerDAO.deleteCustomer(readCustomer2);
        System.out.println("Customer deleted: " + readCustomer2);

        // Find all customers
        List<Customer> customers = customerDAO.getAllCustomers();
        System.out.println("All customers: " + customers);

        // Find all orders
        List<Order> orders = orderDAO.getAllOrders();
        System.out.println("All orders: " + orders);

        // Shutdown JPA
        JPAUtil.shutdown();
    }
}