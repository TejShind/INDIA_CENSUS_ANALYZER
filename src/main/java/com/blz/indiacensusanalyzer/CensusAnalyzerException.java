package com.blz.indiacensusanalyzer;

public class CensusAnalyzerException extends Exception {

    public ExceptionType exceptionType;
    public String message;

    CensusAnalyzerException(String message, ExceptionType exceptionType) {
        this.exceptionType = exceptionType;
        this.message = message;
    }

    public enum ExceptionType {
        CENSUS_FILE_PROBLEM
    }


}
