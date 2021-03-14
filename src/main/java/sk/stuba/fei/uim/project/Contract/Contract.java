package sk.stuba.fei.uim.project.Contract;

import java.time.LocalDateTime;

public abstract class Contract {
    private int idContract;
    private LocalDateTime dateTime;
    private String insurer;
    private LocalDateTime dateStart;
    private LocalDateTime dateEnd;
    private float highAmount;
    private float monthPayment;
    private String nameOfContract;

    public Contract(int idContract,String insurer,LocalDateTime dateTime, LocalDateTime dateStart, LocalDateTime dateEnd, float highAmount, float monthPayment) {
        setInsurer(insurer);
        setIdContract(idContract);
        setDateTime(dateTime);
        setDateStart(dateStart);
        setDateEnd(dateEnd);
        setHighAmount(highAmount);
        setMonthPayment(monthPayment);
    }

    public Contract() {
    }


    public int getIdContract() { return idContract; }

    public void setIdContract(int ID_contract) {
        if (ID_contract <=0 ){
            throw new IllegalArgumentException("ID_contract doesn't exist");
        }
        this.idContract = ID_contract;
    }


    public LocalDateTime getDateTime() { return dateTime; }

    public void setDateTime(LocalDateTime dateTime) {
        if (dateTime == null){
            throw new IllegalArgumentException("Time is set to null");
        }
        this.dateTime = dateTime;
    }

    public String getInsurer() { return insurer; }

    public void setInsurer(String insurer) {
        if (insurer == null ||insurer.trim().isEmpty()){
            throw new IllegalArgumentException("insurer doesn't exist");
        }
        this.insurer = insurer;
    }

    public LocalDateTime getDateStart() { return dateStart; }

    public void setDateStart(LocalDateTime dateStart) {
        if (dateStart == null){
            throw new IllegalArgumentException("dateStart is set to null");
        }
        this.dateStart = dateStart;
    }
    public LocalDateTime getDateEnd() { return dateEnd; }

    public void setDateEnd(LocalDateTime dateEnd) {
        if (dateEnd == null){
            throw new IllegalArgumentException("dateEnd is set to null");
        }
        this.dateEnd = dateEnd;
    }

    public float getHighAmount() { return highAmount; }

    public void setHighAmount(float highAmount) {
        this.highAmount = highAmount;
    }

    public float getMonthPayment() {
        return monthPayment;
    }

    public void setMonthPayment(float monthPayment) {
        this.monthPayment = monthPayment;
    }

    public String getNameOfContract() {
        return nameOfContract;
    }


    @Override
    public String toString() {
        return insurer;
    }
}
