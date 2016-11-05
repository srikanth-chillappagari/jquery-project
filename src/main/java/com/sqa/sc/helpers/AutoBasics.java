/**
 * File Name: AutoBasics.java<br>
 * Chillappagari, Srikanth<br>
 * Java Boot Camp Exercise<br>
 * Instructor: Jean-francois Nepton<br>
 * Created: Nov 2, 2016
 */
package com.sqa.sc.helpers;

import java.io.*;
import java.util.*;

import org.apache.commons.io.*;
import org.apache.log4j.*;
import org.openqa.selenium.*;

/**
 * AutoBasics //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 *
 * @author Chillappagari, Srikanth
 * @version 1.0.0
 * @since 1.0
 */
public class AutoBasics {

	public static final String DEFAULT_SCREENSHOT_FILENAME = "screenshot";

	public static final String DEFAULT_SCREENSHOT_SAVE_LOCATION = "screenshots/";

	public static final String FILE_EXTENSION = ".jpg";

	public static List<WebElement> getBlueTextFromPage(WebDriver driver, By locator) {
		return getCSSPropertyBasedElements(driver, locator, "color", "#136cb2");
	}

	public static List<WebElement> getByTagName(WebDriver driver, String tagName) {
		List<WebElement> elements = driver.findElements(By.tagName(tagName));
		return elements;
	}

	public static List<WebElement> getCSSPropertyBasedElements(WebDriver driver, By locator, String prop,
			String value) {
		List<WebElement> elements = driver.findElements(locator);
		List<WebElement> matchingElements = new ArrayList<WebElement>();
		for (int i = 0; i < elements.size(); i++) {
			String elementValue = elements.get(i).getCssValue(prop);
			if (elementValue.equalsIgnoreCase(value)) {
				matchingElements.add(elements.get(i));
			}
		}
		return elements;
	}

	public static List<WebElement> getLinks(WebDriver driver) {
		List<WebElement> elements = getByTagName(driver, "a");
		return elements;
	}

	public static List<WebElement> getPictures(WebDriver driver) {
		List<WebElement> elements = getByTagName(driver, "img");
		return elements;
	}

	public static List<String> getTextContents(WebDriver driver, By locator) {
		List<WebElement> elements = driver.findElements(locator);
		List<String> elementsTexts = new ArrayList<String>();
		for (int i = 0; i < elements.size(); i++) {
			String text = elements.get(i).getText();
			if (!text.equals("")) {
				elementsTexts.add(text);
			}
		}
		return elementsTexts;
	}

	public static boolean takeScreenshots(WebDriver driver) {
		return takeScreenshots(driver, DEFAULT_SCREENSHOT_FILENAME, DEFAULT_SCREENSHOT_SAVE_LOCATION, null);
	}

	public static boolean takeScreenshots(WebDriver driver, String location, String filename) {
		return takeScreenshots(driver, location, filename, null);
	}

	public static boolean takeScreenshots(WebDriver driver, String location, String filename, Logger log) {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File(location + filename + FILE_EXTENSION));
		} catch (Exception e) {
			if (log != null) {
				log.error("failed to save screenshot at " + location + filename + FILE_EXTENSION);
			}
			return false;
		}
		return true;
	}
}
