package base.shipsys.models;

public class Port {

    private String portName="";
    private String portCode="0000";
    private String country="";

    public Port(String portName, String portCode, String country) {
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

    @Override
    public String toString() {
        return "Port{" +
                "portName='" + portName + '\'' +
                ", portCode='" + portCode + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
