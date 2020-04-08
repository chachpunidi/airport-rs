package ru.airport.model;

public class SeatDto {

    private String aircraftCode;
    private Integer seatNo;
    private Boolean fareCondition;

    public SeatDto() {
    }

    public String getAircraftCode() {
        return aircraftCode;
    }

    public void setAircraftCode(String aircraftCode) {
        this.aircraftCode = aircraftCode;
    }

    public Integer getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(Integer seatNo) {
        this.seatNo = seatNo;
    }

    public Boolean getFareCondition() {
        return fareCondition;
    }

    public void setFareCondition(Boolean fareCondition) {
        this.fareCondition = fareCondition;
    }
}
