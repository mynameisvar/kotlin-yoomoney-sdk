package dev.mynameisvar

import dev.mynameisvar.client.YooMoneyClient
import dev.mynameisvar.request.Amount
import dev.mynameisvar.request.Confirmation
import dev.mynameisvar.request.PaymentRequest

fun main() {
    val token = "token"
    val yooMoneyClient = YooMoneyClient(token)

    val paymentRequest = PaymentRequest(
        amount = Amount("100.00"),
        confirmation = Confirmation("redirect", "https://example-return-url.com"),
        description = "Test Payment"
    )
    val paymentResponse = yooMoneyClient.paymentService.createPayment(paymentRequest)
    println("Payment Created: $paymentResponse")

    val paymentInfo = yooMoneyClient.paymentService.getPaymentInfo(paymentResponse.id)
    println("Payment Info: $paymentInfo")
}