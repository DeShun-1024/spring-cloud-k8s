package com.cloud.k8s.springcloudk8s.pattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * 观察者模式的主要角色如下。
 * 抽象主题（Subject）角色：也叫抽象目标类，它提供了一个用于保存观察者对象的聚集类和增加、删除观察者对象的方法，以及通知所有观察者的抽象方法。
 * 具体主题（Concrete Subject）角色：也叫具体目标类，它实现抽象目标中的通知方法，当具体主题的内部状态发生改变时，通知所有注册过的观察者对象。
 * 抽象观察者（Observer）角色：它是一个抽象类或接口，它包含了一个更新自己的抽象方法，当接到具体主题的更改通知时被调用。
 * 具体观察者（Concrete Observer）角色：实现抽象观察者中定义的抽象方法，以便在得到目标的更改通知时更新自身的状态。
 *
 * @author hudeshun
 * @since 2021/4/14 18:35
 */
abstract class Subject {
    protected List<Observer> observers = new ArrayList<>();

    public void add() {
        System.out.println("增加观察者");
    }

    public void remove() {
        System.out.println("删除观察者");
    }

    public abstract void notifyObserver(); // 通知观察者

}

/**
 * 具体主题
 */
class ConcreteSubject extends Subject {
    @Override
    public void notifyObserver() {
        System.out.println("目标发生改变");

        for (Observer observer : observers) {
            observer.response();
        }
    }
}


/**
 * 抽象观察者
 */
interface Observer {
    void response();
}

/**
 * 具体观察者
 */
class ConcreteObserver1 implements Observer {
    @Override
    public void response() {
        System.out.println("观察者1 反应...");
    }
}

class ConcreteObserver2 implements Observer {

    @Override
    public void response() {
        System.out.println("观察者2 反应...");
    }
}

public class ObserverDemo {
    public static void main(String[] args) {
        Subject subject = new ConcreteSubject();
        subject.add();
        subject.notifyObserver();


        Observable observable = new Observable();
        observable.notifyObservers();

    }

}
