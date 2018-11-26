package com.krupnyi.splat.repositories.impl;

import com.krupnyi.splat.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AccountRepositoryJdbcTemplateImpl implements AccountRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    @Transactional
    public Long getAmount(Integer id) {
        try {
            return jdbcTemplate.queryForObject("select amount from accounts where id=?", new Object[]{id}, java.lang.Long.class);
        } catch (EmptyResultDataAccessException e) {
            return 0L;
        }
    }

    @Override
    @Transactional
    public void addAmount(Integer id, Long amount) {
        try {
            Long oldAmount = jdbcTemplate.queryForObject("select amount from accounts where id=?", new Object[]{id},
                    java.lang.Long.class);
            jdbcTemplate.update("update accounts set amount = ? where id = ?", oldAmount + amount, id);
        } catch (EmptyResultDataAccessException e) {
            jdbcTemplate.update("insert into accounts (id, amount) values (?, ?)", id, amount);

        }
    }
}
