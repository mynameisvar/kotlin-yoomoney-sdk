# YooMoney SDK для Kotlin

Этот SDK упрощает работу с API YooMoney, предоставляя удобные методы для создания и управления платежами, а также возвратами. С его помощью можно легко интегрировать YooMoney в ваше Kotlin-приложение.

## Начало работы

1. Создайте объект `YooMoneyClient`, передав в него свой API-токен:
    ```kotlin
    val token = "ваш_токен"
    val yooMoneyClient = YooMoneyClient(token)
    ```

2. Используйте сервисы для работы с платежами и возвратами.

## Примеры использования

### Создание платежа

```kotlin
val paymentRequest = PaymentRequest(
    amount = Amount("100.00"),
    confirmation = Confirmation("redirect", "https://example-return-url.com"),
    description = "Описание платежа"
)
val paymentResponse = yooMoneyClient.paymentService.createPayment(paymentRequest)
println("Платеж создан: $paymentResponse")
```

### Получение информации о платеже

```kotlin
val paymentInfo = yooMoneyClient.paymentService.getPaymentInfo(paymentResponse.id)
println("Информация о платеже: $paymentInfo")
```

### Создание возврата

```kotlin
val refundRequest = RefundRequest(
    payment_id = paymentResponse.id,
    amount = Amount("100.00")
)
val refundResponse = yooMoneyClient.refundService.createRefund(refundRequest)
println("Возврат создан: $refundResponse")
```

## Что внутри SDK?

- **YooMoneyClient** — основной класс, через который вы будете работать с SDK.
- **PaymentService** — работа с платежами (создание, получение информации).
- **RefundService** — работа с возвратами.
- **ApiService** — отправка запросов к API.
- **Модели данных** — классы для представления данных (например, `PaymentRequest`, `PaymentResponse`).

## Требования

- Kotlin 1.5+
- API-токен YooMoney
