package com.cloud.k8s.springcloudk8s.spring.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyHystrixCommand extends HystrixCommand<Integer> {


    private final String name;

    protected MyHystrixCommand(String name) {
//        super(Setter
//                .withGroupKey(HystrixCommandGroupKey.Factory.asKey("orderService"))
//                .andCommandKey(HystrixCommandKey.Factory.asKey("queryByOrderId"))
//                .andCommandPropertiesDefaults(HystrixCommandProperties
//                        .Setter()
//                        //至少有10个请求，熔断器才进行错误率的计算
//                        .withCircuitBreakerRequestVolumeThreshold(10)
//                        //熔断器中断请求5秒后会进入半打开状态,放部分流量过去重试
//                        .withCircuitBreakerSleepWindowInMilliseconds(5000)
//                        //错误率达到50开启熔断保护
//                        .withCircuitBreakerErrorThresholdPercentage(50)
//                        .withExecutionTimeoutEnabled(true))
//                .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties
//                        .Setter().withCoreSize(10)));

        super(HystrixCommandGroupKey.Factory.asKey("MyHystrixCommand"));
        this.name = name;
    }

    @Override
    protected Integer run() throws Exception {
        log.info("参数:{},健康状态:{}，断路器开关:{}", name, getMetrics().getHealthCounts(), circuitBreaker.isOpen());

        if (name == null) {
            throw new NullPointerException("");
        }
        return 100;
    }

    @Override
    protected Integer getFallback() {
        log.info("fallback");
//        fallback 有异常，hytrix是直接抛出异常
//        System.out.println(1 / 0);
        return -1;
    }


    public static void main(String[] args) throws InterruptedException {
        // 测试断路器是否打开
//        for (int i = 0; i < 50; i++) {
//            MyHystrixCommand command = new MyHystrixCommand(i % 2 == 0 ? null : "demo");
//            command.execute();
//            TimeUnit.MILLISECONDS.sleep(500);
//        }

        MyHystrixCommand command = new MyHystrixCommand(null);
        final Integer execute = command.execute();
        log.info("执行结果:{}", execute);
    }
}
