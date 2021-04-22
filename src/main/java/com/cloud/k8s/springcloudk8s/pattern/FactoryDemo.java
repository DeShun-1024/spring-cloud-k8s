package com.cloud.k8s.springcloudk8s.pattern;

/**
 * 抽象工厂（Abstract Factory）：提供了创建产品的接口，调用者通过它访问具体工厂的工厂方法 newProduct() 来创建产品。
 * 具体工厂（ConcreteFactory）：主要是实现抽象工厂中的抽象方法，完成具体产品的创建。
 * 抽象产品（Product）：定义了产品的规范，描述了产品的主要特性和功能。
 * 具体产品（ConcreteProduct）：实现了抽象产品角色所定义的接口，由具体工厂来创建，它同具体工厂之间一一对应。
 *
 * @author hudeshun
 * @since 2021/4/14 18:14
 */

/**
 * 抽象产品1
 */
interface Product1 {
    void show();
}

interface Product2 {
    void show();
}


/**
 * 具体产品
 */
class ConcreteProduct11 implements Product1 {

    @Override
    public void show() {
    }
}

/**
 * 具体产品
 */
class ConcreteProduct22 implements Product1 {

    @Override
    public void show() {
    }
}

/**
 * 抽象工厂
 */
interface AbstractFactory {
    Product1 newProduct1();

//    工厂模式 增加产品族形成 抽象工厂模式
//    Product2 newProduct2();
}

/**
 * 具体工厂1
 */
class ConcreteFactory1 implements AbstractFactory {
    @Override
    public Product1 newProduct1() {
        return new ConcreteProduct11();
    }
}

/**
 * 具体工厂2
 */
class ConcreteFactory2 implements AbstractFactory {

    @Override
    public Product1 newProduct1() {
        return new ConcreteProduct22();
    }
}

public class FactoryDemo {
    AbstractFactory abstractFactory1 = new ConcreteFactory1();

    AbstractFactory abstractFactory2 = new ConcreteFactory2();
}
