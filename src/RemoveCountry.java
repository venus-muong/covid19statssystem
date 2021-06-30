
/**
 * RemoveCountry Class will check if country is in system or country list
 * before adding it to country list.
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class RemoveCountry {
	private JTextField removeCountryText;
	private JTextArea countryList;
	private ArrayList<String> countries;
	private String line;
	private String cvsSplitBy;
	private String csvFile;
	private BufferedReader br = null;

	RemoveCountry(String line, JTextField removeCountryText, JTextArea countryList, ArrayList<String> countries,
			String cvsSplitBy, String csvFile) {
		this.line = line;
		this.removeCountryText = removeCountryText;
		this.countryList = countryList;
		this.countries = countries;
		this.cvsSplitBy = cvsSplitBy;
		this.csvFile = csvFile;
	}

	/**
	 * CheckRemoveCountry() checks if removal of a selected country is valid
	 * 
	 * @return true if removal is valid, false otherwise
	 */
	public boolean CheckRemoveCountry() {
		boolean found = false;
		try {

			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {

				// use comma as separator
				String[] country = line.split(cvsSplitBy);

				if (country[3].equals(removeCountryText.getText())) {
					found = true;
					if (countries.contains(removeCountryText.getText())) {
						System.out.println("Removed " + removeCountryText.getText());
						countries.remove(removeCountryText.getText());

					} else {
						JOptionPane.showMessageDialog(null, "Please enter a country that has been selected");
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

	/**
	 * UpdateCountryList() will update the list without the removed country
	 */
	public void UpdateCountryList() {
		// update the displayed country list
		countryList.setText("");
		for (int i = 0; i < countries.size(); i++) {
			countryList.append(countries.get(i) + "\n");
		}
		for (int i = 0; i < countries.size(); i++) {
			System.out.println(countries.get(i));
		}
	}
}