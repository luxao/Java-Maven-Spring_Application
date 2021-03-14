package sk.stuba.fei.uim.project.ContractResource;

import lombok.Data;
import lombok.NoArgsConstructor;
import sk.stuba.fei.uim.project.Enums.PurposeOfTrip;
import sk.stuba.fei.uim.project.Contract.LifeInsurance.TravelInsurance;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDateTime;
@Data
@NoArgsConstructor
public class TravelResource {
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
    private boolean eu;
    @NotNull
    @Min(1)
    private PurposeOfTrip purposeOfTrip;

    public TravelResource(TravelInsurance travelInsurance){
        this.idContract = travelInsurance.getIdContract();
        this.dateTime = travelInsurance.getDateTime();
        this.insurer = travelInsurance.getInsurer();
        this.insured = travelInsurance.getInsured();
        this.dateStart = travelInsurance.getDateStart();
        this.dateEnd = travelInsurance.getDateEnd();
        this.highAmount = travelInsurance.getHighAmount();
        this.monthPayment = travelInsurance.getMonthPayment();
        this.eu = travelInsurance.isEu();
        this.nameOfContract = travelInsurance.getNameOfContract();
        this.purposeOfTrip = travelInsurance.getPurposeOfTrip();
    }

    public TravelInsurance toTravel(int idContract) {
        return new TravelInsurance(
                idContract,
                insurer,
                insured,
                dateTime,
                dateStart,
                dateEnd,
                highAmount,
                monthPayment,
                eu,
                purposeOfTrip
        );
    }
}
