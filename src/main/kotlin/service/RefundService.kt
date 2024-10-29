package dev.mynameisvar.service

import com.google.gson.Gson
import dev.mynameisvar.request.RefundRequest
import dev.mynameisvar.request.RefundResponse

class RefundService(private val apiService: ApiService) {
    private val gson = Gson()

    fun createRefund(refundRequest: RefundRequest): RefundResponse {
        val jsonData = gson.toJson(refundRequest)
        val response = apiService.sendRequest("refunds", "POST", jsonData)
        return gson.fromJson(response, RefundResponse::class.java)
    }

    fun getRefundInfo(refundId: String): RefundResponse {
        val response = apiService.sendRequest("refunds/$refundId", "GET")
        return gson.fromJson(response, RefundResponse::class.java)
    }
}