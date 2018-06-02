package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
    
    @ResponseBody
    @RequestMapping(value = "/getAllCountries", method = {RequestMethod.GET, RequestMethod.POST})
    public List<String> getAllTheCountryNamesAndCodes() {
        List<String> countryCodesAndNames = new ArrayList<String>(countryService.getAllCountries().stream().map(CountryVo::getName).collect(Collectors.toList()));
        countryCodesAndNames.addAll(countryService.getAllCountries().stream().map(CountryVo::getCode).collect(Collectors.toList()));
        return countryCodesAndNames;
    }
}
