package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import service.RunwayService;
import vo.CountryAirportRunwayVo;

@RestController
public class RunwayController {

    @Autowired
    private RunwayService runwayService;
    
    
    public List<CountryAirportRunwayVo> queryWithCountry(String countryCode) {
        return runwayService.queryWithCountry(countryCode);
    }
}
