## ตารางแสดง Api ที่จำเป็นต้องใช้

| Method | Url                        | Description                    | Request/Response <br />Reference |
| ------ | -------------------------- | ------------------------------ | -------------------------------- |
| GET    | /products                  | แสดงรายการ product ที่มี       |
| GET    | /products/{id}             | แสดงรายการ product อย่างเจาะจง |
| GET    | /me/basket                 | แสดงตระกร้าสินค้าของผู้ใช้     |
| PUT    | /me/basket                 | อัปเดตตระกร้าสินค้า            |
| GET    | /me/address                | แสดงที่อยู่ของผู้ใช้           |
| POST   | /shipping-instruction      | สร้างคำสั่งซื้อ                |
| GET    | /shipping-instruction/{id} | แสดงรายการสั่งซื้ออย่างเจาะจง  |
| PUT    | /shipping-instruction/{id} | อัปเดตรายการสั่งซื้อ           |
| POST   | /payment                   | สร้างการชำระเงิน               |
| POST   | /invoices                  | สร้าง invoice                  |
| GET    | /invoices/{id}             | แสดง invoice อย่างเจาะจง       |
