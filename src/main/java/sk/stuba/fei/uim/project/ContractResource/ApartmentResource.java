package sk.stuba.fei.uim.project.ContractResource;

import lombok.Data;
import lombok.NoArgsConstructor;
import sk.stuba.fei.uim.project.Contract.NonLifeInsurance.HouseApartmentInsurance;
import sk.stuba.fei.uim.project.Enums.TypesOfRealEstate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDateTime;
@Data
@NoArgsConstructor
public class ApartmentResource {
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
    private boolean garageInsurance;
    @NotNull
    @Min(1)
    private float valueOfHouse;
    @NotNull
    private TypesOfRealEstate typesOfRealEstate;

    public ApartmentResource(HouseApartmentInsurance houseApartmentInsurance){
        this.idContract = houseApartmentInsurance.getIdContract();
        this.dateTime = houseApartmentInsurance.getDateTime();
        this.insurer = houseApartmentInsurance.getInsurer();
        this.dateStart = houseApartmentInsurance.getDateStart();
        this.dateEnd = houseApartmentInsurance.getDateEnd();
        this.highAmount = houseApartmentInsurance.getHighAmount();
        this.monthPayment = houseApartmentInsurance.getMonthPayment();
        this.garageInsurance = houseApartmentInsurance.isGarageInsurance();
        this.valueOfHouse = houseApartmentInsurance.getValueOfHouse();
        this.nameOfContract = houseApartmentInsurance.getNameOfContract();
        this.typesOfRealEstate = houseApartmentInsurance.getTypesOfRealEstate();
    }

    public HouseApartmentInsurance toApartment(int idContract) {
        return new HouseApartmentInsurance(
            idContract,
                insurer,
                dateTime,
                dateStart,
                dateEnd,
                highAmount,
                monthPayment,
                valueOfHouse,
                typesOfRealEstate,
                garageInsurance
        );
    }
}
