package dev.mynameisvar.service

import java.net.HttpURLConnection
import java.net.URL

class ApiService(private val token: String) {
    private val baseUrl = "https://api.yookassa.ru/v3/"

    fun sendRequest(endpoint: String, method: String, jsonData: String? = null): String {
        val url = URL(baseUrl + endpoint)
        val connection = (url.openConnection() as HttpURLConnection).apply {
            requestMethod = method
            setRequestProperty("Authorization", "Bearer $token")
            setRequestProperty("Content-Type", "application/json")
            if (jsonData != null) {
                doOutput = true
                outputStream.write(jsonData.toByteArray(Charsets.UTF_8))
            }
        }

        val responseCode = connection.responseCode
        val response = connection.inputStream.bufferedReader().use { it.readText() }

        if (responseCode !in 200..299) {
            throw Exception("Error response from YooMoney: $response")
        }
        return response
    }
}