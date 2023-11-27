module base.shipsys {
    requires javafx.controls;
    requires javafx.fxml;
    requires xstream;


    opens base.shipsys to javafx.fxml;
    exports base.shipsys;
}