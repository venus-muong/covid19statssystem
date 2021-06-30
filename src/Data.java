/**
 * Data Class - using Facade Design Pattern
 */
public abstract class Data {

    Data(){}

    /**
     * GetData() will get data for selected country
     * @param country
     * @return double
     */
    public abstract double getData(String country);
}
