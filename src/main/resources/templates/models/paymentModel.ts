type OrderId = string;

export class PaymentModel {
    amount: number;
    customerName: string;
    failUrl: string;
    orderId: OrderId;
    orderName: string;
    successUrl: string;

    constructor(amount: number,
                customerName: string,
                failUrl: string,
                orderId: OrderId,
                orderName: string,
                successUrl: string) {
        this.amount = amount;
        this.customerName = customerName;
        this.failUrl = failUrl;
        this.orderId = orderId;
        this.orderName = orderName;
        this.successUrl = successUrl;
    }

    static builder(): PaymentModelBuilder {
        return new DefaultPaymentBuilder();
    }
}


interface PaymentModelBuilder {
    withAmount(amount: number): PaymentModelBuilder;

    withOrderId(orderId: OrderId): PaymentModelBuilder;

    withOrderName(orderName: string): PaymentModelBuilder;

    withCustomerName(customerName: string): PaymentModelBuilder;

    withSuccessUrl(successUrl: string): PaymentModelBuilder;

    withFailUrl(failUrl: string): PaymentModelBuilder;

    build(): PaymentModel;
}


class DefaultPaymentBuilder implements PaymentModelBuilder {

    private amount: number = 0;
    private customerName: string = '';
    private orderId: OrderId = '';
    private orderName: string = '';
    private successUrl: string = '';
    private failUrl: string = '';

    withAmount(amount: number): PaymentModelBuilder {
        this.amount = amount;
        return this;
    }

    withCustomerName(customerName: string): PaymentModelBuilder {
        this.customerName = customerName;
        return this;
    }

    withOrderId(orderId: OrderId): PaymentModelBuilder {
        this.orderId = orderId;
        return this;
    }

    withOrderName(orderName: string): PaymentModelBuilder {
        this.orderName = orderName;
        return this;
    }

    withSuccessUrl(successUrl: string): PaymentModelBuilder {
        this.successUrl = successUrl;
        return this;
    }

    withFailUrl(failUrl: string): PaymentModelBuilder {
        this.failUrl = failUrl;
        return this;
    }

    build(): PaymentModel {
        return new PaymentModel(
            this.amount,
            this.customerName,
            this.failUrl,
            this.orderId,
            this.orderName,
            this.successUrl
        );
    }

}
