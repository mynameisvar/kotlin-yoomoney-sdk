package dev.mynameisvar.client

import dev.mynameisvar.service.ApiService
import dev.mynameisvar.service.PaymentService
import dev.mynameisvar.service.RefundService

class YooMoneyClient(private val token: String) {
    private val apiService = ApiService(token)

    val paymentService: PaymentService by lazy { PaymentService(apiService) }
    val refundService: RefundService by lazy { RefundService(apiService) }
}