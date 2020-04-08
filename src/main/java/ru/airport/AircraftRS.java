package ru.airport;

import ru.airport.model.AircraftDto;
import ru.airport.model.SeatDto;
import ru.airport.service.AircraftService;
import ru.airport.service.MockAircraftServiceImpl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/aircrafts")     // аннотация из jax-rs привязывает все методы класса к адерсу {address-to-services}/aircrafts
@Produces(MediaType.APPLICATION_JSON) // аннотация из jax-rs говорит во что преобразововать отдаваемые java объекты.
                                      // Но для ее работы нужна библиотека преобразователь. См. jersey-media-json-jackson
public class AircraftRS {

    private AircraftService aircraftService = new MockAircraftServiceImpl();

    /**
     * Метод возвращает список всех самтолетов
     * аннотация Path из jax-rs привязывает java метод к http методу GET {address-to-services}/aircrafts/
     *
     * @return список самолетов
     */
    @GET
    @Path("/")
    public List<AircraftDto> aircrafts() {
        return aircraftService.getAircrafts();
    }

    /**
     * Метод возвращает самолет по переданному коду
     * аннотация Path из jax-rs привязывает все методы класса к http методу GET {address-to-services}/aircrafts/{aircraftCode}.
     * Пример {address-to-services}/aircrafts/12 долшен вернуть мамолет с aircraftCode = 12
     *
     * @return самолет
     */
    @GET
    @Path("/{aircraftCode}")
    public AircraftDto airctaft(@PathParam("aircraftCode") String aircraftCode) {
        AircraftDto aircrafts = aircraftService.getAircraft(aircraftCode);
        return aircrafts;
    }

    /**
     * Метод возвращает список всех посадочных мест самолета
     *
     * @return список мест
     */
    @GET
    @Path("/seats")
    public List<SeatDto> getSeats() {
        return aircraftService.getSeats();
    }

    /**
     * Метод возвращает список всех посадочных мест самолета
     *
     * @return список мест
     */
    @GET
    @Path("/{aircraftCode}/seats")
    public List<SeatDto> getAircraftSeats(String aircraftCode) {
        return aircraftService.getAircraftSeats(aircraftCode);
    }

    /**
     * Метод возвращает список всех посадочных мест самолета
     *
     * @return номер места
     */
    @GET
    @Path("/seats/{seatNo}")
    public SeatDto getSeat(String seatNo) {
        return aircraftService.getSeat(seatNo);
    }

    public static void main(String[] args) {
        AircraftRS rs = new AircraftRS();

        SeatDto fouded = rs.getSeat("1");
        System.out.println(fouded);
    }
}
