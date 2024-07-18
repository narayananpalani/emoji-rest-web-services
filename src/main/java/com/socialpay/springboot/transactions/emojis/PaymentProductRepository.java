package com.socialpay.springboot.transactions.emojis;

import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class PaymentProductRepository {

    private final List<PaymentProduct> paymentProducts = List.of(
            new PaymentProduct(801, 501, "Classic", "current account", new BigDecimal("10.00")),
            new PaymentProduct(802, 501, "Premium", "Premium account", new BigDecimal("8.00")),
            new PaymentProduct(803, 502, "Gold", "Gold account", new BigDecimal("1.50")),
            new PaymentProduct(804, 503, "Silver", "Silver Account", new BigDecimal("1.00")),
            new PaymentProduct(805, 503, "Platinum", "Platinum Account", new BigDecimal("0.00")));

    public List<PaymentProduct> findByEmojiId(int emojiId) {
        return paymentProducts.stream().filter(paymentProduct -> paymentProduct.payId() == emojiId).toList();
    }
}
