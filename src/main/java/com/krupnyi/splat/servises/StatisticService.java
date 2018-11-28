package com.krupnyi.splat.servises;

public interface StatisticService {

    long getQueryCount(String methodId);

    void incQueryCount(String methodId);

    double getQueryFrequencyPerSecond(String methodId);

    void clear();
}
