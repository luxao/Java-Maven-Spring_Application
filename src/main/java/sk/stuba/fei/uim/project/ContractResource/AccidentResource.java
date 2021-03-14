package sk.stuba.fei.uim.project.ContractResource;

import lombok.Data;
import lombok.NoArgsConstructor;
import sk.stuba.fei.uim.project.Contract.LifeInsurance.AccidentInsurance;
import sk.stuba.fei.uim.project.Enums.TerritorialValidity;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDateTime;
@Data
@NoArgsConstructor

public class AccidentResource {
    @NotNull
    @Min(1)
    private int idContract;
    @NotNull
    @PastOrPresent
    private LocalDateTime dateTime;
    @NotNull
    private String insurer;
    @NotNull
    private String insured;
    @NotNull
    @PastOrPresent
    @NotEmpty
    private LocalDateTime dateStart;
    @NotNull
    @PastOrPresent
    @NotEmpty
    private LocalDateTime dateEnd;
    @NotNull
    @Min(1)
    private float highAmount;
    @NotNull
    @Min(1)
    private float monthPayment;
    @NotNull
    @NotEmpty
    private String nameOfContract;

    @NotNull
    @Min(1)
    private float permanentConsequences;
    @NotNull
    @Min(1)
    private float deathConsequences;
    @NotNull
    @Min(1)
    private float dayHospitalization;
    @NotNull
    private TerritorialValidity territorialValidity;

    public AccidentResource(AccidentInsurance accidentInsurance){
        this.idContract = accidentInsurance.getIdContract();
        this.dateTime = accidentInsurance.getDateTime();
        this.insurer = accidentInsurance.getInsurer();
        this.insured = accidentInsurance.getInsured();
        this.dateStart = accidentInsurance.getDateStart();
        this.dateEnd = accidentInsurance.getDateEnd();
        this.highAmount = accidentInsurance.getHighAmount();
        this.monthPayment = accidentInsurance.getMonthPayment();
        this.permanentConsequences = accidentInsurance.getPermanentConsequences();
        this.deathConsequences = accidentInsurance.getDeathConsequences();
        this.dayHospitalization = accidentInsurance.getDayHospitalization();
        this.nameOfContract = accidentInsurance.getNameOfContract();
        this.territorialValidity = accidentInsurance.getTerritorialValidity();
    }

    

    public AccidentInsurance toAccident(int idContract) {
        return new AccidentInsurance(
               idContract,
                insurer,
                insured,
                dateTime,
                dateStart,
                dateEnd,
                highAmount,
                monthPayment,
                permanentConsequences,
                deathConsequences,
                dayHospitalization,
                territorialValidity
        );
    }
}
