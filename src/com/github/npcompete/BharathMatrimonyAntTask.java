package com.github.npcompete;

import org.w3c.dom.Document;

import java.io.File;

import static com.github.npcompete.BMLogger.print;
import static com.github.npcompete.BMLogger.Severe;

/**
 * Created with IntelliJ IDEA.
 * User: Bijesh
 * Date: 18/8/13
 * Time: 6:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class BharathMatrimonyAntTask {

    private BMProject project;

     private BharathMatrimonyAntTask(String projectPath,String currentPackage,String intentPackage){
//         JOptionPane.showMessageDialog(null,"executed from jar");
//         scanForManifest("");
           execute(projectPath,currentPackage,intentPackage);
     }

    private void execute(String projectPath,String currentPackage,String intentPackage){

          String fileSeparator =  fileSeparator();
          File manifestFile = getManifestFile(projectPath,fileSeparator);
          project = constructAndroidProject(manifestFile,currentPackage,intentPackage,systemOS(),fileSeparator);

          renamePackageNameInManifest(project,intentPackage);



    }

    private void renamePackageNameInManifest(BMProject project,String intentPackage){
          BMUtility.setAttributeValue(project.getManifestFile(),"manifest","package",intentPackage);
    }

    private String systemOS(){
        return System.getProperty("os.name");
    }

    private String fileSeparator(){
        return System.getProperty("file.separator");
    }

    /**
     *   now this is hard coded later get the project path and append the manifest file
     * @return file
     */
    private File getManifestFile(String projectPath,String fileSeparator){

         return new File(projectPath+fileSeparator+"AndroidManifest.xml");
    }



    /**
     * This method will construct the project model which contains all the needed information about the project
     */
    private BMProject constructAndroidProject(File manifestFile,String currentPackage,String intentPackage,String os,String fileSeparator){

           String currentPackageInManifest = getCurrentPackagename(manifestFile);
           if(currentPackage.equals(currentPackageInManifest)){
              print(Severe.HIGH,"The pacakage name in the manifest is same as argument so automation will exit ");
              System.exit(0);
           }
           return new BMProject(manifestFile,currentPackage,intentPackage,os,fileSeparator);
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
    private String appendLanguage(BMProject androidProject){
         return androidProject.getCurrentPackageName().concat(androidProject.getLanguageToBuild());
    }
      public static void main(String[] str){
          new BharathMatrimonyAntTask(str[0],str[1],str[2]);
      }

}
