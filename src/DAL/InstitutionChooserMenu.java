package DAL;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class InstitutionChooserMenu extends KaszperPage{
	// after choosing an institution the page is automatically left, 
	//so if we want to choose another, we have to enter again
	private boolean leftPage = false;

	public InstitutionChooserMenu(String loginname, String password) {
		super(loginname, password);
		selectMenu("i");
	}
	
	public InstitutionChooserMenu(KaszperPage source) {
		super(source, "i");
	}
	
	public void selectInstitution(String institutionname) {
		if(leftPage)
			selectMenu("i");
		String tableselector = ".filter-table > tbody:nth-child(1) > tr:nth-child(3) > td:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > *";
		List<WebElement> rows = getDriver().findElements(By.cssSelector(tableselector));
		List<String> names = new ArrayList<>(rows.size());
		//a valaszthato intezmenyek neveinek lekerese TODO mivan ha tobb oldalnyi intezmeny van
		for (int i = 0; i < rows.size()-4; i++) {
			names.add(getCellContent(i,2));
		}
		
		for (int i = 0; i < names.size(); i++) {
			if(names.get(i).equals(institutionname)) {
				String selectbuttoncss = ".filter-table > tbody:nth-child(1) > tr:nth-child(3) > td:nth-child(1) > " + 
						"table:nth-child(1) > tbody:nth-child(1) > tr:nth-child("+ (i+4) +") > td:nth-child(1) input";
				getDriver().findElement(By.cssSelector(selectbuttoncss)).click();
			}
		}
		waitForLoading();
		leftPage = true;
	}

}
