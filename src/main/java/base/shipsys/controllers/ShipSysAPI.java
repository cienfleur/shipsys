package base.shipsys.controllers;

import base.shipsys.Main;
import java.io.*;

import base.shipsys.models.*;
import base.shipsys.utils.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;


public class ShipSysAPI {

    //add fields for adding Ports
    public TextField portName, portCode, portCountry;

    //add linked list to store ports and implement it into JavaFX
    private ScratchList<Port> ports;
    private ListView<Port> portView;
    
    //additional field for saving and loading
    private Port head;

    public void addPort(String portName, String portCode, String portCountry) {
        Port newPort = new Port(portName, portCode, portCountry);
        ports.addElement(newPort);
        populateList();
    }

    public void populateList() {
        portView.getItems().clear();
        for(int i=0; i<ports.getLength(); i++) {
            System.out.println(ports.accessIndex(i).getPortCode());
            portView.getItems().add(ports.accessIndex(i));
        }
    }

    public void addPortToView(ActionEvent addPortEvent) {
        addPort(portName.getText(), portCode.getText(), portCountry.getText());
    }

    public void deletePort(ActionEvent deletePortEvent) {
        if (ports.getLength() > 0) {
            ports.removeElement(ports.getLength() - 1);
            populateList();
        }
    }

    public void clearPorts(){
        ports.clearList();
        portView.getItems().clear();
    }

    public int getTotalValue() {
        int totalValue = 0;
        for(int i=0; i<ports.getLength(); i++) {
            totalValue += ports.accessIndex(i).getPortValue();
        }
        return totalValue;
    }

    public int getPortValue() {
        int portValue = 0;
        for(int i=0; i<ports.getLength(); i++) {
            portValue += ports.accessIndex(i).getTotalValue();
        }
        return portValue;
    }

    public Pallet searchPallets(String palletDesc) {
        Pallet pallet = null;
        for(int i=0; i<ports.getLength(); i++) {
            pallet = pallets.accessIndex(i);
            if (pallets.accessIndex(i).getPalletDesc().equals(palletDesc)) {
                return pallet
            }
        }
    }

    public void initialize() {
        try {
            load();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void changeScene(ActionEvent createCase) throws IOException {
        FXMLLoader fxmlloader = new FXMLLoader(Main.class.getResource("sysMenu.fxml"));
        portCode.getScene().setRoot(fxmlloader.load());
    }


    // The load method uses the XStream component to read all the legoSet objects from the legoSets.xml
    public void load() throws Exception {
        head = ports.getHead();
        //list of classes that you wish to include in the serialisation, separated by a comma
        Class<?>[] classes = new Class[] {Port.class, ContainerShip.class, Container.class, Pallet.class};
        //setting up the xstream object with default security and the above classes
        XStream xstream = new XStream(new DomDriver());
        XStream.setupDefaultSecurity(xstream);
        xstream.allowTypes(classes);
        //doing the actual serialisation to an XML file
        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("Ports.xml"));
        head = (Port) is.readObject();
        is.close();
    }


    public void save() throws Exception {
        head = ports.getHead();
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("Ports.xml"));
        out.writeObject(head);
        out.close();
    }
}
