package com.blz.indiacensusanalyzer;

import com.opencsv.bean.CsvBindByName;

public class IndiaCensusCSV {
    /*
     * Class where we have defined the variables
     */
    @CsvBindByName(column = "State")
    public String state;

    @CsvBindByName(column = "Population")
    public String population;

    @CsvBindByName(column = "AreaInSqKm")
    public String areaInSqKm;

    @CsvBindByName(column = "DensityPerSqKm")
    public String densityPerSqKm;

    public IndiaCensusCSV(String state, String population, String areaInSqKm, String densityPerSqKm) {
        this.state = state;
        this.population = population;
        this.areaInSqKm = areaInSqKm;
        this.densityPerSqKm = densityPerSqKm;
    }

    public IndiaCensusCSV() {

    }

    @Override
    public String toString() {
        return "IndiaCensusCSV{" +
                "state='" + state + '\'' +
                ", population='" + population + '\'' +
                ", areaInSqKm='" + areaInSqKm + '\'' +
                ", staDensityPerSqKm='" + densityPerSqKm + '\'' +
                '}';
    }
}
