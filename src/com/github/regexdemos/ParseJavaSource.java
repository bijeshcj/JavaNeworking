package com.github.regexdemos;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: Bijesh C J
 * Date: 4/9/13
 * Time: 2:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class ParseJavaSource {

    public ParseJavaSource(){
    }
    private String getString(){
        StringBuilder sb = new StringBuilder();
        sb.append("public class Test{\n").append("public Test(){\n hi there\n}\n}");
        return sb.toString();
    }
    private void getNumberOfBracesFromGivenString(String s,String pattern){
        System.out.println(s);
        Pattern pat = Pattern.compile(pattern);
        Matcher mat = pat.matcher(s);
        int count = 0;
        System.out.println("*****************************");
        while(mat.find()){
            count++;
            System.out.println(mat.group());
        }
        System.out.println("number of brackets in the given string are " + count);
    }
    public static void main(String[] str){
        new ParseJavaSource();
    }
}
