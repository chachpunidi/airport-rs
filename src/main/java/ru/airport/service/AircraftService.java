package ru.airport.service;

import ru.airport.model.AircraftDto;
import ru.airport.model.SeatDto;

import java.util.List;

/**
 * Интерфейс описывающий сервисные методы.
 *
 * В сервисных методах выполняется бизнес логика: выгрузка информации, стыковка с другими данными, обработка данных, изменеие данных итд.
 * Интерфейс в свою очередь отрывает то как мы обращаемся к данным от реализации. Того как эти данные будут получены.
 */
public interface AircraftService {

    List<AircraftDto> getAircrafts();

    AircraftDto getAircraft(String code);

    List<SeatDto> getSeats();

    List<SeatDto> getAircraftSeats(String aircraftCode);

    SeatDto getSeat(String seatNo);
}
