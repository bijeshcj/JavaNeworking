package com.github.maths;

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

        String formula = "(AB)C = A(BC)";

        String lhs = getLHSOrRHS(formula,Side.LEFT);

        System.out.println("LHS : "+lhs);
        getTextInsideBrackets(lhs);


    }
    private void getTextInsideBrackets(String format){
        Pattern pat = Pattern.compile("\\(.*?\\)");
        Matcher mat = pat.matcher(format);
        String temp = "";
        while(mat.find()){
            temp = mat.group();
            System.out.println(temp);
            removePattern(temp);
        }

    }
    private String removePattern(String candidate){
        String retVal = "";
        Pattern pat = Pattern.compile("\\w");
        Matcher mat = pat.matcher(candidate);
        while(mat.find()){
            System.out.println(mat.group());
        }
        return retVal;
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



