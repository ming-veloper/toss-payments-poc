export interface OrderModel {

}

export interface OrderRequestModel extends OrderModel {
    ordererName: string,
    productId: number
}