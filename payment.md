# Api payments

## รายการ Api

- [POST /payments/debit-credit](#post-paymentsdebit-credit)
  - [Request](#request)
  - [Response](#response)

## รายละเอียดของแต่ละ Api

### POST /payments/debit-credit

**สร้างการชำระเงิน**
**ส่งกลับสถานะการชำระเงิน**

#### Request

Request body - application/json

| Name        | Type   | Description     |
| ----------- | ------ | --------------- |
| cardNumber  | String | หมายเลขบัตร     |
| holderName  | String | ชื่อบนบัตร      |
| expireYear  | String | ปีที่หมดอายุ    |
| expireMonth | String | เดือนที่หมดอายุ |
| ccvCvv      | String | รหัสหลังบัตร    |

#### Response

Response model - 201
