package vo;

import lombok.Data;

@Data
public class CountryVo {

    private final String id;
    private final String code;
    private final String name;
    private final String continent;
    private final String wikipediaLink;
    private final String keywords;
}
