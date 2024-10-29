package dev.mynameisvar.request

data class PaymentRequest(
    val amount: Amount,
    val confirmation: Confirmation,
    val capture: Boolean = true,
    val description: String
)

data class PaymentResponse(
    val id: String,
    val status: String,
    val amount: Amount,
    val confirmation: Confirmation?
)

data class RefundRequest(
    val payment_id: String,
    val amount: Amount
)

data class RefundResponse(
    val id: String,
    val status: String,
    val payment_id: String,
    val amount: Amount
)

data class Amount(
    val value: String,
    val currency: String = "RUB"
)

data class Confirmation(
    val type: String,
    val return_url: String
)
