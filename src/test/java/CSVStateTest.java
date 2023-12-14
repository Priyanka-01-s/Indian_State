import org.junit.jupiter.api.Test;

import com.example.CSVStateCensus;
import com.example.StateCensusAnalyser;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CSVStateTest {

    @Test
    void testNumberOfRecords() {
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
}

