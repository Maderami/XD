import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StreamDataFromFile {
    private static final String FILENAME = "C:\\Users\\sdsoe\\Desktop\\Laba2-S7-Fix\\src\\listdocs.xml";

    public List<EntityDocument> description() throws ParserConfigurationException, IOException, SAXException {
//Get Document Builder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

//Build Document
        Document document = builder.parse(new File(FILENAME));

//Normalize the XML Structure; It's just too important !!
        document.getDocumentElement().normalize();

//Here comes the root node
        Element root = document.getDocumentElement();


//Get all employees
        NodeList nList = document.getElementsByTagName("docs_s");

        List<EntityDocument> entityDocuments = new ArrayList<>();


        for (int i = 0; i < nList.getLength(); i++) {
            Node node = nList.item(i);
            System.out.println();    //Just a separator
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                //Print each employee's detail
                Element eElement = (Element) node;
                String id = ((Element) node).getAttribute("id").trim();
                String title = eElement.getElementsByTagName("titleDoc").item(0).getTextContent();
                String author = eElement.getElementsByTagName("authorDoc").item(0).getTextContent();
                String creationDate = eElement.getElementsByTagName("creationdate").item(0).getTextContent();
                String registrationDate = eElement.getElementsByTagName("registrationdate").item(0).getTextContent();
                String status = eElement.getElementsByTagName("status").item(0).getTextContent();
                EntityDocument entityDocument = new EntityDocument(id, title, author, creationDate, registrationDate, status);
                entityDocuments.add(entityDocument);
                // System.out.println("Employee id : " + eElement.getAttribute("id"));
                // System.out.println("First Name : " + eElement.getElementsByTagName("firstName").item(0).getTextContent());
                // System.out.println("Last Name : " + eElement.getElementsByTagName("lastName").item(0).getTextContent());
                // System.out.println("Location : " + eElement.getElementsByTagName("location").item(0).getTextContent());
            }
        }


        return entityDocuments;

    }

    public Map<String, List<EntityDocument>> getStatistics(List<EntityDocument> list) throws ParserConfigurationException, IOException, SAXException {

        Map<String, List<EntityDocument>> statistics = new HashMap<>();
        int i=0;
        for (EntityDocument doc : list) {
            String date = doc.getRegistrationDate();
            List<EntityDocument> docsByDate = statistics.get(date);
            if (docsByDate == null) {
                docsByDate = new ArrayList<>();
                statistics.put(date, docsByDate);
            }
            docsByDate.add(doc);
            statistics.put(date, docsByDate);

        }
        return statistics;
    }
}