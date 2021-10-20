import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public class OperationDoc {

    private int c;
    public static List<EntityDocument> list;

    public int getCountApprove( ) throws ParserConfigurationException, IOException, SAXException {
        StreamDataFromFile streamDataFromFile = new StreamDataFromFile();
        list = streamDataFromFile.description();
        int i = 0;
        int count = 0;

        for (EntityDocument doc : list) {
            String date = doc.getRegistrationDate();
            List<EntityDocument> docsByDate = streamDataFromFile.getStatistics(list).get(date);
            streamDataFromFile.getStatistics(list).put(date, docsByDate);
            String status = streamDataFromFile.getStatistics(list).get(date).get(i).getStatus();
            if ("Approve".equals(status)) {
                count++;
            }

            i++;

        }
        System.out.println(count);
        return count;
    }

    public int getCountDeflect() throws ParserConfigurationException, IOException, SAXException {
        StreamDataFromFile streamDataFromFile = new StreamDataFromFile();
        list = streamDataFromFile.description();
        int i = 0;
        int def = 0;

        for (EntityDocument doc : list) {
            String date = doc.getRegistrationDate();
            List<EntityDocument> docsByDate = streamDataFromFile.getStatistics(list).get(date);
            streamDataFromFile.getStatistics(list).put(date, docsByDate);
            String status = streamDataFromFile.getStatistics(list).get(date).get(i).getStatus();
            if ("Deflect".equals(status)) {
                def++;
            }
            i++;

        }
        System.out.println(def);
        return def;
    }

}
