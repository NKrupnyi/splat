package com.krupnyi.splat.repositories.impl;

import com.krupnyi.splat.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AccountRepositoryJdbcTemplateImpl implements AccountRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AccountRepositoryJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Cacheable(value = "amount")
    public Long getAmount(Integer id) {
        try {
            return jdbcTemplate.queryForObject("select amount from accounts where id=?", new Object[]{id}, java.lang.Long.class);
        } catch (EmptyResultDataAccessException e) {
            return 0L;
        }
    }

    @Override
    @CacheEvict(value = "amount", key = "#id")
    public Long addAmount(Integer id, Long amount) {
        jdbcTemplate.update("insert into accounts AS a(id, amount) values (?, ?) " +
                "ON CONFLICT (id) DO UPDATE SET amount=a.amount + EXCLUDED.amount  ", id, amount);
        return amount;
    }


}
