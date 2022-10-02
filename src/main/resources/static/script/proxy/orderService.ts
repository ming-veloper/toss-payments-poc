import {AXIOS_INSTANCE} from "./axiosInstance";
import {OrderModel} from "../models/orderModels";
import {AxiosResponse} from "axios";
import {Order, OrderId} from "../models/types";

export class OrderService {
    /**
     * 주문 생성
     * @param body
     */
    static createOrder(body: OrderModel): Promise<AxiosResponse<OrderId>> {
        return AXIOS_INSTANCE.post("/api/order", JSON.stringify(body));
    }

    /**
     * 주문 조회
     */
    static getOrders(): Promise<AxiosResponse<Order[]>> {
        return AXIOS_INSTANCE.get("api/order")
    }
}



