package com.withos.currencyChange.xmlparse;

import com.withos.currencyChange.entities.Currencies;
import com.withos.currencyChange.entities.Currency;
import com.withos.currencyChange.remoteProvider.RemoteProvider;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLParse {
    private final Document data;
    private static final String fileURL = "https://www.nbp.pl/kursy/xml/lasta.xml";

    public XMLParse(){
        RemoteProvider provider = new RemoteProvider();
        this.data = provider.getData(fileURL);
    }

    public void createList(){
        NodeList nodeList = this.data.getElementsByTagName("pozycja");
        for (int i = 0; i < nodeList.getLength(); i++)
        {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE)
            {
                Element element = (Element) node;
                String name = element.getElementsByTagName("nazwa_waluty").item(0).getTextContent();
                Integer multiplier = Integer.valueOf(element.getElementsByTagName("przelicznik").item(0).getTextContent());
                String code = element.getElementsByTagName("kod_waluty").item(0).getTextContent();
                Double rate = Double.valueOf(element.getElementsByTagName("kurs_sredni").item(0).getTextContent().replace(",", "."));
                Currencies.getInstance().addCurrency(new Currency(name, multiplier, code, rate));
            }
        }
        Currencies.getInstance().addCurrency(new Currency("zloty_polski", 1, "PLN", 1));
    }
}
