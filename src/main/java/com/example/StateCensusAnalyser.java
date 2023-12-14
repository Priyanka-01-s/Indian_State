package com.example;

import java.util.List;

public class StateCensusAnalyser {

    private final List<String[]> fileData;

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
    
    
}
