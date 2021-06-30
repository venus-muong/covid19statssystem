/**
 * TotalDeathsPerCountry Class is a concrete class of Analysis
 * using Strategy Design Pattern
 */
import java.util.ArrayList;

public class TotalDeathsPerCountry extends Analysis{

    TotalDeathsPerCountry(){};
    /**
     * getAnalysisData will get the total death case data for
     * each selected country
     * @return ArrayList<Double>
     */
    @Override
    public ArrayList<Double> getAnalysisData(){
        RetrieveData deathCases = new RetrieveData();
        for (int i = 0; i < countries.size(); i++) {
            resultData.add(deathCases.getDeathCases(countries.get(i)));
            System.out.println(countries.get(i) + ":" + resultData.get(i));
        }
        return resultData;
    }
}
