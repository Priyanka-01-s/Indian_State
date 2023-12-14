package com.example;

import java.util.List;

public class StateCensusAnalyser {

    private List<String[]> fileData;

    public StateCensusAnalyser(CSVStateCensus csvStateCensus){
        this.fileData = csvStateCensus.readFile();
    }

    //searching the TIN number
    public String[] searchTIN(String tinNum){
        for(String[] data:fileData){
            if(data.length>2 && data[2].equals(tinNum)){
                return data;
            }
        }
        return null;
    }

    public List<String[]> getData() {
        return fileData;
    }
    
    public void loadAndParseData(String csvFilePath) {
        CSVStateCensus csvStateCensus = new CSVStateCensus(csvFilePath);
        this.fileData = csvStateCensus.readFile();
    }
    
}
