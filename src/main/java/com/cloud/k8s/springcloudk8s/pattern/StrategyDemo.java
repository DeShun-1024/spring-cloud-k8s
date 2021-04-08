package com.cloud.k8s.springcloudk8s.pattern;


import lombok.extern.slf4j.Slf4j;

/**
 * 策略模式
 *
 * @author hudeshun
 * @since 2021/3/10 13:56
 */

public class StrategyDemo {

    public static void main(String[] args) {
        Context context = new Context();

        Strategy strategy_A = new Strategy_A();
        Strategy strategy_B = new Strategy_A();

        context.setStrategy(strategy_A);
        context.setStrategy(strategy_B);

        context.strategyMethod();
    }
}

/**
 * 抽象策略类
 */
interface Strategy {
    void strategyMethod();
}

/**
 * 具体策略
 */
@Slf4j
class Strategy_A implements Strategy {

    @Override
    public void strategyMethod() {
        log.info("策略_A");
    }
}

/**
 * 具体策略
 */
@Slf4j
class Strategy_B implements Strategy {

    @Override
    public void strategyMethod() {
        log.info("策略_B");
    }
}

/**
 * 环境类
 */
class Context {

    private Strategy strategy;

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void strategyMethod() {
        strategy.strategyMethod();
    }
}
