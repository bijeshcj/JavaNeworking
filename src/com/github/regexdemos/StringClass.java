package com.github.regexdemos;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: Bijesh C J
 * Date: 28/8/13
 * Time: 10:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class StringClass {
    public StringClass(){
        learnReplace();
    }
    public static void main(String[] str){
        new StringClass();
    }
    void learnReplace(){

        String s = "this is test";
        s = s.replace("is","at");
        System.out.println(s);

        System.out.println(Pattern.LITERAL);

        Pattern pat = Pattern.compile(s,Pattern.LITERAL);
        Matcher mat = pat.matcher(s);

        while(mat.find()){
            System.out.println(mat.group());
        }


    }
}
