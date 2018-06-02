package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import service.ReportService;
import vo.ApiResponseVo;

@RestController
public class ReportController {

    @Autowired
    private ReportService reportService;
    
    @ResponseBody
    @RequestMapping(value = "/getHighestNumberOfAirportCountries", method = {RequestMethod.GET, RequestMethod.POST})
    public List<ApiResponseVo> getHighestNumberOfAirportCountries() {
        return reportService.getHighestNumberOfAirportCountries();
    }
    
    
    @ResponseBody
    @RequestMapping(value = "/getCountryAndTypeOfRunwayData", method = {RequestMethod.GET, RequestMethod.POST})
    public List<ApiResponseVo> getCountryAndTypeOfRunwayData() {
        return reportService.getCountryAndTypeOfRunwayData();
    }
    
    
    @ResponseBody
    @RequestMapping(value = "/getTopRunwayIndentifications", method = {RequestMethod.GET, RequestMethod.POST})
    public List<ApiResponseVo> getTopRunwayIndentifications() {
        return reportService.getTopRunwayIndentifications();
    }
}
