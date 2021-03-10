package com.cloud.k8s.springcloudk8s.basic;

public class IntefaceDemo {

    public void testRun(Runner runner) {
        runner.run();
    }

    public static void main(String[] args) {
        RunnerA runnerA = new RunnerA();
        RunnerB runnerB = new RunnerB();

        IntefaceDemo demo = new IntefaceDemo();

        demo.testRun(runnerA);
        demo.testRun(runnerB);
    }
}

interface Runner {
    void run();
}


class RunnerA implements Runner {

    @Override
    public void run() {

    }
}


class RunnerB implements Runner {

    @Override
    public void run() {

    }
}
