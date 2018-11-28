package com.krupnyi.splat.controllers;

import com.krupnyi.splat.servises.AccountService;
import com.krupnyi.splat.servises.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {
    private final AccountService accountService;
    private final StatisticService statisticService;

    @Autowired
    public AccountController(AccountService accountService, StatisticService statisticService) {
        this.accountService = accountService;
        this.statisticService = statisticService;
    }

    @GetMapping("/{id}")
    Long get(@PathVariable int id) {
        System.out.println("get " + id);
        statisticService.incQueryCount("get");
        return accountService.getAmount(id);

    }

    @PostMapping("/{id}")
    Object add(@PathVariable int id, @RequestBody Long amount) {
        System.out.println("post " + id + "_+" + amount);
        statisticService.incQueryCount("add");
        accountService.addAmount(id, amount);
        return amount;

    }


}
