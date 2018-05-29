package vo;

import lombok.Data;

@Data
public class AirportVo {

    private final String id;
    private final String ident;
    private final String type;
    private final String name;
    private final String latitudeDeg;
    private final String longitudeDeg;
    private final String elevationFt;
    private final String continent;
    private final String isoCountry;
    private final String isoRegion;
    private final String municipality;
    private final String scheduledService;
    private final String gpsCode;
    private final String iataCode;
    private final String localCode;
    private final String homeLink;
    private final String wikipediaLink;
    private final String keywords;


}
