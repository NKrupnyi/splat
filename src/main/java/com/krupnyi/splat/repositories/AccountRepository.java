package com.krupnyi.splat.repositories;

import com.krupnyi.splat.model.Account;

public interface AccountRepository {
    Long getAmount(Integer id);

    void addAmount(Integer id, Long Amount);
}
