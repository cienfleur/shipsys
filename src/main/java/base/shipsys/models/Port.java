package base.shipsys.models;

import base.shipsys.utils.ScratchList;

public class Port {
    private String portName="";
    private String portCode="0000";
    private String country="";

    public ScratchList<ContainerShip> ships;

    public Port(String portName, String portCode, String country) {
        ships = new ScratchList<ContainerShip>();
        this.portName = portName;
        this.portCode = portCode;
        this.country = country;
    }

    public String getPortName() {
        return portName;
    }

    public void setPortName(String portName) {
        this.portName = portName;
    }

    public String getPortCode() {
        return portCode;
    }

    public void setPortCode(String portCode) {
        this.portCode = portCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void addShip(ContainerShip ship) {
        ships.addElement(ship);
    }

    public void removeShip(int index) {
        ships.removeElement(index);
    }

    public ScratchList<ContainerShip> getShips() {
        return ships;
    }
    public int totalValue() {
        int total = 0;
        for (ContainerShip ship: ships) {
            total += ship.totalValue();
        }
        return total;
    }

    @Override
    public String toString() {
        return "Name= " + portName +
                ",Code= " + portCode +
                ", Country= " + country;
    }
}
