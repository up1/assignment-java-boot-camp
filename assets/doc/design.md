# Design Model

## คำอธิบาย

ออกแบบการเลือกซื้อสินค้าและชำระด้วยบัตรเครดิต มี model สำหรับเก็บข้อมูล
ดังต่อไปนี้

### Product

```json
{
  "name": "adidas",
  "size": "3.4",
  "price": "100",
  "amount": "15"
}
```

### Customer

```json
{
  "customerId": "123",
  "firstname": "Tom",
  "lastname": "Hank",
  "addresses": "34 Flat",
  "zipCode": "10140",
  "province": "Bangkok",
  "phoneNumber": "09111111",
  "shoppingCartCode": "23"
}
```

### Shopping Cart

```json
 {
  "shoppingCartCode": "23",
  "products": []
}
```

### CreditCard

```json
{
  "creditCardNum": "1234567890123",
  "CVV": "123",
  "exp": "12/23"
}
```

