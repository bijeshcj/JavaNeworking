package com.github.test;

/**
 * Created with IntelliJ IDEA.
 * User: npcompete
 * Date: 23/8/13
 * Time: 2:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class BMLogger{

    private static final boolean FLAG = false;

    protected static void print(Severe sev,String message){
            switch (sev){
                case HIGH:
                    System.out.println(message);
                    break;
                case LOW:
                    if(FLAG){
                        System.out.println(message);
                    }

            }
    }
    enum Severe{
         HIGH,
         LOW
    }
}
