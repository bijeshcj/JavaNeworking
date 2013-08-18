package com.github.npcompete;

import javax.swing.*;

/**
 * Created with IntelliJ IDEA.
 * User: Bijesh C J
 * Date: 18/8/13
 * Time: 6:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class BharathMatrimonyAntTask {
     private BharathMatrimonyAntTask(){
//         JOptionPane.showMessageDialog(null,"executed from jar");
         scanForManifest();
     }

    /**
     * This method will scan for AndoridManifest.xml in the project's root directory.
     * This method is not implemented now add functionality of the same which is done for ArtisanSupport tools.
     */
    private boolean scanForManifest(){
         boolean returnFlag = true;

        return returnFlag;
    }
    private String appendLanguage(AndroidProject androidProject){
         return androidProject.getPackageName().concat(androidProject.getLanguageToBuild());
    }
      public static void main(String[] str){
          new BharathMatrimonyAntTask();
      }
    private class AndroidProject{
        private String packageName;
        private String languageToBuild;
        private String applicationName;

        private String getPackageName() {
            return packageName;
        }

        private void setPackageName(String packageName) {
            this.packageName = packageName;
        }

        private String getLanguageToBuild() {
            return languageToBuild;
        }

        private void setLanguageToBuild(String languageToBuild) {
            this.languageToBuild = languageToBuild;
        }

        private String getApplicationName() {
            return applicationName;
        }

        private void setApplicationName(String applicationName) {
            this.applicationName = applicationName;
        }

        private AndroidProject(String appname,String packageName,String languageToBuild){
             this.packageName = packageName;
             this.languageToBuild = languageToBuild;
             this.applicationName = appname;
        }
        @Override
        public String toString(){
            return "[AppName: "+applicationName+",package name is "+packageName+", langiage in which it would be compiled "+languageToBuild+"]";
        }
    }
}
