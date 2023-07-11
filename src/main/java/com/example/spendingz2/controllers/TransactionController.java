package com.example.spendingz2.controllers;

import com.example.spendingz2.entities.Transaction;
import com.example.spendingz2.requests.TransactionCreateRequest;
import com.example.spendingz2.services.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private TransactionService transactionService;

    public TransactionController(TransactionService transactionService){
        this.transactionService = transactionService;
    }

    @GetMapping()
    public List<Transaction> findAllTransactions(){
        return transactionService.findAllTransactions();
    }

    @PostMapping()
    public Transaction createTransaction(@RequestBody TransactionCreateRequest transactionCreateRequest){
        System.out.println("aaa");
        return transactionService.createTransaction(transactionCreateRequest);
    }

    @GetMapping("/{tid}")
    public Transaction findTransactionByID(@PathVariable Long tid){
        return transactionService.findTransactionById(tid);
    }

    @PutMapping("/{tid}")
    public Transaction updateTransactionByID(@RequestBody Transaction transaction, @PathVariable Long tid){
        return transactionService.updatetransactionByID(transaction, tid);
    }

    @DeleteMapping("/{tid}")
    public void deleteTransactionByID(@PathVariable Long tid){
        transactionService.deleteTransactionByID(tid);

    }


}
