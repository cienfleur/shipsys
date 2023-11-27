package base.shipsys.models;

public class ContainerShip {

    private String shipName="";
    private int shipIMO= 9074729;
    private String shipCountry="";
    private String shipURL="";

    public ContainerShip(String shipName, int shipIMO, String shipCountry, String shipURL) {
        this.shipName = shipName;
        this.shipIMO = shipIMO;
        this.shipCountry = shipCountry;
        this.shipURL = shipURL;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public int getShipIMO() {
        return shipIMO;
    }

    public void setShipIMO(int shipIMO) {
        this.shipIMO = shipIMO;
    }

    public String getShipCountry() {
        return shipCountry;
    }

    public void setShipCountry(String shipCountry) {
        this.shipCountry = shipCountry;
    }

    public String getShipURL() {
        return shipURL;
    }

    public void setShipURL(String shipURL) {
        this.shipURL = shipURL;
    }

    public String getShipName() {
        return shipName;
    }

    @Override
    public String toString() {
        return "ContainerShip{" +
                "shipName='" + shipName + '\'' +
                ", shipIMO=" + shipIMO +
                ", shipCountry='" + shipCountry + '\'' +
                ", shipURL='" + shipURL + '\'' +
                '}';
    }
}
