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
        String pat = "\\{((.*?)\\}";
//        getNumberOfBracesFromGivenString(getString(),"\\{(.*?)\\}");
        getNumberOfBracesFromGivenString(getString(),pat);
//        scanNewLine();
    }
    private String getString(){
        StringBuilder sb = new StringBuilder();
        sb.append("public class Test{\n").append("public Test(){\n hi there\n}\n}");
        return sb.toString();
    }
    private void scanNewLine(){
        String s = "hi there\nfind how many lines\n";
        Pattern pat = Pattern.compile("\\n");
        Matcher mat = pat.matcher(s);
        int count =0;
        System.out.println("before scan");
        while(mat.find()){
            System.out.println(mat.group(0));
            count++;
        }
        System.out.println("Number of lines are "+count);
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
