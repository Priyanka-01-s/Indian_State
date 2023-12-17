package com.example;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("-----------------------INDIAN STATES-------------------------\n");
        String csvFile = "StateCensus.csv";

        CSVStateCensus csvStateCensus = new CSVStateCensus(csvFile);

        System.out.println("THE STATE DETAILS IN THE CSV FILE \n");
        //Displaying the file
        List<String[]> stateData = csvStateCensus.readFile();
        for(String[] data:stateData){
            for(String cell :data){
                    System.out.print(cell + " ");            
            }
            System.out.println();
        }

        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser(csvStateCensus);
        System.out.println("The number of entries in the CSv file : "+stateCensusAnalyser.countEntries());

        //For searching using the TIN number of the state
        
        System.out.println("ENTER THE STATE TIN NUMBER TO CHECK :");
        Scanner sc = new Scanner(System.in);
        String tinNum = sc.nextLine();

        String[] stateDetail = stateCensusAnalyser.searchTIN(tinNum);

        if(stateDetail != null){
            System.out.println("\nThe details of the state with TIN Number "+tinNum);
            for(String data : stateDetail){
                System.out.print(data +" ");
            }
        }else{
            System.out.println("\nNo record found for the given TIN Number!");
        }
        sc.close();
    }
}