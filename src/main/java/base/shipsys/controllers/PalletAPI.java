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

public class PalletAPI {

    //add fields for adding Pallets
    public TextField palletDesc, unitQuant, palletValue, palletWeight, palletVol;

    //add linked list to store pallets and implement it into JavaFX
    private ScratchList<Pallet> pallets;
    private ListView<Pallet> palletView;

    //additional field for saving and loading
    private Pallet head;

    public void addPallet(String desc, int unitQuant, float unitValue, int totalWeight, int totalVol) {
        Pallet newPallet = new Pallet(desc, unitQuant, unitValue, totalWeight, totalVol);
        pallets.addElement(newPallet);
        populateList();
    }

    public void populateList() {
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

    public void save() throws Exception{
        try {
            XStream xstream = new XStream(new DomDriver());
            ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("pallets.xml"));
            out.writeObject(pallets);
            out.close();
        } catch (Exception e) {
            System.out.println("Error saving pallets: " + e);
        }
    }

    public void load() throws Exception {
        try {
            XStream xstream = new XStream(new DomDriver());
            ObjectInputStream is = xstream.createObjectInputStream(new FileReader("pallets.xml"));
            pallets = (ScratchList<Pallet>) is.readObject();
            is.close();
            populateList();
        } catch (Exception e) {
            System.out.println("Error loading pallets: " + e);
        }
    }
}
