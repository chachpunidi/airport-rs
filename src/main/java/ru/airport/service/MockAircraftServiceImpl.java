package ru.airport.service;

import ru.airport.model.AircraftDto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

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
    private List<AircraftDto> aircrafts = new ArrayList<AircraftDto>();

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
        }
    }

    public List<AircraftDto> getAircrafts() {
        return aircrafts;
    }
}
