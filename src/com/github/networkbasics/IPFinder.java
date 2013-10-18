package com.github.networkbasics;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Bijesh C J
 * Date: 18/10/13
 * Time: 6:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class IPFinder {
    private static String getIPOfanURL(String hostName){
        try{
            InetAddress address = InetAddress.getByName(hostName);
            return address.toString();
        }catch (UnknownHostException ex){
            ex.printStackTrace();
        }
        return null;
    }
    private static String getIPAddress(){
        try{
           InetAddress add = InetAddress.getLocalHost();
            return add.toString();
        }catch (UnknownHostException ex){
            ex.printStackTrace();
        }
        return null;
    }
    public static void main(String... str){
//        String host;
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter the host name: ");
//        host = scanner.next();
        System.out.println("The ip address of the host: "+getIPAddress());
    }
}
