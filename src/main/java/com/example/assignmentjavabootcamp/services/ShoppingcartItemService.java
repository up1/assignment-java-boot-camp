package com.example.assignmentjavabootcamp.services;

import com.example.assignmentjavabootcamp.exceptions.CreditCardNotFoundException;
import com.example.assignmentjavabootcamp.exceptions.InvalidInputToShoppingcartException;
import com.example.assignmentjavabootcamp.exceptions.ShoppingcartItemNotFoundException;
import com.example.assignmentjavabootcamp.models.Customer;
import com.example.assignmentjavabootcamp.models.Product;
import com.example.assignmentjavabootcamp.models.ShoppingcartItem;
import com.example.assignmentjavabootcamp.repository.ShoppingcartItemRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class ShoppingcartItemService {

    private final ShoppingcartItemRepository shoppingcartItemRepository;

    private final CustomerService customerService;

    private final ProductService productService;

    private final OrderService orderService;

    public ShoppingcartItem save(ShoppingcartItem shoppingcartItem) {
        return shoppingcartItemRepository.save(shoppingcartItem);
    }

    public void delete(ShoppingcartItem shoppingcartItem) {
        shoppingcartItemRepository.delete(shoppingcartItem);
    }

    public ShoppingcartItem getShoppingcartItem(Long customerId, Long productId) {
        if (shoppingcartItemRepository.findByCustomerCustomerIdAndProductProductId(customerId, productId).isPresent()) {
            return shoppingcartItemRepository.findByCustomerCustomerIdAndProductProductId(customerId, productId).get();
        }
        throw new ShoppingcartItemNotFoundException("Not found this item");
    }

    public ShoppingcartItem addItem(Long customerId, Long productId, Integer amount) {
        Customer customer = customerService.getCustomer(customerId);
        Product product = productService.getProductById(productId);
        Optional<ShoppingcartItem> itemOptional = shoppingcartItemRepository.findByCustomerCustomerIdAndProductProductId(customerId, productId);
        ShoppingcartItem item = null;

        if (itemOptional.isPresent()) {
            item = itemOptional.get();
            if (item.getAmount() + amount <= product.getAmount()) {
                item.setAmount(item.getAmount() + amount);
                save(item);
                log.info("add item : " + productId + " to cart amount is " + item.getAmount());
                return item;
            }
        } else if (amount <= product.getAmount()) {
            item = save(new ShoppingcartItem(product, amount, customer));
            log.info("add item : " + productId + " to cart amount is " + item.getAmount());
            return item;
        }
        throw new InvalidInputToShoppingcartException("ProductId : " + productId + " amount is less than " + amount);
    }

    public ShoppingcartItem removeItem(Long customerId, Long productId, Integer reduceAmount) {
        Customer customer = customerService.getCustomer(customerId);
        Product product = productService.getProductById(productId);
        ShoppingcartItem item = getShoppingcartItem(customer.getCustomerId(), product.getProductId());

        if (reduceAmount < 0 || reduceAmount > item.getAmount()) {
            throw new InvalidInputToShoppingcartException("Can not remove amount of item in shoppingCart");
        } else if (reduceAmount == item.getAmount()) {
            delete(item);
            return null;
        } else {
            item.setAmount(item.getAmount() - reduceAmount);
        }
        item = save(item);
        log.info("remove amount of item from cart remaining is " + item.getAmount());
        return item;
    }

    public List<ShoppingcartItem> getAllShoppingcartItem(Long customerId) {
        return shoppingcartItemRepository.findByCustomerCustomerId(customerId);
    }

    public double getTotal(Long customerId) {
        List<ShoppingcartItem> itemList = getAllShoppingcartItem(customerId);
        double total = 0d;
        for (ShoppingcartItem item : itemList) {
            total += (item.getAmount() * item.getProduct().getPrice());
        }
        return total;
    }

    public JSONObject getSummary(Long customerId) {
        List<ShoppingcartItem> itemList = getAllShoppingcartItem(customerId);
        return itemList.isEmpty() ? new JSONObject() : new JSONObject().put("itemList", itemList).put("total", getTotal(customerId));
    }

    @Transactional
    public void checkout(Long customerId) {
        Customer customer = customerService.getCustomer(customerId);

        if (customer.getCreditCard() != null) {
            List<ShoppingcartItem> itemList = getAllShoppingcartItem(customerId);
            for (ShoppingcartItem item : itemList) {
                productService.checkout(item.getProduct(), item.getAmount());
            }
            orderService.buildOrder(customer, itemList);
            return;
        }
        throw new CreditCardNotFoundException("Customer id : " + customerId + " not found creditcard");
    }
}
