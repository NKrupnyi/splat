package com.krupnyi.splat.controllers;

import com.krupnyi.splat.servises.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/statistic")
public class StatisticController {
    private final StatisticService statisticService;

    @Autowired
    public StatisticController(StatisticService statisticService) {
        this.statisticService = statisticService;
    }

    @GetMapping("/{methodId}")
    String getStatistic(@PathVariable String methodId) {
        return statisticService.getQueryCount(methodId) + " queries total," +
                statisticService.getQueryFrequencyPerSecond(methodId) + " queries per second";

    }

    @DeleteMapping
    void cleanStatistic() {
        statisticService.clear();

    }

}
