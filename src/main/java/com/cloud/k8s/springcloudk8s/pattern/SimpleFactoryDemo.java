package com.cloud.k8s.springcloudk8s.pattern;

import static com.cloud.k8s.springcloudk8s.pattern.Const.PRODUCT_A;

interface Producer {
    void show();
}

class ConCreateProduct1 implements Producer {
    @Override
    public void show() {
        System.out.println("具体产品-1");
    }
}

class ConCreateProduct2 implements Producer {
    @Override
    public void show() {
        System.out.println("具体产品-2");
    }
}

class SimpleFactory {
    public static Producer makeProduct(int kind) {
        switch (kind) {
            case PRODUCT_A:
                return new ConCreateProduct1();
            case Const.PRODUCT_B:
                return new ConCreateProduct2();
        }
        return null;
    }
}

final class Const {
    static final int PRODUCT_A = 0;
    static final int PRODUCT_B = 1;
}

/**
 * 简单工厂模式的主要角色如下：
 * 简单工厂（SimpleFactory）：是简单工厂模式的核心，负责实现创建所有实例的内部逻辑。工厂类的创建产品类的方法可以被外界直接调用，创建所需的产品对象。
 * 抽象产品（Product）：是简单工厂创建的所有对象的父类，负责描述所有实例共有的公共接口。
 * 具体产品（ConcreteProduct）：是简单工厂模式的创建目标。
 *
 * @author hudeshun
 * @since 2021/4/11 16:27
 */
public class SimpleFactoryDemo {

    public static void main(String[] args) {
        final Producer producer = SimpleFactory.makeProduct(PRODUCT_A);
    }
}



