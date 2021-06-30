/**
 * RetrieveTotalConfirmedCases Class using Facade Design Pattern
 * concrete class of Data
 */
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

public class RetrieveTotalConfirmedCases extends Data{
    private double cases = 0;

    RetrieveTotalConfirmedCases(){}
    /**
     * getData() will retrieve the selected country's total confirmed cases
     * from API
     * @param country
     * @return double
     */
    public double getData(String country) {
        String urlString = String.format("https://api.covid19api.com/total/dayone/country/%s/status/confirmed", country);
        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            int responsecode = conn.getResponseCode();
            if (responsecode == 200) {
                String inline = "";
                Scanner sc = new Scanner(url.openStream());
                while (sc.hasNext()) {
                    inline += sc.nextLine();
                }
                sc.close();
                JsonArray jsonArray = new JsonParser().parse(inline).getAsJsonArray();
                int size = jsonArray.size();
                cases = jsonArray.get(size - 1).getAsJsonObject().get("Cases").getAsDouble();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return cases;
    }
}
