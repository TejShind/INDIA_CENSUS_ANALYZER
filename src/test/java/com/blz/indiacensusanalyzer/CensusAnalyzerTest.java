package com.blz.indiacensusanalyzer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CensusAnalyzerTest {
    private static final String INDIA_CENSUS_CSV_FILE_PATH = "C:\\Users\\SONY\\JAVA\\INDIA_CENSUS_ANALYZER\\src\\main\\resources\\IndiaStateCensusData.csv";
    private static final String WRONG_INDIA_CENSUS_CSV_FILE_PATH = "C:\\Users\\SONY\\JAVA\\INDIA_CENSUS_ANALYZER\\src\\main\\IndiaStateCensusData.csv";
    private static final String WRONG_FILE_TYPE_PATH = "C:\\Users\\SONY\\JAVA\\INDIA_CENSUS_ANALYZER\\src\\main\\resources\\IndiaStateCensusData.txt";
    private static final String WRONG_DELIMITER_FILE_PATH = "C:\\Users\\SONY\\JAVA\\INDIA_CENSUS_ANALYZER\\src\\main\\resources\\DelimiterIndiaStateCensusData.csv";
    private static final String WITHOUT_HEADER_FILE_PATH = "C:\\Users\\SONY\\JAVA\\INDIA_CENSUS_ANALYZER\\src\\main\\resources\\WithoutHeaderIndiaStateCensusData.csv";
    CensusAnalyzer censusAnalyzer = new CensusAnalyzer();

    //TC1.1
    @Test
    public void givenIndiaCensusCorrectCSVFile_ItShouldReturnExactCount() {
        try {
            int numOfRecord = censusAnalyzer.loadIndiaCensusData((INDIA_CENSUS_CSV_FILE_PATH));
            Assert.assertEquals(29, numOfRecord);

        } catch (CensusAnalyzerException e) {
        }
    }

    //TC1.2
    @Test
    public void givenIndiaCensusCorrectCSVFile_ItShouldReturnThrowException() {
        try {

            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyzerException.class);
            censusAnalyzer.loadIndiaCensusData(WRONG_INDIA_CENSUS_CSV_FILE_PATH);
        } catch (CensusAnalyzerException e) {
            Assert.assertEquals(CensusAnalyzerException.ExceptionType.CENSUS_FILE_PROBLEM, e.exceptionType);
        }
    }

    //TC1.3
    @Test
    public void given_IndiaCodeData_WithWrongFileType_ShouldThrowException() {
        try {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyzerException.class);
            censusAnalyzer.loadIndiaCensusData(WRONG_FILE_TYPE_PATH);
        } catch (CensusAnalyzerException e) {
            Assert.assertEquals(CensusAnalyzerException.ExceptionType.WRONG_FILE_TYPE, e.exceptionType);
        }
    }

    //TC1.4
    @Test
    public void given_IndiaCodeData_WithWrongFileDelimiter_ShouldThrowException() {
        try {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyzerException.class);
            censusAnalyzer.loadIndiaCensusData(WRONG_DELIMITER_FILE_PATH);
        } catch (CensusAnalyzerException e) {
            Assert.assertEquals(CensusAnalyzerException.ExceptionType.INCORRECT_DELIMITER_OR_HEADER, e.exceptionType);
        }
    }

    //TC 1.5
    @Test
    public void given_IndiaCodeData_WithoutHeader_ShouldThrowException() {
        try {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyzerException.class);
            censusAnalyzer.loadIndiaCensusData(WITHOUT_HEADER_FILE_PATH);
        } catch (CensusAnalyzerException e) {
            Assert.assertEquals(CensusAnalyzerException.ExceptionType.INCORRECT_DELIMITER_OR_HEADER, e.exceptionType);
        }
    }
}