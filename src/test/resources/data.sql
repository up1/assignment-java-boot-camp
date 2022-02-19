-- insert into Customers (customer_id, firstname, lastname, address, zip_code, province, phone_number)
-- Values (1, 'Tom', 'Hank', '38 Moo 14', '10140', 'Bangkok', '09111111');

-- insert into Products(product_id, name, type_of_size, size, color, price, amount)
-- values (1, 'Adidas RUNNING Roamer FY6698', 'UK', '9', 'Black', 1350, 15),
--        (2, 'Adidas Yeezy 700 V2 Runner Boost Unisex B75571', 'EU', '8', 'Red', 2800, 14),
--        (3, 'Pharrell x NMD Human Race', 'EU', '36', 'Yellow', 1190, 20),
--        (4, 'Adidas ORIGINALS ZX 700 HD FX5812', 'UK', '11.5', 'Black', 3400, 42),
--        (5, 'Adidas ORIGINALS NMD R1 B42200', 'UK', '3.5', 'Black', 3588, 21);

-- insert into CreditCards(id, credit_card_number, cvv, exp, owner_id)
-- values (1, 1234567890123456, 345, '2025-05-01', 1);
--
insert into shoppingcart_items(shoppingcart_item_id, amount, owner_id, product_id)
values (1, 3, 1, 1),
       (2, 4, 1, 3),
       (3, 5, 1, 2);