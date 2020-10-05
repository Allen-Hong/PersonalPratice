package com.allen;

/**
 * @author huanghw
 * @Description TODO
 * @create 2020-10-04 16:02
 */
public class B {

    public B() {
    }

    public void run(){
        if (new C().getVersion().equals("2.0")) {
            System.out.println("B ok");
        } else {
            System.out.println("B error");
        }
    }
}
