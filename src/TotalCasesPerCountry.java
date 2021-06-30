/**
 * TotalCasesPerCountry Class is a concrete class of Analysis
 * using Strategy Design Pattern
 */
import java.util.ArrayList;

public class TotalCasesPerCountry extends Analysis{

    TotalCasesPerCountry(){}
    /**
     * getAnalysisData will get the confirmed cases data for
     * each selected country
     * @return ArrayList<Double>
     */
    @Override
    public ArrayList<Double> getAnalysisData(){
        RetrieveData confirmedCases = new RetrieveData();
        for (int i = 0; i < countries.size(); i++) {
            resultData.add(confirmedCases.getConfirmedCases(countries.get(i)));
            System.out.println(countries.get(i) + ":" + resultData.get(i));
        }
        return resultData;
    }
}
