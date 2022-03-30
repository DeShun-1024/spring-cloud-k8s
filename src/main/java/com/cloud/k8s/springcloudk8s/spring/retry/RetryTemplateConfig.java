package com.cloud.k8s.springcloudk8s.spring.retry;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.backoff.ExponentialBackOffPolicy;
import org.springframework.retry.support.RetryTemplate;

@Configuration
public class RetryTemplateConfig {

    @Bean("ipaynowRetry")
    public RetryTemplate ipaynowRetry() {
        return defaultRetryTemplate();
    }

    @Bean("goallRetry")
    public RetryTemplate goallRetry() {
        return defaultRetryTemplate();
    }

    /**
     * 500
     * 500*2
     * 500*2*2
     * 500*2*2*2
     *
     * 默认重试次数是3次
     */
    private RetryTemplate defaultRetryTemplate() {
        final RetryTemplate retryTemplate = new RetryTemplate();
        ExponentialBackOffPolicy backOffPolicy = new ExponentialBackOffPolicy();
        backOffPolicy.setMultiplier(3);
        backOffPolicy.setInitialInterval(500);
        retryTemplate.setBackOffPolicy(backOffPolicy);
        return retryTemplate;
    }
}