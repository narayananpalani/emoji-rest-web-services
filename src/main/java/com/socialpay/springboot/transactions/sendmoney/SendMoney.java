package com.socialpay.springboot.transactions.sendmoney;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SendMoney(
        Integer id,
        @NotNull(message = "Payment Id is required") Integer paymentId,
        String transactionCode,
        @NotBlank(message = "Sender name is required") String senderName) {
}
