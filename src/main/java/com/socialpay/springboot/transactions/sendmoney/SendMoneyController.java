package com.socialpay.springboot.transactions.sendmoney;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping(path = "/SendMoney")
public class SendMoneyController {

    private final SendMoneyRepository sendmoneyRepository;

    public SendMoneyController(SendMoneyRepository sendmoneyRepository) {
        this.sendmoneyRepository = sendmoneyRepository;
    }

    @PostMapping
    public SendMoney create(@RequestBody @Valid SendMoney sendmoney) {
        return sendmoneyRepository.create(sendmoney);
    }

    @GetMapping(path = "/{transactionCode}")
    public SendMoney get(@PathVariable("transactionCode") String transactionCode) {
        return sendmoneyRepository.findByTransactionCode(transactionCode)
                .orElseThrow(() -> new NoSuchElementException("Send money with transaction code " + transactionCode + " not found"));
    }

    @PutMapping
    public SendMoney update(@RequestBody SendMoney sendmoney) {
        return sendmoneyRepository.update(sendmoney);
    }

    @DeleteMapping(path = "/{transactionCode}")
    public void delete(@PathVariable("transactionCode") String transactionCode) {
        sendmoneyRepository.deleteByTransactionCode(transactionCode);
    }
}
