/**
 * Context Class for Strategy Design Pattern to be used for analysis
 */

import java.util.ArrayList;

public class Context {
    private Analysis analysis;

    /**
     * Context constructor - sets analysis
     * @param analysis
     */
    Context (Analysis analysis){
        this.analysis = analysis;
    }

    /**
     * executeAnalysis will perform the analysis for selected countries
     * and selected analysis
     * @param countries
     * @return ArrayList<Double>
     */
    public ArrayList<Double> executeAnalysis(ArrayList<String> countries){
        ArrayList<Double> results;
        analysis.setCountries(countries);
        results = analysis.getAnalysisData();

        return results;
    }

}
