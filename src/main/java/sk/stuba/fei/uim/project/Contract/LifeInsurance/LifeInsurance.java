package sk.stuba.fei.uim.project.Contract.LifeInsurance;

import sk.stuba.fei.uim.project.Contract.Contract;

import java.time.LocalDateTime;

public abstract class LifeInsurance extends Contract {
    private String insured;

    public LifeInsurance(int ID_contract, String insurer, String insured, LocalDateTime dateTime, LocalDateTime dateStart, LocalDateTime dateEnd, float highAmount, float monthPayment) {
        super(ID_contract, insurer, dateTime, dateStart, dateEnd, highAmount, monthPayment);
        setInsured(insured);
    }

    public LifeInsurance(){

    }

    public String getInsured() {
        return insured;
    }

    public void setInsured(String insured) {
        if (insured == null || insured.trim().isEmpty()){
            throw new IllegalArgumentException("insured was not created");
        }
        this.insured = insured;
    }

    @Override
    public String toString() {
        return insured;
    }
}
