package com.socialpay.springboot.transactions.emojis;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SenderRepository {

    private final List<Sender> senders = List.of(
            new Sender(101, "David", "Current Acc Setup"),
            new Sender(102, "George", "Savings Acc Setup"));

    public List<Sender> findAll() {
        return senders;
    }
}
