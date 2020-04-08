package ru.airport;

import ru.airport.model.AirportDto;
import ru.airport.service.AirportService;
import ru.airport.service.MocAirportServiceIml;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.List;

@Path("/airports")
public class AirportRS {
    private AirportService airportService = new MocAirportServiceIml();

    @GET
    @Path("/")
    public List<AirportDto> airports() {
        return airportService.getAirports();

    }

    @GET
    @Path("/{airportCode}")
    public AirportDto airport(@PathParam("airportCode") String airportCode) {
        AirportDto airport = airportService.getAirport(airportCode);
        return airport;
    }
}