package com.cloud.k8s.springcloudk8s.jvm;

/**
 * VM Args：-Xss128k，该参数设置的是每个线程，栈占用空间；
 *
 * hotsopt虚拟机 不支持虚拟机栈的动态扩容的，所以是不会由于虚拟机栈无法扩展而导致oom，但是如果申请时就失败，还是会oom；
 *
 * @author zzm
 */
public class JavaVMStackSOF_1 {

    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF_1 oom = new JavaVMStackSOF_1();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length:" + oom.stackLength);
            throw e;
        }
    }
}