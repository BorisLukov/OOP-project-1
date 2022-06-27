package bg.tu_varna.sit.files;

import bg.tu_varna.sit.rooms.RoomDetails;
import bg.tu_varna.sit.rooms.RoomOperations;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Files {
    private boolean status;
    RoomOperations roomOperations1 = new RoomOperations();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    RoomDetails roomDetails = new RoomDetails();
    Scanner scanner = new Scanner(System.in);
    private ArrayList<RoomDetails> roomOperations = roomOperations1.getRoomOperations();


    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


    public void open() {
        if (!isStatus()) {
            File file = new File("Hotel.xml");

            if (file.exists()) {
                try {
                    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                    DocumentBuilder db = dbf.newDocumentBuilder();
                    Document document = db.parse(file);
                    document.getDocumentElement().normalize();
                    System.out.println("Root Element :" + document.getDocumentElement().getNodeName());
                    NodeList nList = document.getElementsByTagName("roomDetail");
                    for (int temp = 0; temp < nList.getLength(); temp++) {
                        Node nNode = nList.item(temp);
                        System.out.println("\nCurrent Element :" + nNode.getNodeName());
                        if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                            Element eElement = (Element) nNode;
                            System.out.println(eElement.getElementsByTagName("RoomNumber").item(0).getTextContent());
                            System.out.println(eElement.getElementsByTagName("DateFrom").item(0).getTextContent());
                            System.out.println(eElement.getElementsByTagName("DateTo").item(0).getTextContent());
                            System.out.println(eElement.getElementsByTagName("note").item(0).getTextContent());
                            System.out.println(eElement.getElementsByTagName("beds").item(0).getTextContent());
                            System.out.println(eElement.getElementsByTagName("NumGuests").item(0).getTextContent());
                            roomDetails.setRoomNumber(Integer.parseInt(eElement.getElementsByTagName("RoomNumber").item(0).getTextContent()));
                            roomDetails.setDateFrom(sdf.parse(eElement.getElementsByTagName("DateFrom").item(0).getTextContent()));
                            roomDetails.setDateTo(sdf.parse(eElement.getElementsByTagName("DateTo").item(0).getTextContent()));
                            roomDetails.setNote(eElement.getElementsByTagName("note").item(0).getTextContent());
                            roomDetails.setBeds(Integer.parseInt(eElement.getElementsByTagName("beds").item(0).getTextContent()));
                            roomDetails.setNumGuests(Integer.parseInt(eElement.getElementsByTagName("NumGuests").item(0).getTextContent()));
                            roomOperations.add(roomDetails);
                        }


                    }
                } catch (IOException | ParserConfigurationException | SAXException | ParseException e) {
                    System.out.println(e);
                }

            } else {
                try {
                    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                    DocumentBuilder builder = dbf.newDocumentBuilder();
                    Document document = builder.newDocument();

                    TransformerFactory tFactory = TransformerFactory.newInstance();
                    Transformer trans = tFactory.newTransformer();

                    Element root = document.createElement("Hotel");
                    document.appendChild(root);

                    DOMSource source = new DOMSource(document);

                    try {
                        FileWriter fileWriter = new FileWriter("Hotel.xml");
                        StreamResult result = new StreamResult(fileWriter);
                        trans.transform(source, result);
                        fileWriter.close();
                    } catch (IOException | TransformerException e) {
                        e.printStackTrace();
                    }
                } catch (ParserConfigurationException | TransformerConfigurationException ex) {
                    ex.printStackTrace();
                }
                System.out.println("File successfully created and opened. ");

            }
        }
        setStatus(true);
    }

    public void close() throws IOException {
        if(isStatus()){
            FileReader f = new FileReader("Hotel.xml");
            f.close();
            setStatus(false);
            System.out.println("File successfully closed.");
        }
    }

    public void save() {
        if(isStatus()) {
            try {

                DocumentBuilderFactory dFact = DocumentBuilderFactory.newInstance();
                DocumentBuilder build = dFact.newDocumentBuilder();
                Document document = build.newDocument();

                Element root = document.createElement("Hotel");
                document.appendChild(root);

                for (RoomDetails roomDetails : roomOperations) {

                    Element roomDetail = document.createElement("roomDetail");
                    root.appendChild(roomDetail);

                    Element roomNumber = document.createElement("RoomNumber");
                    roomNumber.appendChild(document.createTextNode(String.valueOf(roomDetails.getRoomNumber())));
                    roomDetail.appendChild(roomNumber);

                    Element dateFrom = document.createElement("DateFrom");
                    dateFrom.appendChild(document.createTextNode(String.valueOf(roomDetails.getDateFrom())));
                    roomDetail.appendChild(dateFrom);

                    Element dateTo = document.createElement("DateTo");
                    dateTo.appendChild(document.createTextNode(String.valueOf(roomDetails.getDateTo())));
                    roomDetail.appendChild(dateTo);

                    Element note = document.createElement("note");
                    note.appendChild(document.createTextNode(String.valueOf(roomDetails.getNote())));
                    roomDetail.appendChild(note);

                    Element beds = document.createElement("beds");
                    beds.appendChild(document.createTextNode(String.valueOf(roomDetails.getBeds())));
                    roomDetail.appendChild(beds);

                    Element numGuests = document.createElement("NumGuests");
                    numGuests.appendChild(document.createTextNode(String.valueOf(roomDetails.getNumGuests())));
                    roomDetail.appendChild(numGuests);

                }

                try {
                    FileWriter fos = new FileWriter("Hotel.xml");
                    StreamResult result = new StreamResult(fos);


                } catch (IOException e) {

                    e.printStackTrace();
                }
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource domSource = new DOMSource(document);
                StreamResult streamResult = new StreamResult(new FileWriter("Hotel.xml"));

                transformer.transform(domSource, streamResult);
            } catch (ParserConfigurationException | TransformerException | IOException pce) {
                pce.printStackTrace();
            }
        }
    }

    public void saveas() {
        if(isStatus()) {
            System.out.println("enter path");
            String pathName = scanner.next();
            try {

                DocumentBuilderFactory dFact = DocumentBuilderFactory.newInstance();
                DocumentBuilder build = dFact.newDocumentBuilder();
                Document document = build.newDocument();

                Element root = document.createElement("Hotel");
                document.appendChild(root);

                for (RoomDetails roomDetails : roomOperations) {

                    Element roomDetail = document.createElement("roomDetail");
                    root.appendChild(roomDetail);

                    Element roomNumber = document.createElement("RoomNumber");
                    roomNumber.appendChild(document.createTextNode(String.valueOf(roomDetails.getRoomNumber())));
                    roomDetail.appendChild(roomNumber);

                    Element dateFrom = document.createElement("DateFrom");
                    dateFrom.appendChild(document.createTextNode(String.valueOf(roomDetails.getDateFrom())));
                    roomDetail.appendChild(dateFrom);

                    Element dateTo = document.createElement("DateTo");
                    dateTo.appendChild(document.createTextNode(String.valueOf(roomDetails.getDateTo())));
                    roomDetail.appendChild(dateTo);

                    Element note = document.createElement("note");
                    note.appendChild(document.createTextNode(String.valueOf(roomDetails.getNote())));
                    roomDetail.appendChild(note);

                    Element beds = document.createElement("beds");
                    beds.appendChild(document.createTextNode(String.valueOf(roomDetails.getBeds())));
                    roomDetail.appendChild(beds);

                    Element numGuests = document.createElement("NumGuests");
                    numGuests.appendChild(document.createTextNode(String.valueOf(roomDetails.getNumGuests())));
                    roomDetail.appendChild(numGuests);

                }

                try {
                    FileWriter fos = new FileWriter(pathName);
                    StreamResult result = new StreamResult(fos);

                } catch (IOException e) {

                    e.printStackTrace();
                }
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource domSource = new DOMSource(document);
                StreamResult streamResult = new StreamResult(new FileWriter(pathName));

                transformer.transform(domSource, streamResult);
            } catch (ParserConfigurationException | TransformerException | IOException pce) {
                pce.printStackTrace();
            }
        }
    }
}
