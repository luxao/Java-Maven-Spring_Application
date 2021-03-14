package sk.stuba.fei.uim.project.Contract.LifeInsurance;

import sk.stuba.fei.uim.project.Enums.TerritorialValidity;

import java.time.LocalDateTime;

public class AccidentInsurance extends LifeInsurance {
    protected String name = "Accident Insurance";
    private float permanentConsequences;
    private float deathConsequences;
    private float dayHospitalization;
    private TerritorialValidity territorialValidity;


    public AccidentInsurance(int ID_contract, String insurer, String insured, LocalDateTime dateTime, LocalDateTime dateStart, LocalDateTime dateEnd, float highAmount, float monthPayment, float permanentConsequences, float deathConsequences, float dayHospitalization, TerritorialValidity territorialValidity) {
        super(ID_contract, insurer, insured,dateTime, dateStart, dateEnd, highAmount, monthPayment);
        setPermanentConsequences(permanentConsequences);
        setDeathConsequences(deathConsequences);
        setDayHospitalization(dayHospitalization);
        setTerritorialValidity(territorialValidity);
    }

    public AccidentInsurance(){

    }

    public float getPermanentConsequences() { return permanentConsequences; }

    public void setPermanentConsequences(float permanentConsequences) {
        if (permanentConsequences <= 0){
            throw new IllegalArgumentException("value is set to null");
        }
        this.permanentConsequences = permanentConsequences;
    }

    public float getDeathConsequences() { return deathConsequences; }

    public void setDeathConsequences(float deathConsequences) {
        if (deathConsequences <= 0){
            throw new IllegalArgumentException("value is set to null");
        }
        this.deathConsequences = deathConsequences;
    }

    public float getDayHospitalization() { return dayHospitalization; }

    public void setDayHospitalization(float dayHospitalization) {
        if (dayHospitalization <= 0){
            throw new IllegalArgumentException("value is set to null");
        }
        this.dayHospitalization = dayHospitalization;
    }

    public TerritorialValidity getTerritorialValidity() {
        return territorialValidity;
    }

    public void setTerritorialValidity(TerritorialValidity territorialValidity) {
        this.territorialValidity = territorialValidity;
    }

    public String getNameOfContract() {
        return name;
    }
}
