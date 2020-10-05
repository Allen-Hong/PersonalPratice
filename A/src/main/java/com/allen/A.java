package com.allen;

/**
 * @author huanghw
 * @Description TODO
 * @create 2020-10-04 15:48
 */
public class A {

    public A() {
    }

    public void run(){
        if (new C().getVersion().equals("1.0")) {
            System.out.println("A ok");
        } else {
            System.out.println("A error");
        }
    }
}
