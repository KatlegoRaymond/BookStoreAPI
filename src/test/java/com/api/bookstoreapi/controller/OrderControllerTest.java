package com.api.bookstoreapi.controller;

import com.api.bookstoreapi.model.Order;
import com.api.bookstoreapi.service.OrderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Unit tests for the OrderController class.
 */
@WebMvcTest(OrderController.class)
public class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrderService orderService;

    @InjectMocks
    private OrderController orderController;

    private Order order1;
    private Order order2;
    private List<Order> orderList = new ArrayList<>();

    /**
     * Setup method to initialize mock objects and test data before each test method.
     */
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        order1 = new Order("1", "Details", 2, 59.98);
        order2 = new Order("2", "Details2", 5, 329.71);
        orderList.add(order1);
        orderList.add(order2);
    }

    /**
     * Teardown method to clear test data after each test method.
     */
    @AfterEach
    void tearDown() {
        orderList.clear();
    }

    /**
     * Test case for retrieving order details by order ID.
     * @throws Exception If an error occurs during the test.
     */
    @Test
    public void testGetOrderDetails() throws Exception {
        when(orderService.getOrder("1")).thenReturn(order1);
        this.mockMvc.perform(get("/Order/"+"1")).andDo(print()).andExpect(status().isOk());
    }

    /**
     * Test case for retrieving all order details.
     * @throws Exception If an error occurs during the test.
     */
    @Test
    public void testGetAllOrderDetails() throws Exception {
        when(orderService.getAllOrders()).thenReturn(orderList);
        this.mockMvc.perform(get("/Order/"))
                .andDo(print()).andExpect(status().isOk());
    }

    /**
     * Test case for creating order details.
     * @throws Exception If an error occurs during the test.
     */
    @Test
    public void testCreateOrderDetails() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(order1);

        this.mockMvc.perform(post("/Order/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("Order Created Successfully"));

    }

    /**
     * Test case for updating order details.
     * @throws Exception If an error occurs during the test.
     */
    @Test
    public void testUpdateOrderDetails() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(order1);

        this.mockMvc.perform(put("/Order/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("Order Updated Successfully"));

    }

    /**
     * Test case for deleting order details.
     * @throws Exception If an error occurs during the test.
     */
    @Test
    public void testDeleteOrderDetails() throws Exception {
        when(orderService.deleteOrder("1")).thenReturn("Order Deleted Successfully");

        this.mockMvc.perform(delete("/Order/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("Order Deleted Successfully"));

    }
}
