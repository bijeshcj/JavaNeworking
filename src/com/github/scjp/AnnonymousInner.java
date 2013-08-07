package com.github.scjp;

/**
 * Created with IntelliJ IDEA.
 * User: npcompete
 * Date: 7/8/13
 * Time: 11:11 AM
 * To change this template use File | Settings | File Templates.
 */
public class AnnonymousInner {
     Popcorn p = new Popcorn(){
       public void sizzle(){
           System.out.println("sizzling hot");
       }
       @Override
       protected  void pop(){
           System.out.println("I am anonymous pop corn wanna try me....");
       }
     };
    public void popIt(){
        p.pop();
//        p.sizzle();
    }
}
class Popcorn{
    protected void pop(){
        System.out.println("I am popcorn");
    }
}
