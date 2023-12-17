import org.junit.jupiter.api.Test;

import com.example.CSVStateCensus;
import com.example.StateCensusAnalyser;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CSVStateTest {
    

    //TC1
    //happy test case
    @Test
    void testNumberOfRecordsHappy() {
        String csvFilePath = "StateCensus.csv";
        CSVStateCensus csvStateCensus = new CSVStateCensus(csvFilePath);
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser(csvStateCensus);
        stateCensusAnalyser.loadAndParseData(csvFilePath);

        // the loaded data
        int actualNumberOfRecords = stateCensusAnalyser.getData().size();

        int expectedNumberOfRecords = 37;

        assertEquals(expectedNumberOfRecords, actualNumberOfRecords,
                "Number of records in the CSV file does not match the expected number.");
    }

    //TC2
    //sad test case
    @Test
    void testNumberOfRecordsSad() {
        String csvFilePath = "StateCensus.csv";
        CSVStateCensus csvStateCensus = new CSVStateCensus(csvFilePath);
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser(csvStateCensus);
        stateCensusAnalyser.loadAndParseData(csvFilePath);

        // the loaded data
        int actualNumberOfRecords = stateCensusAnalyser.getData().size();

        int expectedNumberOfRecords = 40;

        assertEquals(expectedNumberOfRecords, actualNumberOfRecords,
                "Number of records in the CSV file does not match the expected number.");
    }

    
}
