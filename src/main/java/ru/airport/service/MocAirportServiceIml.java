package ru.airport.service;

import ru.airport.model.AirportDto;

import java.util.ArrayList;
import java.util.List;

public class MocAirportServiceIml implements AirportService {

    private List<AirportDto> airports = new ArrayList<>();

    @Override
    public List<AirportDto> getAirports() {
        return airports;
    }
    @Override
    public AirportDto getAirport(String airportCode) {
        AirportDto airport = null;
        for (AirportDto currentAirport : airports) {
            if (currentAirport.getAirportName().equals(airportCode)) {
                airport = currentAirport;
                break;
            }
        }
        return airport;
    }


}