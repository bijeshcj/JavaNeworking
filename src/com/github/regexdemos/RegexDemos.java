package com.github.regexdemos;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: Bijesh C J
 * Date: 19/7/13
 * Time: 9:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class RegexDemos {
    private RegexDemos(){
        String x =  "{\"time\" : \"2012-09-24T03:08:50\", \"message\" : \"Call() started\"}";
        String pat = "\\{(.*?)\\}";
//        getNumberOfBracesFromGivenString(getString(),"\\{(.*?)\\}");
        getNumberOfBracesFromGivenString(x,pat);
    }
    private String getString(){
        StringBuilder sb = new StringBuilder();
        sb.append("public class Test{\n").append("public Test(){\n hi there}\n}");
        return sb.toString();
    }
    private void getNumberOfBracesFromGivenString(String s,String pattern){
        System.out.println(s);
        Pattern pat = Pattern.compile(pattern);
        Matcher mat = pat.matcher(s);
        int count = 0;
        while(mat.find()){
             count++;
            System.out.println(mat.group(1));
        }
        System.out.println("number of brackets in the given string are " + count);
    }
    public static void main(String[] str){
        new RegexDemos();
    }
}
