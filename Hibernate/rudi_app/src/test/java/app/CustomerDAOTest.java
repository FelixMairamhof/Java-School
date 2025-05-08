package app;

import model.Customer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerDAOTest {
    private CustomerDAO customerDAO;

    @BeforeEach
    void setUp() {
        customerDAO = new CustomerDAO();
        customerDAO.deleteAllCustomers(); // Ensure the database is clean before each test
    }

    @AfterEach
    void tearDown() {
        customerDAO.deleteAllCustomers(); // Clean up after each test
    }

    @Test
    void getCustomerById() {
        Customer customer = new Customer("John Doe", "john.doe@example.com");
        customerDAO.createCustomer(customer);
        Customer retrievedCustomer = customerDAO.getCustomerById(customer.getId());
        assertNotNull(retrievedCustomer);
        assertEquals("John Doe", retrievedCustomer.getName());
    }

    @Test
    void getAllCustomers() {
        Customer customer1 = new Customer("John Doe", "john.doe@example.com");
        Customer customer2 = new Customer("Jane Doe", "jane.doe@example.com");
        customerDAO.createCustomer(customer1);
        customerDAO.createCustomer(customer2);
        assertEquals(2, customerDAO.getAllCustomers().size());
    }

    @Test
    void createCustomer() {
        Customer customer = new Customer("John Doe", "john.doe@example.com");
        customerDAO.createCustomer(customer);
        Customer retrievedCustomer = customerDAO.getCustomerById(customer.getId());
        assertNotNull(retrievedCustomer);
        assertEquals("John Doe", retrievedCustomer.getName());
    }

    @Test
    void updateCustomer() {
        Customer customer = new Customer("John Doe", "john.doe@example.com");
        customerDAO.createCustomer(customer);
        customer.setName("Jane Doe");
        customerDAO.updateCustomer(customer);
        Customer retrievedCustomer = customerDAO.getCustomerById(customer.getId());
        assertEquals("Jane Doe", retrievedCustomer.getName());
    }

    @Test
    void deleteCustomer() {
        Customer customer = new Customer("John Doe", "john.doe@example.com");
        customerDAO.createCustomer(customer);
        customerDAO.deleteCustomer(customer);
        Customer retrievedCustomer = customerDAO.getCustomerById(customer.getId());
        assertNull(retrievedCustomer);
    }

    @Test
    void deleteAllCustomers() {
        Customer customer1 = new Customer("John Doe", "john.doe@example.com");
        Customer customer2 = new Customer("Jane Doe", "jane.doe@example.com");
        customerDAO.createCustomer(customer1);
        customerDAO.createCustomer(customer2);
        customerDAO.deleteAllCustomers();
        assertEquals(0, customerDAO.getAllCustomers().size());
    }
}