import {OrderId} from "./types";

export interface OrderModel {

}

export interface OrderCreateRequestModel extends OrderModel {
    ordererName: string,
    productId: number
}

export interface OrderCancelRequestModel extends OrderModel {
    orderId: OrderId
}