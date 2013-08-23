package com.github.npcompete;

import org.w3c.dom.Document;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: Bijesh C J
 * Date: 18/8/13
 * Time: 6:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class BharathMatrimonyAntTask extends BMLogger{
     private BharathMatrimonyAntTask(String language){
//         JOptionPane.showMessageDialog(null,"executed from jar");
//         scanForManifest("");
           execute(language);
     }

    private void execute(String language){
          File manifestFile = getManifestFile();
          AndroidProject project = constructAndroidProject(manifestFile,language);
    }

    /**
     *   now this is hard coded later get the project path and append the manifest file
     * @return file
     */
    private File getManifestFile(){
         return null;
    }

    /**
     * This method will construct the project model which contains all the needed information about the project
     */
    private AndroidProject constructAndroidProject(File manifestFile,String language){
           AndroidProject project = null;
           String currentPackage = getCurrentPackagename(manifestFile);

           project = new AndroidProject(currentPackage,language);

           return project;
    }



    private String getCurrentPackagename(File manifestFile){
        String retVal = "";

        print(Severe.LOW,"in getCurrentPackage...");

        Document doc = BMUtility.getDocument(manifestFile);
        retVal = BMUtility.getAttributeValue(doc,"manifest","package");


        return retVal;
    }

    /**
     * This method will scan for AndoridManifest.xml in the project's root directory.
     * This method is not implemented now add functionality of the same which is done for ArtisanSupport tools.
     */
    private boolean scanForManifest(String projectPath){
        boolean returnFlag = true;

        return returnFlag;
    }
    private String appendLanguage(AndroidProject androidProject){
         return androidProject.getCurrentPackageName().concat(androidProject.getLanguageToBuild());
    }
      public static void main(String[] str){
          new BharathMatrimonyAntTask(str[0]);
      }
    private class AndroidProject{

        private String currentPackageName;
        private String intentedPackageName;
        private String languageToBuild;

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


        private AndroidProject(String currentpackageName,String languageToBuild){
             this.currentPackageName = currentpackageName;
             this.languageToBuild = languageToBuild;

        }
        @Override
        public String toString(){
            return "[package name is "+ currentPackageName +", language in which it would be compiled "+languageToBuild+"]";
        }
    }
}
