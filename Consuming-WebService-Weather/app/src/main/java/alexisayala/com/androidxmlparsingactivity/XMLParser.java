package alexisayala.com.androidxmlparsingactivity;


import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import java.io.IOException;
import java.io.StringReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Created by alexis on 11/02/16.
 */
public class XMLParser {
    //Constructor
    public XMLParser(){

    }
    /*obtenemos el xml usando una peticion soap 1.1*/

    public String getXMLUsingSoap(String ciudad, String pais){
        String xml = null;
        /*
        Instanciamos el objeto de Soap en el cual se indican los datos del servidor
         */
        SoapObject so = new SoapObject("http://www.webserviceX.NET","GetWeather");
        //añadimos las propiedades que requiere el servicio web, CityName & CountryName
        so.addProperty("CityName",ciudad);
        so.addProperty("CountryName", pais);
        //wrap it in a SOAP envelope
        SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapEnvelope.bodyOut = so;
        soapEnvelope.dotNet = true;
        //listo para enviar peticion
        try {
            HttpTransportSE htse = new HttpTransportSE("http://www.webserviceX.NET/globalweather.asmx");
            htse.call("http://www.webserviceX.NET/GetWeather", soapEnvelope);
            //obtenemos la respuesta
            xml = soapEnvelope.getResponse().toString();
        }catch (Exception e){
            System.out.println(e.getMessage());
            xml=e.getMessage();
        }
        return xml;
    }
    public Document getDOMElement(String xml){
        Document doc= null;
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db= dbf.newDocumentBuilder();
            InputSource is = new InputSource();
            is.setCharacterStream(new StringReader(xml));
            doc = db.parse(is);
        } catch (ParserConfigurationException e) {
            System.out.println(e.getMessage());
            return null;
        } catch (SAXException e) {
            System.out.println(e.getMessage());
            return null;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return doc;
    }
    public final String getElementValue( Node elem ) {
        Node child;
        if( elem != null){
            if (elem.hasChildNodes()){
                for( child = elem.getFirstChild(); child != null; child = child.getNextSibling() ){
                    if( child.getNodeType() == Node.TEXT_NODE  ){
                        return child.getNodeValue();
                    }
                }
            }
        }
        return "";
    }

    public String getValue(Element item, String str) {

        NodeList n = item.getElementsByTagName(str);
        return this.getElementValue(n.item(0));
    }
}
