package service;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Getter;
import vo.AirportVo;
import vo.CountryAirportRunwayVo;
import vo.RunwayVo;


@Service
public class RunwayService extends CommonService{
    
    @Autowired
    private AirportService airportService;

    @Getter
    private String csvName = "runways.csv";
    
    @Getter
    private List<RunwayVo> allRunways;
    
    @PostConstruct
    public void setUp() throws URISyntaxException {
        allRunways = new ArrayList<RunwayVo>();
        getRowValues().stream()
                      .filter(row -> row != null)
                      .map(row -> new RunwayVo(row[0], 
                                               row[1], 
                                               row[2], 
                                               row[3], 
                                               row[4], 
                                               row[5], 
                                               row[6], 
                                               row[7], 
                                               row[8],
                                               row[9], 
                                               row[10], 
                                               row[11], 
                                               row[12],
                                               row[13], 
                                               row[14], 
                                               row[15], 
                                               row[16],
                                               row[17], 
                                               row[18], 
                                               row[19]))
                      .forEach(countryVo -> allRunways.add(countryVo));
    }
    
    public List<CountryAirportRunwayVo> queryWithCountry(String countryCode) {
        List<CountryAirportRunwayVo> cars = new ArrayList<CountryAirportRunwayVo>();
        
        List<AirportVo> chosenAirports = airportService.getAirportsWithCountryCode(countryCode);
        chosenAirports
                  .stream()
                  .forEach(airport -> {
                      queryRunwaysWithAirportCode(airport.getId())
                          .forEach(runway -> {
                              CountryAirportRunwayVo car = new CountryAirportRunwayVo(countryCode, airport.getName(), runway.getId());
                              cars.add(car);
                          });
                  });
        
        return cars;
    }
    
    public List<RunwayVo> queryRunwaysWithAirportCode(String airportCode) {
        return allRunways.stream().filter(r -> r.getAirportRef().equals(airportCode)).collect(Collectors.toList());
    }
    
    public List<RunwayVo> queryWithIdentificationTypes(String leIdent) {
        return allRunways.stream().filter(runway -> leIdent.equalsIgnoreCase(runway.getLeident())).collect(Collectors.toList());
    }
}
