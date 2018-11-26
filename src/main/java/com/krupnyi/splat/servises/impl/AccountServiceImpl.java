package com.krupnyi.splat.servises.impl;

import com.krupnyi.splat.repositories.AccountRepository;
import com.krupnyi.splat.servises.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    @Transactional
    public Long getAmount(Integer id) {
        return accountRepository.getAmount(id);
    }

    @Override
    @Transactional
    public void addAmount(Integer id, Long value) {
        Long oldAmount = accountRepository.getAmount(id);
        accountRepository.setAmount(id, oldAmount + value);
    }
}
