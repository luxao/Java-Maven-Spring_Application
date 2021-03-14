package sk.stuba.fei.uim.project.Contract.NonLifeInsurance;

import sk.stuba.fei.uim.project.Contract.Contract;
import sk.stuba.fei.uim.project.Enums.TypesOfRealEstate;

import java.time.LocalDateTime;

public abstract class NonLifeInsurance extends Contract {
    private float valueOfHouse;
    private TypesOfRealEstate typesOfRealEstate;

    public NonLifeInsurance(int ID_contract, String insurer, LocalDateTime dateTime, LocalDateTime dateStart, LocalDateTime dateEnd,  float highAmount, float monthPayment, float valueOfHouse, TypesOfRealEstate typesOfRealEstate) {
        super(ID_contract, insurer, dateTime, dateStart, dateEnd, highAmount, monthPayment);
        setValueOfHouse(valueOfHouse);
        setTypesOfRealEstate(typesOfRealEstate);
    }

    public NonLifeInsurance(){

    }

    public float getValueOfHouse() { return valueOfHouse; }

    public void setValueOfHouse(float valueOfHouse) {
        if (valueOfHouse <= 0){
            throw new IllegalArgumentException();
        }
        this.valueOfHouse = valueOfHouse;
    }

    public void setTypesOfRealEstate(TypesOfRealEstate typesOfRealEstate) {
        if (typesOfRealEstate == null){
            throw new IllegalArgumentException("types has not value");
        }
        this.typesOfRealEstate = typesOfRealEstate;
    }


    public TypesOfRealEstate getTypesOfRealEstate() {
        return typesOfRealEstate;
    }



}
