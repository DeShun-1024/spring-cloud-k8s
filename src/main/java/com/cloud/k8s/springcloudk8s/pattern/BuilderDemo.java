package com.cloud.k8s.springcloudk8s.pattern;

import lombok.Data;

/**
 * 建造者（Builder）模式的主要角色如下。
 * 1、产品角色（Product）：它是包含多个组成部件的复杂对象，由具体建造者来创建其各个零部件。
 * 2、抽象建造者（Builder）：它是一个包含创建产品各个子部件的抽象方法的接口，通常还包含一个返回复杂产品的方法 getResult()。
 * 3、具体建造者(Concrete Builder）：实现 Builder 接口，完成复杂产品的各个部件的具体创建方法。
 * 4、指挥者（Director）：它调用建造者对象中的部件构造与装配方法完成复杂对象的创建，在指挥者中不涉及具体产品的信息。
 */
public class BuilderDemo {
    public static void main(String[] args) {
        Builder builder = new Builder_A();
        Director director = new Director(builder);

        final Product product = director.construct();
        product.show();
    }
}

@Data
class Product {
    private String partA;
    private String partB;
    private String partC;

    public void show() {
    }
}

abstract class Builder {

    protected Product product = new Product();

    public abstract void buildPartA();

    public abstract void buildPartB();

    public abstract void buildPartC();

    public Product getProduct() {
        return product;
    }
}

class Builder_A extends Builder {

    @Override
    public void buildPartA() {
        product.setPartA("构建 A");
    }

    @Override
    public void buildPartB() {
        product.setPartB("构建 B");
    }

    @Override
    public void buildPartC() {
        product.setPartC("构建 C");
    }
}

class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public Product construct() {
        builder.buildPartA();
        builder.buildPartB();
        builder.buildPartC();
        return builder.getProduct();
    }
}