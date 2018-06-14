package DAL;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Menu91 extends KaszperPage{
	
	
	public Menu91(KaszperPage source) {
		super(source, "91");
	}
	
	public boolean kontirtetelHasElotoltButton(int rowindex) {
		String elotoltcss = "body > main:nth-child(3) > center:nth-child(1) > form:nth-child(10) > span:nth-child(2) "
				+ "> span:nth-child(1) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(2) "
				+ "> td:nth-child(1) > span:nth-child(1) > table:nth-child(4) > tbody:nth-child(1) > tr:nth-child(2) "
				+ "> td:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) "
				+ "> table:nth-child(1) > tbody:nth-child(1) > tr:nth-child("+(rowindex+2)+") > td:nth-child(1) > "
				+ "span:nth-child(1) > input:nth-child(1)";
		int numofitems = getNumOfOccurances(elotoltcss);
		if(numofitems>1) {
			throw new RuntimeException(new Exception("There cannot be more than one button, something is wrong with the selector"));
		}
		return numofitems==1;
			
	}
	public void elotoltRow(int rowindex) {
		// rakattint a sor elotolt gombjara
		String elotoltcss = "body > main:nth-child(3) > center:nth-child(1) > form:nth-child(10) > span:nth-child(2) "
				+ "> span:nth-child(1) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(2) "
				+ "> td:nth-child(1) > span:nth-child(1) > table:nth-child(4) > tbody:nth-child(1) > tr:nth-child(2) "
				+ "> td:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) "
				+ "> table:nth-child(1) > tbody:nth-child(1) > tr:nth-child("+(rowindex+2)+") > td:nth-child(1) > "
				+ "span:nth-child(1) > input:nth-child(1)";
		getElementByCss(elotoltcss).click();
		waitForLoading();
	}
	public void hozzaad() {
		// hozzaad gombra kattint
		String hozzaadcss = "body > main:nth-child(3) > center:nth-child(1) > form:nth-child(10) > span:nth-child(2) "
				+ "> span:nth-child(1) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(5) "
				+ "> td:nth-child(1) > span:nth-child(1) > span:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) "
				+ "> tr:nth-child(2) > td:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > "
				+ "td:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(24) > td:nth-child(1) > "
				+ "span:nth-child(1) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > "
				+ "td:nth-child(1) > span:nth-child(1) > input:nth-child(1)";
		getElementByCss(hozzaadcss).click();
		waitForLoading();
	}
	public void closeDetails() {
		// visszater a tablazathoz
		String bezarcss = "body > main:nth-child(3) > center:nth-child(1) > form:nth-child(10) > span:nth-child(2) > "
				+ "span:nth-child(1) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(5) > "
				+ "td:nth-child(1) > span:nth-child(1) > span:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > "
				+ "tr:nth-child(2) > td:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > "
				+ "td:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(24) > td:nth-child(1) > "
				+ "span:nth-child(1) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > "
				+ "td:nth-child(2) > span:nth-child(1) > input:nth-child(1)";
		getElementByCss(bezarcss).click();
		waitForLoading();
		
	}
	public void selectRow(int rowindex) {
		// bepipalja a sort
		String checkboxcss = ".filter-table > tbody:nth-child(1) > tr:nth-child(3) > "
				+ "td:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child("+(rowindex+4)+") > "
				+ "td:nth-child(1) > span:nth-child(1) > nobr:nth-child(1) > span:nth-child(1) > input:nth-child(1)";
		getElementByCss(checkboxcss).click();
	}
	public void veglegesit() {
		// veglegesit gombra kattint
		String veglegesitcss = "body > main:nth-child(3) > center:nth-child(1) > form:nth-child(10) > span:nth-child(2) > "
				+ "span:nth-child(1) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > "
				+ "td:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(1) > "
				+ "span:nth-child(1) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > "
				+ "td:nth-child(4) > span:nth-child(1) > input:nth-child(1)";
		waitUntilElementisClickable(By.cssSelector(veglegesitcss));
		getElementByCss(veglegesitcss).click();
		acceptAlert();
		waitForLoading();
		waitUntilElementisClickable(By.cssSelector(veglegesitcss));
		
	}
	public boolean selectNextPage() {
		String nextpagecss = ".filter-table-pager-bottom > div:nth-child(1) > div:nth-child(1) > table:nth-child(1) "
				+ "> tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > font:nth-child(6) > input:nth-child(1)";
		WebElement nextpagebutton = getElementByCss(nextpagecss);
		if(nextpagebutton.isEnabled()) {
			nextpagebutton.click();
			waitForLoading();
			return true;
		}
		return false;
	}
	public int getNumberofRowsOnListPage() {
		String rowcss = ".filter-table > tbody:nth-child(1) > tr:nth-child(3) > "
				+ "td:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > * ";
		sleep(1);
		return getNumOfOccurances(rowcss)-4;
	}
	
	public int getNumberofKontirTetelek() {
		
		String rowselector ="html > body > main > center > form > span > span "
				+ "> div:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > "
				+ "tr:nth-child(2) > td:nth-child(1) > span > table:nth-child(4) > tbody:nth-child(1) > tr:nth-child(2) > " 
				+ "td:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > "
				+ "table:nth-child(1) > tbody:nth-child(1) > *";
		// -1 because the selector counts the header too
		return getNumOfOccurances(rowselector)-1;
		
	}
	

	public String getId(int rowindex) {
		String cellselector = ".filter-table > tbody:nth-child(1) > tr:nth-child(3)"
				+ " > td:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) >"
				+ " tr:nth-child("+ (rowindex+4) +") > td:nth-child(2) > "
				+ "span:nth-child(1) > nobr:nth-child(1)";
		return getDriver().findElement(By.cssSelector(cellselector)).getText();
	}
	
	public String enterRowDetailsPage(int rowindex) {
		String detailslinkcss = ".filter-table > tbody:nth-child(1) > "
				+ "tr:nth-child(3) > td:nth-child(1) > table:nth-child(1) "
				+ "> tbody:nth-child(1) > tr:nth-child("+(rowindex+4)+") > td:nth-child(3) > "
						+ "span > span > a > nobr";
		getDriver().findElement(By.cssSelector(detailslinkcss)).click();
		return getId(rowindex);
	}

	
}
