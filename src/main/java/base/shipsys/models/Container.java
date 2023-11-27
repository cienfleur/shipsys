package base.shipsys.models;

public class Container {

    private int contID;
    private int contLength;
    private final int contWidth = 8;
    private final int contHeight = 8;

    public Container(int contID, int contLength) {
        this.contID = contID;
        this.contLength = contLength;
    }

    public int getContID() {
        return contID;
    }

    public void setContID(int contID) {
        this.contID = contID;
    }

    public int getContLength() {
        return contLength;
    }

    public void setContLength(int contLength) {
        if (contLength == 10 || contLength == 20 || contLength == 40) {
            this.contLength = contLength;
        }
    }

    public int getContWidth() {
        return contWidth;
    }

    public int getContHeight() {
        return contHeight;
    }

    @Override
    public String toString() {
        return "Container{" +
                "contID=" + contID +
                ", contLength=" + contLength +
                ", contWidth=" + contWidth +
                ", contHeight=" + contHeight +
                '}';
    }
}
