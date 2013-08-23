package com.github.test;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: npcompete
 * Date: 23/8/13
 * Time: 4:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class RelatedToBM {

    public RelatedToBM(){
        File file = new File("/home/npcompete/workspace/TestAntOne/src/com/example/testantone/MainActivity.java");
        renamePackage(file, "com.bharathmatrimony", "com.bharathmatrimony_tamil");
    }

    public static void main(String[] str){
        new RelatedToBM();
    }
    private void renamePackage(File file, String currentPackage, String intentPackage){
        try{
            String src = FileUtils.readFileToString(file);

            System.out.println("*************** Original Src ******************");

            System.out.println(src);
            System.out.println("*************** Altered Src ******************");
            src = src.replaceAll(currentPackage,intentPackage);
            System.out.println(src);

            FileUtils.write(file,src);

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
