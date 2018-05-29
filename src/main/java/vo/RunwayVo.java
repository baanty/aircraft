package vo;

import lombok.Data;

@Data
public class RunwayVo {

    private final String id;
    private final String airportRef;
    private final String airportIdent;
    private final String lengthFt;
    private final String widthFt;
    private final String surface;
    private final String lighted;
    private final String closed;
    private final String leident;
    private final String leLatitudedeg;
    private final String leLongitudeDeg;
    private final String leElevationFt;
    private final String leHeadingDegT;
    private final String leDisplacedThresholdFt;
    private final String heIdent;
    private final String heLatitudeDeg;
    private final String heLongitudeDeg;
    private final String heElevationFt;
    private final String heHeadingDegT;
    private final String heDisplacedThresholdFt;

}
