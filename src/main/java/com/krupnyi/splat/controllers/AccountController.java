package com.krupnyi.splat.controllers;

import com.krupnyi.splat.servises.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {
    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/{id}")
    Long get(@PathVariable int id) {
        return accountService.getAmount(id);

    }

    @PostMapping("/{id}")
    Object add(@PathVariable int id, @RequestBody Long amount) {
        accountService.addAmount(id, amount);
        return amount;

    }


}
