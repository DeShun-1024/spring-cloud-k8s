package com.cloud.k8s.springcloudk8s.utils;


import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;

@Slf4j
public class DateUtils {

    public static void test_duration() {
        Instant instant1 = Instant.parse("2007-12-03T09:15:30.00Z");
        Instant instant2 = Instant.parse("2007-12-03T10:15:30.00Z");
        Duration duration = Duration.between(instant1, instant2);
        log.info("{}", duration.getSeconds());
    }

    public static void test_period() {
        LocalDate dateTime1 = LocalDate.of(2018, 12, 02);
        LocalDate dateTime2 = LocalDate.of(2018, 12, 01);
        Period period = Period.between(dateTime1, dateTime2);
        log.info("相差天数：{}", period.getDays());
        log.info("相差天数：{}", period.getMonths());
        log.info("相差天数：{}", period.getYears());
        log.info("{}", period.get(ChronoUnit.DAYS));
    }

    public static void chronoUnit() {
        LocalDate startDate = LocalDate.of(2003, Month.AUGUST, 9);
        LocalDate endDate = LocalDate.of(2015, Month.AUGUST, 12);
        long daysDiff = ChronoUnit.DAYS.between(startDate, endDate);
    }

}
