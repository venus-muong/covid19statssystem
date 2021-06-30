/**
 * TotalCasesPerCapita Class is a concrete class of Analysis
 * using Strategy Design Pattern
 */

import java.util.ArrayList;

public class TotalCasesPerCapita extends Analysis{

    TotalCasesPerCapita(){}

    /**
     * getAnalysisData will get the confirmed cases data and country population
     * in order to calculate total cases per capita for selected countries
     * @return ArrayList<Double>
     */
    @Override
    public ArrayList<Double> getAnalysisData(){
        RetrieveData confirmedCases = new RetrieveData();
        RetrieveData countryPopulation = new RetrieveData();
        double num, denom, result;
        for (int i = 0; i < countries.size(); i++) {
            num = confirmedCases.getConfirmedCases(countries.get(i));
            denom = countryPopulation.getPopulation(countries.get(i));
            result = num/denom;
            resultData.add(result);
            System.out.println(countries.get(i) + ":" + result);
        }
        return resultData;
    }
}
