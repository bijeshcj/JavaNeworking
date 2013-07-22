package com.github.automations;

import java.io.OutputStream;
import java.io.PrintWriter;

/**
 * Created with IntelliJ IDEA.
 * User: Bijesh C J
 * Date: 22/7/13
 * Time: 7:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class AutomationDemos {
    private AutomationDemos(){
//        openCommandPrompt();
        openCommandWithScript();
    }

    public static void main(String... str){
        new AutomationDemos();
    }
    private void openCommandPrompt(){
        try{
           String command = "cmd /c start cmd.exe";
           Process child = Runtime.getRuntime().exec(command);
            OutputStream out = child.getOutputStream();
            out.write("cd C:/ /r/n".getBytes());
            out.flush();
            out.write("dir /r/n".getBytes());
            out.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    private void openCommandWithScript(){
        String[] command = {"cmd"};
        try{
        Process pro = Runtime.getRuntime().exec(command);
        new Thread(new SyncPipe(pro.getErrorStream(),System.err)).start();
        new Thread(new SyncPipe(pro.getInputStream(),System.out)).start();
            PrintWriter stdIn = new PrintWriter(pro.getOutputStream());
//            stdIn.println("dir c:\\ /A /Q");
            stdIn.println("gradle --version");
            stdIn.close();
            int ret = pro.waitFor();
            System.out.println("Return Code "+ret);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
