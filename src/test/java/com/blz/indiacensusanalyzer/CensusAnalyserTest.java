package com.blz.indiacensusanalyzer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CensusAnalyserTest {
    //------> For India code census data file
    private static final String INDIA_CENSUS_CSV_FILE_PATH = "C:\\Users\\SONY\\JAVA\\INDIA_CENSUS_ANALYZER\\src\\main\\resources\\IndiaStateCensusData.csv";
    private static final String WRONG_INDIA_CENSUS_CSV_FILE_PATH = "C:\\Users\\SONY\\JAVA\\INDIA_CENSUS_ANALYZER\\src\\main\\IndiaStateCensusData.csv";
    private static final String WRONG_FILE_TYPE_PATH = "C:\\Users\\SONY\\JAVA\\INDIA_CENSUS_ANALYZER\\src\\main\\resources\\IndiaStateCensusData.txt";
    private static final String WRONG_DELIMITER_FILE_PATH = "C:\\Users\\SONY\\JAVA\\INDIA_CENSUS_ANALYZER\\src\\main\\resources\\DelimiterIndiaStateCensusData.csv";
    private static final String WITHOUT_HEADER_FILE_PATH = "C:\\Users\\SONY\\JAVA\\INDIA_CENSUS_ANALYZER\\src\\main\\resources\\WithoutHeaderIndiaStateCensusData.csv";

    //------> For State code file
    private static final String INDIA_STATE_CODE_CSV_FILE_PATH = "C:\\Users\\SONY\\JAVA\\INDIA_CENSUS_ANALYZER\\src\\main\\resources\\IndiaStateCode.csv";
    private static final String WRONG_STATE_CODE_CSV_FILE_PATH = "C:\\Users\\SONY\\JAVA\\INDIA_CENSUS_ANALYZER\\src\\main\\IndiaStateCode.csv";
    private static final String WRONG_INDIA_STATE_CODE_FILE_PATH_TYPE = "C:\\Users\\SONY\\JAVA\\INDIA_CENSUS_ANALYZER\\src\\main\\resources\\IndiaStateCode.txt";
    private static final String INDIA_STATE_CODE_CSV_HEADER_INCORRECT = "/C:\\Users\\SONY\\JAVA\\INDIA_CENSUS_ANALYZER\\src\\main\\resources\\Without Header IndiaStateCode.csv";
    CensusAnalyser censusAnalyzer = new CensusAnalyser();

    //TC1.1-INDIA_CENSUS_CSV_FILE
    @Test
    public void givenIndiaCensusCorrectCSVFile_ItShouldReturnExactCount() {
        try {
            int numOfRecord = censusAnalyzer.loadIndiaCensusData((INDIA_CENSUS_CSV_FILE_PATH));
            Assert.assertEquals(29, numOfRecord);

        } catch (CensusAnalyserException e) {
        }
    }

    //TC 1.1-INDIA_STATE_CODE_CSV_FILE_PATH
    @Test
    public void givenIndiaStateCodeCorrectCSVFile_ItShouldReturnExactCount() {
        try {
            int numOfRecord = censusAnalyzer.loadStateCodeData((INDIA_STATE_CODE_CSV_FILE_PATH));
            Assert.assertEquals(37, numOfRecord);

        } catch (CensusAnalyserException e) {
        }
    }

    //TC1.2 INDIA_CENSUS_CSV_FILE
    @Test
    public void givenIndiaCensusWrongCSVFile_ItShouldReturnThrowException() {
        try {

            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyzer.loadIndiaCensusData(WRONG_INDIA_CENSUS_CSV_FILE_PATH);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.exceptionType);
        }
    }

    //TC1.2 INDIA_STATE_CODE
    @Test
    public void givenIndiaStateCodeWrongCSVFile_ItShouldReturnThrowException() {
        try {

            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyzer.loadStateCodeData(WRONG_STATE_CODE_CSV_FILE_PATH);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.STATE_CODE_FILE_PROBLEM, e.exceptionType);
        }
    }

    //TC1.3 INDIA_CENSUS_CSV_FILE
    @Test
    public void given_IndiaCodeData_WithWrongFileType_ShouldThrowException() {
        try {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyzer.loadIndiaCensusData(WRONG_FILE_TYPE_PATH);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.WRONG_FILE_TYPE, e.exceptionType);
        }
    }

    //TC1.3 INDIA_STATE_CODE
    @Test
    public void given_India_State_Code_WithWrongFileType_ShouldThrowException() {
        try {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyzer.loadStateCodeData(WRONG_INDIA_STATE_CODE_FILE_PATH_TYPE);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.WRONG_FILE_TYPE, e.exceptionType);
        }
    }

    //TC1.4
    @Test
    public void given_IndiaCodeData_WithWrongFileDelimiter_ShouldThrowException() {
        try {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyzer.loadIndiaCensusData(WRONG_DELIMITER_FILE_PATH);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.INCORRECT_DELIMITER_OR_HEADER, e.exceptionType);
        }
    }

    //TC 1.5 INDIA_CENSUS_CSV_FILE
    @Test
    public void given_IndiaCodeData_WithoutHeader_ShouldThrowException() {
        try {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyzer.loadIndiaCensusData(WITHOUT_HEADER_FILE_PATH);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.INCORRECT_DELIMITER_OR_HEADER, e.exceptionType);
        }
    }
    //TC1.5 INDIA_STATE_CODE

    @Test
    public void given_IndiaState_WithoutHeader_ShouldThrowException() {
        try {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyzer.loadStateCodeData(INDIA_STATE_CODE_CSV_HEADER_INCORRECT);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.INCORRECT_DELIMITER_OR_HEADER, e.exceptionType);
        }
    }
}