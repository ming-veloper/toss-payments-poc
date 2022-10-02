export type OrderId = string;
export type TableRowList = HTMLTableRowElement[];

export interface Order {
    orderId: string,
    orderName: string,
    amount: number,
    ordererName: string,
    orderStatus: OrderStatus
}

export enum OrderStatus {
    PENDING = "PENDING",
    CANCELLED = "CANCELLED",
    COMPLETED = "COMPLETED"
}