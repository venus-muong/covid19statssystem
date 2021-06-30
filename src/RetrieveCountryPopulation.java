/**
 * RetrieveCountryPopulation Class using Facade Design Pattern
 * concrete class of Data
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class RetrieveCountryPopulation extends Data{
    private BufferedReader reader;
    private double population = 0;

    RetrieveCountryPopulation(){}

    /**
     * getData() will retrieve the selected country population from json file
     * @param country
     * @return double
     */
    public double getData(String country){
        try {
            reader = new BufferedReader(new FileReader("Resources/country-by-population.json"));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String line;
        String populationString = "";
        try {
            while ((line = reader.readLine()) != null) {
                if (line.contains(country)) {
                    line = reader.readLine();
                    populationString = line;
                    break;
                }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        populationString = (populationString.split(":"))[1];
        population = Double.parseDouble(populationString);
        return population;
    }
}
