package com.github.test;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: npcompete
 * Date: 23/8/13
 * Time: 2:42 PM
 * To change this template use File | Settings | File Templates.
 */
public class AndroidProject{

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

    public String getIntentedPackageName(){
        return currentPackageName+"_"+languageToBuild;
    }

    private String getCurrentPackageName() {
        return currentPackageName;
    }

    private void setCurrentPackageName(String currentPackageName) {
        this.currentPackageName = currentPackageName;
    }

    private String getLanguageToBuild() {
        return languageToBuild;
    }

    private void setLanguageToBuild(String languageToBuild) {
        this.languageToBuild = languageToBuild;
    }




    public AndroidProject(File manifestFile,String currentpackageName,String languageToBuild,String os,String fileSeparator){
        this.currentPackageName = currentpackageName;
        this.languageToBuild = languageToBuild;
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
