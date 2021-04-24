package automation.googleMortgageCalculator;

import java.io.IOException;
import java.util.Dictionary;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import pageObjects.GoogleSearchPageObject;
import resources.base;

public class MortgageCalculatorTest extends base {
	// Get all elements from the google search page
	GoogleSearchPageObject po = new GoogleSearchPageObject();
	Dictionary<String, By> elements = po.getElements();

	//
	// Monthly cost test helper
	//
	public void monthlyCostTestHelper(String testName) throws IOException, ParseException {
		driver = initDriver();
		JSONObject testData = (JSONObject) getTestData(testName);

		// Browse to google.com
		driver.get("https://www.google.com");
		
		// Click on the search box
		clickElement(elements.get("search box"));
		
		// Enter the search term in the search box and hit enter
		sendKeysToElement(elements.get("search box"), testData.get("searchText").toString());
		sendKeysToElement(elements.get("search box"), Keys.ENTER);
		
		// Wait for the Mortgage calculator
		waitForElement(elements.get("Mortgage calculator"), 10);
		
		// Click Monthly cost
		clickElement(elements.get("Monthly cost"));
		
		// Check the heading text
		checkTextInElement(elements.get("Mortgage calculator"), "Mortgage calculator");
		
		// Clear the text from the element
		clearElement(elements.get("Mortgage amount input"));
		
		// Enter mortgage amount
		sendKeysToElement(elements.get("Mortgage amount input"), testData.get("mortgageAmount").toString());
		
		// Clear the text from the element
		clearElement(elements.get("Interest rate input"));
		
		// Enter interest rate
		sendKeysToElement(elements.get("Interest rate input"), testData.get("interestRate").toString());
		
		// Click mortgage period dropdown
		clickElement(elements.get("Mortgage period dropdown"));
		
		// Wait for mortgage period options
		waitForElement(elements.get(testData.get("mortgagePeriod").toString()), 10);
		
		// Select mortgage period
		clickElement(elements.get(testData.get("mortgagePeriod").toString()));
		
		// Check total cost of mortgage
		checkTextInElement(elements.get("Total cost of mortgage"), testData.get("costOfMortgage").toString());
		
		// Check monthly payments
		checkTextInElement(elements.get("Monthly payments"), testData.get("monthlyPayments").toString());
	}
	
	//
	// Maximum loan test helper
	//
	public void maximumLoanTestHelper(String testName) throws IOException, ParseException {
		driver = initDriver();
		JSONObject testData = (JSONObject) getTestData(testName);

		// Browse to google.com
		driver.get("https://www.google.com");
		
		// Click on the search box
		clickElement(elements.get("search box"));
		
		// Enter the search term in the search box and hit enter
		sendKeysToElement(elements.get("search box"), testData.get("searchText").toString());
		sendKeysToElement(elements.get("search box"), Keys.ENTER);
		
		// Wait for the Mortgage calculator
		waitForElement(elements.get("Mortgage calculator"), 10);
			
		// Click Monthly cost
		clickElement(elements.get("Maximum loan"));
		
		// Check the heading text
		checkTextInElement(elements.get("Mortgage calculator"), "Mortgage calculator");
		
		// Clear the text from the element
		clearElement(elements.get("Monthly payments input"));
		
		// Enter monthly payments
		sendKeysToElement(elements.get("Monthly payments input"), testData.get("monthlyPayments").toString());
		
		// Clear the text from the element
		clearElement(elements.get("Interest rate input"));
		
		// Enter interest rate
		sendKeysToElement(elements.get("Interest rate input"), testData.get("interestRate").toString());
		
		// Click mortgage period dropdown
		clickElement(elements.get("Mortgage period dropdown"));
		
		// Wait for mortgage period options
		waitForElement(elements.get(testData.get("mortgagePeriod").toString()), 10);
		
		// Select mortgage period
		clickElement(elements.get(testData.get("mortgagePeriod").toString()));
		
		// Check total cost of mortgage
		checkTextInElement(elements.get("Total cost of mortgage"), testData.get("costOfMortgage").toString());
		
		// Check loan amount
		checkTextInElement(elements.get("You could borrow"), testData.get("loanAmount").toString());
	}
	
	@Test
	public void monthlyPaymentsCompleteTest() throws IOException, ParseException {
		monthlyCostTestHelper("Monthly cost test - happy path");
	}
	
	@Test
	public void monthlyPaymentsInvalidMortgageAmount() throws IOException, ParseException {
		monthlyCostTestHelper("Monthly cost test - invalid mortgage amount");
	}
	
	@Test
	public void monthlyPaymentsInvalidInterestRate() throws IOException, ParseException {
		monthlyCostTestHelper("Monthly cost test - invalid interest rate");
	}

	@Test
	public void maximumLoanCompleteTest() throws IOException, ParseException {
		maximumLoanTestHelper("Maximum loan test - happy path");
	}
	
	@Test
	public void maximumLoanInvalidMonthlyPayments() throws IOException, ParseException {
		maximumLoanTestHelper("Maximum loan test - invalid monthly payments");
	}
	
	@Test
	public void maximumLoanInvalidInterestRate() throws IOException, ParseException {
		maximumLoanTestHelper("Maximum loan test - invalid interest rate");
	}
}
