package com.github.npcompete;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
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
 * User: npcompete
 * Date: 23/8/13
 * Time: 1:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class BMUtility extends BMLogger{
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

}
