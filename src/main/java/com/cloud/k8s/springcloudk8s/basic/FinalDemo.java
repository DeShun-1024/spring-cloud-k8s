package com.cloud.k8s.springcloudk8s.basic;

public class FinalDemo {

    public static void main(String[] args) {
        Integer first = 10;
        final int a = first;
        first = 20;
        System.out.println(a);
    }
}


class Father {

    public void test() {
        System.out.println("");
    }


    /**
     * final 修饰，子类不能重写
     */
    public final void cannotOverrider() {

    }
}

class Son extends Father {

    @Override
    public void test() {
        super.test();
    }
}
