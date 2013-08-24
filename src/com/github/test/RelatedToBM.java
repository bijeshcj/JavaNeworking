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
public class RelatedToBM extends BMLogger{

    public RelatedToBM(){
//        File file = new File("/home/npcompete/workspace/TestAntOne/src/com/example/testantone/MainActivity.java");
//        renamePackage(file, "com.bharathmatrimony", "com.bharathmatrimony_tamil");
//        File homeFile = new File("/home/npcompete/TempBiju/TestBMAutomation/bm_all_langs/src/com/bharatmatrimony/chat/ChatDB.java");
//        renamePackage(homeFile,"com.bharatmatrimony","com.bharatmatrimony_tamil");
//          replaceString("import com.bharatmatrimony.AppState;",);

          print(Severe.LOW,"ret val "+getPackageNames("com.bharatmatrimony_tamil"));
    }



    public static void main(String[] str){
        new RelatedToBM();
    }

    private String getPackageNames(String intent){
        String retVal = "";
        String[] vals = intent.split("\\.");
        retVal = vals[vals.length-1];
        return retVal;
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
    private void renamePackageFolder(File rootPath){
        String currentPackageName = "bharatmatrimony";
        String intentPackageName = "bharatmatrimony_tamil";
        File[] files = rootPath.listFiles();
        for(File fls:files){
            print(Severe.LOW,"fileName "+fls);
            if(fls.getName().endsWith("src")){
                traverseAndRename(fls,currentPackageName,intentPackageName);
            }
        }

    }
    private void traverseAndRename(File file,String currentPackageName,String intent){
        print(Severe.HIGH,"inside traverseAndRename");
        File[] files = file.listFiles();
        for(File fls:files){
            print(Severe.HIGH,"fls name "+fls.getName());
            if(fls.getName().equals(currentPackageName) && fls.isDirectory()){
                print(Severe.HIGH,"bm older path "+fls.getAbsolutePath());
                 print(Severe.HIGH,"inside condition in traverseAndRename "+ fls.renameTo(new File(fls.getAbsolutePath()+"_hindi")));


            }else if(fls.getName().equals("com")){
                traverseAndRename(fls,currentPackageName,intent);
            }
        }
    }
}
