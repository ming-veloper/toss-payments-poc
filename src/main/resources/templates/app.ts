import {loadTossPayments, TossPaymentsInstance} from '../static/node_modules/@tosspayments/payment-sdk'
import {PaymentModel} from "./models/paymentModel";

let tossInstance: TossPaymentsInstance;

async function initToss() {
    let clientKey = (window as any).clientKey;
    tossInstance = await loadTossPayments(clientKey);
    let element = document.querySelector('#paymentButton') as HTMLButtonElement;
    element.onclick = () => processPayments();
}

function processPayments() {
    let ordererName = (document.querySelector('#usernameForm') as HTMLInputElement).value;
    if (ordererName.length === 0) {
        alert('주문자명은 필수입니다.');
        return;
    }


    fetch('api/order', {
        method: 'POST',
        body: JSON.stringify({
            //TODO ordererName 직접 입력 받게...
            ordererName,
            productId: (document.querySelector('#productId') as HTMLInputElement).value,
        }),
        headers: {
            'Content-Type': 'application/json;'
        }
    })
        .then(async (response: Response) => {
            if (response.status === 201) {
                let orderId = await response.text();
                let amount: number = Number((document.querySelector('#amount') as HTMLInputElement).value);

                let paymentData = PaymentModel.builder()
                    .withAmount(amount)
                    .withOrderId(orderId)
                    .withOrderName("주문 이름")
                    .withCustomerName("고객 이름")
                    .withSuccessUrl(window.location.origin + "/success")
                    .withFailUrl(window.location.origin + "/fail")
                    .build();
                tossInstance.requestPayment("카드", paymentData);
            }
        })
}

initToss();