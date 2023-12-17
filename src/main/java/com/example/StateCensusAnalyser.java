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
        if (!csvFilePath.toLowerCase().endsWith(".csv")) {
            throw new CSVTypeException("Incorrect file type. Expected a CSV file.");
        }

        CSVStateCensus csvStateCensus = new CSVStateCensus(csvFilePath);

        try {
            this.fileData = csvStateCensus.readFile();
            validateType();
        } catch (CSVTypeException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    public int countEntries() {
        return fileData.size();
    }

    private void validateType() {
        int expectedColumnCount = 4;

        for (String[] data : fileData) {
            if (data.length != expectedColumnCount) {
                throw new CSVTypeException("Incorrect type in CSV file. Expected " + expectedColumnCount + " columns.");
            }
        }
    }
}
    

