package com.socialpay.springboot.transactions.emojis;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ModeRepository {

    private final List<Mode> modes = List.of(
            new Mode(201, "faster pay", "10 seconds", "GBP", "INR"),
            new Mode(202, "future pay", "3 days", "GBP", "CAD"));

    public Optional<Mode> findById(int id) {
        return modes.stream().filter(mode -> mode.id() == id).findAny();
    }
}
