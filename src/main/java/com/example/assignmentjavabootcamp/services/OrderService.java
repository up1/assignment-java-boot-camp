package com.example.assignmentjavabootcamp.services;

import com.example.assignmentjavabootcamp.exceptions.OrderNotFoundException;
import com.example.assignmentjavabootcamp.models.*;
import com.example.assignmentjavabootcamp.repository.OrderDetailRepository;
import com.example.assignmentjavabootcamp.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OrderService {

    private final OrderDetailRepository orderDetailRepository;

    private final OrderRepository orderRepository;

    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    public OrderDetail saveOrderDetail(OrderDetail orderDetail) {
        return orderDetailRepository.save(orderDetail);
    }

    public List<OrderDetail> saveAllOrderDetail(List<OrderDetail> orderDetailList) {
        return orderDetailRepository.saveAll(orderDetailList);
    }

    private JSONObject buildJSONOrder(Order order, List<OrderDetail> orderDetailList) {
        return new JSONObject(order)
                .put("product", orderDetailList);
    }

    public JSONObject getOrderById(Long orderId) {
        if (orderRepository.findById(orderId).isPresent()) {
            return buildJSONOrder(orderRepository.findById(orderId).get(), orderDetailRepository.findByOrderId(orderId));
        }
        throw new OrderNotFoundException("Order id : " + orderId + "Not found");
    }

    public JSONObject getLatestOrder(Long customerId) {
        Optional<Order> orderOptional = orderRepository.findFirstByOrderOwnerOrderByBuyAt(customerId);
        if (orderOptional.isPresent()) {
            List<OrderDetail> orderDetailList = orderDetailRepository.findByOrderId(orderOptional.get().getId());
            return buildJSONOrder(orderOptional.get(), orderDetailList);
        }
        throw new OrderNotFoundException("Not found order for customer Id : " + customerId);
    }

    @Transactional
    public void buildOrder(Customer customer, List<ShoppingcartItem> itemList) {
        String shippingAddress = "K." + customer.getFirstname() + " " + customer.getLastname() + "\n" +
                customer.getAddress() + " " + customer.getProvince() + " " + customer.getZipCode() + "\n" +
                customer.getPhoneNumber();

        Order order = new Order();
        order.setOrderOwner(customer);
        order.setBuyAt(LocalDateTime.now());
        order.setPayBy("CREDIT_CARD");
        order.setPhoneNumber(customer.getPhoneNumber());
        order.setShippingAddress(shippingAddress);

        order = saveOrder(order);

        List<OrderDetail> orderDetailList = new ArrayList<>();

        for (ShoppingcartItem item : itemList) {
            Product product = item.getProduct();
            orderDetailList.add(new OrderDetail(product.getName(), product.getColor(), item.getAmount(), product.getPrice(), order));
        }

        saveAllOrderDetail(orderDetailList);
    }
}
