package com.blz.indiacensusanalyzer;

public class CensusAnalyserException extends Exception {

    public ExceptionType exceptionType;
    public String message;

    CensusAnalyserException(String message, ExceptionType exceptionType) {
        this.exceptionType = exceptionType;
        this.message = message;
    }

    public enum ExceptionType {
        CENSUS_FILE_PROBLEM,WRONG_FILE_TYPE,INCORRECT_DELIMITER_OR_HEADER,
        STATE_CODE_FILE_PROBLEM
    }


}
