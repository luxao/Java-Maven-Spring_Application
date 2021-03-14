package sk.stuba.fei.uim.project.Contract.NonLifeInsurance;

import sk.stuba.fei.uim.project.Enums.TypesOfRealEstate;

import java.time.LocalDateTime;

public class HouseApartmentInsurance extends NonLifeInsurance {
    protected String name = "House Apartment Insurance";
    private boolean garageInsurance;

    public HouseApartmentInsurance(int ID_contract, String insurer, LocalDateTime dateTime, LocalDateTime dateStart, LocalDateTime dateEnd, float highAmount, float monthPayment, float valueOfHouse, TypesOfRealEstate typesOfRealEstate, boolean garageInsurance) {
        super(ID_contract, insurer, dateTime, dateStart, dateEnd,  highAmount, monthPayment, valueOfHouse, typesOfRealEstate);
        setGarageInsurance(garageInsurance);
    }

    public HouseApartmentInsurance(){

    }

    public boolean isGarageInsurance() {
        return garageInsurance;
    }

    public void setGarageInsurance(boolean garageInsurance) {
        this.garageInsurance = garageInsurance;
    }

    @Override
    public String toString() {
        return "HouseApartmentInsurance: " + "garageInsurance: " + garageInsurance + "\n";
    }

    public String getNameOfContract() {
        return name;
    }
}
