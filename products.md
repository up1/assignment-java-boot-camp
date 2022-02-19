## รายการ Api

- [GET /products](#get-products)
  - [Request](#request)
  - [Response](#response)
- [GET /products/{id}](#get-productsid)
  - [Request](#request-1)
  - [Response](#response-1)

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
| storeId                | Integer  | เลขร้านค้า                                 |
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
| storeId                      | Integer  | เลขร้านค้า                                 |
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
