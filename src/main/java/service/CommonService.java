package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class CommonService {

    private static final String CSV_COLUMN_DELIMETER = ",";
    
    abstract String getCsvName();
    
    public List<String[]> getRowValues() throws URISyntaxException {
        List<String[]> allRows = new ArrayList<String[]>();
        InputStream is = getClass().getResourceAsStream("/csv/" + getCsvName());
        InputStreamReader reader = new InputStreamReader(is);
        
        try (BufferedReader bufferedReader = new BufferedReader(reader)) {
            String line;
            while((line = bufferedReader.readLine()) != null){
               String[] rowValues = line.split(CSV_COLUMN_DELIMETER, -1);
                allRows.add(rowValues);
            }
        } catch (IOException e) {
            log.error("Can not read CSV file. - " + getCsvName());
        }
        return allRows;
    }
}
