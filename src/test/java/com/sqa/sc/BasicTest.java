/**
 * File Name: BasicTest.java<br>
 * Chillappagari, Srikanth<br>
 * Java Boot Camp Exercise<br>
 * Instructor: Jean-francois Nepton<br>
 * Created: Nov 2, 2016
 */
package com.sqa.sc;

import java.util.concurrent.*;

import org.apache.log4j.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.testng.annotations.*;

import com.sqa.sc.helpers.*;

/**
 * BasicTest //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 *
 * @author Chillappagari, Srikanth
 * @version 1.0.0
 * @since 1.0
 */
public class BasicTest {

	private String baseURL;

	private WebDriver driver;

	private Logger log = Logger.getLogger(BasicTest.class);

	public BasicTest(String baseURL) {
		super();
		this.baseURL = baseURL;
	}

	public String getBaseURL() {
		return this.baseURL;
	}

	public WebDriver getDriver() {
		return this.driver;
	}

	public Logger getLog() {
		return this.log;
	}

	@BeforeClass
	public void setupTest() {
		getLog().info("setting up driver");
		this.driver = new FirefoxDriver();
		getLog().trace("Setting implicit wait to 30seconds");
		this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		getLog().trace("Setting window to full screen");
		this.driver.manage().window().maximize();
		getLog().info("going yo Base URL");
		this.driver.get(this.baseURL);
		getLog().debug("Clearing cookies");
		this.driver.manage().deleteAllCookies();
	}

	public boolean takeScreenshots(String filename) {
		return AutoBasics.takeScreenshots(getDriver(), "screenshots/", filename, getLog());
	}

	@AfterClass
	public void tearDown() {
		getLog().info("closing the driver");
		this.driver.quit();
	}
}
