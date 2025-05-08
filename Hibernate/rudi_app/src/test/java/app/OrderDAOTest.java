package app;

import model.Customer;
import model.Order;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderDAOTest {
    private OrderDAO orderDAO;
    private CustomerDAO customerDAO;
    private Customer customer;

    @BeforeEach
    void setUp() {
        orderDAO = new OrderDAO();
        customerDAO = new CustomerDAO();
        orderDAO.deleteAllOrders(); // Ensure the database is clean before each test
        customerDAO.deleteAllCustomers(); // Ensure the database is clean before each test
        customer = new Customer("John Doe", "john.doe@example.com");
        customerDAO.createCustomer(customer);
    }

    @AfterEach
    void tearDown() {
        orderDAO.deleteAllOrders(); // Clean up after each test
        customerDAO.deleteAllCustomers(); // Clean up after each test
    }

    @Test
    void getOrderById() {
        Order order = new Order("Product A", 100, customer);
        orderDAO.createOrder(order);
        Order retrievedOrder = orderDAO.getOrderById(order.getId());
        assertNotNull(retrievedOrder);
        assertEquals("Product A", retrievedOrder.getProduct());
    }

    @Test
    void getAllOrders() {
        Order order1 = new Order("Product A", 100, customer);
        Order order2 = new Order("Product B", 200, customer);
        orderDAO.createOrder(order1);
        orderDAO.createOrder(order2);
        assertEquals(2, orderDAO.getAllOrders().size());
    }

    @Test
    void createOrder() {
        Order order = new Order("Product A", 100, customer);
        orderDAO.createOrder(order);
        Order retrievedOrder = orderDAO.getOrderById(order.getId());
        assertNotNull(retrievedOrder);
        assertEquals("Product A", retrievedOrder.getProduct());
    }

    @Test
    void updateOrder() {
        Order order = new Order("Product A", 100, customer);
        orderDAO.createOrder(order);
        order.setPrice(150);
        orderDAO.updateOrder(order);
        Order retrievedOrder = orderDAO.getOrderById(order.getId());
        assertEquals(150, retrievedOrder.getPrice(), 0);
    }

    @Test
    void deleteOrder() {
        Order order = new Order("Product A", 100, customer);
        orderDAO.createOrder(order);
        orderDAO.deleteOrder(order);
        Order retrievedOrder = orderDAO.getOrderById(order.getId());
        assertNull(retrievedOrder);
    }

    @Test
    void deleteAllOrders() {
        Order order1 = new Order("Product A", 100, customer);
        Order order2 = new Order("Product B", 200, customer);
        orderDAO.createOrder(order1);
        orderDAO.createOrder(order2);
        orderDAO.deleteAllOrders();
        assertEquals(0, orderDAO.getAllOrders().size());
    }
}