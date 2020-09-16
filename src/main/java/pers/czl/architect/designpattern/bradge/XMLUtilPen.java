package pers.czl.architect.designpattern.bradge;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * @Title:
 * @Description:
 * @Author: wb-ccl670938
 * @CreateTime: 2020-09-16 16:35
 * @Version:1.0
 **/
public class XMLUtilPen {

    public static Object getBean(String args) {
        /*Pen pen = new BigPen();
        pen.setColor(new RedColor());
        pen.draw("大花猫");*/

        try {
            DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dFactory.newDocumentBuilder();
            Document doc = builder.parse(new File("src/main/resources/design/configPen.xml"));

            Node classNode = null;

            NodeList nodeList = doc.getElementsByTagName("className");

            switch (args) {
                case "color":
                    classNode = nodeList.item(0).getFirstChild();
                    break;
                case "pen":
                    classNode = nodeList.item(1).getFirstChild();
                    break;
            }

            String cName = classNode.getNodeValue();
            Class c = Class.forName(cName);

            Object obj = c.newInstance();

            return obj;
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return new Object();
    }
}