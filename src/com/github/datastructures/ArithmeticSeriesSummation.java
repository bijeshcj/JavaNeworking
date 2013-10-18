package com.github.datastructures;

/**
 * Created with IntelliJ IDEA.
 * User: Bijesh C J
 * Date: 27/9/13
 * Time: 9:30 AM
 * To change this template use File | Settings | File Templates.
 */
public class ArithmeticSeriesSummation {

    public ArithmeticSeriesSummation(){

           System.out.println(1 / 2);
//         System.out.println(power(2,2));

    }

    public static int power(int x,int n){
        System.out.println("power x "+x+" n "+n);
        if(n == 0)
            return 1;
        else if(n % 2 == 0) {
            System.out.println("else if X : "+x+" n "+n);
            return power(x * x, n / 2);
        }

        else  {
            System.out.println("else X : "+x+" n "+n);
            return x * power(x * x, n / 2);
        }

    }

    public int factorial(int n){
        if(n == 1)
            return 1;
        else
            return n * factorial(n - 1);
    }

    public static int sum(int n){
        int result = 0;
        for(int i=0;i <= n; ++i){
            result += i;
        }
        return result;
    }
    public static void main(String[] str){
        new ArithmeticSeriesSummation();
    }
}
