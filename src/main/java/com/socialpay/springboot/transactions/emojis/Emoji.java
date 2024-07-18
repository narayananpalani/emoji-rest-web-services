package com.socialpay.springboot.transactions.emojis;

import java.time.LocalDate;

public record Emoji(
        int id,
        String emojiName,
        Sender sender,
        Mode mode,
        LocalDate promoStartDate,
        LocalDate promoEndDate) {
}
