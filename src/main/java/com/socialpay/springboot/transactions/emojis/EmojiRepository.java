package com.socialpay.springboot.transactions.emojis;

import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public class EmojiRepository {

    private final List<Emoji> emojis = List.of(
            new Emoji(501, "Check Mark Button",
                    new Sender(101, "David", "Sending Money for Family needs"),
                    new Mode(201, "faster pay", "2 seconds", "GBP", "INR"),
                    LocalDate.of(2023, 10, 2), LocalDate.of(2023, 10, 4)),
            new Emoji(502, "Fire",
                    new Sender(101, "George", "Sending money to own account"),
                    new Mode(201, "faster pay", "1 sec", "GBP", "INR"),
                    LocalDate.of(2024, 1, 10), LocalDate.of(2024, 1, 10)),
            new Emoji(503, "Smiling Face",
                    new Sender(102, "Jamilia", "Donations"),
                    new Mode(202, "future pay", "3 days", "GBP", "CAD"),
                    LocalDate.of(2024, 2, 29), LocalDate.of(2024, 2, 29)));

    public List<Emoji> findBySenderId(int senderId) {
        return emojis.stream().filter(emoji -> emoji.sender().id() == senderId).toList();
    }

    public Optional<Emoji> findById(int id) {
        return emojis.stream().filter(emoji -> emoji.id() == id).findAny();
    }
}
