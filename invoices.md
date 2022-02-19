# Api invoices

## รายการ Api

- [POST /invoices](#post-invoices)
  - [Request](#request)
  - [Response](#response)
- [GET /invoices/{id}](#get-invoicesid)
  - [Request](#request-1)
  - [Response](#response-1)

## รายละเอียดของแต่ละ Api

### POST /invoices

**เรียกสร้างใบแจ้งชำระเงิน** <br>
**ส่งกลับสถานะใบแจ้งชำระเงิน**

#### Request

Request body - application/json

| Name                  | Type    | Description            |
| --------------------- | ------- | ---------------------- |
| fullName              | String  | ชื่อผู้ซื้อ            |
| shippingInstructionId | Integer | หมายเลขใบคำสั่งส่งของ  |
| transactionDate       | String  | วันเวลาที่ทำรายการซื้อ |
| expiredDate           | String  | วันเวลาที่หมดอายุ      |
| amount                | Double  | ยอดที่ต้องชำระ         |

#### Response

Status code - 201

### GET /invoices/{id}

**เรียกใบแจ้งชำระเงินอย่างเจาะจง** <br>
**ส่งกลับข้อมูลใบแจ้งชำระเงิน**

#### Request

Path parameter

| Name | Type    | Description           |
| ---- | ------- | --------------------- |
| id   | integer | หมายเลขใบคำสั่งส่งของ |

#### Response

Response model - application/json

| Name    | Type   | Description        |
| ------- | ------ | ------------------ |
| pdfPath | string | ที่อยู่ของไฟล์ PDF |

Status code - 200
