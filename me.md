# Api /me

## รายการ Api

- [GET /me/basket](#get-mebasket)
  - [Request](#request)
  - [Response](#response)
- [PUT /me/basket](#put-mebasket)
  - [Request](#request-1)
  - [Response](#response-1)
- [GET /me/addresses](#get-meaddresses)
  - [Request](#request-2)
  - [Response](#response-2)

## รายละเอียดของแต่ละ Api

### GET /me/basket

**เรียกรายการสั่งซื้อในตระกร้า** <br>
**ส่งกลับรายการสั่งซื้อในตระกร้า**

#### Request

ไม่มีพารามิเตอร์ต้องใส่

#### Response

Status code - 200

Response model - application/json <br>
ส่งกลับในรูปแบบของอาร์เรย์ของไอเท็มตามโครงสร้างแสดงดังตารางนี้

| Name                            | Type     | Description      |
| ------------------------------- | -------- | ---------------- |
| productId                       | Integer  | หมายเลขสินค้า    |
| userId                          | Integer  | ไอดีของผู้ซื้อ   |
| features                        | Object[] | รายการฟีเจอร์    |
| &nbsp;&nbsp;&nbsp;name          | String   | ชื่อของฟีเจอร์   |
| &nbsp;&nbsp;&nbsp;selectedValue | String   | ตัวเลือกที่เลือก |
| &nbsp;&nbsp;&nbsp;orderQuantity | Integer  | จำนวนที่ซื้อ     |

### PUT /me/basket

**เรียกอัปเดตรายการในตระกร้า** <br>
**ส่งกลับสถานะการอัปเดตตระกร้า**

#### Request

Request body -application/json

| Name                            | Type     | Description     |
| ------------------------------- | -------- | --------------- |
| productId                       | Integer  | หมายเลขสินค้า   |
| userId                          | Integer  | ไอดีของผู้ซื้อ  |
| features                        | Object[] | รายการฟีเจอร์   |
| &nbsp;&nbsp;&nbsp;name          | String   | ชื่อของฟีเจอร์  |
| &nbsp;&nbsp;&nbsp;selectedValue | String   | ตัวเลือกฟีเจอร์ |
| &nbsp;&nbsp;&nbsp;orderQuantity | Integer  | จำนวนที่ซื้อ    |

#### Response

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
