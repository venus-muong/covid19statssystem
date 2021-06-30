/**
 * Analysis Class - USED STRATEGY DESIGN PATTERN
 */

import java.util.ArrayList;

abstract class Analysis {
    protected ArrayList<String> countries = new ArrayList<String>();
    protected ArrayList<Double> resultData = new ArrayList<Double>();

    Analysis(){}

    /**
     *setCountries() is a setter for countries
     * @param countries
     */
    public void setCountries(ArrayList<String> countries ){
        this.countries = countries;
    }

    /**
     * getAnalysisData() is used to retrieve all data for selected analysis
     * @return ArrayList<Double>
     */
    public abstract ArrayList<Double> getAnalysisData();
}
