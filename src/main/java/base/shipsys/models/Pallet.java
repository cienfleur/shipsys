package base.shipsys.models;

public class Pallet {

    private String desc;
    private int unitQuant;
    private float unitValue;
    private int totalWeight;
    private int totalVol;

    public Pallet(String desc, int unitQuant, float unitValue, int totalWeight, int totalVol) {
        this.desc = desc;
        this.unitQuant = unitQuant;
        this.unitValue = unitValue;
        this.totalWeight = totalWeight;
        this.totalVol = totalVol;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getUnitQuant() {
        return unitQuant;
    }

    public void setUnitQuant(int unitQuant) {
        this.unitQuant = unitQuant;
    }

    public float getUnitValue() {
        return unitValue;
    }

    public void setUnitValue(int unitValue) {
        this.unitValue = unitValue;
    }

    public int getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(int totalWeight) {
        this.totalWeight = totalWeight;
    }

    public int getTotalVol() {
        return totalVol;
    }

    public void setTotalVol(int totalVol) {
        this.totalVol = totalVol;
    }

    public int getValue() {
        return (int) (unitValue * unitQuant);
    }

    @Override
    public String toString() {
        return "Pallet{" +
                "desc='" + desc + '\'' +
                ", unitQuant=" + unitQuant +
                ", unitValue=" + unitValue +
                ", totalWeight=" + totalWeight +
                ", totalVol=" + totalVol +
                '}';
    }
}
