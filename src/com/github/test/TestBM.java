package com.github.test;

import com.github.test.BMLogger;
import com.github.test.BMUtility;
import org.w3c.dom.Document;

import java.io.File;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: npcompete
 * Date: 23/8/13
 * Time: 2:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestBM extends BMLogger{

    TestBM(){
        File file = new File("/home/npcompete/TempBiju/TestBMAutomation/bm_all_langs/AndroidManifest.xml");
        AndroidProject project = constructAndroidProject(file,"tamil","linux",System.getProperty("file.separator"));

        BMUtility.setAttributeValue(project.getManifestFile(),"manifest","package","com.bharatmatrimony_tamil");


//          getProperties();
    }

    public static void main(String[] str){
        new TestBM();
    }

    private void getProperties(){
        Properties  props = System.getProperties();
        props.list(System.out);
    }

    private AndroidProject constructAndroidProject(File manifestFile,String language,String os,String fileSeparator){

        String currentPackage = getCurrentPackagename(manifestFile);
        return new AndroidProject(manifestFile,currentPackage,language,os,fileSeparator);
    }
    private String getCurrentPackagename(File manifestFile){
        String retVal = "";

        print(BMLogger.Severe.LOW,"in getCurrentPackage...");

        Document doc = BMUtility.getDocument(manifestFile);
        retVal = BMUtility.getAttributeValue(doc,"manifest","package");


        return retVal;
    }
}


