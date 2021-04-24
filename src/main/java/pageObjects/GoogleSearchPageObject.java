package pageObjects;

import java.util.Dictionary;
import java.util.Hashtable;

import org.openqa.selenium.By;

public class GoogleSearchPageObject {
	Dictionary<String, By> elements = new Hashtable<String, By>();
	
	public Dictionary<String, By> getElements() {
		elements.put("search box", By.name("q"));
		elements.put("Mortgage calculator", By.xpath("//div[.='Mortgage calculator']"));
		elements.put("Monthly cost", By.xpath("//div[.='Monthly cost']"));
		elements.put("Maximum loan", By.xpath("//div[.='Maximum loan']"));
		elements.put("Mortgage amount input", By.xpath("//label[.='Mortgage amount']/../input"));
		elements.put("Monthly payments input", By.xpath("//label[.='Monthly payments']/../input"));
		elements.put("Interest rate input", By.xpath("//label[.='Interest rate (%)']/../input"));
		elements.put("Mortgage period dropdown", By.xpath("//label[.='Mortgage period (years)']/../div[@role='listbox']"));
		elements.put("10 years", By.xpath("//label[.='Mortgage period (years)']/../div[@role='listbox']/div[.='10']"));
		elements.put("15 years", By.xpath("//label[.='Mortgage period (years)']/../div[@role='listbox']/div[.='15']"));
		elements.put("20 years", By.xpath("//label[.='Mortgage period (years)']/../div[@role='listbox']/div[.='20']"));
		elements.put("25 years", By.xpath("//label[.='Mortgage period (years)']/../div[@role='listbox']/div[.='25']"));
		elements.put("30 years", By.xpath("//label[.='Mortgage period (years)']/../div[@role='listbox']/div[.='30']"));
		elements.put("40 years", By.xpath("//label[.='Mortgage period (years)']/../div[@role='listbox']/div[.='40']"));
		elements.put("Total cost of mortgage", By.xpath("//label[.='Total cost of mortgage']/../div[1]"));
		elements.put("Monthly payments", By.xpath("(//label[.='Monthly payments'])[2]/../div[1]"));
		elements.put("You could borrow", By.xpath("//label[.='You could borrow']/../div[1]"));
		
		return elements;
	}
}
