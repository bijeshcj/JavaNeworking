package com.github.scjp;

/**
 * Created with IntelliJ IDEA.
 * User: Bijesh C J
 * Date: 25/9/13
 * Time: 2:24 PM
 * To change this template use File | Settings | File Templates.
 */
public strictfp class StrictfpClass {


    public StrictfpClass(float a, float b){
        System.out.println("a "+a);
        System.out.println("b "+b);
        stictFloat(a,b);
    }
    private strictfp void stictFloat(float a,float b){
        System.out.println("a "+a);
        System.out.println("b "+b);

    }
    public static void main(String[] str){
         new StrictfpClass(78.4543645354354353235f,58.49854938534850495f);
    }
}
