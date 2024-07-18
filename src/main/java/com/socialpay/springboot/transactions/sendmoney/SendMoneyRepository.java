package com.socialpay.springboot.transactions.sendmoney;

import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class SendMoneyRepository {

    private static final AtomicInteger ID_GENERATOR = new AtomicInteger();

    private final Map<String, SendMoney> registrationByTransactionCode = new ConcurrentHashMap<>();

    public SendMoney create(SendMoney sendmoney) {
        int id = ID_GENERATOR.incrementAndGet();
        String transactionCode = UUID.randomUUID().toString();

        var saved = new SendMoney(id, sendmoney.paymentId(), transactionCode, sendmoney.senderName());
        registrationByTransactionCode.put(transactionCode, saved);
        return saved;
    }

    public Optional<SendMoney> findByTransactionCode(String transactionCode) {
        return Optional.ofNullable(registrationByTransactionCode.get(transactionCode));
    }

    public SendMoney update(SendMoney sendmoney) {
        String transactionCode = sendmoney.transactionCode();

        var opt = findByTransactionCode(transactionCode);
        if (opt.isPresent()) {
            var existing = opt.get();

            var saved = new SendMoney(existing.id(), existing.paymentId(), existing.transactionCode(), sendmoney.senderName());
            registrationByTransactionCode.put(transactionCode, saved);
            return saved;
        } else {
            throw new NoSuchElementException("Send money with transaction code " + transactionCode + " not found");
        }
    }

    public void deleteByTransactionCode(String transactionCode) {
        registrationByTransactionCode.remove(transactionCode);
    }
}
