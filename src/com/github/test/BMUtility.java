package com.github.test;

import org.apache.commons.io.FileUtils;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;

/**
 * Created with IntelliJ IDEA.
 * User: Bijesh
 * Date: 23/8/13
 * Time: 1:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class BMUtility extends BMLogger {


    protected static void renamePackage(File file, String currentPackage, String intentPackage){
        try{
            String src = FileUtils.readFileToString(file);
            if(file.getName().equals("ChatDB.java")){
                print(Severe.HIGH,"currentPackage: "+currentPackage+" intentPackage: "+intentPackage);
                print(Severe.HIGH,"*********************** original src *****************");
                print(Severe.HIGH,src);
            }
            src = src.replaceAll(currentPackage,intentPackage);

            if(file.getName().equals("ChatDB.java")){
                print(Severe.HIGH,"*********************** parsed src *****************");
                print(Severe.HIGH,src);
            }

            FileUtils.write(file,src);

        }catch(IOException e){
            e.printStackTrace();
        }
    }



    protected static Document getDocument(File manifestFile){
        Document doc = null;
        try{
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        doc = dBuilder.parse(manifestFile);
        doc.getDocumentElement().normalize();
        }catch(ParserConfigurationException e){
            e.printStackTrace();
        }catch(SAXException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
        return doc;
    }

    protected static void saveDocument(Document doc,File manifestFile){
        try{
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        StreamResult result = new StreamResult(new StringWriter());
        DOMSource source = new DOMSource(doc);
        transformer.transform(source, result);

        String xmlOutput = result.getWriter().toString();


        StreamResult resultToFile = new StreamResult(manifestFile);
        DOMSource sourceFile = new DOMSource(doc);
        transformer.transform(sourceFile, resultToFile);
        }catch(TransformerConfigurationException e){
            e.printStackTrace();
        }catch(TransformerException e){
            e.printStackTrace();
        }
    }

    protected static String getAttributeValue(Document doc,String element,String attribute){

        String retVal = "";
        NodeList nList = doc.getElementsByTagName(element);
        Node node = nList.item(0);
        if(node instanceof Element){
            retVal = ((Element)node).getAttribute(attribute);
        }
        print(Severe.LOW,"in getAttributeValue return value "+retVal);
        return retVal;
    }

    protected  static void setAttributeValue(File manifestFile,String element,String attribute,String value){
        Document doc = getDocument(manifestFile);
        Node node = doc.getElementsByTagName(element).item(0);
        NamedNodeMap attr = node.getAttributes();
        Node nodeAttr = attr.getNamedItem(attribute);
        nodeAttr.setTextContent(value);

        saveDocument(doc,manifestFile);
    }

}
