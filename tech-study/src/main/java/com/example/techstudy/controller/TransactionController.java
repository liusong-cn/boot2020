package com.example.techstudy.controller;

import com.example.techstudy.transaction.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Administrator
 * @date: 2021/3/9 0:26
 */
@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/doTransaction")
    public void doTransactionDemo(){
        transactionService.doTransaction();
    }
}
