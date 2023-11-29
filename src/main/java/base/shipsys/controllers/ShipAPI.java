/*
package base.shipsys.controllers;

import base.shipsys.Main;
import java.io.*;

import base.shipsys.models.*;
import base.shipsys.utils.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import javafx.stage.Stage;

public class ShipAPI {

    //add fields for adding Ships
    public TextField shipName, shipIMO, shipCountry, shipURL;

    //add linked list to store ships and implement it into JavaFX
    private ScratchList<ContainerShip> ships;
    private ListView<ContainerShip> shipView;

    //additional field for saving and loading
    private ContainerShip head;
    public Port selectedPort = ShipSysAPI.selectedPort;

    public void addContainerShip(String name, int IMO, String flag, String URL) {
        //ContainerShip newShip = new ContainerShip(Controller.selectedPort, name, IMO, flag, URL);
        //ships.addElement(newShip);
        populateList();
    }

    public void populateList() {

        shipView.getItems().clear();
        for(int i=0; i<ships.getLength(); i++) {
            System.out.println(ships.accessIndex(i).getShipIMO());
            shipView.getItems().add(ships.accessIndex(i));
        }
    }

    public void addShipToView(ActionEvent addShipEvent) {
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


    public void changeScene1(ActionEvent createShip) {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("shipMenu.fxml"));
        Scene scene1 = null;
        try {
            scene1 = new Scene(fxmlLoader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage s = (Stage) ((Button) createShip.getSource()).getScene().getWindow();
        s.setScene(scene1);
    }

    public void changeScene2(ActionEvent createContainer) throws IOException{
        Main.primaryStage.setScene(Main.scene1);
    }

    public void initialize() {
        try {
            load();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void load() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("ships.xml"));
        ships = (ScratchList<ContainerShip>) is.readObject();
        is.close();
        populateList();
    }
}



 */