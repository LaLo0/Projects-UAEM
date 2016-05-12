package alexisayala.com.sistema_empleados_cliente;

/**
 * Created by alexis on 14/04/16.
 */
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
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
    private static final String METHOD_NAME = "insertarUsuario";
    private static final String NAMESPACE = "http://usuarios/";
    private static final String URL = "http://10.0.2.2:8080/Sistema_Empleados/usuarios?wsdl";
    public static final String SOAP_ACTION = NAMESPACE+METHOD_NAME;
    /*obtenemos el xml usando una peticion soap 1.1*/

    public String getXMLUsingSoap(String name, String lastnf, String lastnm, String birth, String addr){
        String xml = null;


        /*
        Instanciamos el objeto de Soap en el cual se indican los datos del servidor
         */
        SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
        //añadimos las propiedades que requiere el servicio web, CityName & CountryName

       /*
        request.addProperty("no",name);
        request.addProperty("ap",lastnf);
        request.addProperty("am", lastnm);
        request.addProperty("fn", birth);
        request.addProperty("dr", addr);


        /*/

        //Pass value for userName variable of the web service
        PropertyInfo nameProp =new PropertyInfo();
        nameProp.setName("no");//Define the variable name in the web service method
        nameProp.setValue(name);//set value for userName variable
        nameProp.setType(String.class);//Define the type of the variable
        request.addProperty(nameProp);//Pass properties to the variable


        //Pass value for Password variable of the web service
        PropertyInfo lastnfProp =new PropertyInfo();
        lastnfProp.setName("ap");
        lastnfProp.setValue(lastnf);
        lastnfProp.setType(String.class);
        request.addProperty(lastnfProp);

        PropertyInfo lastnmProp =new PropertyInfo();
        lastnmProp.setName("am");//Define the variable name in the web service method
        lastnmProp.setValue(lastnm);//set value for userName variable
        lastnmProp.setType(String.class);//Define the type of the variable
        request.addProperty(lastnmProp);//Pass properties to the variable


        //Pass value for Password variable of the web service
        PropertyInfo birtProp =new PropertyInfo();
        birtProp.setName("fn");
        birtProp.setValue(birth);
        birtProp.setType(String.class);
        request.addProperty(birtProp);

        PropertyInfo addressProp =new PropertyInfo();
        addressProp.setName("dr");//Define the variable name in the web service method
        addressProp.setValue(addr);//set value for userName variable
        addressProp.setType(String.class);//Define the type of the variable
        request.addProperty(addressProp);//Pass properties to the variable


        //wrap it in a SOAP envelope
        SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapEnvelope.bodyOut = request;
        soapEnvelope.dotNet = true;
        //listo para enviar peticion
        try {
            HttpTransportSE htse = new HttpTransportSE(URL);
            htse.call(SOAP_ACTION, soapEnvelope);
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
