package com.blz.indiacensusanalyzer;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.StreamSupport;


public class CensusAnalyser {

    public int loadIndiaCensusData(String csvPath) throws CensusAnalyserException {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(csvPath));
            Iterator<IndiaCensusCSV> censusCSVIterator = new OpenCSV().getCSVIterator(reader, IndiaCensusCSV.class);
            Iterable<IndiaCensusCSV> csvIterator = () -> censusCSVIterator;
            return this.getCount(csvIterator);
        } catch (NoSuchFileException e) {
            if (!csvPath.contains(".csv")) {
                throw new CensusAnalyserException(e.getMessage(), CensusAnalyserException.ExceptionType.WRONG_FILE_TYPE);
            }
        } catch (IOException e) {
            throw new CensusAnalyserException(e.getMessage(), CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);

        } catch (RuntimeException e) {
            throw new CensusAnalyserException(e.getMessage(), CensusAnalyserException.ExceptionType.INCORRECT_DELIMITER_OR_HEADER);
        }
        return 0;
    }

    public int loadStateCodeData(String csvPath) throws CensusAnalyserException {
        try (Reader reader = Files.newBufferedReader(Paths.get(csvPath))) {
            Iterator<CSVStates> censusCSVIterator = new OpenCSV().getCSVIterator(reader, CSVStates.class);
            Iterable<CSVStates> csvIterator = () -> censusCSVIterator;
            return this.getCount(csvIterator);

        } catch (NoSuchFileException e) {
            if (!csvPath.contains(".csv")) {
                throw new CensusAnalyserException(e.getMessage(), CensusAnalyserException.ExceptionType.WRONG_FILE_TYPE);
            }
        } catch (IOException e) {
            throw new CensusAnalyserException(e.getMessage(), CensusAnalyserException.ExceptionType.STATE_CODE_FILE_PROBLEM);

        } catch (RuntimeException e) {
            throw new CensusAnalyserException(e.getMessage(), CensusAnalyserException.ExceptionType.INCORRECT_DELIMITER_OR_HEADER);
        }
        return 0;
    }

    private <E> int getCount(Iterable<E> csvIterator) {
        return (int) StreamSupport.stream(csvIterator.spliterator(), true)
                .count();

    }


}

