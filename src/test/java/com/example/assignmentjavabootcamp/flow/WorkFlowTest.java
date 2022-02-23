package com.example.assignmentjavabootcamp.flow;

import com.example.assignmentjavabootcamp.dto.RequestAddCreditCard;
import com.example.assignmentjavabootcamp.dto.RequestCart;
import com.example.assignmentjavabootcamp.dto.RequestShippingAddress;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.annotation.DirtiesContext;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class WorkFlowTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    public void whenBuyProductFlow_ShouldGetOrder() {
        String searchProductResponse = testRestTemplate.getForObject("/products/search?keyword=" + "Adidas", String.class);
        String productDetailResponse = testRestTemplate.getForObject("/products/" + new JSONArray(searchProductResponse).getJSONObject(0).getLong("productId"), String.class);
        testRestTemplate.postForObject("/carts/addToCart", new RequestCart(2L, new JSONObject(productDetailResponse).getLong("productId"), 2), String.class);
        testRestTemplate.postForObject("/customers/addShippingAddress", new RequestShippingAddress(2L, "34 Moo8", "73110", "Bangkok", "0911111111"), String.class);
        testRestTemplate.postForObject("/customers/addCreditCard", new RequestAddCreditCard(2L, "1234567890123458", "222", "09/26"), String.class);
        String checkoutResponse = testRestTemplate.postForObject("/carts/checkout",new JSONObject().put("customerId",2L).toString(),String.class);

        Assertions.assertEquals(200,new JSONObject(checkoutResponse).getInt("status"));
    }
}
