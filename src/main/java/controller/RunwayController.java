package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import service.RunwayService;
import vo.CountryAirportRunwayVo;

@RestController
public class RunwayController {

    @Autowired
    private RunwayService runwayService;
    
    @ResponseBody
    @RequestMapping(value = "/runwaysOfCountry" , method = {RequestMethod.GET, RequestMethod.POST})
    public List<CountryAirportRunwayVo> queryWithCountry(@RequestParam("countryCode") String countryCode) {
        return runwayService.queryWithCountry(countryCode);
    }
}
