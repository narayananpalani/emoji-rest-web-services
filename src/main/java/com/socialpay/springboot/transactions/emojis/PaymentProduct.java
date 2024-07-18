package com.socialpay.springboot.transactions.emojis;

import java.math.BigDecimal;

public record PaymentProduct(
        int id,
        int payId,
        String paymentType,
        String description,
        BigDecimal transferFee) {
}
