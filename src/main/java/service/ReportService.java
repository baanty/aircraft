/**
 * 
 */
package service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vo.AirportVo;
import vo.ApiResponseVo;
import vo.CountryVo;

/**
 * @author Pijush
 *
 */
@Service
public class ReportService {
    
    @Autowired
    private AirportService airportService;
    
    @Autowired
    private CountryService countryService;
    
    @Autowired
    private RunwayService runwaysService;
    
    public List<ApiResponseVo> getHighestNumberOfAirportCountries() {
        List<ApiResponseVo> apiResponse = new ArrayList<ApiResponseVo>();
        Map<Integer, CountryVo> data = new TreeMap<Integer, CountryVo>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2>o1?1:o2==o1?0:-1;
            }
        });
        countryService.getAllCountries()
                      .stream()
                      .forEach(countryVo -> data.put(airportService.getAirportsWithCountryCode(countryVo.getCode()).size(), countryVo));
        
        for (Entry<Integer, CountryVo> entry : data.entrySet()) {
            apiResponse.add(new ApiResponseVo(entry.getKey().toString(), entry.getValue().getName()));
        }
        return apiResponse;
    }
    
    public List<ApiResponseVo> getCountryAndTypeOfRunwayData() {
        List<ApiResponseVo> apiResponse = new ArrayList<ApiResponseVo>();
        Map<String, String> data = new HashMap<String, String>();
        countryService.getAllCountries()
                      .stream()
                      .forEach(countryVo -> {
                          final Set<String> runwayTypes = new HashSet<String>();
                          airportService.getAirportsWithCountryCode(countryVo.getCode())
                                        .stream()
                                        .map(AirportVo::getId)
                                        .forEach(airportId -> {
                                            runwaysService.queryRunwaysWithAirportCode(countryVo.getCode())
                                                          .stream()
                                                          .forEach(rvo -> runwayTypes.add(rvo.getSurface()));
                                        });
                          data.put(countryVo.getName(), runwayTypes.stream().collect(Collectors.joining("|")));
                      });
        for (Entry<String, String> entry : data.entrySet()) {
            apiResponse.add(new ApiResponseVo(entry.getKey(), entry.getValue()));
        }
        return apiResponse;
    }
    
    public List<ApiResponseVo> getTopRunwayIndentifications() {
        List<ApiResponseVo> apiResponse = new ArrayList<ApiResponseVo>();
        Map<Integer, String> data = new TreeMap<Integer, String>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2>o1?1:o2==o1?0:-1;
            }
        });
        runwaysService
                   .getAllRunways()
                   .stream()
                   .forEach(runway -> {
                       data.put(runwaysService.queryWithIdentificationTypes(runway.getLeident()).size(), runway.getId());
                   });
        for (Entry<Integer, String> entry : data.entrySet()) {
            apiResponse.add(new ApiResponseVo(entry.getKey().toString(), entry.getValue()));
        }
        
        return apiResponse;
    }
     

}

















