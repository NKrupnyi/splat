package com.krupnyi.splat.repositories;

public interface AccountRepository {
    Long getAmount(Integer id);

    Long addAmount(Integer id, Long amount);
}
