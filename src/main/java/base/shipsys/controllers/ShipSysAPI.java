package base.shipsys.controllers;

import base.shipsys.Main;
import java.io.*;
import java.util.Objects;

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
    public ScratchList<Port> ports = new ScratchList<Port>();
    public ListView<Port> portView = new ListView<Port>();

    //add fields for adding Ships
    public TextField shipName, shipIMO, shipCountry, shipURL;
    //add linked list to store ships and implement it into JavaFX
    public ScratchList<ContainerShip> ships = new ScratchList<ContainerShip>();
    public ListView<ContainerShip> shipView = new ListView<ContainerShip>();

    //add fields for adding Containers
    public TextField contID;
    public ChoiceBox<Integer> contLength;

    //add linked list to store containers and implement it into JavaFX
    private ScratchList<Container> containers;
    private ListView<Container> containerView;

    //add fields for adding Pallets
    public TextField palletDesc, unitQuant, palletValue, palletWeight, palletVol;

    //add linked list to store pallets and implement it into JavaFX
    private ScratchList<Pallet> pallets;
    private ListView<Pallet> palletView;

    // fields to handle drill down menu view
    public static Port selectedPort;
    public static ContainerShip selectedShip;
    public static Container selectedContainer;
    public static Pallet selectedPallet;

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

    public void selectPort(MouseEvent selectPortEvent) throws IOException {
        selectedPort = portView.getSelectionModel().getSelectedItem();
        System.out.println(selectedPort.totalValue());
    }

    public void enterPort(ActionEvent enterPortEvent) throws IOException {
        selectedPort = portView.getSelectionModel().getSelectedItem();
        Main.primaryStage.setScene(Main.scene2);
        System.out.println("selected port: " + selectedPort.getPortCode());
    }

    public void addContainerShip(String name, int IMO, String flag, String URL) {
        //check if shore exists, add if not
        boolean shorePresent = false;
        for (ContainerShip ship : selectedPort.getShips()) {
            if (Objects.equals(ship.getShipName(), "Shore")) {
                shorePresent = true;
                break;
            }
        }
        if (!shorePresent) {
            ContainerShip shore = new ContainerShip("Shore", 1, "N/A", "N/A");
            selectedPort.addShip(shore);
        }
        ContainerShip newShip = new ContainerShip(name, IMO, flag, URL);
        selectedPort.addShip(newShip);
        populateShipList();
    }

    public void populateShipList() {
        shipView.getItems().clear();
        for(int i=0; i<selectedPort.ships.getLength(); i++) {
            System.out.println(selectedPort.ships.accessIndex(i).getShipIMO());
            shipView.getItems().add(selectedPort.ships.accessIndex(i));
        }
    }

    public void addShipToView(ActionEvent addShipEvent) {
        System.out.println("selected port: " + selectedPort.getPortCode());
        addContainerShip(shipName.getText(), Integer.parseInt(shipIMO.getText()), shipCountry.getText(), shipURL.getText());
    }

    public void deleteShip(ActionEvent deleteShipEvent) {
        if (ships.getLength() > 0) {
            ships.removeElement(ships.getLength() - 1);
            populateList();
        }
    }

    public void clearShips(){
        ships.clearList();
        shipView.getItems().clear();
    }

    public void selectShip(MouseEvent selectShipEvent) {
        selectedShip = shipView.getSelectionModel().getSelectedItem();
        System.out.println(selectedShip.getShipIMO());
    }

    public void enterShip(ActionEvent enterShipEvent) {
        selectedShip = shipView.getSelectionModel().getSelectedItem();
        Main.primaryStage.setScene(Main.scene3);
    }

    public void addContainer(int contID, int length) {
        Container newContainer = new Container(contID, length);
        selectedShip.addContainer(newContainer);
        populateContainerList();
    }

    public void populateContainerList() {
        containerView.getItems().clear();
        for(int i=0; i<containers.getLength(); i++) {
            System.out.println(containers.accessIndex(i).getContID());
            containerView.getItems().add(containers.accessIndex(i));
        }
    }

    public void addContainerToView(ActionEvent addContainerEvent) {
        addContainer(Integer.parseInt(contID.getText()), contLength.getValue());
    }

    public void deleteContainer(ActionEvent deleteContainerEvent) {
        if (containers.getLength() > 0) {
            containers.removeElement(containers.getLength() - 1);
            populateContainerList();
        }
    }

    public void selectContainer(MouseEvent selectContainerEvent) {
        selectedContainer = containerView.getSelectionModel().getSelectedItem();
        System.out.println(selectedContainer.getContID());
    }

    public void enterContainer(ActionEvent enterContainerEvent) {
        selectedContainer = containerView.getSelectionModel().getSelectedItem();
        Main.primaryStage.setScene(Main.scene4);
    }

    public void addPallet(String desc, int unitQuant, float unitValue, int totalWeight, int totalVol) {
        Pallet newPallet = new Pallet(desc, unitQuant, unitValue, totalWeight, totalVol);
        selectedContainer.addPallet(newPallet);
        populatePalletList();
    }

    public void populatePalletList() {
        palletView.getItems().clear();
        for(int i=0; i<pallets.getLength(); i++) {
            System.out.println(pallets.accessIndex(i).getDesc());
            palletView.getItems().add(pallets.accessIndex(i));
        }
    }

    public void addPalletToView(ActionEvent addPalletEvent) {
        addPallet(palletDesc.getText(), Integer.parseInt(unitQuant.getText()), Float.parseFloat(palletValue.getText()), Integer.parseInt(palletWeight.getText()), Integer.parseInt(palletVol.getText()));
    }

    public void deletePallet(ActionEvent deletePalletEvent) {
        if (pallets.getLength() > 0) {
            pallets.removeElement(pallets.getLength() - 1);
            populateList();
        }
    }

    public void clearPallets(){
        pallets.clearList();
        palletView.getItems().clear();
    }

    public void deleteSelectedPallet(ActionEvent deletePalletEvent) {
        if (pallets.getLength() > 0) {
            pallets.removeElement(selectedPallet.getIndexOf());
            populatePalletList();
        }
    }

    public int valOfSelectedPort() {
        return selectedPort.totalValue();
    }

    // implement search function
    public ListView<String> searchListView;
    public TextField search;
    public void searchPallet() {
        for (Port port : ports) {
            for (ContainerShip ship : port.getShips()) {
                for (Container container : ship.getContainers()) {
                    for (Pallet pallet : container.getPallets()) {
                        if (pallet.getDesc().contains(search.getText())) {
                            searchListView.getItems().add(pallet.getDesc());
                        }
                    }
                }
            }
        }
    }


    //initialize the list of ports, add sea port if not present
    public void initialize()  {
        boolean seaPresent = false;
        for (Port port : ports) {
            if (Objects.equals(port.getPortCode(), "0000")) {
                seaPresent = true;
                break;
            }
        }
        if (!seaPresent) {
            Port sea = new Port("Sea", "0000", "Sea");
            ports.addElement(sea);
        }
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
        //list of classes that you wish to include in the serialisation, separated by a comma
        Class<?>[] classes = new Class[] {ScratchList.class, Port.class, ContainerShip.class, Container.class, Pallet.class};
        //setting up the xstream object with default security and the above classes
        XStream xstream = new XStream(new DomDriver());
        xstream.allowTypes(classes);
        //doing the actual serialisation to an XML file
        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("Ports.xml"));
        ports = (ScratchList<Port>) is.readObject();
        is.close();
        populateList();
    }


    public void save() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("Ports.xml"));
        out.writeObject(ports);
        out.close();
    }
}
