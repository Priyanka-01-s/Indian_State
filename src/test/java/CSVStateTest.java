import org.junit.jupiter.api.Test;

import com.example.CSVStateCensus;
import com.example.CSVTypeException;
import com.example.StateCensusAnalyser;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    //TC3
    @Test
    void testIncorrectFileType() {
        String incorrectFilePath = "StateCensus.txt";

        CSVStateCensus csvStateCensus = new CSVStateCensus(incorrectFilePath);
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser(csvStateCensus);
        CSVTypeException thrownException = assertThrows(CSVTypeException.class, () -> stateCensusAnalyser.loadAndParseData(incorrectFilePath));
        assertNotNull(thrownException);
        assertEquals("Incorrect file type. Expected a CSV file.", thrownException.getMessage());
    }
    
}
