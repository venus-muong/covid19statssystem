import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JTextArea;
import javax.swing.JTextField;

public class AddCountry {
	private JTextField addCountryText;
	private JTextArea countryList;
	private ArrayList<String> countries;
	private String line;
	private String cvsSplitBy;
	private String csvFile;
	private BufferedReader br = null;

	AddCountry(String line, JTextField addCountryText, JTextArea countryList, ArrayList<String> countries,
			String cvsSplitBy, String csvFile) {
		this.line = line;
		this.addCountryText = addCountryText;
		this.countryList = countryList;
		this.countries = countries;
		this.cvsSplitBy = cvsSplitBy;
		this.csvFile = csvFile;
	}

	/**
	 * CheckAddCountry() checks if the country user is attempting to add is valid
	 * paint circles
	 * 
	 * 
	 * @return true if the country is valid, false otherwise
	 */
	public boolean CheckAddCountry() {
		boolean found = false;
		try {
			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {

				// use comma as separator
				String[] country = line.split(cvsSplitBy);

				if (country[3].equals(addCountryText.getText())) {
					found = true;
					countryList.setText("");
					System.out.println("Added " + addCountryText.getText());
					countries.add(addCountryText.getText());
					for (int i = 0; i < countries.size(); i++) {
						countryList.append(countries.get(i) + "\n");
					}
					for (int i = 0; i < countries.size(); i++) {
						System.out.println(countries.get(i));
					}
				}
			}
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		}
		return found;
	}

}