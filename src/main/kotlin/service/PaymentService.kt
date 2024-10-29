package dev.mynameisvar.service

import com.google.gson.Gson
import dev.mynameisvar.request.Amount
import dev.mynameisvar.request.PaymentRequest
import dev.mynameisvar.request.PaymentResponse

class PaymentService(private val apiService: ApiService) {
    private val gson = Gson()

    fun createPayment(paymentRequest: PaymentRequest): PaymentResponse {
        val jsonData = gson.toJson(paymentRequest)
        val response = apiService.sendRequest("payments", "POST", jsonData)
        return gson.fromJson(response, PaymentResponse::class.java)
    }

    fun getPaymentInfo(paymentId: String): PaymentResponse {
        val response = apiService.sendRequest("payments/$paymentId", "GET")
        return gson.fromJson(response, PaymentResponse::class.java)
    }

    fun capturePayment(paymentId: String, amount: Amount): PaymentResponse {
        val captureData = mapOf("amount" to amount)
        val jsonData = gson.toJson(captureData)
        val response = apiService.sendRequest("payments/$paymentId/capture", "POST", jsonData)
        return gson.fromJson(response, PaymentResponse::class.java)
    }
}