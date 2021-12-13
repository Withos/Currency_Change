package com.withos.currencyChange.remoteProvider;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URL;

public class RemoteProvider {

    public RemoteProvider(){};

    public Document getData(String fileURL){

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {
            URL url = new URL(fileURL);
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(url.openStream());
            doc.getDocumentElement().normalize();
            return doc;
        } catch(ParserConfigurationException | SAXException | IOException e){
            e.printStackTrace();
            return null;
        }
    }
}
