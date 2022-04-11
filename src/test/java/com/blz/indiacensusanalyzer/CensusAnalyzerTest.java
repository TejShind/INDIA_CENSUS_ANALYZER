package com.blz.indiacensusanalyzer;
import org.junit.Assert;
import org.junit.Test;

public class CensusAnalyzerTest {
    private static final String INDIA_CENSUS_CSV_FILE_PATH = "C:\\Users\\SONY\\JAVA\\INDIA_CENSUS_ANALYZER\\src\\main\\resources\\IndiaStateCensusData.csv";
    private static final String WRONG_INDIA_CENSUS_CSV_FILE_PATH = "C:\\Users\\SONY\\JAVA\\INDIA_CENSUS_ANALYZER\\src\\main\\IndiaStateCensusData.csv";
    private static final String INDIA_CENSUS_FILE_PATH_WRONG = "C:\\Users\\SONY\\JAVA\\INDIA_CENSUS_ANALYZER\\src\\main\\IndiaStateCensusData";

    CensusAnalyzer censusAnalyzer = new CensusAnalyzer();

    @Test
    public void givenIndiaCensusCorrectCSVFile_ItShouldReturnExactCount() throws CensusAnalyzerException {

        int numOfRecord = censusAnalyzer.loadIndiaCensusData((INDIA_CENSUS_CSV_FILE_PATH));
        Assert.assertEquals(29, numOfRecord);

    }

    @Test
    public void givenIndiaCensusCorrectCSVFile_ItShouldReturnThrowException() {
        try {

            int numOfRecord = censusAnalyzer.loadIndiaCensusData((WRONG_INDIA_CENSUS_CSV_FILE_PATH));
            Assert.assertEquals(29, numOfRecord);

        } catch (CensusAnalyzerException e) {
            Assert.assertEquals(CensusAnalyzerException.ExceptionType.CENSUS_FILE_PROBLEM, e.exceptionType);
        }
    }

    @Test
    public void givenIndiaCensusCorrectCSVFile_ReturnIncorrectCustomExceptionTestTypeCheckSad() {
        try {
            int numOfRecord = censusAnalyzer.loadIndiaCensusData((INDIA_CENSUS_FILE_PATH_WRONG));
            Assert.assertEquals(29, numOfRecord);

        } catch (CensusAnalyzerException e) {
            Assert.assertEquals(CensusAnalyzerException.ExceptionType.CENSUS_FILE_PROBLEM, e.exceptionType);
        }
    }
}