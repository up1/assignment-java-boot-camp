# Apis

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

## รายละเอียดของแต่ละ Api

### GET /products

**เรียก product ที่มี**<br>
**แสดงรายการ product ที่มี**

#### Request

พารามิเตอร์ที่ใช้งานได้

Query parameters

| Name         | Type    | Description                            |
| ------------ | ------- | -------------------------------------- |
| search_query | String  | หารายการ product ด้วย contains keyword |
| limit        | Integer | รายการสูงสุดที่ต้องการส่งข้อมูลกลับ    |

#### Response

Status code - 200

Response model - application/json <br>
ส่งกลับในรูปแบบอาร์เรย์ที่ไอเท็มมีโครงสร้างตามตาราง

| Name                   | Type     | Description                                |
| ---------------------- | -------- | ------------------------------------------ |
| productId              | Integer  | เลข product id                             |
| title                  | String   | ชื่อ product                               |
| features               | String[] | รายการรายละเอียดฟีเจอร์                    |
| price                  | Double   | ราคาของ product                            |
| hasDiscount            | Boolean  | แฟล็กใช้กำกับว่ามีการลดราคาหรือไม่         |
| discount               | Integer  | เปอร์เซ็นต์ลดราคา                          |
| discountExpiredDate    | Date     | วันสุดท้ายของการลดราคา                     |
| rating                 | Double   | เรตติ้งเป็นเปอร์เซ็นต์                     |
| reviewerCount          | Integer  | จำนวนคนให้คะแนน                            |
| reviewerDetailGroupId  | Integer  | หมายเลขกลุ่มที่รีวิว product ดังกล่าว      |
| productImageUrlList    | String[] | รายการที่อยู่ของภาพ product                |
| brandName              | String   | ชื่อยี่ห้อ                                 |
| sellerStorePageId      | Integer  | เลข store home page id                     |
| warrantyAmount         | Integer  | จำนวนรับประกัน                             |
| warrantyUnit           | String   | หน่วยวันของจำนวนรับประกัน                  |
| sellCity               | String   | เมืองที่จำหน่าย                            |
| productProfileImageUrl | String   | ที่อยู่ของภาพโปรไฟล์ของ product            |
| hasFastSending         | Boolean  | แฟล็กใช้อธิบายว่ามีการส่งแบบรวดเร็วหรือไม่ |

### GET /products/{id}

**เรียก product ตามหมายเลข id** <br>
**ส่งกลับ object ของ product หมายเลข id นั้น ๆ**

#### Request

พารามิเตอร์ที่ใช้งานได้

Path parameters

| Name | Type    | Description     |
| ---- | ------- | --------------- |
| id   | Integer | หมายเลข product |

#### Response

Status code - 200

Response model - application/json <br>
ส่งกลับในรูปแบบโครงสร้างตามตาราง

| Name                         | Type     | Description                                |
| ---------------------------- | -------- | ------------------------------------------ |
| productId                    | Integer  | เลข product id                             |
| title                        | String   | ชื่อ product                               |
| advertiseSentenceList        | String[] | รายการประโยคโฆษณา                          |
| features                     | object[] |                                            |
| &nbsp;&nbsp;&nbsp;name       | String   | ชื่อของฟีเจอร์                             |
| &nbsp;&nbsp;&nbsp;isRequired | Boolean  | ตัวกำกับว่าบังคับหรือไม่                   |
| &nbsp;&nbsp;&nbsp;options    | String[] | รายการตัวเลือก                             |
| price                        | Double   | ราคาของ product                            |
| hasDiscount                  | Boolean  | แฟล็กใช้กำกับว่ามีการลดราคาหรือไม่         |
| discount                     | Integer  | เปอร์เซ็นต์ลดราคา                          |
| discountExpiredDate          | Date     | วันสุดท้ายของการลดราคา                     |
| rating                       | Double   | เรตติ้งเป็นเปอร์เซ็นต์                     |
| reviewerCount                | Integer  | จำนวนคนให้คะแนน                            |
| reviewerDetailGroupId        | Integer  | หมายเลขกลุ่มที่รีวิว product ดังกล่าว      |
| productImageUrlList          | String[] | รายการที่อยู่ของภาพ product                |
| brandName                    | String   | ชื่อยี่ห้อ                                 |
| brandDetail                  | String   | ยี่ห้ออธิบายเพิ่มเติม                      |
| sellerStorePageId            | Integer  | เลข store home page id                     |
| warrantyAmount               | Integer  | จำนวนรับประกัน                             |
| warrantyUnit                 | String   | หน่วยวันของจำนวนรับประกัน                  |
| sellCity                     | String   | เมืองที่จำหน่าย                            |
| productProfileImageUrl       | String   | ที่อยู่ของภาพโปรไฟล์ของ product            |
| hasFastSending               | Boolean  | แฟล็กใช้อธิบายว่ามีการส่งแบบรวดเร็วหรือไม่ |

### GET /me/basket

**เรียกรายการสั่งซื้อในตระกร้า** <br>
**ส่งกลับรายการสั่งซื้อในตระกร้า**

#### Request

ไม่มีพารามิเตอร์ต้องใส่

#### Response

Status code - 200

Response model - application/json <br>
ส่งกลับในรูปแบบของอาร์เรย์ของไอเท็มตามโครงสร้างแสดงดังตารางนี้

| Name          | Type    | Description      |
| ------------- | ------- | ---------------- |
| productId     | Integer | หมายเลขสินค้า    |
| features      | Object  | รายการฟีเจอร์    |
| name          | String  | ชื่อของฟีเจอร์   |
| selectedValue | String  | ตัวเลือกที่เลือก |

### GET /me/addresses

**เรียกรายการที่อยู่ที่มี**<br>
**ส่งกลับรายการที่อยู่ที่มี**

#### Request

พารามิเตอร์ที่ใช้งานได้

Query parameters

| Name    | Type   | Description                                 |
| ------- | ------ | ------------------------------------------- |
| address | String | ค่าที่ใช้ได้กับพารามิเตอร์นี้ คือ "default" |

#### Response

Status code - 200

Response model - application/json <br>
ส่งกลับในรูปแบบของอาร์เรย์ของไอเท็มตามโครงสร้างแสดงดังตารางนี้

| Name       | Type    | Description            |
| ---------- | ------- | ---------------------- |
| email      | String  | อีเมลของที่อยู่นั้น ๆ  |
| fullName   | String  | ชื่อเต็มของผู้สั่งซื้อ |
| address    | String  | รายละเอียดที่อยู่      |
| postalCode | Integer | หมา่ยเลขไปรษณีย์       |
| zone       | String  | เขต                    |
| city       | String  | จังหวัด                |
| telephone  | String  | หมายเลขโทรศัพท์        |

### POST /shipping-instruction

**สร้างคำสั่งซื้อ**

#### Request

Request body - application/json

| Name     | Type   | Description            |
| -------- | ------ | ---------------------- |
| fullName | String | ชื่อเต็มของผู้สั่งซื้อ |

#### Response

Status code - 201
