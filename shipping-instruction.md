# Api shipping-instruction

## รายการ Api

- [POST /shipping-instruction](#post-shipping-instruction)
  - [Request](#request)
  - [Response](#response)
- [PUT /shipping-instruction/{id}](#put-shipping-instructionid)
  - [Request](#request-1)
  - [Response](#response-1)
- [GET /shipping-instruction/{id}](#get-shipping-instructionid)
  - [Request](#request-2)
  - [Response](#response-2)

## รายละเอียดของแต่ละ Api

### POST /shipping-instruction

**สร้างคำสั่งส่งของ** <br>
**ส่งกลับสถานะคำสั่งส่งของ**

#### Request

Request body - application/json

| Name                                              | Type     | Description            |
| ------------------------------------------------- | -------- | ---------------------- |
| email                                             | String   | อีเมล                  |
| fullName                                          | String   | ชื่อเต็มของผู้สั่งซื้อ |
| address                                           | String   | รายละเอียดที่อยู่      |
| postalCode                                        | Integer  | หมายเลขไปรษณีย์        |
| zone                                              | String   | เขต                    |
| city                                              | String   | จังหวัด                |
| telephone                                         | String   | หมายเลขโทรศัพท์        |
| paymentMethod                                     | String   | วิธีจ่ายเงิน           |
| paymentStatus                                     | String   | สถานะการจ่ายเงิน       |
| confirmedProducts                                 | Object[] |                        |
| &nbsp;&nbsp;&nbsp;productId                       | Integer  | หมายเลขสินค้า          |
| &nbsp;&nbsp;&nbsp;features                        | Object[] | รายการฟีเจอร์          |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;name          | String   | ชื่อของฟีเจอร์         |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;selectedValue | String   | ตัวเลือกที่เลือก       |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;orderQuantity | Integer  | จำนวนที่ซื้อ           |

#### Response

Status code - 201

### PUT /shipping-instruction/{id}

**เรียกเพื่ออัปเดตรายการคำสั่งส่งของ** <br>
**ส่งกลับสถานะการอัปเดต**

#### Request

Path parameters

| Name | Type    | Description                  |
| ---- | ------- | ---------------------------- |
| id   | Integer | หมายเลข shipping-instruction |

Request body - application/json

| Name                                              | Type     | Description            |
| ------------------------------------------------- | -------- | ---------------------- |
| email                                             | String   | อีเมล                  |
| fullName                                          | String   | ชื่อเต็มของผู้สั่งซื้อ |
| address                                           | String   | รายละเอียดที่อยู่      |
| postalCode                                        | Integer  | หมายเลขไปรษณีย์        |
| zone                                              | String   | เขต                    |
| city                                              | String   | จังหวัด                |
| telephone                                         | String   | หมายเลขโทรศัพท์        |
| paymentMethod                                     | String   | วิธีจ่ายเงิน           |
| paymentStatus                                     | String   | สถานะการจ่ายเงิน       |
| confirmedProducts                                 | Object[] |                        |
| &nbsp;&nbsp;&nbsp;productId                       | Integer  | หมายเลขสินค้า          |
| &nbsp;&nbsp;&nbsp;features                        | Object[] | รายการฟีเจอร์          |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;name          | String   | ชื่อของฟีเจอร์         |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;selectedValue | String   | ตัวเลือกที่เลือก       |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;orderQuantity | Integer  | จำนวนที่ซื้อ           |

#### Response

Status code - 200

### GET /shipping-instruction/{id}

**เรียกรายการคำสั่งส่งของอย่างเจาะจง** <br>
**ส่งกลับรายการคำสั่งส่งของอย่างเจาะจง**

#### Request

Path parameters

| Name | Type    | Description         |
| ---- | ------- | ------------------- |
| id   | Integer | หมายเลขคำสั่งจัดส่ง |

#### Response

Response model - application/json <br>
ส่งกลับในรูปแบบโครงสร้างตามตาราง

| Name                                              | Type     | Description            |
| ------------------------------------------------- | -------- | ---------------------- |
| email                                             | String   | อีเมล                  |
| fullName                                          | String   | ชื่อเต็มของผู้สั่งซื้อ |
| address                                           | String   | รายละเอียดที่อยู่      |
| postalCode                                        | Integer  | หมายเลขไปรษณีย์        |
| zone                                              | String   | เขต                    |
| city                                              | String   | จังหวัด                |
| telephone                                         | String   | หมายเลขโทรศัพท์        |
| paymentMethod                                     | String   | วิธีจ่ายเงิน           |
| paymentStatus                                     | String   | สถานะการจ่ายเงิน       |
| confirmedProducts                                 | Object[] |                        |
| &nbsp;&nbsp;&nbsp;productId                       | Integer  | หมายเลขสินค้า          |
| &nbsp;&nbsp;&nbsp;features                        | Object[] | รายการฟีเจอร์          |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;name          | String   | ชื่อของฟีเจอร์         |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;selectedValue | String   | ตัวเลือกที่เลือก       |
| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;orderQuantity | Integer  | จำนวนที่ซื้อ           |

Status code - 200
