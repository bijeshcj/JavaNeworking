package com.github.scjp;

/**
 * Created with IntelliJ IDEA.
 * User: npcompete
 * Date: 24/7/13
 * Time: 1:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class ScjpMain {
    private String outer = "this is outer";
    public ScjpMain(){
         innerDemo();
    }
    public static void main(String[] str){
          new ScjpMain();
    }
    private void innerDemo(){
        final String innerS = "this is inner";
        class MyInner{
            public void seeOuter(){
                System.out.println(outer);
                System.out.println(innerS);
            }
        }
        MyInner inner = new MyInner();
        inner.seeOuter();
    }
}
