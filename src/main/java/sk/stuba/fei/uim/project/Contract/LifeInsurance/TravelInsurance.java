package sk.stuba.fei.uim.project.Contract.LifeInsurance;

import sk.stuba.fei.uim.project.Enums.PurposeOfTrip;

import java.time.LocalDateTime;

public class TravelInsurance extends LifeInsurance {
    protected String name = "Travel Insurance";
    private boolean Eu;
    private PurposeOfTrip purposeOfTrip;


    public TravelInsurance(int ID_contract, String insurer, String insured, LocalDateTime dateTime, LocalDateTime dateStart, LocalDateTime dateEnd, float highAmount, float monthPayment, boolean eu, PurposeOfTrip purposeOfTrip) {
        super(ID_contract, insurer, insured,dateTime, dateStart, dateEnd, highAmount, monthPayment);
        setEu(true);
        setPurposeOfTrip(purposeOfTrip);
    }

    public TravelInsurance(){
    }

    public boolean isEu() {
        return Eu;
    }

    public void setEu(boolean eu) {
        Eu = eu;
    }


    public PurposeOfTrip getPurposeOfTrip() {
        return purposeOfTrip;
    }

    public void setPurposeOfTrip(PurposeOfTrip purposeOfTrip) {
        this.purposeOfTrip = purposeOfTrip;
    }

    @Override
    public String toString() {
        return "TravelInsurance: " +"in or out of Eu : " + Eu + " purposeOfTrip: " + purposeOfTrip + "\n";
    }


    public String getNameOfContract() {
        return name;
    }
}
