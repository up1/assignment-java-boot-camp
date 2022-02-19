package com.example.assignmentjavabootcamp.services;

import com.example.assignmentjavabootcamp.exceptions.CreditCardNotFoundException;
import com.example.assignmentjavabootcamp.exceptions.InvalidInputToShoppingcartException;
import com.example.assignmentjavabootcamp.exceptions.ShoppingcartItemNotFoundException;
import com.example.assignmentjavabootcamp.models.Customer;
import com.example.assignmentjavabootcamp.models.Product;
import com.example.assignmentjavabootcamp.models.ShoppingcartItem;
import com.example.assignmentjavabootcamp.repository.ShoppingcartItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
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

    public void addItem(Long customerId, Long productId, Integer amount) {
        Customer customer = customerService.getCustomer(customerId);
        Product product = productService.getProductById(productId);

        if (product.getAmount() >= amount) {
            save(new ShoppingcartItem(product, amount, customer));
        }
        throw new InvalidInputToShoppingcartException("ProductId : " + productId + " amount is less than " + amount);
    }

    public void removeItem(Long customerId, Long productId, Integer setAmount) {
        Customer customer = customerService.getCustomer(customerId);
        Product product = productService.getProductById(productId);
        ShoppingcartItem item = getShoppingcartItem(customer.getCustomerId(), product.getProductId());

        if (setAmount < 0) {
            throw new InvalidInputToShoppingcartException("Can not set amount of item in shoppingCart to less than 0");
        } else if (setAmount > 0 && product.getAmount() >= setAmount) {
            item.setAmount(setAmount);
        } else if (setAmount == 0) {
            delete(item);
        }
        save(item);

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

    @Transactional
    public void checkout(Long customerId) {
        Customer customer = customerService.getCustomer(customerId);

        if (customer.getCreditCard() != null) {
            List<ShoppingcartItem> itemList = getAllShoppingcartItem(customerId);
            for (ShoppingcartItem item : itemList) {
                productService.checkout(item.getProduct(), item.getAmount());
            }
            orderService.buildOrder(customer, itemList);
        }
        throw new CreditCardNotFoundException("Customer id : " + customerId + " not found creditcard");
    }
}
