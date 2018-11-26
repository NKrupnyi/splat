package com.krupnyi.splat.repositories;

import com.krupnyi.splat.model.Account;

public interface AccountRepository {
    Long getAmount(Integer id);

    Long setAmount(Integer id, Long amount);
}
