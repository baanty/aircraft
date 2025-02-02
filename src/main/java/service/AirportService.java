package service;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Getter;
import vo.AirportVo;

@Service
public class AirportService extends CommonService {
    
    @Autowired
    private CountryService countryService;

    @Getter
    private String csvName = "airports.csv";

    private List<AirportVo> allAirports;
    
    @PostConstruct
    public void setUp() throws URISyntaxException {
        allAirports = new ArrayList<AirportVo>();
        getRowValues().stream()
                      .filter(row -> row != null)
                      .map(row -> new AirportVo(row[0], 
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
                                                row[17]))
                      .forEach(vo -> allAirports.add(vo));
    }
    
    public List<AirportVo> getAirportsWithCountryCode(String countryCode) {
        List<String> chosenCountries = countryService.getCountryNamesLike(countryCode);
        List<AirportVo> airports = new ArrayList<AirportVo>();
        if (chosenCountries != null && chosenCountries.size() > 0) {
            String chosenCountry = chosenCountries.stream().filter(c -> c != null && c.trim().length() > 0).findAny().get();
            if (chosenCountry != null && chosenCountry.length() > 2) {
                chosenCountry = countryService.getCountryFromCountryName(chosenCountry).getCode();
            }
            for (AirportVo airport : allAirports) {
                if (airport.getIsoCountry().toLowerCase().equals(chosenCountry.toLowerCase())) {
                    airports.add(airport);
                }
            }
        }
        
        return airports;
    }
    
}
