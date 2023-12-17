package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVStateCensus {
    
    private String filePath;
    private String expectedDelimiter = ","; 

    public CSVStateCensus(String filePath){
        this.filePath = filePath;
    }

    public void setExpectedDelimiter(String delimiter) {
        this.expectedDelimiter = delimiter;
    }

    public List<String[]> readFile(){
        List<String[]> data = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            reader.readLine();

            String line;
            while((line=reader.readLine())!=null){
                String[] row= line.split(",");
                data.add(row);
            } 
        }catch(IOException e){
            e.printStackTrace();
        }
        return data;
    }

}

