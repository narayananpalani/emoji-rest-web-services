package com.socialpay.springboot.transactions.emojis;

public record Mode(
        int id,
        String payType,
        String duration,
        String sendCCY,
        String receiveCCY) {
}
