module base.shipsys {
    requires javafx.controls;
    requires javafx.fxml;
    requires xstream;
    exports base.shipsys.models;

    opens base.shipsys.models to xstream;
    opens base.shipsys.utils to xstream;

    opens base.shipsys to javafx.fxml;
    exports base.shipsys;
    exports base.shipsys.controllers;
    opens base.shipsys.controllers to javafx.fxml;
}