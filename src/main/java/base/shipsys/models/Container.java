package base.shipsys.models;

import base.shipsys.utils.ScratchList;

public class Container {

    private int contID;
    private int contLength;
    private final int contWidth = 8;
    private final int contHeight = 8;
    private int contVol;
    private int contVolOccupied;

    private ScratchList<Pallet> pallets;

    public Container(int contID, int contLength) {
        pallets = new ScratchList<Pallet>();
        this.contID = contID;
        this.contLength = contLength;
        this.contVol = contLength*contWidth*contHeight;
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

    public void addPallet(Pallet pallet) {
        if (pallet.getTotalVol()<contVol-contVolOccupied) {
            pallets.addElement(pallet);
            contVolOccupied+=pallet.getTotalVol();
        }
        else System.out.println("Container is full");
    }

    public void removePallet(int index) {
        contVolOccupied-=pallets.accessIndex(index).getTotalVol();
        pallets.removeElement(index);
    }

    public ScratchList<Pallet> getPallets() {
        return pallets;
    }

    public int getValue() {
        int value = 0;
        for (Pallet pallet : pallets) {
            value += pallet.getValue();
        }
        return value;
    }

    public int totalValue() {
        int total = 0;
        for (Pallet pallet: pallets) {
            total += pallet.getValue();
        }
        return total;
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
