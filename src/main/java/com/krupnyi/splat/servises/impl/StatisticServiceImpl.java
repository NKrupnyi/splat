package com.krupnyi.splat.servises.impl;

import com.krupnyi.splat.servises.StatisticService;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

@Service
public class StatisticServiceImpl implements StatisticService {
    private ConcurrentHashMap<String, Long> queryCountMap;
    private long startStatisticTime;

    public StatisticServiceImpl() {
        init();
    }

    private void init() {
        queryCountMap = new ConcurrentHashMap<>();
        this.startStatisticTime = System.currentTimeMillis();
    }

    @Override
    public long getQueryCount(String methodId) {
        return queryCountMap.getOrDefault(methodId, 0L);
    }

    @Override
    public void incQueryCount(String methodId) {
        queryCountMap.merge(methodId, 1L, Long::sum);
    }

    @Override
    public double getQueryFrequencyPerSecond(String methodId) {
        double secondsInWork = ((double) (System.currentTimeMillis() - startStatisticTime)) / 1000;
        return queryCountMap.getOrDefault(methodId, 0L) / secondsInWork;
    }

    @Override
    public void clear() {
        init();
    }
}
