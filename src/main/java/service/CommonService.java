package service;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class CommonService {

    private static final String CSV_COLUMN_DELIMETER = ",";

    @Autowired 
    private ResourceLoader resourceLoader;
    
    abstract String getCsvName();
    
    public List<String[]> getRowValues() {
        List<String[]> allRows = new ArrayList<String[]>();
        Resource resource = resourceLoader.getResource("csv" + File.separator + getCsvName());
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resource.getInputStream()))) {
            String line;
            while((line = bufferedReader.readLine()) != null){
                String[] rowValues = line.split(CSV_COLUMN_DELIMETER);
                allRows.add(rowValues);
            }
        } catch (IOException e) {
            log.error("Can not read CSV file.");
        }
        return allRows;
    }
}
