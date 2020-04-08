package ru.airport.service;

import ru.airport.model.AircraftDto;
import ru.airport.model.SeatDto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Реализация AircraftService. Если AircraftService описывал как мы обращаемся к данным(только вид методов(сигнатуру)),
 * то данный класс описывает как эти методы будут работать.
 *
 * Фраза Mock* обычно означает что класс возвращает не реальные данный из БД, а что то тестовое, что накидеет программист.
 * Это бывает нужно для автоматических тестов приложения, или для того чтобы разрабатывать приложение когда какая то часть еще не реализована.
 *
 * У нас пока не подключена БД поэтому чтобы тестировать rest методы мы создали Сервис заглушку(mock)
 *
 */
public class MockAircraftServiceImpl implements AircraftService {

    // Это список всех самолетов. Типа хранилище данных(как таблица в БД)
    private List<AircraftDto> aircrafts = new ArrayList<>();
    private List<SeatDto> seats = new ArrayList<>();

    // Список возможных моделей
    private List<String> models = Arrays.asList("Airbus A220", "Иркут МС-21", "Боинг-777", "Боинг-787");

    public MockAircraftServiceImpl() {
        // При создании сервиса заполним список самолетов самолетами
        for (int i = 1; i <= 100; i++) {
            // Получаем случайную модель из перечня самолетов
            Random rand = new Random();
            Integer randomModelIdx = rand.nextInt(models.size()); // генерируем случайное число из диапазона [0..models.size())
            String model = models.get(randomModelIdx);

            // Создаем запись о самолете
            AircraftDto aircraft = new AircraftDto();
            aircraft.setAircraftCode(i + "");
            aircraft.setModel(model);
            aircraft.setRange(randomModelIdx * i * 100);
            aircrafts.add(aircraft);

            for (int k = 1; k <= 10; k++) {
                Integer randomSeatIdx = rand.nextInt(); // генерируем случайное число из диапазона [0..models.size())


                // Создаем запись о месте
                SeatDto seat = new SeatDto();
                seat.setAircraftCode(aircraft.getAircraftCode());
                seat.setSeatNo(randomSeatIdx);
                seat.setFareCondition(false);
                seats.add(seat);
            }
        }

    }

    @Override
        public List<AircraftDto> getAircrafts() {
            return aircrafts;
    }

    @Override
    public AircraftDto getAircraft(String code) {
        AircraftDto aircraft = null;
        for (AircraftDto currentAircraft : aircrafts) {
            if (currentAircraft.getAircraftCode().equals(code)) {
                aircraft = currentAircraft;
                break;
            }
        }
        return aircraft;
    }

    @Override
    public List<SeatDto> getSeats() {
        return seats;
    }

    @Override
    public List<SeatDto> getAircraftSeats(String aircraftCode) {
        return seats.stream()
                .filter(seat -> seat.getAircraftCode().equals(aircraftCode))
                .collect(Collectors.toList());
    }

    @Override
    public SeatDto getSeat(String seatNo) {
        SeatDto seat = null;
        for (SeatDto currentSeat : seats) {
            if (currentSeat.getSeatNo().equals(seatNo)) {
                seat = currentSeat;
                break;
            }
        }
        return seat;
    }
}
