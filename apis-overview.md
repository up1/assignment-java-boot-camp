# Apis

## ตารางแสดง Api ที่จำเป็นต้องใช้

| Method | Url                        | Description                    | Request/response <br />reference                                                |
| ------ | -------------------------- | ------------------------------ | ------------------------------------------------------------------------------- |
| GET    | /products                  | แสดงรายการ product ที่มี       | [Get products](products.md#get-products)                                        |
| GET    | /products/{id}             | แสดงรายการ product อย่างเจาะจง | [Get product by id](products.md#get-productsid)                                 |
| GET    | /me/basket                 | แสดงตระกร้าสินค้าของผู้ใช้     | [Get basket](me.md#get-mebasket)                                                |
| PUT    | /me/basket                 | อัปเดตตระกร้าสินค้า            | [Update basket](me.md#put-mebasket)                                             |
| GET    | /me/address                | แสดงที่อยู่ของผู้ใช้           | [Get address](me.md#get-meaddresses)                                            |
| POST   | /shipping-instruction      | สร้างคำสั่งซื้อ                | [Post shipping-instruction](shipping-instruction.md#post-shipping-instruction)  |
| GET    | /shipping-instruction/{id} | แสดงรายการสั่งซื้ออย่างเจาะจง  | [Get shipping-instruction](shipping-instruction.md#get-shipping-instructionid)  |
| PUT    | /shipping-instruction/{id} | อัปเดตรายการสั่งซื้อ           | [Put shipping-insstruction](shipping-instruction.md#put-shipping-instructionid) |
| POST   | /payments/debit-credit     | สร้างการชำระเงิน               | [Post mayments by debit/credit](payment.md#post-paymentsdebit-credit)           |
| POST   | /invoices                  | สร้าง invoice                  | [Post invoices](invoices.md#post-invoices)                                      |
| GET    | /invoices/{id}             | แสดง invoice อย่างเจาะจง       | [Get invoice by id](invoices.md#get-invoicesid)                                 |
