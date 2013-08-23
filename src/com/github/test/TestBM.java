package com.github.test;

import com.github.test.BMLogger;
import com.github.test.BMUtility;
import org.w3c.dom.Document;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: npcompete
 * Date: 23/8/13
 * Time: 2:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestBM extends BMLogger{

    TestBM(){
        File file = new File("/home/npcompete/workspace/TestAntOne/AndroidManifest.xml");
        constructAndroidProject(file);
    }

    public static void main(String[] str){
        new TestBM();
    }

    private AndroidProject constructAndroidProject(File manifestFile){
        AndroidProject project = null;
        String currentPackage = getCurrentPackagename(manifestFile);

        return project;
    }
    private String getCurrentPackagename(File manifestFile){
        String retVal = "";

        print(BMLogger.Severe.LOW,"in getCurrentPackage...");

        Document doc = BMUtility.getDocument(manifestFile);
        retVal = BMUtility.getAttributeValue(doc,"manifest","package");


        return retVal;
    }
}
