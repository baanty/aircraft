package controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import service.CountryService;
import vo.CountryVo;

@RestController
public class CountryController {

    @Autowired
    private CountryService countryService;
    
    @RequestMapping(value = "/getCountry" , method = {RequestMethod.GET, RequestMethod.POST})
    public List<String> queryWithCountry(String countryCode) {
        return countryService.getCountryNamesLike(countryCode);
    }
    
    @RequestMapping(value = "/getAllCountries", method = {RequestMethod.GET, RequestMethod.POST})
    public List<String> getAllTheCountries() {
        return countryService.getAllCountries().stream().map(CountryVo::getName).collect(Collectors.toList());
    }
}
