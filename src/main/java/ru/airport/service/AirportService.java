package ru.airport.service;

import ru.airport.model.AirportDto;

import java.util.List;

public interface AirportService {

  List<AirportDto> getAirports();

  AirportDto getAirport(String code);
}
