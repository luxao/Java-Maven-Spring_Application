package sk.stuba.fei.uim.project.Contract.NonLifeInsurance;

import sk.stuba.fei.uim.project.Enums.TypesOfRealEstate;

import java.time.LocalDateTime;

public class HouseHoldInsurance extends NonLifeInsurance {
    protected String name = "House Hold Insurance";
    private float houseEquipment;

    public HouseHoldInsurance(int ID_contract, String insurer, LocalDateTime dateTime, LocalDateTime dateStart, LocalDateTime dateEnd, float highAmount, float monthPayment, float valueOfHouse, TypesOfRealEstate typesOfRealEstate, float houseEquipment) {
        super(ID_contract, insurer, dateTime, dateStart, dateEnd,  highAmount, monthPayment, valueOfHouse, typesOfRealEstate);
        setHouseEquipment(houseEquipment);
    }

    public HouseHoldInsurance(){

    }

    public float getHouseEquipment() { return houseEquipment; }

    public void setHouseEquipment(float houseEquipment) {
        if (houseEquipment <= 0){
            throw new IllegalArgumentException();
        }
        this.houseEquipment = houseEquipment;
    }

    @Override
    public String toString() {
        return "HouseHoldInsurance: " + " houseEquipment: " + houseEquipment + "\n";
    }

    public String getNameOfContract() {
        return name;
    }
}
