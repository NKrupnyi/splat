package com.krupnyi.splat.model;

public class Account {
    private int id;
    private long amount;

    public Account(int id, long amount) {
        this.id = id;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public Account setId(int id) {
        this.id = id;
        return this;
    }

    public long getAmount() {
        return amount;
    }

    public Account setAmount(long amount) {
        this.amount = amount;
        return this;
    }
}
