
/**
 * DisplayResult class will take the analysis results and put it on the map
 */

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class DisplayResult {
	private ArrayList<Double> results;
	private ArrayList<String> countries;
	private String line;
	private String cvsSplitBy;
	private String csvFile;
	private BufferedReader br = null;

	DisplayResult(ArrayList<Double> results, ArrayList<String> countries, String line, String cvsSplitBy,
			String csvFile) {
		this.results = results;
		this.countries = countries;
		this.line = line;
		this.cvsSplitBy = cvsSplitBy;
		this.csvFile = csvFile;
	}

	/**
	 * getXY() will get the coordinates on the map based on the selected country to
	 * paint circles
	 * 
	 * @param lat       the latitude
	 * @param lng       the longitude
	 * @param mapWidth  the width of the map
	 * @param mapHeight the height of the map
	 * @return the point to paint a circle at on the map
	 */
	public Point getXY(double lat, double lng, int mapWidth, int mapHeight) {
		int screenX = (int) Math.round((((lng + 180) / 360) * mapWidth));
		int screenY = (int) Math.round(((((lat * -1) + 90) / 180) * mapHeight));
		return new Point(screenX, screenY);
	}

	/**
	 * MapResult() will paint the circles on the map
	 * 
	 * @return the map with the circles painted on it
	 */
	public ImageIcon MapResult() {
		BufferedImage myPicture = null;
		try {
			myPicture = ImageIO.read(new File("Resources/map.jpg"));
		} catch (IOException event) {
			// TODO Auto-generated catch block
			event.printStackTrace();
		}
		int mapWidth = myPicture.getWidth();
		int mapHeight = myPicture.getHeight();

		for (int i = 0; i < countries.size(); i++) {

			Graphics2D editableImage = (Graphics2D) myPicture.getGraphics();

			Double maxValue = results.get(i);
			System.out.println("max value: " + maxValue);
			int maxOvalDimension;
			if (maxValue < 10000) {
				editableImage.setColor(Color.GREEN);
				maxOvalDimension = 20;
			} else if (maxValue < 50000) {
				editableImage.setColor(Color.YELLOW);
				maxOvalDimension = 30;
			} else if (maxValue < 100000) {
				editableImage.setColor(Color.ORANGE);
				maxOvalDimension = 50;
			} else {
				editableImage.setColor(Color.RED);
				maxOvalDimension = 70;
			}
			int minOvalDimension = 15;
			int ovalDimension = (int) Math.round(((maxOvalDimension - minOvalDimension) * 1) + minOvalDimension);

			try {

				br = new BufferedReader(new FileReader(csvFile));
				boolean found = false;
				while ((line = br.readLine()) != null) {

					// use comma as separator
					String[] country = line.split(cvsSplitBy);

					if (country[3].equals(countries.get(i))) {
						found = true;
						double lat = Double.parseDouble(country[1]);
						double lng = Double.parseDouble(country[2]);
						Point2D coords = new Point2D.Double(lng, lat);
						// longitude and latitude values are of type double as given
						// from the csv coordinates file

						System.out.println("Coordinates: " + coords.getX() + ", " + coords.getY());
						Point testPoint = getXY(coords.getY(), coords.getX(), mapWidth, mapHeight);
						// Add the circle to the image
						editableImage.setStroke(new BasicStroke(3));
						editableImage.fillOval(testPoint.x - (ovalDimension / 2), testPoint.y - (ovalDimension / 2),
								ovalDimension, ovalDimension);
					}
				}
				if (!found) {
					JOptionPane.showMessageDialog(null, "Please enter a valid country");
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

		}

		ImageIcon imageIcon = new ImageIcon();
		imageIcon.setImage(myPicture);
		Image image = imageIcon.getImage(); // transform it
		Image newimg = image.getScaledInstance(900, 500, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		imageIcon = new ImageIcon(newimg); // transform it back
		return imageIcon;
	}

}