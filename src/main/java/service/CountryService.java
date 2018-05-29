package service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import lombok.Getter;
import vo.CountryVo;


@Service
public class CountryService extends CommonService{

    @Getter
    private String csvName = "country.csv";
    
    private List<CountryVo> allCountries;
    
    @PostConstruct
    public void setUp() {
        allCountries = new ArrayList<CountryVo>();
        getRowValues().stream()
                      .filter(row -> row != null)
                      .map(row -> new CountryVo(row[0], row[1], row[2], row[3], row[4], row[5]))
                      .forEach(countryVo -> allCountries.add(countryVo));
    }
    
    public List<String> getCountryLike(String inputCountry) {
        return allCountries.stream()
                           .filter(vo -> (vo.getCode().toLowerCase().contains(inputCountry.toLowerCase()) 
                                       || vo.getName().toLowerCase().contains(inputCountry.toLowerCase())))
                           .map(CountryVo::getName)
                           .collect(Collectors.toList());
                           
    }
    
}
