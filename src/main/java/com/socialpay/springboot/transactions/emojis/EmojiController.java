package com.socialpay.springboot.transactions.emojis;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class EmojiController {

    private final SenderRepository senderRepository;
    private final EmojiRepository emojiRepository;
    private final PaymentProductRepository paymentProductRepository;

    public EmojiController(SenderRepository senderRepository,
                           EmojiRepository emojiRepository,
                           PaymentProductRepository paymentProductRepository) {
        this.senderRepository = senderRepository;
        this.emojiRepository = emojiRepository;
        this.paymentProductRepository = paymentProductRepository;
    }

    @GetMapping(path = "/senders")
    public List<Sender> getSenders() {
        return senderRepository.findAll();
    }

    @GetMapping(path = "/emojis")
    public List<Emoji> getEmojisBySender(@RequestParam("senderId") int senderId) {
        return emojiRepository.findBySenderId(senderId);
    }

    @GetMapping(path = "/emojis/{id}")
    public Emoji getEmojiById(@PathVariable("id") int emojiId) {
        return emojiRepository.findById(emojiId)
                .orElseThrow(() -> new NoSuchElementException("Event with id " + emojiId + " not found"));
    }

    @GetMapping(path = "/PaymentProducts")
    public List<PaymentProduct> getPaymentProductsByEmoji(@RequestParam("emojiId") int emojiId) {
        return paymentProductRepository.findByEmojiId(emojiId);
    }
}
