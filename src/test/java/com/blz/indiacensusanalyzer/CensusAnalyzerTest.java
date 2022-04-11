package com.blz.indiacensusanalyzer;
import org.junit.Assert;
import org.junit.Test;

public class CensusAnalyzerTest {
    private static final String INDIA_CENSUS_CSV_FILE_PATH = "C:\\Users\\SONY\\JAVA\\Census_Analyzer\\src\\main\\resources\\IndiaStateCensusData.csv";

    @Test
    public void givenIndiaCensusCorrectCSVFile_ItShouldReturnExactCount()  {

        CensusAnalyzer censusAnalyzer = new CensusAnalyzer();
        int numOfRecord = censusAnalyzer.loadIndiaCensusData((INDIA_CENSUS_CSV_FILE_PATH));
        Assert.assertEquals(29, numOfRecord);

    }

}