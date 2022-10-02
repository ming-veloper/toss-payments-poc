export type OrderId = string;
export type TableRowList = HTMLTableRowElement[];

export interface Order {
    orderId: string,
    orderName: string,
    amount: number,
    ordererName: string,
    orderStatus: OrderStatus
}

enum OrderStatus {
    PENDING = "주문대기",
    CANCELLED = "주문취소",
    COMPLETED = "주문완료"
}