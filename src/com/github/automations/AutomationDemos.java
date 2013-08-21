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
//        openCommandWithScript();
          encryptMacAddress("BC:FA");        //6667585152
        print127();
    }

    public static void main(String... str){
        new AutomationDemos();
    }
    private String encryptMacAddress(String macAddress){

        StringBuilder sb = new StringBuilder();
        char[] chars = macAddress.toCharArray();
        for(int i=0;i<chars.length;i++){

          sb.append(getEncryptedString(chars[i]));
        }
        System.out.println("encrypted string: "+sb.toString());
        System.out.println("decrypted string: "+deCryptMacAddress(sb.toString()));
        return sb.toString();
    }
    private String getInt(char c){
        if(c == ':'){
            return ""+(((int)c)+23);
        }
        return ""+(((int)c)+30);
    }
    private String getEncryptedString(char i){
        String retVal = "";

        switch (i){
            case 'A':
                retVal = ""+(char)161;
                break;
            case 'B':
                retVal = ""+(char)182;
                break;
            case 'C':
                retVal = ""+(char)177;

                break;
            case 'D':
                retVal = getInt(i);

                break;
            case 'E':
                retVal = getInt(i);

                break;
            case 'F':
                retVal = ""+(char)191;

                break;
            case 'G':
                retVal = getInt(i);

                break;
            case 'H':
                retVal = getInt(i);

                break;
            case 'I':
                retVal = getInt(i);

                break;
            case 'J':
                retVal = getInt(i);

                break;
            case 'K':
                retVal = getInt(i);

                break;
            case 'L':
                retVal = getInt(i);

                break;
            case 'M':
                retVal = getInt(i);

                break;
            case 'N':
                retVal = getInt(i);

                break;
            case 'O':
                retVal = getInt(i);

                break;
            case 'P':

                break;
            case 'Q':

                break;

            case 'R':

                break;
            case 'S':

                break;
            case 'T':

                break;
            case 'U':

                break;
            case 'V':

                break;
            case 'W':

                break;
            case 'X':

                break;
            case 'Y':

                break;
            case 'Z':

                break;
            case ':':
                retVal = ""+(char)187;
                break;

            default:
                System.out.println("default");
        }


        return retVal;
    }
    private String deCryptMacAddress(String macAddress){
//        BC:FA
        StringBuilder retVal = new StringBuilder();
        char[] chars = macAddress.toCharArray();
        for(int i=0;i<chars.length;i++){
        switch(chars[i]){
            case '¡':
            retVal.append('A');
                break;
            case '¶':
                retVal.append('B');
                break;
            case '±':
                retVal.append('C');
                break;
            case '¿':
                retVal.append('F');
                break;
            default:
                retVal.append(':');

        }
        }
        return retVal.toString();
    }

    private void print127(){
        for(int i=0;i<255;i++){
            System.out.println(i+": "+(char)i);
        }
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
