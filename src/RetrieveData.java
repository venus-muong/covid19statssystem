/**
 * RetrieveData Class using Facade Design Pattern
 * This is the 'Facade Class'
 */
public class RetrieveData {
    private Data confirmedCases;
    private Data deathCases;
    private Data countryPopulation;

    /**
     * RetrieveData() constructor will take all private members to create
     * a new object
     */
    public RetrieveData(){
        confirmedCases = new RetrieveTotalConfirmedCases();
        deathCases = new RetrieveTotalDeathCases();
        countryPopulation = new RetrieveCountryPopulation();
    }

    /**
     * getConfirmedCases() will get the confirmed cases for selected country
     * @param country
     * @return double
     */
    public double getConfirmedCases(String country){
        return confirmedCases.getData(country);
    }
    /**
     * getDeathCases() will get the death cases for selected country
     * @param country
     * @return double
     */
    public double getDeathCases(String country){
        return deathCases.getData(country);
    }
    /**
     * getPopulation() will get the population for selected country
     * @param country
     * @return double
     */
    public double getPopulation(String country){
        return countryPopulation.getData(country);
    }

}
