package com.example.spendingz2.services;

import com.example.spendingz2.entities.Transaction;
import com.example.spendingz2.entities.User;
import com.example.spendingz2.repos.TransactionRepository;
import com.example.spendingz2.requests.TransactionCreateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    TransactionRepository transactionRepository;
    UserService userService;

    public TransactionService(TransactionRepository transactionRepository, UserService userService){
        this.userService = userService;
        this.transactionRepository = transactionRepository;
    }


    public List<Transaction> findAllTransactions() {
        return transactionRepository.findAll();
    }


    public Transaction createTransaction(TransactionCreateRequest transactionCreateRequest) {
        User user = userService.findUserByID(transactionCreateRequest.getUid());
        if(user == null){
            return null;
        }
        Transaction transaction = new Transaction();
        System.out.println(transaction.getDate());
        System.out.println(transaction.getTid());
        transaction.setPrice(transactionCreateRequest.getPrice());
        transaction.setProduct(transactionCreateRequest.getProduct());
        transaction.setUser(user);
        return transactionRepository.save(transaction);
    }


    public Transaction findTransactionById(Long tid) {
        return transactionRepository.findById(tid).orElse(null);
    }


    public Transaction updatetransactionByID(Transaction transaction, Long tid) {
        Optional<Transaction> possibleTransaction = transactionRepository.findById(tid);
        if(possibleTransaction.isPresent()){
            Transaction updatedTransaction = possibleTransaction.get();
            updatedTransaction.setDate(transaction.getDate());
            updatedTransaction.setPrice(transaction.getPrice());
            updatedTransaction.setProduct(transaction.getProduct());
            transactionRepository.save(updatedTransaction);
            return updatedTransaction;
        }
        return null;
    }


    public void deleteTransactionByID(Long tid) {
        Optional<Transaction> possibleTransaction = transactionRepository.findById(tid);
        if(possibleTransaction.isPresent()){
            transactionRepository.deleteById(tid);
        }
    }
}
