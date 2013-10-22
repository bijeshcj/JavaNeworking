package com.github.maths;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: Bijesh C J
 * Date: 15/10/13
 * Time: 12:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class EqualMatrix {
    public EqualMatrix(){
        process();
    }
    private void process(){
        // now the matrix are hard coded later on get the input from the user and make it dynamic

        int [][] A = new int[][] {{2,3,1},{3,0,3}};
        int B[] = new int[]{1,1,2};
        int C[] = new int[]{1,-2};

        // formula is also hard coded later on get the input from the user and make it dynamic

        String formula = "(A+B)C = A(BC)";

        String lhs = getLHSOrRHS(formula,Side.LEFT);

        System.out.println("LHS : "+lhs);
        List<String> lstChrs =  getTextInsideBrackets(lhs);

        if(lstChrs != null){
//            find the operators and do the operation
            System.out.println("list is "+lstChrs);
            performOperation(lstChrs);
        }

    }
    private void performOperation(List<String> values){
        for(int i = 0;i<values.size();i++)
        {
         char[] c = values.get(i).toCharArray();
         char previousChar = ' ',currentChar=' ';
         switch(c[0]){
             case 'A':
                 System.out.println("A found");
                 break;
             case 'B':
                 System.out.println("B found");
                 break;
             case 'C':
                 System.out.println("C found");
                 break;
             case 'D':
                 System.out.println("D found");
                 break;
             case 'E':
                 System.out.println("E found");
                 break;
             case '-':
                 System.out.println("subtraction found");
                 break;
             case '+':
                 System.out.println("Addition found");
         }
        }
    }
    private void temp(int i){
        if(i == 0){

        }

    }
    private List<String> getTextInsideBrackets(String format){

        Pattern pat = Pattern.compile("\\(.*?\\)");
        Matcher mat = pat.matcher(format);
        String temp = "";
        while(mat.find()){
            temp = mat.group();
            System.out.println(temp);
            return removeBrackets(temp);
        }
       return null;
    }
    private List<String> removeBrackets(String candidate){
        List<String> chars = new ArrayList<String>();
        String retVal = "";
        Pattern pat = Pattern.compile("[^\\( || ^\\)]");
        Matcher mat = pat.matcher(candidate);
        while(mat.find()){
            chars.add(mat.group());
        }
        return chars;
    }
    private String getLHSOrRHS(String formula,Side side){
        // A validation needed to be included later on to fin whether the formuala is a valid
        switch(side){
            case LEFT:
                    return formula.split("=")[0];
                case RIGHT:
                    return formula.split("=")[1];
            default:
                    return null;
        }
    }
    enum Side{
        LEFT,RIGHT
    }
    public static void main(String... str){
        new EqualMatrix();
    }
}



