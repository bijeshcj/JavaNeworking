package com.github.test;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * Author: Bijesh
 * Date: 24/8/13
 * Time: 12:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class BMProject{

    private String OS;
    private String fileSeparator;
    private String rootPath;
    private String currentPackageName;
    private String intentedPackageName;
    private String languageToBuild;
    private File manifestFile;

    public File getManifestFile() {
        return manifestFile;
    }

    public void setManifestFile(File manifestFile) {
        this.manifestFile = manifestFile;
    }

    public String getFileSeparator() {
        return fileSeparator;
    }

    public void setFileSeparator(String fileSeparator) {
        this.fileSeparator = fileSeparator;
    }

    public String getOS() {
        return OS;
    }

    public void setOS(String OS) {
        this.OS = OS;
    }

    public String getRootPath() {
        return rootPath;
    }

    public void setRootPath(String rootPath) {
        this.rootPath = rootPath;
    }

    public void setIntentedPackageName(String packagename){
        this.intentedPackageName = packagename;
    }

    public String getIntentedPackageName(){
        return this.intentedPackageName;
    }

    public String getCurrentPackageName() {
        return currentPackageName;
    }

    public void setCurrentPackageName(String currentPackageName) {
        this.currentPackageName = currentPackageName;
    }

    public String getLanguageToBuild() {
        return languageToBuild;
    }

    public void setLanguageToBuild(String languageToBuild) {
        this.languageToBuild = languageToBuild;
    }




    public BMProject(File manifestFile,String currentpackageName,String intentPackage,String os,String fileSeparator){
        this.currentPackageName = currentpackageName;
        this.intentedPackageName = intentPackage;
        this.OS = os;
        this.fileSeparator = fileSeparator;
        this.manifestFile = manifestFile;
    }
    @Override
    public String toString(){
        return "BharathMatrimony project details [package name is "+ currentPackageName +", language in which it would be compiled "+
                languageToBuild+", project running on OS ]"+this.OS+" file separator "+fileSeparator+"path : "+this.rootPath+"  ]";
    }
}
