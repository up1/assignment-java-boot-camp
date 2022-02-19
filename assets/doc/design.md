# Design Model

## คำอธิบาย

ออกแบบการเลือกซื้อสินค้าและชำระด้วยบัตรเครดิต มี model สำหรับเก็บข้อมูล ดังต่อไปนี้

## ER Diagram

![er-diagram](../img/er-diagram.jpeg)

## Feature
### Search Product by Name flow

- ค้นหา product ด้วยชื่อของสินค้า

endpoint สำหรับ search product by name โดยส่งเป็น query string 


``
GET http://localhost:8080/product/search?keyworad={keyworad}
``

###Choose product flow

- เมื่อเลือกสินค้าได้แล้วให้แสดงรายละเอียดของสินค้า

``
GET http://localhost:8080/product/{id}
``
 