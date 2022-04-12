package com.blz.indiacensusanalyzer;

import com.opencsv.bean.CsvBindByName;

public class CSVStates {
    @CsvBindByName(column = "SrNo")
    public int srNo;
    @CsvBindByName(column = "StateName")
    public String stateName;
    @CsvBindByName(column = "TIN")
    public int tin;
    @CsvBindByName(column = "StateCode")
    public String stateCode;

    public CSVStates(int srNo, String stateName, int tin, String stateCode) {
        this.srNo = srNo;
        this.stateName = stateName;
        this.tin = tin;
        this.stateCode = stateCode;
    }

    public CSVStates() {

    }
}
