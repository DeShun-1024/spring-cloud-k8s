package com.cloud.k8s.springcloudk8s.basic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * 在subList场景中，如果对父元素的修改，删除，均会导致子元素在遍历、增加、删除时，出现ConcurrentModificationException。
 * 原因：
 * 在subList的各个操作均有checkForComodification() 方法
 */
public class ListConcurrentModificationException {


    public static void listIteratorTest() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");

        final Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            final String next = iterator.next();
            if (next.equals("2")) {
                iterator.remove();
            }
        }
        System.out.println(list);
    }

    public static void listForTest() {
        List<String> list = new ArrayList<>();
        list.add("45");
        list.add("2");
//        list.add("1");
//        list.add("4");

        // 1、首先foreach是语法糖，这个与for有区别的，for是底层。
        // 2、foreach反编译后，就是使用的迭代器，在遍历时，使用的是java.util.ArrayList.Itr，该方法在next中会做并发修改校验，调用方法：checkForComodification ，list的修改次数与期望修改次数比较,
        // 3、为什么换成2后，就会报错，反编译的代码中，hasNext判断是：cursor != size (index of next element to return)，在最好一次移除后，
        // 前面判断返回true，从而需要调用迭代器的next方法，从而报错
        // List remove 底层方法调用的是ArrayList的remove（）方法，
        for (String s : list) {
            if ("2".equals(s)) {
                list.remove(s);
            }
        }
        System.out.println(list);
    }


    // 不要在foreach中遍历，修改remove、add方法。remove元素使用iterator方式、
    public static void subListAddOrRemove() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("12");
        list.add("123");

        final List<String> subList = list.subList(0, 1);
        list.add("1234");

//        subList.add("sub-1");
        subList.remove("123");
    }
    public static void subListIterator() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("12");
        list.add("123");

        final List<String> subList = list.subList(0, 1);
        list.add("1234");
        System.out.println(subList);
    }

    public static void main(String[] args) {
//        subListAddOrRemove();

        listForTest();
//

    }
}
