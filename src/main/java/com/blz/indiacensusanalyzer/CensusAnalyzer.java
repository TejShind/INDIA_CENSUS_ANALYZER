package com.blz.indiacensusanalyzer;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Iterator;


public class CensusAnalyzer {

    public int loadIndiaCensusData(String csvPath) throws CensusAnalyzerException {
        int numOfEntries = 0;
        try {
            Reader reader = Files.newBufferedReader(Paths.get(csvPath));
            CsvToBean<IndiaCensusCSV> csvToBean = new CsvToBeanBuilder<IndiaCensusCSV>(reader)
                    .withType(IndiaCensusCSV.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            Iterator<IndiaCensusCSV> censusCSVIterator = csvToBean.iterator();
            numOfEntries = 0;
            while (censusCSVIterator.hasNext()) {
                numOfEntries++;
                censusCSVIterator.next();
            }
            return numOfEntries;

        } catch (NoSuchFileException e) {
            if (!csvPath.contains(".csv")) {
                throw new CensusAnalyzerException(e.getMessage(), CensusAnalyzerException.ExceptionType.WRONG_FILE_TYPE);
            }
        } catch (IOException e) {
            throw new CensusAnalyzerException(e.getMessage(), CensusAnalyzerException.ExceptionType.CENSUS_FILE_PROBLEM);

        } catch (RuntimeException e) {
            throw new CensusAnalyzerException(e.getMessage(), CensusAnalyzerException.ExceptionType.INCORRECT_DELIMITER_OR_HEADER);
        }
        return numOfEntries;
    }
    }
