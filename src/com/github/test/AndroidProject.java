package com.github.test;

/**
 * Created with IntelliJ IDEA.
 * User: npcompete
 * Date: 23/8/13
 * Time: 2:42 PM
 * To change this template use File | Settings | File Templates.
 */
public class AndroidProject {
    private String currentPackageName;
    private String languageToBuild;


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


    private AndroidProject(String packageName,String languageToBuild){
        this.currentPackageName = packageName;
        this.languageToBuild = languageToBuild;

    }
    @Override
    public String toString(){
        return "[package name is "+ currentPackageName +", language in which it would be compiled "+languageToBuild+"]";
    }
}
