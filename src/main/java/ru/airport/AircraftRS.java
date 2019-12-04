package ru.airport;

import org.glassfish.jersey.message.internal.MediaTypes;
import ru.airport.model.AircraftDto;
import ru.airport.service.AircraftService;
import ru.airport.service.MockAircraftServiceImpl;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
        throw new UnsupportedOperationException("Метод еще не реализован");
    }
}
