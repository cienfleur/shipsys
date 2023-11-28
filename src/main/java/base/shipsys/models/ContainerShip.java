package base.shipsys.models;

import base.shipsys.utils.ScratchList;

public class ContainerShip {

    private String shipName="";
    private int shipIMO= 9074729;
    private String shipCountry="";
    private String shipURL="";

    private ScratchList<Container> containers;

    public ContainerShip(String shipName, int shipIMO, String shipCountry, String shipURL) {
        containers = new ScratchList<Container>();
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

    public void addContainer(Container container) {
        containers.addElement(container);
    }

    public void removeContainer(int index) {
        containers.removeElement(index);
    }

    public ScratchList<Container> getContainers() {
        return containers;
    }

    public int totalValue() {
        int total = 0;
        for (Container container: containers) {
            total += container.totalValue();
        }
        return total;
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
