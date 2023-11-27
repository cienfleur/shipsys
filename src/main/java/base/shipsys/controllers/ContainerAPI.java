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

public class ContainerAPI {

    //add fields for adding Containers
    public TextField contID;
    public ChoiceBox<Integer> contLength;

    //add linked list to store containers and implement it into JavaFX
    private ScratchList<Container> containers;
    private ListView<Container> containerView;

    //additional field for saving and loading
    private Container head;

    public void addContainer(int contID, int length) {
        Container newContainer = new Container(contID, length);
        containers.addElement(newContainer);
        populateList();
    }

    public void populateList() {
        containerView.getItems().clear();
        for(int i=0; i<containers.getLength(); i++) {
            System.out.println(containers.accessIndex(i).getContID());
            containerView.getItems().add(containers.accessIndex(i));
        }
    }

    public void addContainerToView(ActionEvent addContainerEvent) {
        addContainer(contID.getText(), contLength.getValue());
    }

    public void deleteContainer(ActionEvent deleteContainerEvent) {
        if (containers.getLength() > 0) {
            containers.removeElement(containers.getLength() - 1);
            populateList();
        }
    }
}
