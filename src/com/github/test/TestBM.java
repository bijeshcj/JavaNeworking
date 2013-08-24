package com.github.test;

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
        BMProject project = constructBMProject(file,"com.bharatmatrimony","com.bharatmatrimony_tamil","linux",System.getProperty("file.separator"));
        project.setRootPath("/home/npcompete/TempBiju/TestBMAutomation/bm_all_langs");
        parseSourceAndResources(project);
//        BMUtility.setAttributeValue(project.getManifestFile(),"manifest","package","com.bharatmatrimony_tamil");


//          getProperties();
    }

    public static void main(String[] str){
        new TestBM();
    }

    private void parseSourceAndResources(BMProject project){
        parsingSource(project);
        parsingResource(project);
    }
    private void parsingSource(BMProject project){
          traverse(new File(project.getRootPath()+project.getFileSeparator()+"src"),".java",project.getCurrentPackageName(),project.getIntentedPackageName());
    }
    private void parsingResource(BMProject project){
        traverse(new File(project.getRootPath()+project.getFileSeparator()+"res"),".xml",project.getCurrentPackageName(),project.getIntentedPackageName());
    }

    private void traverse(File f,String fileType,String currentName,String intentName){
         File[] files = f.listFiles();
         for(File file:files){
             if(file.isDirectory()){
                 traverse(file,fileType,currentName,intentName);
             }else if(file.getName().endsWith(fileType)){
                 BMUtility.renamePackage(file,currentName,intentName);
             }
         }
    }



    private void getProperties(){
        Properties  props = System.getProperties();
        props.list(System.out);
    }

    private BMProject constructBMProject(File manifestFile, String currentPackage, String intentPackage, String os, String fileSeparator){

        String currentPackageInManifest = getCurrentPackagename(manifestFile);
        if(intentPackage.equals(currentPackageInManifest)){
            print(Severe.HIGH, "The pacakage name in the manifest is same as argument so automation will exit ");
            System.exit(0);
        }
        return new BMProject(manifestFile,currentPackage,intentPackage,os,fileSeparator);
    }
    private String getCurrentPackagename(File manifestFile){
        String retVal = "";

        print(BMLogger.Severe.LOW,"in getCurrentPackage...");

        Document doc = BMUtility.getDocument(manifestFile);
        retVal = BMUtility.getAttributeValue(doc,"manifest","package");


        return retVal;
    }
}


