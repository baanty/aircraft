package service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import lombok.Getter;
import vo.AirportVo;

@Service
public class AirportService extends CommonService {

    @Getter
    private String csvName = "airports.csv";

    private List<AirportVo> allAirports;
    
    @PostConstruct
    public void setUp() {
        allAirports = new ArrayList<AirportVo>();
        getRowValues().stream()
                      .filter(row -> row != null)
                      .map(row -> new AirportVo(row[0], row[1], row[2], row[3], row[4], row[5], row[6], row[7], row[8], row[9], row[10], row[11], row[12], row[13], row[14], row[15], row[16], row[17]))
                      .forEach(vo -> allAirports.add(vo));
    }
}
