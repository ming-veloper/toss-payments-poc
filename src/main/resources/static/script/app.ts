import {loadTossPayments, TossPaymentsInstance} from '@tosspayments/payment-sdk'
import {PaymentModel} from "./models/paymentModel";
import {OrderRequestModel} from "./models/orderModels";
import {OrderService} from "./proxy/orderService";
import {CommonService} from "./proxy/commonService";
import {Order, TableRowList} from "./models/types";

let tossInstance: TossPaymentsInstance;

function initTableBody(): HTMLTableElement {
    let tableBody = document.querySelector('#tableBody') as HTMLTableElement;
    tableBody.innerHTML = '';
    return tableBody;
}

function createOrderTableRow(trList: TableRowList, order: Order) {
    let tableRow = document.createElement('tr');

    let orderIdColumn = document.createElement('td');
    orderIdColumn.innerText = order.orderId;

    let orderNameColumn = document.createElement('td');
    orderNameColumn.innerText = order.orderName;

    let amountColumn = document.createElement('td');
    amountColumn.innerText = order.amount.toString();

    let ordererNameColumn = document.createElement('td');
    ordererNameColumn.innerText = order.ordererName;

    let orderStatus = document.createElement('td');
    orderStatus.innerText = order.orderStatus;

    tableRow.appendChild(orderIdColumn);
    tableRow.appendChild(orderNameColumn);
    tableRow.appendChild(amountColumn);
    tableRow.appendChild(ordererNameColumn);
    tableRow.appendChild(orderStatus);

    trList.push(tableRow);
}

function createOrderTable(orders: Order[]) {
    let tableBody = initTableBody();
    let trList: TableRowList = [];
    for (const order of orders) {
        createOrderTableRow(trList, order);
    }

    trList.forEach(e => {
        tableBody.appendChild(e);
    });
}

async function main() {
    const orders: Order[] = (await OrderService.getOrders()).data;
    createOrderTable(orders);
    let clientKey = (await CommonService.getClientKey()).data;
    tossInstance = await loadTossPayments(clientKey);
    let element = document.querySelector('#paymentButton') as HTMLButtonElement;
    element.onclick = () => processPayments();
}

async function processPayments() {
    let ordererName = (document.querySelector('#usernameForm') as HTMLInputElement).value;
    if (ordererName.length === 0) {
        alert('주문자명은 필수입니다.');
        return;
    }

    let parsedValue = (document.querySelector('#productId') as HTMLInputElement).value;
    let productId = Number(parsedValue);
    let orderRequestModel: OrderRequestModel = {
        ordererName,
        productId
    }
    const {status, data} = await OrderService.createOrder(orderRequestModel);
    console.assert(status === 201, "status must be [201]");
    let amount: number = Number((document.querySelector('#amount') as HTMLInputElement).value);
    let paymentData = PaymentModel.builder()
        .withAmount(amount)
        .withOrderId(data)
        .withOrderName("주문 이름")
        .withCustomerName("고객 이름")
        .withSuccessUrl(window.location.origin + "/success")
        .withFailUrl(window.location.origin + "/fail")
        .build();
    tossInstance.requestPayment("카드", paymentData);


}

main();