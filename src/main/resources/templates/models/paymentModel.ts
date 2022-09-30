type OrderId = string;

export interface PaymentModel {
    amount: number,
    orderId: OrderId,
    orderName: string,
    customerName: string,
    successUrl: string,
    failUrl: string;
}